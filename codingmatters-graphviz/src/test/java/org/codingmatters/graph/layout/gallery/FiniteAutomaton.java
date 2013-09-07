package org.codingmatters.graph.layout.gallery;

import org.codingmatters.graph.layout.Graph;
import org.codingmatters.graph.layout.attributes.Attributes;
import org.codingmatters.graph.layout.attributes.values.Direction;
import org.codingmatters.graph.layout.attributes.values.Shape;
import org.codingmatters.graph.layout.processor.GraphProcessing;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 07/09/13
 * Time: 08:02
 * To change this template use File | Settings | File Templates.
 */
public class FiniteAutomaton extends GallerySample {

    public static void main(String[] args) {
        generate(new FiniteAutomaton(args), "finite automaton");
    }

    protected FiniteAutomaton(String[] args) {
        super(args);
    }

    @Override
    public Graph graph() {
        return new Graph("finite_state_machine").directed()
                .graphAttributes(Attributes.graph()
                        .rankdir(Direction.major(Direction.Dir.LEFT).minor(Direction.Dir.RIGHT))
                        .size(8.5)
                )
                .node("LR_0", Attributes.node().shape(Shape.DOUBLECIRCLE))
                .node("LR_3", Attributes.node().shape(Shape.DOUBLECIRCLE))
                .node("LR_4", Attributes.node().shape(Shape.DOUBLECIRCLE))
                .node("LR_8", Attributes.node().shape(Shape.DOUBLECIRCLE))
                
                .nodeAttributes(Attributes.node().shape(Shape.CIRCLE))
                
                .edge("LR_0", "LR_2", Attributes.edge().label("\"SS(B)\""))
                .edge("LR_0", "LR_1", Attributes.edge().label("\"SS(S)\""))
                .edge("LR_1", "LR_3", Attributes.edge().label("\"SS($end)\""))
                .edge("LR_2", "LR_6", Attributes.edge().label("\"SS(b)\""))
                .edge("LR_2", "LR_5", Attributes.edge().label("\"SS(a)\""))
                .edge("LR_2", "LR_4", Attributes.edge().label("\"S(A)\""))
                .edge("LR_5", "LR_7", Attributes.edge().label("\"S(b)\""))
                .edge("LR_5", "LR_5", Attributes.edge().label("\"S(a)\""))
                .edge("LR_6", "LR_6", Attributes.edge().label("\"S(b)\""))
                .edge("LR_6", "LR_5", Attributes.edge().label("\"S(a)\""))
                .edge("LR_7", "LR_8", Attributes.edge().label("\"S(b)\""))
                .edge("LR_7", "LR_5", Attributes.edge().label("\"S(a)\""))
                .edge("LR_8", "LR_6", Attributes.edge().label("\"S(b)\""))
                .edge("LR_8", "LR_5", Attributes.edge().label("\"S(a)\""))
                ;
    }

    @Override
    public File generate() throws Exception {
        File output = this.getOutputFile("finite-automaton.png");
        GraphProcessing
                .dot(this.graph())
                .process(output)
        ;
        return output;
    }
}
