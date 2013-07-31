package org.codingmatters.code.analysis.model.from.code;

import org.codingmatters.code.analysis.model.AbstractTest;
import org.codingmatters.code.analysis.model.ClassModel;
import org.codingmatters.code.analysis.model.CodeBaseModel;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 07:01
 */
public class CodeBaseLoaderTest extends AbstractTest {
    
    @Test
    public void testEmptySource() throws Exception {
        CodeBaseLoader loader = new CodeBaseLoader();
        loader.addSourcePath(new File("./src/test/java/org/codingmatters/code/analysis/model/from/code/inspected/empty")) ;
        CodeBaseModel codeBase = loader.load();

        assertEquals(set(), set(codeBase.allClassesLookup().lookup())) ;
    }

    @Test
    public void testBrokenSource() throws Exception {
        CodeBaseLoader loader = new CodeBaseLoader();
        loader.addSourcePath(new File("./src/test/java/org/codingmatters/code/analysis/model/from/code/inspected/broken")) ;
        CodeBaseModel codeBase = loader.load();

        assertEquals(set(), set(codeBase.allClassesLookup().lookup())) ;
    }
    
    
    @Test
    public void testOneSourcePath() throws Exception {
        CodeBaseLoader loader = new CodeBaseLoader();
        loader.addSourcePath(new File("./src/test/java/org/codingmatters/code/analysis/model/from/code/inspected/oneclass")) ;
        CodeBaseModel codeBase = loader.load();

        assertEquals(
                set(ClassModel.forName("org.codingmatters.code.analysis.model.from.code.inspected.oneclass", "Empty")), 
                set(codeBase.allClassesLookup().lookup())) ;
    }
    
    @Test
    public void testTwoSourcePath() throws Exception {
        CodeBaseLoader loader = new CodeBaseLoader();
        loader.addSourcePath(new File("./src/test/java/org/codingmatters/code/analysis/model/from/code/inspected/oneclass")) ;
        loader.addSourcePath(new File("./src/test/java/org/codingmatters/code/analysis/model/from/code/inspected/anotherclass")) ;
        CodeBaseModel codeBase = loader.load();

        assertEquals(
                set(
                        ClassModel.forName("org.codingmatters.code.analysis.model.from.code.inspected.oneclass", "Empty"),
                        ClassModel.forName("org.codingmatters.code.analysis.model.from.code.inspected.anotherclass", "Empty")
                ), 
                set(codeBase.allClassesLookup().lookup())) ;
    }
}
