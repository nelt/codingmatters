package org.codingmatters.code.analysis;

import org.codingmatters.code.analysis.inspected.InspectedClass;
import org.codingmatters.code.analysis.processors.TestInstanceVariableProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.processing.AbstractProcessor;
import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 19/07/13
 * Time: 06:15
 */
public class InstanceVariablesTest {
    
    private JavaCompiler.CompilationTask task;

    @Before
    public void setUp() throws Exception {
        File compilationPath = new File("./src/test/java/org/codingmatters/code/analysis/inspected");
        System.out.println(compilationPath.getAbsolutePath());
        this.prepareCompilation(compilationPath);
    }

    private void prepareCompilation(File inspectedDir) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        fileManager.setLocation(
                StandardLocation.SOURCE_PATH, 
                Collections.singleton(inspectedDir.getAbsoluteFile())
        );
        Iterable<JavaFileObject> sources = fileManager.list(StandardLocation.SOURCE_PATH, "", Collections.singleton(JavaFileObject.Kind.SOURCE), true);
        
        this.task = compiler.getTask(null, fileManager, null, null, null, sources);
    }

    @Test
    public void testVariableNames() throws Exception {
        TestInstanceVariableProcessor processor = new TestInstanceVariableProcessor(InspectedClass.class.getName()) ;
        compileWithProcessors(processor);

        Assert.assertEquals(set("stringField"), processor.variableNames());
    }

    private Set set(Object ... elements) {
        Set result = new HashSet();
        if(elements != null) {
            for (Object element : elements) {
                result.add(element) ;
            }
        }
        return result;
    }
    private List list(Object ... elements) {
        List result = new LinkedList();
        if(elements != null) {
            for (Object element : elements) {
                result.add(element) ;
            }
        }
        return result;
    }

    private void compileWithProcessors(AbstractProcessor ... processors) {
        this.task.setProcessors(Arrays.asList(processors));
        this.task.call();
    }
}
