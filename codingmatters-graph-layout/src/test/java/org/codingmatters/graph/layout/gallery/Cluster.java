package org.codingmatters.graph.layout.gallery;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.attributes.Attributes;
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
        try {
            new Cluster(args).generate();
        } catch (Exception e) {
            throw new RuntimeException("failed generating cluster example");
        }
    }
    
    protected Cluster(String[] args) {
        super(args);
    }

    @Override
    public void generate() throws Exception {
        File output = this.getOutputFile("cluster.png");
        GraphProcessing
                .dot( new Graph("G")
                            .directed()
                            .subgraph(new Graph("cluster_0")
                                    .graphAttributes(Attributes.graph()
                                            .style(Style.GraphStyle.FILLED)
                                            //missing color
                                    )
                                    .nodeAttributes(Attributes.node()
                                            .style(Style.NodeStyle.FILLED)
                                            //missing color
                                    )
                                    .edge("a0", "a1")
                                    .edge("a1", "a2")
                                    .edge("a2", "a3")
                                    
                            )
                )
                .process(output)
        ;
        System.out.println("generated " + output.getAbsolutePath());
    }
}
