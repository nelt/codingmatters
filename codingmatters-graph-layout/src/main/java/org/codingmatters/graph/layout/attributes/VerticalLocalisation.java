package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 14/08/13
 * Time: 15:40
 */
public enum VerticalLocalisation {
    TOP("t"), BOTTOM("b");
    private final String formatted;

    private VerticalLocalisation(String formatted) {
        this.formatted = formatted;
    }

    public String formatted() {
        return this.formatted;
    }
}
