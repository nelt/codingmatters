package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.attributes.values.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 14/08/13
 * Time: 07:47
 */
public class ColorTest {

    @Test
    public void testRGB() throws Exception {
        assertEquals("#aabbcc", Color.rgb("aa", "bb", "cc").formatted());
    }
    
    @Test
    public void testRGBTruncated() throws Exception {
        assertEquals("#aabbcc", Color.rgb("aaaa", "bbbb", "cccc").formatted());
    }

    @Test
    public void testRGBA() throws Exception {
        assertEquals("#aabbccxx", Color.rgba("aa", "bb", "cc", "xx").formatted());
    }

    @Test
    public void testHSV() throws Exception {
        assertEquals("0.482 0.714 0.878", Color.hsv(0.482f, 0.714f, 0.878f).formatted());
    }

    @Test
    public void testNamed() throws Exception {
        assertEquals("name", Color.named("name").formatted());
    }
}
