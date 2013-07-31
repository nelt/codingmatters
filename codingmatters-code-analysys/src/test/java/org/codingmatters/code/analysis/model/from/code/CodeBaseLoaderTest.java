package org.codingmatters.code.analysis.model.from.code;

import org.codingmatters.code.analysis.model.AbstractTest;
import org.codingmatters.code.analysis.model.ClassModel;
import org.codingmatters.code.analysis.model.CodeBaseModel;
import org.codingmatters.code.analysis.model.MethodModel;
import org.codingmatters.code.analysis.model.from.code.inspected.method.OneMethod;
import org.junit.Assert;
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
    public void testMethod() throws Exception {
        CodeBaseLoader loader = new CodeBaseLoader();
        loader.addSourcePath(new File(INSPECTED_CODE_ROOT + "method")) ;
        CodeBaseModel codeBase = loader.load();

        ClassModel model = codeBase.classForName(OneMethod.class.getName());
        
        assertEquals(
                new MethodModel("method", ClassModel.forName(OneMethod.class.getName())),
                codeBase.classForName(OneMethod.class.getName()).getMethod("method")
        );
    }
}
