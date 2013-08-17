package org.codingmatters.graph.layout;

import org.codingmatters.graph.layout.attributes.GraphAttributeFormatter;
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
                .graphAttributes(new GraphAttributeFormatter().charset("UTF-8"))
                ;

        assertEquals(
                "graph G {\n" +
                "\tgraph [charset = UTF-8];\n" +
                "}", 
                graph.asDot());
    }
}
