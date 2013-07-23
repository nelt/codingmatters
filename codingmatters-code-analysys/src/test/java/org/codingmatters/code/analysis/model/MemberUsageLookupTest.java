package org.codingmatters.code.analysis.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 07:05
 * To change this template use File | Settings | File Templates.
 */
public class MemberUsageLookupTest extends AbstractTest {

    @Test
    public void testNoUsage() throws Exception {
        ClassModel model = ClassModel.forName("test", "Test")
                .member("first")
                .member("second")
                
                .method("usingFirst")
                .method("notUsingAnything")
                ;
        assertEquals(
                set(),
                set(model.usingLookup(model.getMember("second")).lookup()));
    }

    @Test
    public void testMemberUsage() throws Exception {
        ClassModel model = ClassModel.forName("test", "Test")
                .member("first")
                .member("second")
                
                .method("usingFirst")
                .method("usingSecond")
                .method("usingBoth")
                .method("notUsingAnything")
                ;
        model.getMethod("usingFirst").usedMember(model.getMember("first"));
        model.getMethod("usingSecond").usedMember(model.getMember("second"));
        model.getMethod("usingBoth").usedMember(model.getMember("first"));
        model.getMethod("usingBoth").usedMember(model.getMember("second"));

        assertEquals(
                set(model.getMethod("usingFirst"), model.getMethod("usingBoth")), 
                set(model.usingLookup(model.getMember("first")).lookup()));
        assertEquals(
                set(model.getMethod("usingSecond"), model.getMethod("usingBoth")), 
                set(model.usingLookup(model.getMember("second")).lookup()));
    }

    @Test
    public void testUsageShortcut() throws Exception {
        ClassModel model = ClassModel.forName("test", "Test");
        model
            .member("member1")
            .member("member2")
            .method("method1")
            .method("method2")
            .method("method", new Usage()
                    .member(model.getMember("member1"))
                    .member(model.getMember("member2"))
                    .method(model.getMethod("method1"))
                    .method(model.getMethod("method2"))
                )
            ;
        
        assertEquals(set(model.getMember("member1"), model.getMember("member2")), model.getMethod("method").getUsedMembers());
        assertEquals(set(model.getMethod("method1"), model.getMethod("method2")), model.getMethod("method").getUsedMethods());
    }
}
