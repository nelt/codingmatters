package org.codingmatters.code.analysis.model.from.code;

import org.codingmatters.code.analysis.model.*;
import org.codingmatters.code.analysis.model.from.code.inspected.memberusage.SimpleMemberUsage;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 02/08/13
 * Time: 07:03
 */
public class CodeBaseLoaderMemberUsageTest extends AbstractTest implements CodeBaseLoaderTestConstants {

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

    @Test
    public void testInMethodCall() throws Exception {
        ClassModel classModel = this.load();
        
        MemberModel member = classModel.getMember("member");
        MethodModel actual = classModel.getMethod("memberInMethodCall");
        
        assertTrue(actual.uses(member));
    }

    @Test
    public void testInReturnStatement() throws Exception {
        ClassModel classModel = this.load();
        
        MemberModel member = classModel.getMember("member");
        MethodModel actual = classModel.getMethod("memberInReturn");
        
        assertTrue(actual.uses(member));
    }

    @Test
    public void testMaskedMember() throws Exception {
        ClassModel classModel = this.load();
        
        MemberModel member = classModel.getMember("member");
        MethodModel actual = classModel.getMethod("memberMasked");
        
        assertFalse(actual.uses(member));
    }
    
    @Test
    public void testMaskedMemberInBlock() throws Exception {
        ClassModel classModel = this.load();
        
        MemberModel member = classModel.getMember("member");
        MethodModel actual = classModel.getMethod("maskedInBlock");
        
        assertFalse(actual.uses(member));
    }
    
    @Test
    public void testPreviouslyMaskedMember() throws Exception {
        ClassModel classModel = this.load();
        
        MemberModel member = classModel.getMember("member");
        MethodModel actual = classModel.getMethod("previouslyMaskedMember");
        
        assertTrue(actual.uses(member));
    }

    


}
