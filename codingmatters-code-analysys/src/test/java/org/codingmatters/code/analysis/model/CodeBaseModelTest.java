package org.codingmatters.code.analysis.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 25/07/13
 * Time: 03:59
 * To change this template use File | Settings | File Templates.
 */
public class CodeBaseModelTest extends AbstractTest{

    @Test
    public void testGetClass() throws Exception {
        CodeBaseModel model = new CodeBaseModel()
                .addClass(ClassModel.forName("org", "Test1"))
                .addClass(ClassModel.forName("org", "Test2"))
                ;
        assertEquals(ClassModel.forName("org", "Test1"), model.classForName("org.Test1"));
    }

    @Test
    public void testLookupClasses() throws Exception {
        CodeBaseModel model = new CodeBaseModel()
                .addClass(ClassModel.forName("org", "Test1"))
                .addClass(ClassModel.forName("org", "Test2"))
                ;
        assertEquals(
                set(ClassModel.forName("org", "Test1"), ClassModel.forName("org", "Test2")), 
                set(model.allClassesLookup().lookup()));
    }

    @Test
    public void testLookupPackageClasses() throws Exception {
        CodeBaseModel model = new CodeBaseModel()
                .addClass(ClassModel.forName("org.p1", "Test1"))
                .addClass(ClassModel.forName("org.p2", "Test2"))
                .addClass(ClassModel.forName("org.p1.p2", "Test3"))
                ;
        assertEquals(
                set(ClassModel.forName("org.p1", "Test1")), 
                set(model.packageClassesLookup("org.p1").lookup()));
        assertEquals(
                set(ClassModel.forName("org.p1.p2", "Test3")),
                set(model.packageClassesLookup("org.p1.p2").lookup()));
    }

    @Test
    public void testMemberUsageLookup() throws Exception {
        CodeBaseModel model = new CodeBaseModel();
        model
                .addClass(ClassModel.forName("org", "Test1").member("field"))
                .addClass(ClassModel.forName("org", "Test2"))
                ;
        model.classForName("org.Test1").method("method", new Usage().member(model.classForName("org.Test1").getMember("field"))) ;
        model.classForName("org.Test2")
                .method("usingMethod", new Usage().member(model.classForName("org.Test1").getMember("field")))
                .method("notUsing")
                ;
        
        assertEquals(
                set(model.classForName("org.Test1").getMethod("method"), model.classForName("org.Test2").getMethod("usingMethod")),
                set(model.usageLookup(model.classForName("org.Test1").getMember("field")).lookup())
        );
    }

    @Test
    public void testMethodUsageLookup() throws Exception {
        CodeBaseModel model = new CodeBaseModel();
        model
                .addClass(ClassModel.forName("org", "Test1").method("used"))
                .addClass(ClassModel.forName("org", "Test2"))
        ;
        
        model.classForName("org.Test1").method("using", new Usage().method(model.classForName("org.Test1").getMethod("used"))) ;
        model.classForName("org.Test2")
                .method("using", new Usage().method(model.classForName("org.Test1").getMethod("used")))
                .method("notUsing")
        ;
        
        assertEquals(
                set(model.classForName("org.Test1").getMethod("using"), model.classForName("org.Test2").getMethod("using")),
                set(model.usageLookup(model.classForName("org.Test1").getMethod("used")).lookup())
        );
    }
}
