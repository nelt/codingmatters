package org.codingmatters.graph.layout.gallery;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.processor.GraphProcessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 19/08/13
 * Time: 07:32
 */
public class HelloWorld extends GallerySample {


    public static void main(String[] args) {
        generate(new HelloWorld(args), "hello world");
    }

    protected HelloWorld(String[] args) {
        super(args);
    }

    @Override
    public Graph graph() {
        return new Graph("G").directed().edge("Hello", "World");
    }
    
    
    @Override
    public File generate() throws Exception {
        File output = this.getOutputFile("hello-world.png");
        GraphProcessing
                .dot(this.graph())
                .process(output)
                ;
        return output;
    }
}
