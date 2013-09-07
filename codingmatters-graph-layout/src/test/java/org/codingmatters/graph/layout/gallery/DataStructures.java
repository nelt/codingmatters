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
                .edgeAttributes(Attributes.edge())
                .node("node0", node().label("\"<f0> 0x10ba8| <f1>\"").shape(Shape.RECORD))
                .node("node1", node().label("\"<f0> 0xf7fc4380| <f1> | <f2> |-1\"").shape(Shape.RECORD))
                .node("node2", node().label("\"<f0> 0xf7fc44b8| | |2\"").shape(Shape.RECORD))
                .node("node3", node().label("\"<f0> 3.43322790286038071e-06|44.79998779296875|0\"").shape(Shape.RECORD))  
                .node("node4", node().label("\"<f0> 0xf7fc4380| <f1> | <f2> |2\"").shape(Shape.RECORD))
                .node("node5", node().label("\"<f0> (nil)| | |-1\"").shape(Shape.RECORD))
                .node("node6", node().label("\"<f0> 0xf7fc4380| <f1> | <f2> |1\"").shape(Shape.RECORD))
                .node("node7", node().label("\"<f0> 0xf7fc4380| <f1> | <f2> |2\"").shape(Shape.RECORD))
                .node("node8", node().label("\"<f0> (nil)| | |-1\"").shape(Shape.RECORD))
                .node("node9", node().label("\"<f0> (nil)| | |-1\"").shape(Shape.RECORD))
                .node("node10", node().label("\"<f0> (nil)| <f1> | <f2> |-1\"").shape(Shape.RECORD))
                .node("node11", node().label("\"<f0> (nil)| <f1> | <f2> |-1\"").shape(Shape.RECORD))
                .node("node12", node().label("\"<f0> 0xf7fc43e0| | |1\"").shape(Shape.RECORD))
                
                .edge("node0:f0", "node1:f0", Attributes.edge().id("0"))
                .edge("node0:f1", "node2:f0", Attributes.edge().id("1"))
                .edge("node1:f0", "node3:f0", Attributes.edge().id("2"))
                .edge("node1:f1", "node4:f0", Attributes.edge().id("3"))
                .edge("node1:f2", "node5:f0", Attributes.edge().id("4"))
                .edge("node4:f0", "node3:f0", Attributes.edge().id("5"))
                .edge("node4:f1", "node6:f0", Attributes.edge().id("6"))
                .edge("node4:f2", "node10:f0", Attributes.edge().id("7"))
                .edge("node6:f0", "node3:f0", Attributes.edge().id("8"))
                .edge("node6:f1", "node7:f0", Attributes.edge().id("9"))
                .edge("node6:f2", "node9:f0", Attributes.edge().id("10"))
                .edge("node7:f0", "node3:f0", Attributes.edge().id("11"))
                .edge("node7:f1", "node1:f0", Attributes.edge().id("12"))
                .edge("node7:f2", "node8:f0", Attributes.edge().id("13"))
                .edge("node10:f1", "node11:f0", Attributes.edge().id("14"))
                .edge("node10:f2", "node12:f0", Attributes.edge().id("15"))
                .edge("node11:f2", "node1:f0", Attributes.edge().id("16"))
                ;  
    }


    @Override
    public File generate() throws Exception {
        File output = this.getOutputFile("data-stuctures.png");
        GraphProcessing.dot(this.graph()).process(output);
        return output;
    }
}
