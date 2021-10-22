package com.lyl.technology.geotools;

import it.geosolutions.geoserver.rest.GeoServerRESTPublisher;
import it.geosolutions.geoserver.rest.GeoServerRESTReader;
import it.geosolutions.geoserver.rest.manager.GeoServerRESTStoreManager;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/10/20 14:49
 */
public class PublishTiffUtils {


    public static void main(String[] args) {
        System.out.println("aaa");
        String RESTURL = "http://localhost:8082/geoserver";
        String RESTUSER = "admin";
        String RESTPW = "geoserver";

        List<String> workspaces = null;
        String result = "";
        try {
            File zipFile = new File("E:\\tools\\geoserver-2.19.2-bin\\data_dir\\data\\TEST\\tif-shp-meters\\images\\idps-test2.tif");

            URL url = new URL("RESTURL");
            GeoServerRESTStoreManager geoServerRESTStoreManager = new GeoServerRESTStoreManager(url, RESTUSER, RESTPW);

            GeoServerRESTReader reader = new GeoServerRESTReader(RESTURL, RESTUSER, RESTPW);
            GeoServerRESTPublisher publisher = new GeoServerRESTPublisher(RESTURL, RESTUSER, RESTPW);

            workspaces = reader.getWorkspaceNames();

            if (workspaces.contains("test")) {

                //if (publisher.publishDBLayer("test", "idps-test-shp", "idps-test-shp-layer", "EPSG:4326", "default_polygon")){
                if (publisher.publishGeoTIFF("test", "idps-test2","idps-test2", zipFile)) {

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
