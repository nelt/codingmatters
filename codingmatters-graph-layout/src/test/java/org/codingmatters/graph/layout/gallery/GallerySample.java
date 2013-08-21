package org.codingmatters.graph.layout.gallery;

import java.io.File;
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

    private final File directory;

    public abstract void generate() throws Exception;

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

    public File directory() {
        return this.directory;
    }
    
    protected File getOutputFile(String name) {
        return new File(this.directory(), name);
    }
}
