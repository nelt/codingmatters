package org.codingmatters.graph.layout;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 08:09
 */
public class GraphTest {
    
    @Test
    public void testDefault() throws Exception {        
        Graph graph = new Graph("G");
        assertEquals(
                "graph G {\n}", 
                graph.asDot());
    }
    
    @Test
    public void testDirected() throws Exception {        
        Graph graph = new Graph("G")
                .directed()
                ;
        assertEquals(
                "digraph G {\n}", 
                graph.asDot());
    }

    @Test
    public void testEdge() throws Exception {
        Graph graph = new Graph("G").directed()
                .edge("One", "Two")
                ;
        assertEquals(
                "digraph G {\n" +
                        "\tOne->Two;\n" +
                        "}",
                graph.asDot());
    }

    @Test
    public void testEdges() throws Exception {
        Graph graph = new Graph("G").directed()
                .edge("One", "Two")
                .edge("Three", "Two")
                ;
        assertEquals(
                "digraph G {\n" +
                        "\tOne->Two;\n" +
                        "\tThree->Two;\n" +
                        "}",
                graph.asDot());
    }

    @Test
    public void testSubgraph() throws Exception {
        Graph graph = new Graph("G").directed()
                .subgraph(new Graph("SG").edge("a", "b"))
                ;

        assertEquals(
                "digraph G {\n" +
                        "\tsubgraph SG {\n" +
                        "\t\ta->b;\n" +
                        "\t}\n" +
                        "}",
                graph.asDot());
    }
}
