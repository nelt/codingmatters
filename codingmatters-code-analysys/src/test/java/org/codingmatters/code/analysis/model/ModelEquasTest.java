package org.codingmatters.code.analysis.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 24/07/13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class ModelEquasTest {

    @Test
    public void testMember() throws Exception {
        EqualsVerifier.forClass(MemberModel.class).verify();
    }

    @Test
    public void testMethod() throws Exception {
        EqualsVerifier.forClass(MethodModel.class).verify();
    }

    @Test
    public void testClass() throws Exception {
        EqualsVerifier.forClass(ClassModel.class).verify();
    }
    
}
