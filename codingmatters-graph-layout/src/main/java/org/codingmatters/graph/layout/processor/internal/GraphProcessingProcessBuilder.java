package org.codingmatters.graph.layout.processor.internal;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 20/08/13
 * Time: 08:09
 * To change this template use File | Settings | File Templates.
 */
public class GraphProcessingProcessBuilder {
    private final String cmd;
    private String outputType;
    private File output;

    public GraphProcessingProcessBuilder(String cmd) {
        this.cmd = cmd;
    }

    public GraphProcessingProcessBuilder outputType(String type) {
        this.outputType = type;
        return this;
    }

    public GraphProcessingProcessBuilder output(File output) {
        this.output = output;
        return this;
    }

    public ProcessBuilder build() {
        return new ProcessBuilder(this.cmd, "-T" + this.outputType)
                .redirectOutput(output)
                ;
    }
}
