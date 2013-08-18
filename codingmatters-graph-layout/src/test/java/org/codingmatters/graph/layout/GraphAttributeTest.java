package org.codingmatters.graph.layout;

import org.codingmatters.graph.layout.attributes.Attributes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 17/08/13
 * Time: 07:20
 */
public class GraphAttributeTest {

    @Test
    public void testGraphAttributes() throws Exception {
        Graph graph = new Graph("G")
                .graphAttributes(Attributes.graph().charset("UTF-8"))
                ;

        assertEquals(
                "graph G {\n" +
                "\tgraph [charset = UTF-8];\n" +
                "}", 
                graph.asDot());
    }

    @Test
    public void testEdgeAttributes() throws Exception {
        Graph graph = new Graph("G")
                .edgeAttributes(Attributes.edge().url("http://www.codingmatters.org"))
                ;

        assertEquals(
                "graph G {\n" +
                        "\tedge [URL = http://www.codingmatters.org];\n" +
                        "}",
                graph.asDot());
    }

    @Test
    public void testNodeAttributes() throws Exception {
        Graph graph = new Graph("G")
                .nodeAttributes(Attributes.node().url("http://www.codingmatters.org"))
                ;

        assertEquals(
                "graph G {\n" +
                        "\tnode [URL = http://www.codingmatters.org];\n" +
                        "}",
                graph.asDot());
    }
}
