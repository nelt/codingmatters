package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 07:59
 */
public enum AspectRatioType {
    FILL("fill"), COMPRESS("compress"), EXPAND("expand"), AUTO("auto");

    private final String formatted;

    private AspectRatioType(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
