package org.codingmatters.code.analysis.model;

import org.codingmatters.code.analysis.model.lookup.Lookup;
import org.junit.Assert;
import org.junit.Ignore;
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
    
    @Ignore
    @Test
    public void testMemberUsage() throws Exception {
        ClassModel model = ClassModel.forName("test", "Test");
        
        model
                .member("first")
                .member("second")
                
                .method("usingFirst")
                .method("usingSecond")
                .method("usingBoth")
                .method("notUsingAnything")
                ;
        model.getMethod("usingFirst").uses(model.getMember("first"));
        model.getMethod("usingSecond").uses(model.getMember("second"));
        model.getMethod("usingBoth").uses(model.getMember("first"));
        model.getMethod("usingBoth").uses(model.getMember("second"));

        Lookup<ClassModel, MethodModel> usingFirstLookup = model.usingLookup(model.getMember("first"));
        Lookup<ClassModel, MethodModel> usingSecondLookup = model.usingLookup(model.getMember("second"));
        
        assertEquals(
                set(model.getMethod("usingFirst"), model.getMethod("usingBoth")), 
                set(usingFirstLookup.lookup()));
        assertEquals(
                set(model.getMethod("usingSecond"), model.getMethod("usingBoth")), 
                set(usingSecondLookup.lookup()));
    }
}
