package org.codingmatters.random.values.base.simple;

import org.codingmatters.random.values.base.utils.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 09:47
 * To change this template use File | Settings | File Templates.
 */
public class RandomIntegerTest {

    @Test
    public void testDefault() throws Exception {
        RandomInteger random = new RandomInteger() ;
        Assert.assertNotNull( random.value() ) ;
    }

    @Test
    public void testRange() throws Exception {
        RandomInteger random = new RandomInteger().min( 2 ).max( 4 ) ;
        Assert.assertInRange( 2 , 4 , random.value() ) ;
    }

    @Test
    public void testPositive() throws Exception {
        RandomInteger random = new RandomInteger().min( 0 ).max( 4 ) ;
        Assert.assertInRange( 0 , 4 , random.value() ) ;
    }

    @Test
    public void testNegative() throws Exception {
        RandomInteger random = new RandomInteger().min( -2 ).max( 0 ) ;
        Assert.assertInRange( -2 , 0 , random.value() ) ;
    }

    @Test
    public void testZeroLengthRange() throws Exception {
        RandomInteger random = new RandomInteger().min( 2 ).max( 2 ) ;
        Assert.assertEquals(new Integer(2), random.value());
    }

    @Test(expected = AssertionError.class)
    public void testMalformedRange() throws Exception {
        new RandomInteger().min( 2 ).max( -2 ).value() ;
    }
}
