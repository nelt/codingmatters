package org.codingmatters.javafx.file.browser.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 24/07/13
 * Time: 13:17
 * To change this template use FileModel | Settings | FileModel Templates.
 */
public class FileModel {
    private final String name ;
    private final FileModel parent ;

    public FileModel(String name, FileModel parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileModel fileModel = (FileModel) o;

        if (name != null ? !name.equals(fileModel.name) : fileModel.name != null) return false;
        if (parent != null ? !parent.equals(fileModel.parent) : fileModel.parent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }

    private final LinkedList<FileModel> children = new LinkedList<>() ;
    
    public List<FileModel> children() {
        return this.children;
    }

    public FileModel addChild(String name) {
        FileModel result = new FileModel(name, this);
        this.children.add(result) ;
        return result;
    }
}
