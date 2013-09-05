package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 05/09/13
 * Time: 08:54
 * To change this template use File | Settings | File Templates.
 */
public enum Shape {
    BOX("box"), DIAMOND("diamond"), MDIAMOND("Mdiamond") , SQUARE("square"), MSQUARE("Msquare");
    private final String formatted;

    private Shape(String formatted) {
        this.formatted = formatted;
    }

    public String formatted() {
        return this.formatted;
    }
}
