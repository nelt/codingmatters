package org.codingmatters.javafx.file.browser.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 24/07/13
 * Time: 13:21
 * To change this template use FileModel | Settings | FileModel Templates.
 */
public class FileLoader {
    
    private final Path root ;

    public FileLoader(Path root) {
        this.root = root;
    }


    public FileModel load() throws IOException {
        Path parent = this.root;
        FileModel result = new FileModel(parent.toFile().getName(), null);
        this.loadChildren(parent, result);
        return result;
    }
    
    private void loadChildren(Path parentPath, FileModel parentModel) throws IOException {
        if(Files.isDirectory(parentPath)) {
            for (Path childPath : Files.newDirectoryStream(parentPath)) {
                FileModel childModel = parentModel.addChild(childPath.toFile().getName());
                this.loadChildren(childPath, childModel) ;
            }
        }
    }
}
