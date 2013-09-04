package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 17/08/13
 * Time: 13:54
 */
public class Attributes {
    
    static public GraphAttributes graph() {
        return GenericAttributesFormatter.builder();
    }

    public static EdgeAttributes edge() {
        return GenericAttributesFormatter.builder();
    }

    public static NodeAttributes node() {
        return GenericAttributesFormatter.builder();
    }
}
