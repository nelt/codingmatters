package org.codingmatters.random.values.base.simple;

import org.codingmatters.random.values.base.utils.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/04/13
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class RandomDoubleTest {

    @Test
    public void testDefault() throws Exception {
        RandomDouble random = new RandomDouble() ;
        Assert.assertNotNull(random.value()) ;
    }

    @Test
    public void testRange() throws Exception {
        RandomDouble random = new RandomDouble().min( 2.0d ).max( 4.0d ) ;
        Assert.assertInRange( 2.0d , 4.0d , random.value() ) ;
    }

    @Test
    public void testPositive() throws Exception {
        RandomDouble random = new RandomDouble().min( 0.0d ).max( 5.0d ) ;
        Assert.assertInRange(0.0d, 5.0d, random.value());
    }

    @Test
    public void testNegative() throws Exception {
        RandomDouble random = new RandomDouble().min( -5.0d ).max( 0.0d ) ;
        Assert.assertInRange(-5.0d, 0.0d, random.value());
    }

    @Test
    public void testZeroLengthRange() throws Exception {
        RandomDouble random = new RandomDouble().min( 2.0d ).max( 2.0d ) ;
        Assert.assertEquals(new Double(2.0d) , random.value());
    }

    @Test(expected = AssertionError.class)
    public void testMalformedRange() throws Exception {
        new RandomDouble().min( 2.0d ).max( 1.0d ) ;
    }

}
