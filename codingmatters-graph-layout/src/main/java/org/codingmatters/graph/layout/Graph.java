package org.codingmatters.graph.layout;

import org.codingmatters.graph.layout.attributes.GraphAttributeFormatter;
import org.codingmatters.graph.layout.internal.IndentedFormatter;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 08:11
 */
public class Graph {
    private final String id;
    private GraphType type = GraphType.GRAPH;
    private final ArrayList<Edge> edges = new ArrayList<>();
    private final ArrayList<Graph> subgraphs = new ArrayList<>();
    private GraphAttributeFormatter graphAttributes;

    public Graph(String id) {
        this.id = id;
    }

    public String asDot() {
        IndentedFormatter result = new IndentedFormatter();
        this.format(result);
        return result.formatted();
    }

    private void format(IndentedFormatter result) {
        result.line("%s %s {", this.type.token() ,this.id);
        
        this.formatAttributes(result);
        this.formatSubgraphs(result);
        this.formatEdges(result);

        result.line("}");
    }

    private void formatSubgraphs(IndentedFormatter result) {
        for (Graph subgraph : this.subgraphs) {
            result.indent();
            subgraph.format(result);
            result.unindent();
        }
    }

    private void formatEdges(IndentedFormatter result) {
        for (Edge edge : this.edges) {
            result.indent();
            edge.format(result);
            result.unindent();
        }
    }

    public Graph directed() {
        this.type = GraphType.DIGRAPH;
        return this;
    }

    public Graph edge(String left, String right) {
        this.edges.add(new Edge(left, right));
        return this;
    }

    public Graph subgraph(Graph graph) {
        graph.type = GraphType.SUBGRAPH;
        this.subgraphs.add(graph);
        return this;
    }

    public Graph graphAttributes(GraphAttributeFormatter attributes) {
        this.graphAttributes = attributes;
        return this;
    }
    
    private void formatAttributes(IndentedFormatter result) {
        if(this.graphAttributes != null) {
            result.indent();
            result.append("graph [");
            this.graphAttributes.append(result);
            result.append("];");
            result.newLine();
            result.unindent();
        }
    }
}
