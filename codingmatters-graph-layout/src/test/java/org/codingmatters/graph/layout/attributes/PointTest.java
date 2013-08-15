package org.codingmatters.graph.layout.attributes;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 06:34
 */
public class PointTest {

    @Test
    public void testXY() throws Exception {
        Point actual = Point.xy(10, 12);
        Assert.assertEquals("10.0,12.0", actual.formatted());
    }
    
    @Test
    public void testXYInputOnly() throws Exception {
        Point actual = Point.xy(10, 12).inputOnly();
        Assert.assertEquals("10.0,12.0!", actual.formatted());
    }
    
    @Test
    public void testXYZ() throws Exception {
        Point actual = Point.xy(10, 12).z(14);
        Assert.assertEquals("10.0,12.0,14.0", actual.formatted());
    }
    
    @Test
    public void testXYZInputOnly() throws Exception {
        Point actual = Point.xy(10, 12).z(14).inputOnly();
        Assert.assertEquals("10.0,12.0,14.0!", actual.formatted());
    }
}
