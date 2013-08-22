package org.codingmatters.graph.layout.gallery;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.processor.GraphProcessing;

import java.io.File;

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
    public File generate() throws Exception {
        File output = this.getOutputFile("hello-world.png");
        GraphProcessing
                .dot(new Graph("G").directed().edge("Hello", "World"))
                .process(output)
                ;
        return output;
    }
}
