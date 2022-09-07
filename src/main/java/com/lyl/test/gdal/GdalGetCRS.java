package com.lyl.test.gdal;

import org.gdal.gdal.Dataset;
import org.gdal.gdal.Driver;
import org.gdal.gdal.gdal;
import org.gdal.ogr.DataSource;
import org.gdal.ogr.Layer;
import org.gdal.ogr.ogr;
import org.gdal.osr.SpatialReference;

import static org.gdal.gdalconst.gdalconstConstants.DCAP_RASTER;
import static org.gdal.gdalconst.gdalconstConstants.GA_ReadOnly;
import static org.gdal.ogr.ogrConstants.OGRERR_UNSUPPORTED_SRS;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : GdalGetCRS
 *
 * @author : liuyuanlong
 * @date : 2022/8/11 10:29
 */
public class GdalGetCRS {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\rs13\\Desktop\\test\\image_dev.tif";
        //String filePath = "C:\\Users\\rs13\\Desktop\\test\\labels";
        // todo 为什么设置这么大？
        gdal.SetCacheMax(500 * 1024 * 1024);
        gdal.AllRegister();

        Driver driver = gdal.IdentifyDriver(filePath);
        System.out.println(driver.getShortName());

        String isRaster = driver.GetMetadataItem(DCAP_RASTER);
        SpatialReference spatialReference = null;
        if (null == isRaster && !"HFA".equals(driver.getShortName())) {
            org.gdal.ogr.Driver ogrDriver = ogr.GetDriverByName(driver.getShortName());
            DataSource dataSource = ogrDriver.Open(filePath, GA_ReadOnly);
            System.out.println("dataSource layer count=" + dataSource.GetLayerCount());

            Layer layer = dataSource.GetLayer(0);
            spatialReference = layer.GetSpatialRef();
        } else {
            Dataset dataset = gdal.Open(filePath);
            String projection = dataset.GetProjection();
            spatialReference = new SpatialReference(projection);
        }

        System.out.println(spatialReference.ExportToWkt());
        // todo 问题 无spatialReference.FindMatches()方法
        // 且 AutoIdentifyEPSG 抛出异常，而不是返回0;
        // https://www.osgeo.cn/gdal/doxygen/classOGRSpatialReference.html#acb0373c83927bfd694048da6f79e33ea
        //spatialReference.ImportFromEPSG(4396);

      //spatialReference.AutoIdentifyEPSG();
        System.out.println(spatialReference.ExportToWkt());
        System.out.println(spatialReference.GetAttrValue("Authority", 1));
        System.out.println(spatialReference.ExportToWkt());
    }
}
