package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 14/08/13
 * Time: 15:30
 */
public enum Justification {
    LEFT("l"), CENTER("c"), RIGHT("r");
    
    private final String formatted;

    private Justification(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
