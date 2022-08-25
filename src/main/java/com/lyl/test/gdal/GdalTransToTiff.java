package com.lyl.test.gdal;

import org.gdal.gdal.Dataset;
import org.gdal.gdal.Driver;
import org.gdal.gdal.TranslateOptions;
import org.gdal.gdal.gdal;
import org.gdal.osr.SpatialReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : GdalTransToTiff
 *
 * @author : liuyuanlong
 * @date : 2022/8/10 15:02
 */
public class GdalTransToTiff {

    public static void recognize(){
        String filePath = "C:\\Users\\rs13\\Desktop\\test\\image.img";
        gdal.SetCacheMax(500 * 1024 * 1024);
        gdal.AllRegister();
        Dataset dataset = gdal.Open(filePath);

        // recognize
        Driver driver = gdal.IdentifyDriver(filePath);
        System.out.println(driver.getShortName());


    }

    public void toTif(){
        String filePath = "C:\\Users\\rs13\\Desktop\\test\\image.img";
        gdal.SetCacheMax(500 * 1024 * 1024);
        gdal.AllRegister();
        Dataset dataset = gdal.Open(filePath);

        Driver driver = gdal.IdentifyDriver(filePath);
        System.out.println(driver.getShortName());

        System.out.println("RasterYSize=" + dataset.GetRasterYSize());
        System.out.println("RasterXSize=" + dataset.GetRasterXSize());
        System.out.println("RasterCount=" + dataset.GetRasterCount());

        int bandNum = dataset.GetRasterCount();
        int[] bandMapping = new int[]{1, 2, 3};
        List<Integer> bandList = new ArrayList<>();
        for (int i = 0; i < bandMapping.length; i++) {
            if (i < bandNum) {
                bandList.add(bandMapping[i]);
            }
        }

        Double[] nodataValue = new Double[1];
        dataset.GetRasterBand(1).GetNoDataValue(nodataValue);
        Double nodata = null;
        if (null != nodataValue[0]) {
            nodata = nodataValue[0];
        }

        // get crs
        String projection = dataset.GetProjection();
        SpatialReference spatialReference = new SpatialReference(projection);
        String crs = spatialReference.ExportToWkt();

        List<List<Integer>> statisticList = Gdal_collect_gis_meta.getPercentileHistogram(dataset, bandList, 2, 98);

        Vector vector = new Vector();
        vector.add("-of");
        vector.add("GTiff");

        vector.add("-ot");
        vector.add("Byte");

        if (null != nodata) {
            vector.add("-a_nodata");
            vector.add(String.valueOf(nodata));
        }

        vector.add("-a_srs");
        vector.add(crs);

        for (int band : bandList) {
            vector.add("-b");
            vector.add(String.valueOf(band));
        }

        for (List<Integer> integerList1 : statisticList) {
            vector.add("-scale");
            for (Integer band : integerList1) {
                vector.add(String.valueOf(band));
            }
        }

        TranslateOptions translateOptions = new TranslateOptions(vector);

        gdal.Translate("C:\\Users\\rs13\\Desktop\\test\\img.tif", dataset, translateOptions);
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\rs13\\Desktop\\test\\clip";
        gdal.SetCacheMax(500 * 1024 * 1024);

        gdal.AllRegister();

        // recognize
        File files = new File(filePath);
        Vector vector = new Vector();
        if(files.isDirectory()){
            for(File tmp : files.listFiles()){
                vector.add(tmp.getName());
            }
        }
        Driver driver = gdal.IdentifyDriver(filePath,vector);
        System.out.println(driver.getShortName());

    }
}
