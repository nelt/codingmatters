package org.codingmatters.code.analysis.model.from.code;

import org.codingmatters.code.analysis.model.*;
import org.codingmatters.code.analysis.model.from.code.inspected.memberusage.SimpleMemberUsage;
import org.codingmatters.code.analysis.model.from.code.inspected.methodusage.SimpleMethodUsage;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 05/08/13
 * Time: 07:53
 */
public class CodeBaseLoaderMethodUsageTest extends AbstractTest implements CodeBaseLoaderTestConstants {

    protected ClassModel load() throws IOException {
        CodeBaseModel codeBase = new CodeBaseLoader()
                .addSourcePath(new File(INSPECTED_CODE_ROOT + "methodusage"))
                .load();
        return codeBase.classForName(SimpleMethodUsage.class.getName());
    }
    
    

    @Test
    public void testNoUsage() throws Exception {
        ClassModel classModel = this.load();

        MethodModel actual = classModel.getMethod("noUsage");
        MethodModel used = classModel.getMethod("used");

        assertFalse(actual.uses(used));
    }


    @Ignore
    @Test
    public void testQualifiedUsage() throws Exception {
        ClassModel classModel = this.load();

        MethodModel actual = classModel.getMethod("qualifiedUsage");
        MethodModel used = classModel.getMethod("used");

        assertTrue(actual.uses(used));
    }
    
    @Ignore
    @Test
    public void testUnqualifiedUsage() throws Exception {
        ClassModel classModel = this.load();

        MethodModel actual = classModel.getMethod("unqualifiedUsage");
        MethodModel used = classModel.getMethod("used");

        assertTrue(actual.uses(used));
    }
    
    
    
}
