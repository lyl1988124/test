package com.lyl.test.gdal;

import org.gdal.gdal.Dataset;
import org.gdal.gdal.gdal;

import static org.gdal.gdalconst.gdalconstConstants.GA_ReadOnly;
import static org.gdal.gdalconst.gdalconstConstants.GA_Update;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : GdalOverView
 *
 * @author : liuyuanlong
 * @date : 2022/8/25 13:05
 */
public class GdalOverView {

    public static void main(String[] args) {
        gdal.AllRegister();


       // Dataset dataset = gdal.Open("C:\\Users\\rs13\\Desktop\\test\\image.img", 0);

        // GA_ReadOnly（0） 外部金字塔； GA_Update（1）内部金字塔
        Dataset dataset = gdal.Open("C:\\Users\\rs13\\Desktop\\test\\image_dev.tif", GA_ReadOnly);
        System.out.println(GA_ReadOnly);
        System.out.println(GA_Update);
        System.out.println(dataset.GetDriver().getShortName());
    /**
     * Erdas Imagine.img
     * https://www.osgeo.cn/gdal/drivers/raster/hfa.html
     *
     * HFA_USE_RRD=YES/NO ：是否强制以Erdas rrd格式和.rrd文件扩展名创建外部概述（gdaladdo与-ro--config组合使用-rrd YES创建扩展名为.aux的概述文件）。
     *
     * HFA_COMPRESS_OVR=YES/NO ：是否创建压缩概述。默认情况下，仅在压缩文件时创建压缩概述。
     *
     * 此配置选项可用于为非Erdas Imagine格式的基本图像生成外部概述。生成的概述文件将使用rrd结构并具有.aux扩展名。
     *
     * gdaladdo out.tif --config USE_RRD YES --config HFA_COMPRESS_OVR YES 2 4 8
     * Erdas Imagine和老版本的ArcGIS可能只在扩展名为.rrd的情况下才能识别某些图像格式的概述。在这种情况下，使用：
     *
     * gdaladdo out.tif --config USE_RRD YES --config HFA_USE_RRD YES --config HFA_COMPRESS_OVR YES 2 4 8
     *
     *         可不使用压缩  gdal.SetConfigOption("HFA_COMPRESS_OVR","YES");
     *         gdal.SetConfigOption("USE_RRD", "YES");
     *         gdal.SetConfigOption("HFA_USE_RRD", "YES");
     * */

        int[] m = new int[]{2, 4, 8, 16};
        dataset.BuildOverviews(m);
    }
}
