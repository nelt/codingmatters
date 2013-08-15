package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 07:30
 */
public enum PackingMode {
    NODE("node"), CLUSTER("clust"), GRAPH("graph");

    private final String formatted;

    private PackingMode(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
