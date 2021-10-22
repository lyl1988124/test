package com.lyl.technology.geotools;

import it.geosolutions.geoserver.rest.GeoServerRESTPublisher;
import it.geosolutions.geoserver.rest.GeoServerRESTReader;
import org.opengis.referencing.FactoryException;

import java.io.File;
import java.util.List;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/10/20 14:49
 */
public class PublishUtils {


    public static void main(String[] args) throws FactoryException {

        String RESTURL = "http://localhost:8082/geoserver";
        String RESTUSER = "admin";
        String RESTPW = "geoserver";

//        CoordinateReferenceSystem referenceSystem = CRS.decode("GCS_WGS_1984");
//
//        System.out.println(referenceSystem);

        List<String> workspaces = null;
        String result = "";
        try {
            File zipFile = new File("C:\\Users\\Admin\\Desktop\\test\\geomPolygon.zip");

            GeoServerRESTReader reader = new GeoServerRESTReader(RESTURL, RESTUSER, RESTPW);
            GeoServerRESTPublisher publisher = new GeoServerRESTPublisher(RESTURL, RESTUSER, RESTPW);

            workspaces = reader.getWorkspaceNames();
            if (workspaces.contains("test")) {

                //if (publisher.publishDBLayer("test", "idps-test-shp", "idps-test-shp-layer", "EPSG:4326", "default_polygon")){
                if (publisher.publishShp("test", "geomPolygon", "geomPolygon", zipFile, "EPSG:4545")) {

                    result = "He did it!";
                } else {
                    result = "fail!";
                }

            }
            System.out.println(result);
        } catch (Exception mue) {
            mue.printStackTrace();
        }
    }
}
