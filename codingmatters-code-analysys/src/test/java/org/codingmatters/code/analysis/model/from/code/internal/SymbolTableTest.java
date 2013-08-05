package org.codingmatters.code.analysis.model.from.code.internal;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 05/08/13
 * Time: 07:11
 */
public class SymbolTableTest {

    @Test
    public void testEmpty() throws Exception {
        SymbolTable actual = new SymbolTable();
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testAddOne() throws Exception {
        SymbolTable actual = new SymbolTable();
        actual.add("symbol");
        
        assertFalse(actual.isEmpty());
        assertTrue(actual.contains("symbol"));
    }

    @Test
    public void testSubscopeSymbol() throws Exception {
        SymbolTable parent = new SymbolTable();
        parent.add("s1");
        
        SymbolTable actual = new SymbolTable(parent);
        actual.add("s2");
        
        assertTrue(actual.contains("s1"));
        assertTrue(actual.contains("s2"));
        assertFalse(parent.contains("s2"));
    }

    @Test
    public void testClear() throws Exception {
        SymbolTable actual = new SymbolTable();
        actual.add("symbol");

        actual.clear();
        
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testChild() throws Exception {
        SymbolTable parent = new SymbolTable();
        parent.add("s1");
        
        SymbolTable actual = parent.child();
        actual.add("s2");


        assertTrue(actual.contains("s1"));
        assertTrue(actual.contains("s2"));
    }

    @Test
    public void testParent() throws Exception {
        SymbolTable parent = new SymbolTable();

        assertEquals(parent , parent.child().parent());
    }
}
