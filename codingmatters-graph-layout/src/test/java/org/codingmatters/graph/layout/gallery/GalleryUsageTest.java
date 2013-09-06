package org.codingmatters.graph.layout.gallery;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 06/09/13
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public class GalleryUsageTest {
    @Test
    public void testHelloWorld() throws Exception {
        assertEquals(
                this.read("hello-world.dot"),
                new HelloWorld(new String[0]).graph().asDot());
    }

    @Test
    public void testCluster() throws Exception {
        assertEquals(
                this.read("cluster.dot"), 
                new Cluster(new String[0]).graph().asDot());
    }

    private String read(String dot) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("gallery/" + dot)))) {
            StringBuffer result = new StringBuffer();
            char[] buffer = new char[256];
            int read = reader.read(buffer);
            while(read != -1) {
                result.append(buffer, 0, read);
                read = reader.read(buffer);
            }
            return result.toString();
        }
    }
}
