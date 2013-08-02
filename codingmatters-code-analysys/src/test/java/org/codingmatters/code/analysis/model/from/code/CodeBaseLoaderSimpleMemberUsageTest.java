package org.codingmatters.code.analysis.model.from.code;

import org.codingmatters.code.analysis.model.AbstractTest;
import org.codingmatters.code.analysis.model.CodeBaseModel;
import org.codingmatters.code.analysis.model.MethodModel;
import org.codingmatters.code.analysis.model.from.code.inspected.memberusage.SimpleMemberUsage;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 02/08/13
 * Time: 07:03
 */
public class CodeBaseLoaderSimpleMemberUsageTest extends AbstractTest implements CodeBaseLoaderTestConstants {

    @Test
    public void testAssignement() throws Exception {
        CodeBaseLoader loader = new CodeBaseLoader();
        loader.addSourcePath(new File(INSPECTED_CODE_ROOT + "memberusage")) ;
        CodeBaseModel codeBase = loader.load();

        MethodModel actual = codeBase.classForName(SimpleMemberUsage.class.getName()).getMethod("memberAssignement");
        
        assertTrue(actual.uses(codeBase.classForName(SimpleMemberUsage.class.getName()).getMember("member")));
    }
    
    @Test
    public void testAssignementToThis() throws Exception {
        CodeBaseLoader loader = new CodeBaseLoader();
        loader.addSourcePath(new File(INSPECTED_CODE_ROOT + "memberusage")) ;
        CodeBaseModel codeBase = loader.load();
        
        MethodModel actual = codeBase.classForName(SimpleMemberUsage.class.getName()).getMethod("thisMemberAssignement");
        
        assertTrue(actual.uses(codeBase.classForName(SimpleMemberUsage.class.getName()).getMember("member")));
    }
}
