package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 07:10
 */
public enum OutputMode {
    BREADTHFIRST("breadthfirst"),
    NODEFIRST("nodesfirst"),
    EDGEFIRST("edgesfirst");
    
    private final String formatted;

    private OutputMode(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
