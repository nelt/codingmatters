package org.codingmatters.code.analysis.model.from.code.internal;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 05/08/13
 * Time: 07:08
 */
public class SymbolTable {
    
    static private SymbolTable EMPTY = new SymbolTable() {
        @Override
        public void add(String symbol) {}

        @Override
        public boolean contains(String symbol) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public void clear() {}
    } ;
    
    private final SymbolTable parent;
    private final HashSet<String> symbols = new HashSet<>();

    public SymbolTable() {
        this(EMPTY);
    }

    public SymbolTable(SymbolTable parent) {
        this.parent = parent != null ? parent : EMPTY;
    }

    public boolean isEmpty() {
        return this.symbols.isEmpty() && this.parent.isEmpty();
    }

    public void add(String symbol) {
        this.symbols.add(symbol);
    }

    public boolean contains(String symbol) {
        return this.symbols.contains(symbol) || this.parent.contains(symbol);
    }

    public void clear() {
        this.symbols.clear();
    }

    public SymbolTable child() {
        return new SymbolTable(this);
    }

    public SymbolTable parent() {
        return this.parent;
    }
}
