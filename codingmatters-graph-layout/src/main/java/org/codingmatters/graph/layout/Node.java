package org.codingmatters.graph.layout;

import org.codingmatters.graph.layout.attributes.NodeAttributes;
import org.codingmatters.graph.layout.internal.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 18/08/13
 * Time: 08:24
 */
public class Node {
    private final String id;
    private final NodeAttributes attributes;

    public Node(String id, NodeAttributes attributes) {
        this.attributes = attributes;
        this.id = id;
    }

    public void format(IndentedFormatter formatter) {
        formatter.append(this.id);
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
