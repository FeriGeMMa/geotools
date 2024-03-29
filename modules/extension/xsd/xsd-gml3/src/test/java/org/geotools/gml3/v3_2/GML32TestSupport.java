package org.geotools.gml3.v3_2;

import java.util.Map;
import org.geotools.gml3.bindings.GML3MockData;
import org.geotools.xsd.Configuration;
import org.geotools.xsd.test.XMLTestSupport;
import org.junit.After;
import org.junit.Before;
import org.w3c.dom.Node;

public abstract class GML32TestSupport extends XMLTestSupport {

    @Override
    protected Map<String, String> getNamespaces() {
        return namespaces(Namespace("gml", GML.NAMESPACE));
    }

    @Override
    protected Configuration createConfiguration() {
        return new GMLConfiguration(enableArcSurfaceSupport());
    }

    /*
     * To be overriden by subclasses that require the extended arc/surface bindings
     * enabled.
     */
    protected boolean enableArcSurfaceSupport() {
        return false;
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        GML3MockData.setGML(GML.getInstance());
    }

    @After
    public void tearDown() throws Exception {
        GML3MockData.setGML(null);
    }

    /**
     * Return the gml:id of a Node (must be an Element).
     *
     * @return the gml:id
     */
    protected String getID(Node node) {
        return node.getAttributes()
                .getNamedItemNS(GML.NAMESPACE, GML.id.getLocalPart())
                .getNodeValue();
    }
}
