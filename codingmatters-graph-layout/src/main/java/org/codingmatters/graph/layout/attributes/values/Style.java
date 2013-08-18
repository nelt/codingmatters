package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 17:07
 */
public interface Style {
    
    public static enum GraphStyle implements Style {
        RADIAL("radial")
        ;
        private final String formatted;

        private GraphStyle(String formatted) {
            this.formatted = formatted;
        }
        
        public String formatted() {return this.formatted;}
    }

    public static enum ClusterStyle implements Style {
        FILLED("filled"),
        STRIPPED("striped"),
        ROUNDED("rounded"),
        RADIAL("radial")
        ;
        private final String formatted;

        private ClusterStyle(String formatted) {
            this.formatted = formatted;
        }

        public String formatted() {return this.formatted;}
    }

    public static enum NodeStyle implements Style {
        DASHED("dashed"),
        DOTTED("dotted"),
        SOLID("solid"),
        INVIS("invis"),
        BOLD("bold"),
        FILLED("filled"),
        STRIPPED("striped"),
        WEDGED("wedged"),
        DIAGONALS("diagonals"),
        ROUNDED("rounded"),
        RADIAL("radial")
        ;
        private final String formatted;

        private NodeStyle(String formatted) {
            this.formatted = formatted;
        }

        public String formatted() {return this.formatted;}
    }

    public static enum EdgeStyle implements Style {
        DASHED("dashed"),
        DOTTED("dotted"),
        SOLID("solid"),
        INVIS("invis"),
        BOLD("bold"),
        TAPERED("tapered")
        ;
        private final String formatted;

        private EdgeStyle(String formatted) {
            this.formatted = formatted;
        }

        public String formatted() {return this.formatted;}
    }
}
