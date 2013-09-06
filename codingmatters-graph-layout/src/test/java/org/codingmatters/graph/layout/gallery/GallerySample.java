package org.codingmatters.graph.layout.gallery;

import org.codingmatters.graph.layout.Graph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 20/08/13
 * Time: 07:41
 * To change this template use File | Settings | File Templates.
 */
public abstract class GallerySample {

    static public void generate(GallerySample sample, String name) {
        try {
            File output = sample.generate();
            System.out.println("generated " + name + " to " + output.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("failed generating " + name);
            e.printStackTrace();
        }
    }
    
    private final File directory;
    
    public abstract Graph graph();
    public abstract File generate() throws Exception;

    protected GallerySample(String[] args) {
        if(args.length > 0) {
            this.directory = new File(args[0]);
        } else {
            this.directory = new File(System.getProperty("java.io.tmpdir"), "graph-gallery");
            if(! this.directory.exists()) {
                this.directory.mkdirs();
            }
        }
    }


    public void generateDotFile(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(this.graph().asDot());
        }
    }
    public File directory() {
        return this.directory;
    }
    
    protected File getOutputFile(String name) {
        return new File(this.directory(), name);
    }

}
