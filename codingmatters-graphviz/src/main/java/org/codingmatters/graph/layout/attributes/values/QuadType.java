package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 07:48
 */
public enum QuadType {
    NORMAL("normal"), FAST("fast"), NONE("none");

    private final String formatted;

    private QuadType(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
