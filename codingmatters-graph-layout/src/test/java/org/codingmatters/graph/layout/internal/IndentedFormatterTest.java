package org.codingmatters.graph.layout.internal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 23:34
 */
public class IndentedFormatterTest {

    @Test
    public void testEmpty() throws Exception {
        IndentedFormatter formatter = new IndentedFormatter();
        assertEquals("", formatter.formatted());
    }

    @Test
    public void testNoIndentation() throws Exception {
        IndentedFormatter formatter = new IndentedFormatter().line("expected") ;
        assertEquals("expected", formatter.formatted());
    }

    @Test
    public void testIndentedLine() throws Exception {
        IndentedFormatter formatter = new IndentedFormatter().indent().line("expected") ;
        assertEquals("\texpected", formatter.formatted());
    }
    
    @Test
    public void testTwoIndentationLine() throws Exception {
        IndentedFormatter formatter = new IndentedFormatter().indent().indent().line("expected") ;
        assertEquals("\t\texpected", formatter.formatted());
    }

    @Test
    public void testThreeLines() throws Exception {
        IndentedFormatter formatter = new IndentedFormatter().line("one").line("two").line("three");
        assertEquals("one\ntwo\nthree", formatter.formatted());
    }
    
    @Test
    public void testThreeIndentedLines() throws Exception {
        IndentedFormatter formatter = new IndentedFormatter().indent().line("one").line("two").line("three");
        assertEquals("\tone\n\ttwo\n\tthree", formatter.formatted());
    }
    
    
    @Test
    public void testIndentUnindent() throws Exception {
        IndentedFormatter formatter = new IndentedFormatter()
                .line("one")
                .indent().line("two").unindent()
                .line("three");
        assertEquals("one\n\ttwo\nthree", formatter.formatted());
    }

    @Test
    public void testFormattedLine() throws Exception {
        IndentedFormatter formatter = new IndentedFormatter()
                .line("%s %s %s" , "a", "b", "c");
        assertEquals("a b c", formatter.formatted());
    }
}
