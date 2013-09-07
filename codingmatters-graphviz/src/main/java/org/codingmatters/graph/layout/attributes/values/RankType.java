package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 07:53
 */
public enum RankType {
    SAME("same"), MIN("min"), SOURCE("source"), MAX("max"), SINK("sink");

    private final String formatted;

    private RankType(String formatted) {
        this.formatted = formatted;
    }
    
    public String formatted() {
        return this.formatted;
    }
}
