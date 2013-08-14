package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 14/08/13
 * Time: 07:24
 */
public class GraphAttributeFormatterTest {
    private IndentedFormatter formatter;

    @Before
    public void setUp() throws Exception {
        this.formatter = new IndentedFormatter();
    }

    @Test
    public void testAspect() throws Exception {
        new GraphAttributeFormatter().aspect(12.0).format(this.formatter);
        Assert.assertEquals("aspect = 12.0", this.formatter.formatted());
    }
    
    @Test
    public void testAspectWithPasses() throws Exception {
        new GraphAttributeFormatter().aspect(12.0, 5).format(this.formatter);
        Assert.assertEquals("aspect = 12.0, 5", this.formatter.formatted());
    }
    
    @Test
    public void testBoundingBox() throws Exception {
        new GraphAttributeFormatter().boundingBox(0, 1, 2, 3).format(this.formatter);
        Assert.assertEquals("bb = 0,1,2,3", this.formatter.formatted());
    }

    @Test
    public void testBackgroundColor() throws Exception {
        new GraphAttributeFormatter().backgroundColor(Color.named("color")).format(this.formatter);
        Assert.assertEquals("bgcolor = color", this.formatter.formatted());
    }

    @Test
    public void testBackgroundGradiant() throws Exception {
        new GraphAttributeFormatter().backgroundGradient(WeightedColors.list(WeightedColors.weighted(Color.named("blue"), 0.3f), WeightedColors.weighted(Color.named("yellow")))).format(this.formatter);
        Assert.assertEquals("bgcolor = blue;0.3:yellow", this.formatter.formatted());
    }

    @Test
    public void testCenter() throws Exception {
        new GraphAttributeFormatter().center().format(this.formatter);
        Assert.assertEquals("center = true", this.formatter.formatted());
    }

    @Test
    public void testCenterTrue() throws Exception {
        new GraphAttributeFormatter().center(true).format(this.formatter);
        Assert.assertEquals("center = true", this.formatter.formatted());
    }
    
    @Test
    public void testCenterFalse() throws Exception {
        new GraphAttributeFormatter().center(false).format(this.formatter);
        Assert.assertEquals("center = false", this.formatter.formatted());
    }

    @Test
    public void testClusterRankLocal() throws Exception {
        new GraphAttributeFormatter().clusterRank(ClusterMode.LOCAL).format(this.formatter);
        Assert.assertEquals("clusterrank = local", this.formatter.formatted());
    }
    @Test
    public void testClusterRankGlobal() throws Exception {
        new GraphAttributeFormatter().clusterRank(ClusterMode.GLOBAL).format(this.formatter);
        Assert.assertEquals("clusterrank = global", this.formatter.formatted());
    }
    @Test
    public void testClusterRankNone() throws Exception {
        new GraphAttributeFormatter().clusterRank(ClusterMode.NONE).format(this.formatter);
        Assert.assertEquals("clusterrank = none", this.formatter.formatted());
    }
}
