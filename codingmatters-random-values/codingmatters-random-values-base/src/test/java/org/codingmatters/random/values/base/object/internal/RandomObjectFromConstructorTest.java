package org.codingmatters.random.values.base.object.internal;

import org.codingmatters.random.values.base.RandomValues;
import org.codingmatters.random.values.base.object.RandomObject;
import org.codingmatters.random.values.base.utils.Assert;
import org.codingmatters.random.values.base.utils.TestClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class RandomObjectFromConstructorTest {
    @Test
    public void testRandomArguments() throws Exception {
        RandomObject<TestClass> random = new RandomObjectFromConstructor<TestClass>(
                TestClass.class.getConstructor(String.class, Float.class),
                RandomValues.string(),
                RandomValues.float_()
        ) ;

        TestClass actual = random.value();

        Assert.assertNotNull(actual) ;
        Assert.assertNotNull( actual.getStr() ) ;
        Assert.assertNotNull( actual.getF() ) ;
    }

    @Test
    public void testFixedArguments() throws Exception {
        RandomObject<TestClass> random = new RandomObjectFromConstructor<TestClass>(
                TestClass.class.getConstructor(String.class, Float.class) ,
                "fixed" ,
                12f
        ) ;

        TestClass actual = random.value();

        Assert.assertNotNull( actual ) ;
        Assert.assertEquals( "fixed" , actual.getStr() );
        Assert.assertEquals( new Float( 12 ) , actual.getF() );
    }



    @Test
    public void testMixedArguments() throws Exception {
        RandomObject<TestClass> random = new RandomObjectFromConstructor<TestClass>(
                TestClass.class.getConstructor(String.class, Float.class) ,
                RandomValues.string() ,
                12f
        ) ;

        TestClass actual = random.value();

        Assert.assertNotNull( actual ) ;
        Assert.assertNotNull( actual.getStr() );
        Assert.assertEquals( new Float( 12 ) , actual.getF() );
    }


    @Ignore
    @Test(expected = Exception.class)
    public void testWrongParameters() throws Exception {

    }
}
