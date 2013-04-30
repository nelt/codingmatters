package org.codingmatters.random.values.base;

import org.codingmatters.random.values.base.utils.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/04/13
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */
public class RandomValuesTest {

    @Test
    public void testFloat() throws Exception {
        Assert.assertNotNull(RandomValues.float_().value()) ;
    }

    @Test
    public void testDouble() throws Exception {
        Assert.assertNotNull(RandomValues.double_().value() ) ;
    }

    @Test
    public void testInteger() throws Exception {
        Assert.assertNotNull(RandomValues.integer().value() ) ;
    }

    @Test
    public void testLong() throws Exception {
        Assert.assertNotNull(RandomValues.long_().value() ) ;
    }

    @Test
    public void testString() throws Exception {
        Assert.assertNotNull(RandomValues.string().value() ) ;
    }
}
