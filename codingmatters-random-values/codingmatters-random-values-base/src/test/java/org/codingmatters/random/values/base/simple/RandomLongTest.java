package org.codingmatters.random.values.base.simple;

import org.codingmatters.random.values.base.utils.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 10:01
 * To change this template use File | Settings | File Templates.
 */
public class RandomLongTest {
    @Test
    public void testDefault() throws Exception {
        Assert.assertNotNull( new RandomLong().value() ) ;
    }

    @Test
    public void testRange() throws Exception {
        RandomLong random = new RandomLong().min( 2L ).max( 4L ) ;
        Assert.assertInRange(2L, 4L, random.value()) ;
    }

    @Test
    public void testPositive() throws Exception {
        RandomLong random = new RandomLong().min( 0L ).max( 4L ) ;
        Assert.assertInRange(0L, 4L, random.value()) ;
    }

    @Test
    public void testNegative() throws Exception {
        RandomLong random = new RandomLong().min( -4L ).max( 0L ) ;
        Assert.assertInRange(-4L, 0L, random.value()) ;
    }

    @Test
    public void testZeroLengthRange() throws Exception {
        RandomLong random = new RandomLong().min( 4L ).max( 4L ) ;
        Assert.assertEquals( new Long( 4L ), random.value()) ;
    }

    @Test(expected = AssertionError.class)
    public void testMalformedRange() throws Exception {
        new RandomLong().min( 2L ).max( 1L ).value() ;
    }
    
}
