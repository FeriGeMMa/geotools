/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2006-2008, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.filter;

import java.util.List;
import org.geotools.api.filter.Filter;
import org.geotools.api.filter.FilterVisitor;
import org.geotools.api.filter.Or;

/** @author jdeolive */
public class OrImpl extends LogicFilterImpl implements Or {

    protected OrImpl(List<Filter> children) {
        super(children);
    }

    @Override
    public boolean evaluate(Object feature) {
        for (Filter filter : children) {
            if (filter.evaluate(feature)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object accept(FilterVisitor visitor, Object extraData) {
        return visitor.visit(this, extraData);
    }
}
