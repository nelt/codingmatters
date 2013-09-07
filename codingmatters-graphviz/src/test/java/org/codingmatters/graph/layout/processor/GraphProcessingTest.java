package org.codingmatters.graph.layout.processor;

import org.codingmatters.graph.layout.Graph;
import org.junit.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 19/08/13
 * Time: 07:40
 */
public class GraphProcessingTest {

    private File outputFile;

    @Before
    public void setUp() throws Exception {
        this.outputFile = new File("graph-" + UUID.randomUUID().toString() + ".png");
        this.outputFile.deleteOnExit();
    }

    @After
    public void tearDown() throws Exception {
        if(this.outputFile.exists()) {
            this.outputFile.delete();
        }
    }
    
    @Test
    public void testGeneration() throws Exception {
        GraphProcessing
                .dot(new Graph("G").directed().edge("a", "b"))
                .process(this.outputFile)
                ;
        
        assertTrue(this.outputFile.exists());
        assertNotEquals(0, this.outputFile.length());
    }
}
