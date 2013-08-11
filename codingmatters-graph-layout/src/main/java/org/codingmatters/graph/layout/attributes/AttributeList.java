package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:24
 */
public class AttributeList {
    
    private final HashMap<String, String> attributes = new HashMap<>();

    public void format(IndentedFormatter formatter) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (String name : this.attributes.keySet()) {
            if(first) {
                first = false;
            } else {
                result.append(", ");
            }
            result.append(name).append(" = ").append(this.attributes.get(name));
        }
        formatter.line(result.toString());
    }

    public AttributeList attribute(String name, String value) {
        this.attributes.put(name, value);
        return this;
    }

    public AttributeList attribute(String name, double d) {
        return this.attribute(name, Double.toString(d));
    }
}
