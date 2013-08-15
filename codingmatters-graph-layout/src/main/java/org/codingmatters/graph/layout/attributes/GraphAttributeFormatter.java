package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:39
 */
public class GraphAttributeFormatter {
    
    private final AttributeList attributes = new AttributeList();

    public void format(IndentedFormatter formatter) {
        this.attributes.format(formatter);
    }
    


    public GraphAttributeFormatter damping(double damping) {
        this.attributes.attribute("Damping", damping);
        return this;
    }
    
    public GraphAttributeFormatter k(double damping) {
        this.attributes.attribute("K", damping);
        return this;
    }

    public GraphAttributeFormatter url(String url) {
        this.attributes.attribute("URL", url);
        return this;
    }
    
    public GraphAttributeFormatter aspect(double ratio) {
        this.attributes.attribute("aspect", ratio);
        return this;
    }
    
    public GraphAttributeFormatter aspect(double ratio, int passCount) {
        this.attributes.attribute("aspect", Double.toString(ratio) + ", " + passCount);
        return this;
    }

    public GraphAttributeFormatter boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY) {
        this.attributes.attribute("bb", String.format("%s,%s,%s,%s", lowerLeftX,lowerLeftY, upperRightX, upperRightY));
        return this;
    }

    public GraphAttributeFormatter backgroundColor(Color color) {
        this.attributes.attribute("bgcolor", color.formatted());
        return this;
    }

    public GraphAttributeFormatter backgroundGradient(WeightedColors weightedColors) {
        this.attributes.attribute("bgcolor", weightedColors.formatted());
        return this;
    }
    
    public GraphAttributeFormatter center(boolean center) {
        this.attributes.attribute("center", center);
        return this;
    }

    public GraphAttributeFormatter center() {
        return this.center(true);
    }
    
    public GraphAttributeFormatter charset(String charset) {
        this.attributes.attribute("charset", charset);
        return this;
    }

    public GraphAttributeFormatter clusterRank(ClusterMode mode) {
        this.attributes.attribute("clusterrank", mode.formatted());
        return this;
    }
    
    public GraphAttributeFormatter colorScheme(String scheme) {
        this.attributes.attribute("colorscheme", scheme);
        return this;
    }
    
    public GraphAttributeFormatter comment(String comment) {
        this.attributes.attribute("comment", comment);
        return this;
    }
    
    public GraphAttributeFormatter compound(boolean compound) {
        this.attributes.attribute("compound", compound);
        return this;
    }
    public GraphAttributeFormatter compound() {
        this.attributes.attribute("compound", true);
        return this;
    }
    
    public GraphAttributeFormatter concentrate(boolean concentrate) {
        this.attributes.attribute("concentrate", concentrate);
        return this;
    }
    public GraphAttributeFormatter concentrate() {
        this.attributes.attribute("concentrate", true);
        return this;
    }
    
    public GraphAttributeFormatter defaultdist(double dist) {
        this.attributes.attribute("defaultdist", dist);
        return this;
    }
    
    public GraphAttributeFormatter dimension(int dim) {
        this.attributes.attribute("dim", dim);
        return this;
    }
    
    public GraphAttributeFormatter dpi(double dpi) {
        this.attributes.attribute("dpi", dpi);
        return this;
    }
    
    public GraphAttributeFormatter epsilon(double epsilon) {
        this.attributes.attribute("epsilon", epsilon);
        return this;
    }
    
    public GraphAttributeFormatter fontColor(Color color) {
        this.attributes.attribute("fontcolor", color.formatted());
        return this;
    }
    
    public GraphAttributeFormatter fontName(String font) {
        this.attributes.attribute("fontname", font);
        return this;
    }
    
    public GraphAttributeFormatter fontNames(String fonts) {
        this.attributes.attribute("fontnames", fonts);
        return this;
    }
    
    public GraphAttributeFormatter fontPath(String path) {
        this.attributes.attribute("fontpath", path);
        return this;
    }
    
    public GraphAttributeFormatter fontSize(double size) {
        this.attributes.attribute("fontsize", size);
        return this;
    }
    
    public GraphAttributeFormatter forceLabels(boolean force) {
        this.attributes.attribute("forcelabels", force);
        return this;
    }
    
    public GraphAttributeFormatter forceLabels() {
        return this.forceLabels(true);
    }
    
    public GraphAttributeFormatter gradientAngle(int angle) {
        this.attributes.attribute("gradientangle", angle);
        return this;
    }
    
    public GraphAttributeFormatter href(String href) {
        this.attributes.attribute("href", href);
        return this;
    }
    
    public GraphAttributeFormatter id(String id) {
        this.attributes.attribute("id", id);
        return this;
    }
    
    public GraphAttributeFormatter imagePath(String path) {
        this.attributes.attribute("imagepath", path);
        return this;
    }

    public GraphAttributeFormatter label(String label) {
        this.attributes.attribute("label", label);
        return this;
    }
    
    public GraphAttributeFormatter labelScheme(String scheme) {
        this.attributes.attribute("label_scheme", scheme);
        return this;
    }
    
    public GraphAttributeFormatter labelJustification(Justification justification) {
        this.attributes.attribute("labeljust", justification.formatted());
        return this;
    }

    public GraphAttributeFormatter labelLocalisation(VerticalLocalisation localisation) {
        this.attributes.attribute("labelloc", localisation.formatted());
        return this;
    }


    public GraphAttributeFormatter landscape(boolean landscape) {
        this.attributes.attribute("landscape", landscape);
        return this;
    }

    public GraphAttributeFormatter landscape() {
        return this.landscape(true);
    }
    
    public GraphAttributeFormatter layers(String ... layers) {
        this.attributes.attribute("layers", join(layers, ":"));
        return this;
    }

    private String join(String[] layers, String separator) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (String layer : layers) {
            if(! first) {
                result.append(separator);
            } else {
                first = false;
            }
            result.append(layer);
        }

        return result.toString();
    }

    public GraphAttributeFormatter selectedLayers(String ... layers) {
        this.attributes.attribute("layerselect", join(layers, ":"));
        return this;
    }
    
    public GraphAttributeFormatter levels(int levels) {
        this.attributes.attribute("levels", levels);
        return this;
    }
    
    public GraphAttributeFormatter levelsGap(double gap) {
        this.attributes.attribute("levelsgap", gap);
        return this;
    }
    
    public GraphAttributeFormatter logicalHeight(double inches) {
        this.attributes.attribute("lheight", inches);
        return this;
    }

    public GraphAttributeFormatter logicalWidth(double inches) {
        this.attributes.attribute("lwidtth", inches);
        return this;
    }
    
    public GraphAttributeFormatter labelPosition(Point p) {
        this.attributes.attribute("lp", p.formatted());
        return this;
    }
    
    public GraphAttributeFormatter margin(double margin) {
        this.attributes.attribute("margin", margin);
        return this;
    }
    
    public GraphAttributeFormatter margin(Point margin) {
        this.attributes.attribute("margin", margin.formatted());
        return this;
    }
    
    public GraphAttributeFormatter maximumIteration(int max) {
        this.attributes.attribute("maxiter", max);
        return this;
    }
    
    public GraphAttributeFormatter multiplicativeScale(double factor) {
        this.attributes.attribute("mclimit", factor);
        return this;
    }
    
    public GraphAttributeFormatter minimumSeparation(double distance) {
        this.attributes.attribute("mclimit", distance);
        return this;
    }
    
    public GraphAttributeFormatter mode(String mode) {
        this.attributes.attribute("mode", mode);
        return this;
    }
    
    public GraphAttributeFormatter model(String model) {
        this.attributes.attribute("model", model);
        return this;
    }
    
    public GraphAttributeFormatter adjascentNodeSeparation(double distance) {
        this.attributes.attribute("nodesep", distance);
        return this;
    }
    
    public GraphAttributeFormatter nojustify(boolean no) {
        this.attributes.attribute("nojustify", no);
        return this;
    }

    public GraphAttributeFormatter nojustify() {
        return this.nojustify(true);
    }
    
    public GraphAttributeFormatter normalize(double angle) {
        this.attributes.attribute("normalize", angle);
        return this;
    }

    public GraphAttributeFormatter nslimit(double v) {
        this.attributes.attribute("nslimit", v);
        return this;
    }

    public GraphAttributeFormatter nslimit1(double v) {
        this.attributes.attribute("nslimit1", v);
        return this;
    }
    
    public GraphAttributeFormatter ordering(Ordering ordering) {
        this.attributes.attribute("ordering", ordering.formatted());
        return this;
    }
    
    public GraphAttributeFormatter outputOrder(OutputMode mode) {
        this.attributes.attribute("outputorder", mode.formatted());
        return this;
    }
    
    public GraphAttributeFormatter overlap() {
        this.attributes.attribute("overlap", true);
        return this;
    }
    
    public GraphAttributeFormatter defaultOverlap() {
        this.attributes.attribute("overlap", "false");
        return this;
    }
    
    public GraphAttributeFormatter scaleOverlap() {
        this.attributes.attribute("overlap", "scale");
        return this;
    }
    
    public GraphAttributeFormatter prismOverlap() {
        this.attributes.attribute("overlap", "prism");
        return this;
    }
    
    public GraphAttributeFormatter prismOverlap(int attemps) {
        this.attributes.attribute("overlap", "prism" + attemps);
        return this;
    }
    
    public GraphAttributeFormatter voronoiOverlap() {
        this.attributes.attribute("overlap", "voronoi");
        return this;
    }
    
    public GraphAttributeFormatter scalexyOverlap() {
        this.attributes.attribute("overlap", "scalexy");
        return this;
    }
    
    public GraphAttributeFormatter compressOverlap() {
        this.attributes.attribute("overlap", "compress");
        return this;
    }
    
    public GraphAttributeFormatter overlapScaling(double scaling) {
        this.attributes.attribute("overlap_scaling", scaling);
        return this;
    }
    
    public GraphAttributeFormatter pack() {
        this.attributes.attribute("pack", true);
        return this;
    }

    public GraphAttributeFormatter pack(int margin) {
        this.attributes.attribute("pack", margin);
        return this;
    }
    
    public GraphAttributeFormatter packMode(PackingMode mode) {
        this.attributes.attribute("packmode", mode.formatted());
        return this;
    }
    
    public GraphAttributeFormatter arrayPackMode(String flags) {
        this.attributes.attribute("packmode", "array_" + flags);
        return this;
    }
    
    public GraphAttributeFormatter arrayPackMode(String flags, int columns) {
        this.attributes.attribute("packmode", "array_" + flags + columns);
        return this;
    }
    
    public GraphAttributeFormatter pad(double spec) {
        this.attributes.attribute("pad", spec);
        return this;
    }
    
    public GraphAttributeFormatter pad(Point spec) {
        this.attributes.attribute("pad", spec.formatted());
        return this;
    }
    
    public GraphAttributeFormatter page(double spec) {
        this.attributes.attribute("page", spec);
        return this;
    }
    
    public GraphAttributeFormatter page(Point spec) {
        this.attributes.attribute("page", spec.formatted());
        return this;
    }
    
    public GraphAttributeFormatter pageDir(Direction dir) {
        this.attributes.attribute("pagedir", dir.formatted());
        return this;
    }
    
    public GraphAttributeFormatter quadTree(QuadType type) {
        this.attributes.attribute("quadtree", type.formatted());
        return this;
    }
    
    public GraphAttributeFormatter quantum(double quantum) {
        this.attributes.attribute("quantum", quantum);
        return this;
    }
    
    public GraphAttributeFormatter rank(RankType type, Direction direction) {
        this.attributes.attribute("rank", type.formatted());
        this.attributes.attribute("rankdir", direction.formatted());
        return this;
    }
    
    public GraphAttributeFormatter rankSeparation(String spec) {
        this.attributes.attribute("ranksep", spec);
        return this;
    }
    
    public GraphAttributeFormatter aspectRatio(double ratio) {
        this.attributes.attribute("ratio", ratio);
        return this;
    }
    
    public GraphAttributeFormatter aspectRatio(AspectRatioType type) {
        this.attributes.attribute("ratio", type.formatted());
        return this;
    }
    
    public GraphAttributeFormatter runCrossMinimizationTwice() {
        this.attributes.attribute("remincross", true);
        return this;
    }
    
    public GraphAttributeFormatter repulsiveForcePower(double force) {
        this.attributes.attribute("repulsiveforce", force);
        return this;
    }
    
    public GraphAttributeFormatter resolution(double dpi) {
        this.attributes.attribute("resolution", dpi);
        return this;
    }
    
    public GraphAttributeFormatter rootNode(String node) {
        this.attributes.attribute("root", node);
        return this;
    }
    
    public GraphAttributeFormatter rotate(int angle) {
        this.attributes.attribute("rotate", angle);
        return this;
    }
    
    public GraphAttributeFormatter rotation(double counterClockwise) {
        this.attributes.attribute("rotation", counterClockwise);
        return this;
    }
    
    public GraphAttributeFormatter scale(double spec) {
        this.attributes.attribute("scale", spec);
        return this;
    }
    
    public GraphAttributeFormatter scale(Point spec) {
        this.attributes.attribute("scale", spec.formatted());
        return this;
    }
    
    public GraphAttributeFormatter searchsize(int searchsize) {
        this.attributes.attribute("searchsize", searchsize);
        return this;
    }
    
    public GraphAttributeFormatter size(double size) {
        this.attributes.attribute("size", size);
        return this;
    }


}
