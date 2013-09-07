package org.codingmatters.graph.layout;

import org.codingmatters.graph.layout.attributes.EdgeAttributes;
import org.codingmatters.graph.layout.formatting.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 08:24
 */
public class Edge {
    private final String left;
    private final String right;
    private final EdgeAttributes attributes;

    public Edge(String left, String right, EdgeAttributes attributes) {
        this.left = left;
        this.right = right;
        this.attributes = attributes;
    }

    public void format(IndentedFormatter formatter) {
        formatter.append(this.left + "->" + this.right);
        this.formatAttributes(formatter);
        formatter.append(";").newLine();
    }
    
    private void formatAttributes(IndentedFormatter formatter) {
        if(this.attributes != null) {
            formatter.append(" [");
            this.attributes.append(formatter);
            formatter.append("]");
        }
    }
}
