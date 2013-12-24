package org.codingmatters.code.analysis.model.from.code.internal;

import org.codingmatters.code.analysis.model.from.code.CodeBaseLoaderTestConstants;
import org.codingmatters.code.analysis.model.from.code.inspected.memberusage.MemberDeclaredAfterMemberUsage;
import org.codingmatters.code.analysis.model.from.code.inspected.memberusage.SimpleMemberUsage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 24/09/13
 * Time: 08:48
 * To change this template use File | Settings | File Templates.
 */
public class SourcePathAdderTest implements SourcePathIndexer, CodeBaseLoaderTestConstants {

    private ArrayList<String> indexed;

    @Before
    public void setUp() throws Exception {
        this.indexed = new ArrayList<>();
    }

    @Override
    public void index(String name) {
        this.indexed.add(name);
    }

    @Test
    public void testPackagePattern() throws Exception {
        Pattern pattern = Pattern.compile(SourcePathAdder.PACKAGE_PATTERN);
        
        Assert.assertTrue(pattern.matcher("package un.deux.trois ;").matches());
        Assert.assertTrue(pattern.matcher("package    un.deux.trois;").matches());
    }

    @Test
    public void testExtractPackage() throws Exception {
        File javaFile = new File(INSPECTED_CODE_ROOT + "memberusage/SimpleMemberUsage.java");
        assertEquals(
                "org.codingmatters.code.analysis.model.from.code.inspected.memberusage", 
                SourcePathAdder.extractPackage(javaFile));
    }

    @Test
    public void testSources() throws Exception {
        new SourcePathAdder(new File(INSPECTED_CODE_ROOT + "memberusage")).add(this);
        assertEquals(
                set(
                        MemberDeclaredAfterMemberUsage.class.getName(),
                        SimpleMemberUsage.class.getName()
                ), 
                set(this.indexed.toArray()));
    }

    private Set set(Object ... elements) {
        HashSet result = new HashSet();
        for (Object element : elements) {
            result.add(element);
        }
        return result;
    }
}
