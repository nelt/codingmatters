package org.codingmatters.graph.layout.processor;

import org.codingmatters.graph.layout.Graph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 19/08/13
 * Time: 07:40
 */
public class GraphProcessingTest {

    @Test
    public void testDot() throws Exception {
        ProcessBuilder actual = GraphProcessing.dot(new Graph("G")).process();
        assertEquals(Arrays.asList("dot", "-Tpng"), actual.command());
    }
}
