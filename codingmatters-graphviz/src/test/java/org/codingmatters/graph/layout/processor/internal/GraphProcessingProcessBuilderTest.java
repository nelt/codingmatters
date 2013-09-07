package org.codingmatters.graph.layout.processor.internal;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.processor.GraphProcessing;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 20/08/13
 * Time: 08:13
 * To change this template use File | Settings | File Templates.
 */
public class GraphProcessingProcessBuilderTest {


    @Test
    public void testDotCommand() throws Exception {
        File output = new File("/a/file");
        ProcessBuilder actual = new GraphProcessingProcessBuilder("dot")
                .outputType("png")
                .output(output)
                .build()
                ;
        
        assertEquals(Arrays.asList("dot", "-Tpng"), actual.command());
        assertEquals(output, actual.redirectOutput().file());
    }
}
