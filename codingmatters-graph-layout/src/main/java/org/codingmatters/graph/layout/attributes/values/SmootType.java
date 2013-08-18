package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 16:33
 */
public enum SmootType {
    NONE("none"), AVERAGE("avg_dist"), GRAPH("graph_dist"), POWER("power_dist"), RNG("rng"), SPRING("spring"), TRIANGLE("triangle")
    ;

    private final String formatted;

    private SmootType(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
