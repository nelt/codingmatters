package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 17:00
 */
public enum StartType {
    REGULAR("regular"), SELF("self"), RANDOM("random")
    ;
    private final String formatted;

    private StartType(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
