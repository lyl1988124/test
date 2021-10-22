package com.lyl.technology.geotools;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.geometry.iso.text.WKTParser;
import org.geotools.referencing.CRS;
import org.geotools.util.factory.GeoTools;
import org.locationtech.jts.io.WKTConstants;
import org.opengis.feature.GeometryAttribute;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.identity.FeatureId;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.ReferenceIdentifier;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.crs.ProjectedCRS;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GeoToolsSRS {

    public static void main(String[] args) throws IOException, FactoryException {
        String filePath = "C:\\Users\\lyl\\Desktop\\test\\read_dem_feature.shp";
        File file = new File(filePath);
        //URL url = new URL(filePath);
        //FileDataStore fileDataStore = FileDataStoreFinder.getDataStore(file);

        URL url = file.toURI().toURL();
        ShapefileDataStore fileDataStore = new ShapefileDataStore(url);

        SimpleFeatureSource simpleFeatureSource = fileDataStore.getFeatureSource();

        // SimpleFeatureCollection featureCollection= simpleFeatureSource.getFeatures();

        FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
        Set<FeatureId> fids = new HashSet<FeatureId>();
        ff.property("the_geom");

        fids.add(ff.featureId("read_dem_feature.1"));

        Filter left = ff.id(fids);
        SimpleFeatureCollection featureCollection = simpleFeatureSource.getFeatures();

//        Query query = Query.FIDS;
//        query.setPropertyNames(ImmutableList.of("the_geom"));
//        featureCollection = simpleFeatureSource.getFeatures(query);

        SimpleFeatureIterator featureIterator = featureCollection.features();

        if (featureIterator.hasNext()) {
            SimpleFeature simpleFeature = featureIterator.next();
            System.out.println("simpleFeature=" + simpleFeature.getID() + " name=" + simpleFeature.getName());
            System.out.println();
            List<Property> propertyList = (List<Property>) simpleFeature.getValue();
            for (Property property : propertyList) {
                System.out.println("name=" + property.getName());
                System.out.println("value=" + property.getValue());
                System.out.println("type=" + property.getType());
                System.out.println("#############");
            }

            GeometryAttribute geometryText = simpleFeature.getDefaultGeometryProperty();
            CoordinateReferenceSystem coordinateReferenceSystem = geometryText.getDescriptor().getCoordinateReferenceSystem();

            ProjectedCRS projectedCRS = org.geotools.referencing.CRS.getProjectedCRS(coordinateReferenceSystem);

            ReferenceIdentifier referenceIdentifier =coordinateReferenceSystem.getCoordinateSystem().getName();
            //System.out.println(coordinateReferenceSystem.toString());
            String srsInfo= coordinateReferenceSystem.toString();
            //CoordinateReferenceSystem crs = CRS.decode("EPSG:4326");
            //System.out.println(crs);
            System.out.println(coordinateReferenceSystem.getName());
            System.out.println(geometryText.getName().toString());
        }
    }
}
