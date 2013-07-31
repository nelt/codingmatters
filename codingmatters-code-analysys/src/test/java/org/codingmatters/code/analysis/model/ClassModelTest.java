package org.codingmatters.code.analysis.model;

import org.codingmatters.code.analysis.inspected.InspectedClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 06:10
 * To change this template use File | Settings | File Templates.
 */
public class ClassModelTest {

    @Test
    public void testForName() throws Exception {
        ClassModel model = ClassModel.forName("org.codingmatters.code.analysis.inspected", "InspectedClass") ;

        assertEquals("InspectedClass", model.getClassName());
        assertEquals("org.codingmatters.code.analysis.inspected", model.getPackageName());
    }
    
    @Test
    public void testForQualifiedName() throws Exception {
        ClassModel model = ClassModel.forName("org.codingmatters.code.analysis.inspected.InspectedClass") ;

        assertEquals("InspectedClass", model.getClassName());
        assertEquals("org.codingmatters.code.analysis.inspected", model.getPackageName());
    }

    @Test
    public void testMembers() throws Exception {
        ClassModel model = ClassModel.forName("org.codingmatters.code.analysis.inspected", "InspectedClass") 
                .member("stringField")
                ;
        
        MemberModel memberModel = model.getMember("stringField");
        
        assertNotNull(memberModel);
        assertEquals("stringField", memberModel.getName());
        assertEquals(model, memberModel.getClassModel());
    }

    @Test
    public void testMethod() throws Exception {
        ClassModel model = ClassModel.forName("org.codingmatters.code.analysis.inspected", "InspectedClass")
                .method("aMethodUsingStringField")
                ;
        
        MethodModel methodModel = model.getMethod("aMethodUsingStringField");
        assertNotNull(methodModel);
        assertEquals("aMethodUsingStringField", methodModel.getName());
        assertEquals(model, methodModel.getClassModel());
    }
}
