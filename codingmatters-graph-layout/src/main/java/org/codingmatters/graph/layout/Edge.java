package org.codingmatters.graph.layout;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 08:24
 */
public class Edge {
    private final String left;
    private final String right;

    public Edge(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String asDot() {
        return this.left + "->" + this.right + ";";
    }
}
