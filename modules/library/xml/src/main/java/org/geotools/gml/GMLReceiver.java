/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.gml;

import org.geotools.api.feature.simple.SimpleFeature;
import org.geotools.feature.DefaultFeatureCollection;
import org.xml.sax.helpers.XMLFilterImpl;

/** @author Darren Edmonds */
public class GMLReceiver extends XMLFilterImpl implements GMLHandlerFeature {
    /** */
    private DefaultFeatureCollection featureCollection;

    /**
     * Creates a new instance of GMLReceiver
     *
     * @param featureCollection sets the FeatureCollection
     */
    public GMLReceiver(DefaultFeatureCollection featureCollection) {
        this.featureCollection = featureCollection;
    }

    /**
     * Receives an OGC feature and adds it into the collection
     *
     * @param feature the OGC feature
     */
    @Override
    public void feature(SimpleFeature feature) {
        featureCollection.add(feature);
    }
}
