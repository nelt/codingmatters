package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:25
 */
public class AttributeListTest {

    private IndentedFormatter formatter;

    @Before
    public void setUp() throws Exception {
        this.formatter = new IndentedFormatter();
    }

    @Test
    public void testEmpty() throws Exception {
        AttributeList attributes = new AttributeList();
        attributes.format(this.formatter);

        assertEquals("", this.formatter.formatted());
    }

    @Test
    public void testSingle() throws Exception {
        AttributeList attributes = new AttributeList()
                .attribute("name", "value")
                ;
        attributes.format(this.formatter);

        assertEquals("name = value", this.formatter.formatted());
    }

    @Test
    public void testDouble() throws Exception {
        double value = 12.01;
        AttributeList attributes = new AttributeList()
                .attribute("name", value)
                ;
        attributes.format(this.formatter);

        assertEquals("name = 12.01", this.formatter.formatted());
    }

    @Test
    public void testMultiple() throws Exception {
        AttributeList attributes = new AttributeList()
                .attribute("name1", "value1")
                .attribute("name2", "value2")
                ;
        attributes.format(this.formatter);

        assertEquals("name1 = value1, name2 = value2", this.formatter.formatted());
    }
}
