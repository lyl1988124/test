package com.lyl.technology.geotools;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import java.io.File;
import java.io.IOException;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/10/21 17:31
 */
public class ReadTiffUtils {

    public static void main(String[] args) throws IOException, FactoryException {

        String filePath = "C:\\Users\\Admin\\Desktop\\test\\idps-test.tif";
        File file = new File(filePath);

        GeoTiffReader geoTiffReader = new GeoTiffReader(file);
        GridCoverage2D gridCoverage2D = geoTiffReader.read(null);
        CoordinateReferenceSystem srs = gridCoverage2D.getCoordinateReferenceSystem2D();
        System.out.println(srs);
        String crs = CRS.lookupIdentifier(srs, true);
        System.out.println(crs);
    }
}
