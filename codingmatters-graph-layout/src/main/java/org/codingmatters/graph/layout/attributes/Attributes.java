package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 17/08/13
 * Time: 13:54
 */
public class Attributes {
    
    static public GraphAttributes<GraphAttributes> graph() {
        return new GenericAttributesFormatter<GraphAttributes>();
    }
}
