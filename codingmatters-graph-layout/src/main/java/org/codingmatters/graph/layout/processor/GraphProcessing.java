package org.codingmatters.graph.layout.processor;

import org.codingmatters.graph.layout.Graph;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 19/08/13
 * Time: 07:34
 */
public class GraphProcessing {

    static public GraphProcessing dot(Graph g) {
        return new GraphProcessing("dot").outputType("png");
    }
    
    private String outputType;
    
    private final String cmd;
    
    private GraphProcessing(String cmd) {
        this.cmd = cmd;
    }
    
    public GraphProcessing outputType(String type) {
        this.outputType = type;
        return this;
    }

    public ProcessBuilder process() {
        return new ProcessBuilder(this.cmd, "-T" + this.outputType);
    }
}
