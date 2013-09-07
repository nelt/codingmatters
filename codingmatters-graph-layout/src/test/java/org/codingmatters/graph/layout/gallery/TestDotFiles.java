package org.codingmatters.graph.layout.gallery;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 06/09/13
 * Time: 13:14
 * To change this template use File | Settings | File Templates.
 */
public class TestDotFiles {

    public static void main(String[] args) throws IOException {
        File testGallery = new File("./src/test/resources/gallery");
        
        new HelloWorld(args).generateDotFile(new File(testGallery, "hello-world.dot"));
        new Cluster(args).generateDotFile(new File(testGallery, "cluster.dot"));
        new DataStructures(args).generateDotFile(new File(testGallery, "data-structures.dot"));
    }
    
}
