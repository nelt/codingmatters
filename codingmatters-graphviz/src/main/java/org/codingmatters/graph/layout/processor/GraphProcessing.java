package org.codingmatters.graph.layout.processor;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.processor.internal.GraphProcessingProcessBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 19/08/13
 * Time: 07:34
 */
public class GraphProcessing {

    private Graph graph;

    static public GraphProcessing dot(Graph g) {
        return new GraphProcessing("dot").graph(g).outputType("png");
    }
    
    
    private final GraphProcessingProcessBuilder builder;
    
    private GraphProcessing(String cmd) {
        this.builder = new GraphProcessingProcessBuilder(cmd);
    }

    private GraphProcessing graph(Graph g) {
        this.graph = g;
        return this;
    }
    
    public GraphProcessing outputType(String type) {
        this.builder.outputType(type);
        return this;
    }

    public void process(File output) throws IOException, InterruptedException {
        Process gvProcess = this.builder.output(output).build().start();
        
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(gvProcess.getOutputStream(), "UTF-8"))) {
            writer.write(this.graph.asDot());
            writer.flush();
        }
        
        gvProcess.waitFor();
    }
    
}
