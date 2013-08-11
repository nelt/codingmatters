package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:39
 */
public class GraphAttributeFormatter {
    
    private final AttributeList attributes = new AttributeList();
    
    public GraphAttributeFormatter damping(double damping) {
        this.attributes.attribute("Damping", damping);
        return this;
    }

    public GraphAttributeFormatter label(String label) {
        this.attributes.attribute("label", label);
        return this;
    } 

    public void format(IndentedFormatter formatter) {
        this.attributes.format(formatter);
    }
}
