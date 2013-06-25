package org.codingmatters.injector;


import org.codingmatters.injector.beans.TestBean;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 25/06/13
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
public class PojoInjectorTest {
    @Test
    public void testRawPrivateField() throws Exception {
        TestBean bean = new PojoInjector()
                .rawField("rawField", "injected value")
                .injectValues(new TestBean())
                ;
        
        Assert.assertEquals("injected value", bean.getRawField());
    }
}
