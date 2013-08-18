package org.codingmatters.graph.layout;

import org.codingmatters.graph.layout.attributes.AttributesFormatter;
import org.codingmatters.graph.layout.attributes.EdgeAttributes;
import org.codingmatters.graph.layout.attributes.GraphAttributes;
import org.codingmatters.graph.layout.attributes.NodeAttributes;
import org.codingmatters.graph.layout.internal.IndentedFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 09/08/13
 * Time: 08:11
 */
public class Graph {
    private final String id;
    private GraphType type = GraphType.GRAPH;
    private final List<Node> nodes = new ArrayList<>();
    private final List<Edge> edges = new ArrayList<>();
    private final List<Graph> subgraphs = new ArrayList<>();
    private GraphAttributes graphAttributes;
    private EdgeAttributes edgeAttributes;
    private NodeAttributes nodeAttributes;

    public Graph(String id) {
        this.id = id;
    }



    public Graph directed() {
        this.type = GraphType.DIGRAPH;
        return this;
    }

    public Graph edge(String left, String right) {
        return this.edge(left, right, null);
    }

    public Graph edge(String left, String right, EdgeAttributes attributes) {
        this.edges.add(new Edge(left, right, attributes));
        return this;
    }

    public Graph node(String node, NodeAttributes attributes) {
        this.nodes.add(new Node(node, attributes));
        return this;
    }

    public Graph subgraph(Graph graph) {
        graph.type = GraphType.SUBGRAPH;
        this.subgraphs.add(graph);
        return this;
    }

    public Graph graphAttributes(GraphAttributes attributes) {
        this.graphAttributes = attributes;
        return this;
    }

    public Graph edgeAttributes(EdgeAttributes attributes) {
        this.edgeAttributes = attributes;
        return this;
    }

    public Graph nodeAttributes(NodeAttributes attributes) {
        this.nodeAttributes = attributes;
        return this;
    }

    public String asDot() {
        IndentedFormatter result = new IndentedFormatter();
        this.format(result);
        return result.formatted();
    }

    private void format(IndentedFormatter formatter) {
        formatter.line("%s %s {", this.type.token(), this.id);

        this.formatAttributes("graph", this.graphAttributes, formatter);
        this.formatAttributes("edge", this.edgeAttributes, formatter);
        this.formatAttributes("node", this.nodeAttributes, formatter);
        
        this.formatSubgraphs(formatter);
        this.formatNodes(formatter);
        this.formatEdges(formatter);

        formatter.line("}");
    }

    private void formatNodes(IndentedFormatter formatter) {
        for (Node node : this.nodes) {
            formatter.indent();
            node.format(formatter);
            formatter.unindent();
        }
    }

    private void formatSubgraphs(IndentedFormatter formatter) {
        for (Graph subgraph : this.subgraphs) {
            formatter.indent();
            subgraph.format(formatter);
            formatter.unindent();
        }
    }

    private void formatEdges(IndentedFormatter formatter) {
        for (Edge edge : this.edges) {
            formatter.indent();
            edge.format(formatter);
            formatter.unindent();
        }
    }

    private void formatAttributes(String token, AttributesFormatter attributes, IndentedFormatter result) {
        if(attributes != null) {
            result.indent();
            result.append(token + " [");
            attributes.append(result);
            result.append("];");
            result.newLine();
            result.unindent();
        }
    }
}
