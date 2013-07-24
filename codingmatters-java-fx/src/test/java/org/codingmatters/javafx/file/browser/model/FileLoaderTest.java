package org.codingmatters.javafx.file.browser.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 24/07/13
 * Time: 13:22
 * To change this template use File | Settings | File Templates.
 */
public class FileLoaderTest {
    private Path root;

    @Before
    public void setUp() throws Exception {
        this.root = Files.createTempDirectory("root") ;
    }

    @After
    public void tearDown() throws Exception {
        Files.walkFileTree(this.root, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
        Files.deleteIfExists(this.root);
    }

    @Test
    public void testEmpty() throws Exception {
        FileModel actual = new FileLoader(this.root).load() ;
        assertEquals(new FileModel(this.root.toFile().getName(), null), actual);
    }

    @Test
    public void testWithFiles() throws Exception {
        String expectedName = Files.createFile(Paths.get(this.root.toString(), "file.txt")).toFile().getName();
        
        FileModel actual = new FileLoader(this.root).load() ;
        assertEquals(set(new FileModel(expectedName, actual)), set(actual.children()));
    }

    @Test
    public void testWithHierarchy() throws Exception {
        Path dir = Paths.get(this.root.toString(), "dir");
        Files.createDirectory(dir);
        
        Path file = Paths.get(dir.toString(), "file.txt");
        Files.createFile(file) ;
        
        FileModel actual = new FileLoader(this.root).load() ;

        assertEquals(set(new FileModel(dir.toFile().getName(), actual)), set(actual.children()));
        assertEquals(set(new FileModel(file.toFile().getName(), actual.children().get(0))), set(actual.children().get(0).children()));
    }

    private Set set(List elements) {
        HashSet result = new HashSet() ;
        if(elements != null) {
            result.addAll(elements);
        }
        return result ;
    }

    private Set set(Object ... elements) {
        HashSet result = new HashSet() ;
        if(elements != null) {
            Collections.addAll(result, elements);
        }
        return result ;
    }
}
