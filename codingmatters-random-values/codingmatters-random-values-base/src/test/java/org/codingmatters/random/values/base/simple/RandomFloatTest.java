package org.codingmatters.random.values.base.simple;

import org.codingmatters.random.values.base.utils.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/04/13
 * Time: 21:40
 * To change this template use File | Settings | File Templates.
 */
public class RandomFloatTest {

    @Test
    public void testDefault() throws Exception {
        RandomFloat randomFloat = new RandomFloat() ;
        Assert.assertNotNull(randomFloat.value()) ;
    }

    @Test
    public void testRange() throws Exception {
        RandomFloat randomFloat = new RandomFloat().min( 2.0f ).max( 4.0f) ;
        Assert.assertInRange( 2.0f , 4.0f , randomFloat.value() ) ;
    }

    @Test
    public void testPositive() throws Exception {
        RandomFloat randomFloat = new RandomFloat().min( 0.0f ).max( 5.0f ) ;
        Assert.assertInRange(0.0f, 5.0f, randomFloat.value());
    }

    @Test
    public void testNegative() throws Exception {
        RandomFloat randomFloat = new RandomFloat().min( -5.0f ).max( 0.0f ) ;
        Assert.assertInRange(-5.0f, 0.0f, randomFloat.value());
    }

    @Test
    public void testZeroLengthRange() throws Exception {
        RandomFloat randomFloat = new RandomFloat().min( 2.0f ).max( 2.0f ) ;
        Assert.assertEquals(new Float(2.0f) , randomFloat.value());
    }

    @Test(expected = AssertionError.class)
    public void testMalformedRange() throws Exception {
        new RandomFloat().min( 2.0f ).max( 1.0f ) ;
    }
}
