package org.codingmatters.code.analysis.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 06:36
 * To change this template use File | Settings | File Templates.
 */
public class MethodModelTest extends AbstractTest{
    
    private ClassModel classModel;

    @Before
    public void setUp() throws Exception {
        this.classModel = ClassModel.forName("org", "Test");
        this.classModel.member("field");
    }
    
    @Test
    public void testAddMemberUsage() throws Exception {
        MemberModel memberModel = this.classModel.member("field").getMember("field");
        MethodModel actual = this.addMethod("method")
                .usedMember(memberModel)
                ;
        assertEquals(set(memberModel), actual.getUsedMembers());
        assertTrue(actual.uses(memberModel));
    }
    
    @Test
    public void testAddMethodUsage() throws Exception {
        MethodModel usedMethod = this.addMethod("usedMethod");
        MethodModel actual = this.addMethod("method")
                .usedMethod(usedMethod)
                ;
        
        assertEquals(set(usedMethod), actual.getUsedMethods());
        assertTrue(actual.uses(usedMethod));
    }

    private MethodModel addMethod(String method) {
        return this.classModel.method(method).getMethod(method);
    }
}
