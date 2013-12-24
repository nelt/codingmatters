package org.codingmatters.code.analysis.model.from.code;

import org.codingmatters.code.analysis.model.*;
import org.codingmatters.code.analysis.model.from.code.inspected.member.OneMember;
import org.codingmatters.code.analysis.model.from.code.inspected.method.OneMethod;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 14:51
 */
public class CodeBaseLoaderTest extends AbstractTest implements CodeBaseLoaderTestConstants {

    @Test
    public void testDefaultConstructor() throws Exception {
        CodeBaseLoader loader = CodeBaseLoaders.loader();
        loader.addSourcePath(new File(INSPECTED_CODE_ROOT + "method")) ;
        CodeBaseModel codeBase = loader.load();
        
        assertEquals(
                new MethodModel("<init>", ClassModel.forName(OneMethod.class.getName())),
                codeBase.classForName(OneMethod.class.getName()).getMethod("<init>")
        );
    }
    
    @Test
    public void testMethod() throws Exception {
        CodeBaseLoader loader = CodeBaseLoaders.loader();
        loader.addSourcePath(new File(INSPECTED_CODE_ROOT + "method")) ;
        CodeBaseModel codeBase = loader.load();
        
        assertEquals(
                new MethodModel("method", ClassModel.forName(OneMethod.class.getName())),
                codeBase.classForName(OneMethod.class.getName()).getMethod("method")
        );
    }
    
    @Test
    public void testMember() throws Exception {
        CodeBaseLoader loader = CodeBaseLoaders.loader();
        loader.addSourcePath(new File(INSPECTED_CODE_ROOT + "member")) ;
        CodeBaseModel codeBase = loader.load();
        
        assertEquals(
                new MemberModel("member", ClassModel.forName(OneMember.class.getName())),
                codeBase.classForName(OneMember.class.getName()).getMember("member")
        );
    }
    
    
    
    
    
}
