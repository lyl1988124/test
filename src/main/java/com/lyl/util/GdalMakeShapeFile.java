package com.lyl.util;

import org.gdal.gdal.Dataset;
import org.gdal.gdal.gdal;
import org.gdal.ogr.*;
import org.gdal.osr.SpatialReference;

/**
 * Hello world!
 * 依赖 gdal dll文件！！！
 * gdal 环境下载地址： https://www.gisinternals.com/release.php
 */
public class GdalMakeShapeFile {
    static {
//        System.load(System.getProperty("user.dir")+"/gdalalljni.dll");
//        System.load(System.getProperty("user.dir")+"/gdal204.dll");
//        System.load(System.getProperty("user.dir")+"/javamapscript.dll");
//        System.load("D:\\tools\\release-1930-x64-gdal-3-5-0-mapserver-7-6-4\\bin\\gdal\\java\\gdalalljni.dll");
//        System.load("D:\\tools\\release-1930-x64-gdal-3-5-0-mapserver-7-6-4\\bin");
    }

    public static void main(String[] args) {

    }

    static void WriteVectorFile() {
        String strVectorFile = "test/test.shp";

        gdal.AllRegister();
        gdal.SetConfigOption("GDAL_FILENAME_IS_UTF8", "NO");
        gdal.SetConfigOption("SHAPE_ENCODING", "CP936");

        String strDriverName = "ESRI Shapefile";
        org.gdal.ogr.Driver oDriver = ogr.GetDriverByName(strDriverName);

        if (oDriver == null) {
            System.out.println(strVectorFile + " 驱动不可用！\n");
            return;
        }
        DataSource oDS = oDriver.CreateDataSource(strVectorFile, null);
        if (oDS == null) {
            System.out.println("创建矢量文件【" + strVectorFile + "】失败！\n");
            return;
        }

        SpatialReference ref = new SpatialReference();// 空间参数
        ref.SetWellKnownGeogCS("WGS84");

        Layer oLayer = oDS.CreateLayer("TestPolygon", ref, ogr.wkbPolygon, null);
        if (oLayer == null) {
            System.out.println("图层创建失败！\n");
            return;
        }

        // 下面创建属性表
        // 先创建一个叫FieldID的整型属性
        FieldDefn oFieldID = new FieldDefn("FieldID", ogr.OFTInteger);
        oLayer.CreateField(oFieldID);

        // 再创建一个叫FeatureName的字符型属性，字符长度为50
        FieldDefn oFieldName = new FieldDefn("FieldName", ogr.OFTString);
        oFieldName.SetWidth(100);
        oLayer.CreateField(oFieldName);

        FeatureDefn oDefn = oLayer.GetLayerDefn();

        // 创建三角形要素
        Feature oFeatureTriangle = new Feature(oDefn);
        oFeatureTriangle.SetField(0, 0);
        oFeatureTriangle.SetField(1, "三角形");
        Geometry geomTriangle = Geometry.CreateFromWkt("POLYGON ((0 0,20 0,10 15,0 0))");
        oFeatureTriangle.SetGeometry(geomTriangle);
        oLayer.CreateFeature(oFeatureTriangle);

        // 创建矩形要素
        Feature oFeatureRectangle = new Feature(oDefn);
        oFeatureRectangle.SetField(0, 1);
        oFeatureRectangle.SetField(1, "矩形");
        Geometry geomRectangle = Geometry.CreateFromWkt("POLYGON ((30 0,60 0,60 30,30 30,30 0))");
        oFeatureRectangle.SetGeometry(geomRectangle);
        oLayer.CreateFeature(oFeatureRectangle);

        // 创建五角形要素
        Feature oFeaturePentagon = new Feature(oDefn);
        oFeaturePentagon.SetField(0, 2);
        oFeaturePentagon.SetField(1, "五角形");
        Geometry geomPentagon = Geometry.CreateFromWkt("POLYGON ((70 0,85 0,90 15,80 30,65 15,70 0))");
        oFeaturePentagon.SetGeometry(geomPentagon);
        oLayer.CreateFeature(oFeaturePentagon);

        oDS.SyncToDisk();
        System.out.println("\n数据集创建完成！\n");
    }

    static void makeOverviews() {
        gdal.AllRegister();
        int count = ogr.GetDriverCount();
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(ogr.GetDriver(i).GetName());
        }

        Dataset dataset = gdal.Open("C:\\Users\\rs13\\Desktop\\test\\image.img");
        int[] m = new int[]{2, 4};
        dataset.BuildOverviews(m);
    }
}
