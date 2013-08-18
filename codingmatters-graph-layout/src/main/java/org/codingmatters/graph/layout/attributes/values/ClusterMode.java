package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 14/08/13
 * Time: 14:23
 */
public enum ClusterMode {
    LOCAL("local"), GLOBAL("global"), NONE("none");
    
    private final String formatted;

    private ClusterMode(String formatted) {
        this.formatted = formatted;
    }

    public String formatted() {
        return this.formatted;
    }
}
