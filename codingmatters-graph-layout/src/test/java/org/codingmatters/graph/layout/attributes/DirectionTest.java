package org.codingmatters.graph.layout.attributes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 07:45
 */
public class DirectionTest {

    @Test
    public void testBR() throws Exception {
        assertEquals("BR", Direction.major(Direction.Dir.BOTTOM).minor(Direction.Dir.RIGHT).formatted());
    }
    
    @Test
    public void testB() throws Exception {
        assertEquals("BL", Direction.major(Direction.Dir.BOTTOM).formatted());
    }
    
}
