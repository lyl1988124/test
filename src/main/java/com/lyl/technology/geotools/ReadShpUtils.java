package com.lyl.technology.geotools;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.referencing.CRS;
import org.opengis.feature.GeometryAttribute;
import org.opengis.feature.simple.SimpleFeature;
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
public class ReadShpUtils {

    public static void main(String[] args) throws IOException, FactoryException {

        String filePath = "C:\\Users\\Admin\\Desktop\\test\\geomPolygon.shp";
        File file = new File(filePath);
        FileDataStore dataStore = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource simpleFeatureType = dataStore.getFeatureSource();
        SimpleFeatureCollection featureCollection = simpleFeatureType.getFeatures();
        SimpleFeatureIterator featureIterator = featureCollection.features();
        while (featureIterator.hasNext()) {
            SimpleFeature feature = featureIterator.next();
            GeometryAttribute geometryAttribute = feature.getDefaultGeometryProperty();
            CoordinateReferenceSystem crs = geometryAttribute.getDescriptor().getCoordinateReferenceSystem();
            ;

            //CoordinateReferenceSystem example = CRS.parseWKT(crs.toWKT());
            String code = CRS.lookupIdentifier(crs, true);
            System.out.println(code);
            System.out.println(crs);
        }

    }
}
