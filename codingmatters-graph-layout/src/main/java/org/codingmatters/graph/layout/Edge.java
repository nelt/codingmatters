package org.codingmatters.graph.layout;

import org.codingmatters.graph.layout.internal.IndentedFormatter;

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
    
    public void format(IndentedFormatter formatter) {
        formatter.line(this.left + "->" + this.right + ";");
    }
}
