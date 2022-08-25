package com.lyl.util;

import org.gdal.gdal.Dataset;
import org.gdal.gdal.gdal;
import org.gdal.ogr.ogr;
import org.gdal.osr.SpatialReference;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : GdalGetCRS
 *
 * @author : liuyuanlong
 * @date : 2022/8/11 10:29
 */
public class GdalGetCRS {

    public static void main(String[] args) {

        //   String filePath = "C:\\Users\\rs13\\Desktop\\test\\idps-test.img";
        String filePath = "C:\\Users\\rs13\\Desktop\\test\\image.img";
        // todo 为什么设置这么大？
        gdal.SetCacheMax(500 * 1024 * 1024);
        gdal.AllRegister();
        Dataset dataset = gdal.Open(filePath);
//        Driver driver = gdal.IdentifyDriver(filePath);
//        System.out.println(driver.getShortName());

//        String raster = driver.GetMetadataItem(DCAP_RASTER);
//        System.out.println("raster=" + raster);

        String projection = dataset.GetProjection();
        SpatialReference spatialReference = new SpatialReference(projection);
        System.out.println(spatialReference.GetAttrValue("Authority", 1));
        System.out.println(spatialReference.ExportToWkt());
        //String p = spatialReference.GetAttrValue("GEOGCS",0);

//        int count = ogr.GetDriverCount();
//        for (int i = 0; i < count; i++) {
//            System.out.println(ogr.GetDriver(i).GetName());
//            System.out.println(ogr.GetDriver(i).GetDescription());
//        }

        // org.gdal.ogr.Driver driver2 = ogr.GetDriverByName("EIR");
        //driver1.
        // DataSource dataSource = gdal.GetDriverByName("HFA");

        // todo python没有index参数
//        Layer layer = dataSource.GetLayer(0);
//        SpatialReference spatialReference1 = layer.GetSpatialRef();
//
//        if (ogr.OGRERR_UNSUPPORTED_SRS == spatialReference.AutoIdentifyEPSG()) {
//
//            //   spatialReference1.
//            // spatialReference.
//            // spatialReference.AutoIdentifyEPSG();
//        } else {
//            spatialReference.GetAttrValue("Authority", 1);
//            spatialReference.ExportToWkt();
//            spatialReference.ExportToProj4();
//        }
    }
}
