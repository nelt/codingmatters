package org.codingmatters.code.analysis.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 06:36
 * To change this template use File | Settings | File Templates.
 */
public class MethodModelTest extends AbstractTest{
    
    private ClassModel classModel;
    private MemberModel memberModel;

    @Before
    public void setUp() throws Exception {
        this.classModel = ClassModel.forName("org", "Test");
        this.classModel.member("field");
        this.memberModel = this.classModel.member("field").getMember("field");
    }
    
    @Test
    public void testAddMemberUsage() throws Exception {
        MethodModel actual = this.addMethod("method")
                .uses(this.memberModel)
                ;
        Assert.assertEquals(set(this.memberModel), actual.getUsedMembers());
    }
    
    @Test
    public void testAddMethodUsage() throws Exception {
        MethodModel usedMethod = this.addMethod("usedMethod");
        MethodModel actual = this.addMethod("method")
                .uses(usedMethod)
                ;
        
        Assert.assertEquals(set(usedMethod), actual.getUsedMethods());
    }

    private MethodModel addMethod(String method) {
        return this.classModel.method(method).getMethod(method);
    }
}
