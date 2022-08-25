package com.lyl.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.common.collect.ImmutableList;
import org.gdal.gdal.*;
import org.gdal.ogr.Geometry;
import org.gdal.ogr.ogr;
import org.gdal.osr.CoordinateTransformation;
import org.gdal.osr.SpatialReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import static org.gdal.gdalconst.gdalconstConstants.GDT_Byte;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : Gdal_collect_gis_meta
 *
 * @author : liuyuanlong
 * @date : 2022/8/11 15:06
 */
public class Gdal_collect_gis_meta {

    public static void main(String[] args) throws JsonProcessingException {

        //String filePath = "C:\\Users\\rs13\\Desktop\\test\\image_dev.tif";
        String filePath = "C:\\Users\\rs13\\Desktop\\test\\image.img";
        gdal.SetCacheMax(500 * 1024 * 1024);
        gdal.AllRegister();
        Dataset dataset = gdal.Open(filePath);

        int height = dataset.GetRasterYSize();
        int width = dataset.GetRasterXSize();
        int band_num = dataset.GetRasterCount();

        Vector vector = new Vector();
        vector.add("-json");
        InfoOptions infoOptions = new InfoOptions(vector);
        String info = gdal.GDALInfo(dataset, infoOptions);
        System.out.println(info);

        JsonMapper jsonMapper = new JsonMapper();
        JsonNode jsonNode = jsonMapper.readTree(info);

        JsonNode transform = jsonNode.get("geoTransform");
        System.out.println(jsonNode);

        System.out.println("info=" + transform.get(1) + ":" + transform.get(5));

        int dataType = dataset.GetRasterBand(1).getDataType();
        System.out.println(gdal.GetDataTypeName(dataType));
        System.out.println(gdal.GetDataTypeSize(dataType));

        Double[] nodataValue = new Double[1];
        dataset.GetRasterBand(1).GetNoDataValue(nodataValue);
        System.out.println(nodataValue[0]);

        System.out.println("minx=" + transform.get(0));
        System.out.println("maxy=" + transform.get(3));

        JsonNode size = jsonNode.get("size");
        Double minx = transform.get(0).asDouble();
        Double maxy = transform.get(3).asDouble();

        Double maxx = transform.get(0).asDouble() + transform.get(1).asDouble() * size.get(0).asDouble() + transform.get(2).asDouble() * size.get(1).asDouble();
        Double miny = transform.get(3).asDouble() + transform.get(4).asDouble() * size.get(0).asDouble() + transform.get(5).asDouble() * size.get(1).asDouble();
        System.out.println("maxx=" + maxx + " miny=" + miny);

        String projection = dataset.GetProjection();
        SpatialReference spatialReference = new SpatialReference(projection);
        System.out.println(spatialReference.IsProjected());

        String wkt = spatialReference.ExportToWkt();

        Geometry bound_box_geom_linear_ring = new Geometry(ogr.wkbLinearRing);
        bound_box_geom_linear_ring.AddPoint_2D(maxx, maxy);
        bound_box_geom_linear_ring.AddPoint_2D(maxx, maxy);
        bound_box_geom_linear_ring.AddPoint_2D(minx, miny);
        bound_box_geom_linear_ring.AddPoint_2D(maxx, miny);
        bound_box_geom_linear_ring.AddPoint_2D(maxx, maxy);

        Geometry new_bound_box_geom = new Geometry(ogr.wkbPolygon);
        new_bound_box_geom.AddGeometry(bound_box_geom_linear_ring);

        SpatialReference tgt_srs_epsg = new SpatialReference();
        tgt_srs_epsg.ImportFromEPSG(4326);

        SpatialReference wktSR = new SpatialReference(wkt);
        CoordinateTransformation tgt_epsg_transform = new CoordinateTransformation(wktSR, tgt_srs_epsg);
        new_bound_box_geom.Transform(tgt_epsg_transform);

        double[] envelope = new double[4];
        new_bound_box_geom.GetEnvelope(envelope);

        System.out.println("envelope[0]" + envelope[0]);
        System.out.println(new_bound_box_geom.ExportToWkt());


        // Create thumbnail png
        List<Integer> bandMapping = ImmutableList.of(1, 2, 3);
        List<Integer> bandList = new ArrayList();
        for (int index = 0; index < bandMapping.size(); index++) {
            if (index < band_num) {
                bandList.add(bandMapping.get(index));
            }
        }

        System.out.println("height=" + height + " width=" + width);

        List<List<Integer>> statisticList = getPercentileHistogram(dataset, bandList, 2, 98);

        Vector nailV = new Vector();
        nailV.add("-ot");
        nailV.add("Byte");

        nailV.add("-of");
        nailV.add("PNG");

        nailV.add("-a_nodata");
        nailV.add(String.valueOf(nodataValue));

        // %%符号代表按比例缩放
        nailV.add("-outsize");
        nailV.add("100%%");
        nailV.add("100%%");

        for (int band : bandList) {
            nailV.add("-b");
            nailV.add(String.valueOf(band));
        }

        for (List<Integer> integerList1 : statisticList) {
            nailV.add("-scale");
            for (Integer band : integerList1) {
                nailV.add(String.valueOf(band));
            }
        }

        TranslateOptions translateOptions = new TranslateOptions(nailV);

        gdal.Translate("C:\\Users\\rs13\\Desktop\\test\\image.png", dataset, translateOptions);

    }

    public static List<List<Integer>> getPercentileHistogram(Dataset dataset, List<Integer> bandList, int minP, int maxP) {
        List<List<Integer>> statisticList = new ArrayList<>();
        for (Integer bd : bandList) {
            Band band = dataset.GetRasterBand(bd);
            int[] buckets;
            if (GDT_Byte == band.getDataType()) {
                buckets = new int[256];
                band.GetHistogram(0.5, 254.5, buckets, true, false);
            } else {
                // buckets = new int[]{65536};
                buckets = new int[65536];
                band.GetHistogram(0.5, 65534.5, buckets, true, false);
            }

            List<Integer> hisArray = Arrays.stream(buckets).boxed().collect(Collectors.toList());
            statisticList.add(getBandPercentileStatistics(hisArray, minP, maxP));
        }
        return statisticList;
    }

    public static List<Integer> getBandPercentileStatistics(List<Integer> hisArray, Integer minPercent, Integer maxPercent) {
        long colorSum = hisArray.stream().mapToInt(a -> a).sum();

        long colorS = 0;
        for (Integer tmp : hisArray) {
            colorS += tmp;
        }

        double minQuantile = colorSum * minPercent / 100;
        double maxQuantile = colorSum * maxPercent / 100;
        long value = 0;
        Integer minColor = null;
        Integer maxColor = null;
        for (int i = 0; i < hisArray.size(); i++) {
            value += hisArray.get(i);
            if (null == minColor && value >= minQuantile) {
                minColor = i - 1;
            }
            if (null == maxColor && value >= maxQuantile) {
                maxColor = i;
            }
            if (null != minColor && null != maxColor) {
                break;
            }
        }
        if (null == minColor || minColor < 0) {
            maxColor = 0;
        }
        return ImmutableList.of(minColor, maxColor);
    }
}
