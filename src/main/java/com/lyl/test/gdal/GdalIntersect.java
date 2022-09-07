package com.lyl.test.gdal;

import org.gdal.gdal.Driver;
import org.gdal.gdal.gdal;
import org.gdal.ogr.*;

import static org.gdal.gdalconst.gdalconstConstants.GA_ReadOnly;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : GdalIntersect
 *
 * @author : liuyuanlong
 * @date : 2022/8/26 14:05
 */
public class GdalIntersect {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\rs13\\Desktop\\test\\labels";

        gdal.SetCacheMax(500 * 1024 * 1024);
        gdal.AllRegister();

        Driver driver = gdal.IdentifyDriver(filePath);
        System.out.println(driver.getShortName());


        org.gdal.ogr.Driver ogrDriver = ogr.GetDriverByName(driver.getShortName());
        DataSource dataSource = ogrDriver.Open(filePath, GA_ReadOnly);
        Layer layer = dataSource.GetLayer(0);
        System.out.println(layer.GetFeatureCount());

        Feature feature = layer.GetFeature(231);
        Geometry geometry = feature.GetGeometryRef();
        System.out.println(geometry.GetGeometryCount());


        String filePath2 = "C:\\Users\\rs13\\Desktop\\test\\idps-test-intersects";

        Driver driver2 = gdal.IdentifyDriver(filePath2);
        org.gdal.ogr.Driver ogrDriver2 = ogr.GetDriverByName(driver2.getShortName());
        DataSource dataSource2 = ogrDriver2.Open(filePath2, GA_ReadOnly);

        Layer layer2 = dataSource2.GetLayer(0);
        System.out.println(layer2.GetFeatureCount());


        Feature feature2 = layer2.GetFeature(0);
        Geometry geometry2 = feature2.GetGeometryRef();
        System.out.println(geometry2.GetGeometryCount());

        System.out.println(geometry2.Intersect(geometry));

        System.out.println(geometry2.GetGeometryName());




        String newVectorFile = "C:\\Users\\rs13\\Desktop\\test\\new\\new.shp";

        // 为了支持中文路径，请添加下面这句代码
        gdal.SetConfigOption("GDAL_FILENAME_IS_UTF-8","NO");
        // 为了使属性表字段支持中文，请添加下面这句
        gdal.SetConfigOption("SHAPE_ENCODING","");
      //  gdal.SetConfigOption("ENCODING","GBK");
       // gdal.AllRegister();
        //创建数据，这里以创建ESRI的shp文件为例
        String strDriverName = "ESRI Shapefile";
        org.gdal.ogr.Driver oDriver = ogr.GetDriverByName(strDriverName);



        DataSource oDS = oDriver.CreateDataSource(newVectorFile, null);
        Layer oLayer = oDS.CreateLayer("TestPolygon", null, ogr.wkbPolygon, null);

        // 下面创建属性表
        // 先创建一个叫FieldID的整型属性
        FieldDefn oFieldID = new FieldDefn("FieldID", ogr.OFTInteger);
        oLayer.CreateField(oFieldID, 1);

        // 再创建一个叫FeatureName的字符型属性，字符长度为50
        FieldDefn oFieldName = new FieldDefn("FieldName", ogr.OFTString);
        oFieldName.SetWidth(100);
        oLayer.CreateField(oFieldName, 1);

        FeatureDefn oDefn =oLayer.GetLayerDefn();

        // 创建三角形要素
        Feature oFeatureTriangle = new Feature(oDefn);
        oFeatureTriangle.SetField(0, 0);
        oFeatureTriangle.SetField(1, "三角形");
        Geometry geomTriangle =Geometry.CreateFromWkt("POLYGON ((0 0,20 0,10 15,0 0))");
        oFeatureTriangle.SetGeometry(geomTriangle);

        oLayer.CreateFeature(oFeatureTriangle);

        // 创建矩形要素
        Feature oFeatureRectangle = new Feature(oDefn);
        oFeatureRectangle.SetField(0, 1);
        oFeatureRectangle.SetField(1, "矩形");
        Geometry geomRectangle =Geometry.CreateFromWkt("POLYGON ((30 0,60 0,60 30,30 30,30 0))");
        oFeatureRectangle.SetGeometry(geomRectangle);

        oLayer.CreateFeature(oFeatureRectangle);

        // 创建五角形要素
        Feature oFeaturePentagon = new Feature(oDefn);
        oFeaturePentagon.SetField(0, 2);
        oFeaturePentagon.SetField(1, "五角形");
        Geometry geomPentagon =Geometry.CreateFromWkt("POLYGON ((70 0,85 0,90 15,80 30,65 15,70 0))");
        oFeaturePentagon.SetGeometry(geomPentagon);

        oLayer.CreateFeature(oFeaturePentagon);

        //写入文件
        oLayer.SyncToDisk();
        oDS.SyncToDisk();

    }
}
