package org.codingmatters.graph.layout.attributes;

import org.junit.Test;

import static org.codingmatters.graph.layout.attributes.Color.named;
import static org.codingmatters.graph.layout.attributes.WeightedColors.list;
import static org.codingmatters.graph.layout.attributes.WeightedColors.weighted;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 14/08/13
 * Time: 08:15
 */
public class WeightedColorsTest {
    @Test
    public void testWeightedColorUnweighted() throws Exception {
        assertEquals("color", weighted(named("color")).formatted());
    }
    
    @Test
    public void testWeightedColorWeighted() throws Exception {
        assertEquals("color;0.22", weighted(named("color"), 0.22f).formatted());
    }

    @Test
    public void testEmpty() throws Exception {
        assertEquals("", list().formatted());
    }

    @Test
    public void testSingle() throws Exception {
        assertEquals("color;0.3", list(weighted(named("color"), 0.3f)).formatted());
    }

    @Test
    public void testMultiple() throws Exception {
        assertEquals("yellow;0.3:blue", list(weighted(named("yellow"), 0.3f), weighted(named("blue"))).formatted());
    }
}
