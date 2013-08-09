package org.codingmatters.graph.layout;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 08:11
 */
public class Graph {
    private final String id;
    private boolean directed = false;
    private final ArrayList<Edge> edges = new ArrayList<>();
    private final ArrayList<Graph> subggraphs = new ArrayList<>();
    
    public Graph(String id) {
        this.id = id;
    }

    public String asDot() {
        StringBuilder result = new StringBuilder();
        if(this.directed) {
            result.append("digraph ");
        } else {
            result.append("graph ");
        }
        result.append(this.id).append(" {").append("\n");
        for (Edge edge : this.edges) {
            result.append("\t").append(edge.asDot()).append("\n");
        }

        result.append("}");
        return result.toString();
    }

    public Graph directed() {
        this.directed = true;
        return this;
    }

    public Graph edge(String left, String right) {
        this.edges.add(new Edge(left, right));
        return this;
    }

    public Graph subgraph(Graph graph) {
        this.subggraphs.add(graph);
        return this;
    }
}
