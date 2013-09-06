package org.codingmatters.graph.layout.gallery;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.attributes.Attributes;
import org.codingmatters.graph.layout.attributes.values.Direction;
import org.codingmatters.graph.layout.attributes.values.Shape;
import org.codingmatters.graph.layout.processor.GraphProcessing;

import java.io.File;

import static org.codingmatters.graph.layout.attributes.Attributes.*;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 06/09/13
 * Time: 08:49
 * To change this template use File | Settings | File Templates.
 */
public class DataStructures extends GallerySample {


    public static void main(String[] args) {
        generate(new DataStructures(args), "data-structures");
    }
    
    protected DataStructures(String[] args) {
        super(args);
    }

    @Override
    public Graph graph() {
        return new Graph("G").directed()
                .graphAttributes(Attributes.graph()
                        .rankdir(Direction.major(Direction.Dir.LEFT).minor(Direction.Dir.RIGHT))
                )
                .nodeAttributes(node()
                        .fontSize(16)
                        .shape(Shape.ELLIPSE)
                )
                .node("node0", node().label("\"<f0> 0x10ba8| <f1>\"").shape(Shape.RECORD))
                .node("node1", node().label("\"<f0> 0xf7fc4380| <f1> | <f2> |-1\"").shape(Shape.RECORD))
                .node("node2", node().label("\"<f0> 0xf7fc44b8| | |2\"").shape(Shape.RECORD))
                .node("node3", node().label("\"<f0> 3.43322790286038071e-06|44.79998779296875|0\"").shape(Shape.RECORD));
    }

    @Override
    public File generate() throws Exception {
        File output = this.getOutputFile("data-stuctures.png");
        GraphProcessing
                .dot(this.graph());
        return output;
    }
}
