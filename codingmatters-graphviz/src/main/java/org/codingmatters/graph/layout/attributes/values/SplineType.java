package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 16:41
 */
public enum SplineType {
    NONE("none"), 
    LINE("line"),
    POLYLINE("polyline"),
    CURVED("curved"),
    ORTHO("ortho"),
    SPLINE("spline")
    ;
    
    private final String formatted;

    private SplineType(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
