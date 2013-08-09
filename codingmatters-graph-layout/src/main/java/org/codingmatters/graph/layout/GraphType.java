package org.codingmatters.graph.layout;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 23:25
 */
public enum GraphType {
    GRAPH("graph"), DIGRAPH("digraph"), SUBGRAPH("subgraph");
    
    private final String token;

    private GraphType(String token) {
        this.token = token;
    }

    public String token() {
        return token;
    }
}
