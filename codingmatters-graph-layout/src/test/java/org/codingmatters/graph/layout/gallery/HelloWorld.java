package org.codingmatters.graph.layout.gallery;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.processor.GraphProcessing;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 19/08/13
 * Time: 07:32
 */
public class HelloWorld {

    public static void main(String[] args) {
        Graph graph = new Graph("G").directed().edge("Hello", "World");
        ProcessBuilder processBuilder = GraphProcessing.dot(graph).process();
    }
    
}
