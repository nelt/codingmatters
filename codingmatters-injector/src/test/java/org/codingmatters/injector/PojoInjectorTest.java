package org.codingmatters.injector;


import org.codingmatters.injector.beans.TestAnotation;
import org.codingmatters.injector.beans.TestBean;
import org.codingmatters.injector.injectors.AnnotationMatcher;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;

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

    @Test
    public void testUnexistentFieldIgnored() throws Exception {
        new PojoInjector()
                .rawField("noSuchField", "injected value")
                .injectValues(new TestBean())
        ;
    }

    @Test
    public void testAnnotatedField() throws Exception {
        TestBean bean = new PojoInjector()
                .annotatedField(TestAnotation.class, "injected value")
                .injectValues(new TestBean())
                ;

        Assert.assertEquals("injected value", bean.getAnnotatedField());
    }

    @Test
    public void testAnnotatedFieldWithMatcherMatching() throws Exception {
        TestBean bean = new PojoInjector()
                .annotatedField(TestAnotation.class , new AnnotationMatcher<TestAnotation>(){
                    @Override
                    public boolean matches(TestAnotation annotation) throws Exception {
                        return annotation.name().equals("test") ;
                    }
                }, "injected value")
                .injectValues(new TestBean())
                ;

        Assert.assertEquals("injected value", bean.getAnnotatedField());
    }
    
    @Test
    public void testAnnotatedFieldWithMatcherNotMatching() throws Exception {
        TestBean bean = new PojoInjector()
                .annotatedField(TestAnotation.class , new AnnotationMatcher<TestAnotation>(){
                    @Override
                    public boolean matches(TestAnotation annotation) throws Exception {
                        return annotation.name().equals("not") ;
                    }
                }, "injected value")
                .injectValues(new TestBean())
                ;

        Assert.assertNull(bean.getAnnotatedField());
    }
}