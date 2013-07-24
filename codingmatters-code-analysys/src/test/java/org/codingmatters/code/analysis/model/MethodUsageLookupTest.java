package org.codingmatters.code.analysis.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 24/07/13
 * Time: 07:16
 * To change this template use File | Settings | File Templates.
 */
public class MethodUsageLookupTest extends AbstractTest {
    @Test
    public void testNoUsage() throws Exception {
        ClassModel model = ClassModel.forName("test", "Test") ;
        model
                .method("notUsingAnything")
                .method("notUsed")
        ;
        assertEquals(
                set(),
                set(model.usingLookup(model.getMethod("notUsed")).lookup()));
    }


    @Test
    public void testUsage() throws Exception {
        ClassModel model = ClassModel.forName("test", "Test") ;
        model
                .method("used")
                .method("usingMethod", new Usage().method(model.getMethod("used")))
        ;
        assertEquals(
                set(model.getMethod("usingMethod")),
                set(model.usingLookup(model.getMethod("used")).lookup()));
    }
}
