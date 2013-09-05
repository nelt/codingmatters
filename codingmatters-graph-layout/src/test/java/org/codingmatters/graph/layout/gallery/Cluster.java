package org.codingmatters.graph.layout.gallery;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.attributes.Attributes;
import org.codingmatters.graph.layout.attributes.values.Color;
import org.codingmatters.graph.layout.attributes.values.Shape;
import org.codingmatters.graph.layout.attributes.values.Style;
import org.codingmatters.graph.layout.processor.GraphProcessing;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 21/08/13
 * Time: 07:26
 * To change this template use File | Settings | File Templates.
 */
public class Cluster extends GallerySample {
    
    public static void main(String[] args) {
        generate(new Cluster(args), "cluster");
    }
    
    protected Cluster(String[] args) {
        super(args);
    }

    @Override
    public File generate() throws Exception {
        File output = this.getOutputFile("cluster.png");
        GraphProcessing
                .dot( new Graph("G")
                            .directed()
                            .subgraph(new Graph("cluster_0")
                                    .graphAttributes(Attributes.graph()
                                            .label("\"process #1\"")
                                            .style(Style.GraphStyle.FILLED)
                                            .color(Color.named("lightgrey"))
                                    )
                                    .nodeAttributes(Attributes.node()
                                            .style(Style.NodeStyle.FILLED)
                                            .color(Color.named("white"))
                                    )
                                    .edge("a0", "a1")
                                    .edge("a1", "a2")
                                    .edge("a2", "a3")
                            )
                        .subgraph(new Graph("cluster_1")
                                .graphAttributes(Attributes.graph()
                                        .label("\"process #2\"")
                                        .color(Color.named("blue"))
                                )
                                .nodeAttributes(Attributes.node()
                                        .style(Style.NodeStyle.FILLED)
                                )
                                .edge("b0", "b1")
                                .edge("b1", "b2")
                                .edge("b2", "b3")
                        )
                        .edge("start", "a0")
                        .edge("start", "b0")
                        
                        .edge("a1", "b3")
                        .edge("b2", "a3")
                        .edge("a3", "a0")
                        
                        .edge("a3", "end")
                        .edge("b3", "end")
                        
                        .node("start", Attributes.node().shape(Shape.MDIAMOND))
                        .node("end", Attributes.node().shape(Shape.MSQUARE))
                )
                .process(output)
        ;
        return output;
    }
}
