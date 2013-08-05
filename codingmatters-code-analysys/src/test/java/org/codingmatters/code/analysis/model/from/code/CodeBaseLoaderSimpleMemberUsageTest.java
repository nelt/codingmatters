package org.codingmatters.code.analysis.model.from.code;

import org.codingmatters.code.analysis.model.*;
import org.codingmatters.code.analysis.model.from.code.inspected.memberusage.SimpleMemberUsage;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 02/08/13
 * Time: 07:03
 */
public class CodeBaseLoaderSimpleMemberUsageTest extends AbstractTest implements CodeBaseLoaderTestConstants {

    private ClassModel load() throws IOException {
        CodeBaseModel codeBase = new CodeBaseLoader()
                .addSourcePath(new File(INSPECTED_CODE_ROOT + "memberusage")) 
                .load();
        return codeBase.classForName(SimpleMemberUsage.class.getName());
    }
    
    @Test
    public void testAssignement() throws Exception {
        ClassModel classModel = this.load();
                
        MethodModel actual = classModel.getMethod("memberAssignement");
        MemberModel member = classModel.getMember("member");

        assertTrue(actual.uses(member));
    }


    @Test
    public void testAssignementToThis() throws Exception {
        ClassModel classModel = this.load();
        
        MethodModel actual = classModel.getMethod("thisMemberAssignement");
        MemberModel member = classModel.getMember("member");
        
        assertTrue(actual.uses(member));
    }
    
    
    @Test
    public void testInLoop() throws Exception {
        ClassModel classModel = this.load();
        
        MemberModel member = classModel.getMember("member");
        MethodModel actual = classModel.getMethod("memberInLoop");
        
        assertTrue(actual.uses(member));
    }



}
