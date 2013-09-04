package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.AttributeBuilder;
import org.codingmatters.graph.layout.attributes.values.*;
import org.codingmatters.graph.layout.formatting.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:39
 */
public abstract class GenericAttributesFormatter<B extends GenericAttributesFormatter<B>> 
        extends AttributeBuilder<B> 
        implements AttributesFormatter, NodeAttributes, EdgeAttributes, GraphAttributes {


    static public GenericAttributesFormatter<?> builder() {
        return new GenericAttributesFormatterImpl();
    }

    static private class GenericAttributesFormatterImpl extends GenericAttributesFormatter<GenericAttributesFormatterImpl> {
        @Override
        protected GenericAttributesFormatterImpl self() {
            return this;
        }
    }
    
    private final AttributeList attributes = new AttributeList();
    
    @Override
    public void append(IndentedFormatter formatter) {
        this.attributes.format(formatter);
    }
    
    public B damping(double damping) {
        this.attributes.attribute("Damping", damping);
        return this.self();
    }
    
    
    public B k(double damping) {
        this.attributes.attribute("K", damping);
        return this.self();
    }

    
    public B url(String url) {
        this.attributes.attribute("URL", url);
        return this.self();
    }
    
    
    public B aspect(double ratio) {
        this.attributes.attribute("aspect", ratio);
        return this.self();
    }
    
    
    public B aspect(double ratio, int passCount) {
        this.attributes.attribute("aspect", Double.toString(ratio) + ", " + passCount);
        return this.self();
    }

    
    public B boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY) {
        this.attributes.attribute("bb", String.format("%s,%s,%s,%s", lowerLeftX,lowerLeftY, upperRightX, upperRightY));
        return this.self();
    }

    
    public B backgroundColor(Color color) {
        this.attributes.attribute("bgcolor", color.formatted());
        return this.self();
    }

    
    public B backgroundGradient(WeightedColors weightedColors) {
        this.attributes.attribute("bgcolor", weightedColors.formatted());
        return this.self();
    }
    
    
    public B center(boolean center) {
        this.attributes.attribute("center", center);
        return this.self();
    }

    
    public B center() {
        return this.center(true);
    }
    
    
    public B charset(String charset) {
        this.attributes.attribute("charset", charset);
        return this.self();
    }

    
    public B clusterRank(ClusterMode mode) {
        this.attributes.attribute("clusterrank", mode.formatted());
        return this.self();
    }
    
    
    public B colorScheme(String scheme) {
        this.attributes.attribute("colorscheme", scheme);
        return this.self();
    }
    
    
    public B comment(String comment) {
        this.attributes.attribute("comment", comment);
        return this.self();
    }
    
    
    public B compound(boolean compound) {
        this.attributes.attribute("compound", compound);
        return this.self();
    }
    
    public B compound() {
        this.attributes.attribute("compound", true);
        return this.self();
    }
    
    
    public B concentrate(boolean concentrate) {
        this.attributes.attribute("concentrate", concentrate);
        return this.self();
    }
    
    public B concentrate() {
        this.attributes.attribute("concentrate", true);
        return this.self();
    }
    
    
    public B defaultdist(double dist) {
        this.attributes.attribute("defaultdist", dist);
        return this.self();
    }
    
    
    public B dimension(int dim) {
        this.attributes.attribute("dim", dim);
        return this.self();
    }
    
    
    public B dpi(double dpi) {
        this.attributes.attribute("dpi", dpi);
        return this.self();
    }
    
    
    public B epsilon(double epsilon) {
        this.attributes.attribute("epsilon", epsilon);
        return this.self();
    }
    
    
    public B fontColor(Color color) {
        this.attributes.attribute("fontcolor", color.formatted());
        return this.self();
    }
    
    
    public B fontName(String font) {
        this.attributes.attribute("fontname", font);
        return this.self();
    }
    
    
    public B fontNames(String fonts) {
        this.attributes.attribute("fontnames", fonts);
        return this.self();
    }
    
    
    public B fontPath(String path) {
        this.attributes.attribute("fontpath", path);
        return this.self();
    }
    
    
    public B fontSize(double size) {
        this.attributes.attribute("fontsize", size);
        return this.self();
    }
    
    
    public B forceLabels(boolean force) {
        this.attributes.attribute("forcelabels", force);
        return this.self();
    }
    
    
    public B forceLabels() {
        return this.forceLabels(true);
    }
    
    
    public B gradientAngle(int angle) {
        this.attributes.attribute("gradientangle", angle);
        return this.self();
    }
    
    
    public B href(String href) {
        this.attributes.attribute("href", href);
        return this.self();
    }
    
    
    public B id(String id) {
        this.attributes.attribute("id", id);
        return this.self();
    }
    
    
    public B imagePath(String path) {
        this.attributes.attribute("imagepath", path);
        return this.self();
    }

    
    public B label(String label) {
        this.attributes.attribute("label", label);
        return this.self();
    }
    
    
    public B labelScheme(String scheme) {
        this.attributes.attribute("label_scheme", scheme);
        return this.self();
    }
    
    
    public B labelJustification(Justification justification) {
        this.attributes.attribute("labeljust", justification.formatted());
        return this.self();
    }

    
    public B labelLocalisation(VerticalLocalisation localisation) {
        this.attributes.attribute("labelloc", localisation.formatted());
        return this.self();
    }


    
    public B landscape(boolean landscape) {
        this.attributes.attribute("landscape", landscape);
        return this.self();
    }

    
    public B landscape() {
        return this.landscape(true);
    }
    
    
    public B layers(String... layers) {
        this.attributes.attribute("layers", join(layers, ":"));
        return this.self();
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

    
    public B selectedLayers(String... layers) {
        this.attributes.attribute("layerselect", join(layers, ":"));
        return this.self();
    }
    
    
    public B levels(int levels) {
        this.attributes.attribute("levels", levels);
        return this.self();
    }
    
    
    public B levelsGap(double gap) {
        this.attributes.attribute("levelsgap", gap);
        return this.self();
    }
    
    
    public B logicalHeight(double inches) {
        this.attributes.attribute("lheight", inches);
        return this.self();
    }

    
    public B logicalWidth(double inches) {
        this.attributes.attribute("lwidtth", inches);
        return this.self();
    }
    
    
    public B labelPosition(Point p) {
        this.attributes.attribute("lp", p.formatted());
        return this.self();
    }
    
    
    public B margin(double margin) {
        this.attributes.attribute("margin", margin);
        return this.self();
    }
    
    
    public B margin(Point margin) {
        this.attributes.attribute("margin", margin.formatted());
        return this.self();
    }
    
    
    public B maximumIteration(int max) {
        this.attributes.attribute("maxiter", max);
        return this.self();
    }
    
    
    public B multiplicativeScale(double factor) {
        this.attributes.attribute("mclimit", factor);
        return this.self();
    }
    
    
    public B minimumSeparation(double distance) {
        this.attributes.attribute("mclimit", distance);
        return this.self();
    }
    
    
    public B mode(String mode) {
        this.attributes.attribute("mode", mode);
        return this.self();
    }
    
    
    public B model(String model) {
        this.attributes.attribute("model", model);
        return this.self();
    }
    
    
    public B adjascentNodeSeparation(double distance) {
        this.attributes.attribute("nodesep", distance);
        return this.self();
    }
    
    
    public B nojustify(boolean no) {
        this.attributes.attribute("nojustify", no);
        return this.self();
    }

    
    public B nojustify() {
        return this.nojustify(true);
    }

    
    public B normalize(double angle) {
        this.attributes.attribute("normalize", angle);
        return this.self();
    }

    
    public B nslimit(double v) {
        this.attributes.attribute("nslimit", v);
        return this.self();
    }

    
    public B nslimit1(double v) {
        this.attributes.attribute("nslimit1", v);
        return this.self();
    }
    
    
    public B ordering(Ordering ordering) {
        this.attributes.attribute("ordering", ordering.formatted());
        return this.self();
    }
    
    
    public B outputOrder(OutputMode mode) {
        this.attributes.attribute("outputorder", mode.formatted());
        return this.self();
    }
    
    
    public B overlap() {
        this.attributes.attribute("overlap", true);
        return this.self();
    }
    
    
    public B defaultOverlap() {
        this.attributes.attribute("overlap", "false");
        return this.self();
    }
    
    
    public B scaleOverlap() {
        this.attributes.attribute("overlap", "scale");
        return this.self();
    }
    
    
    public B prismOverlap() {
        this.attributes.attribute("overlap", "prism");
        return this.self();
    }
    
    
    public B prismOverlap(int attemps) {
        this.attributes.attribute("overlap", "prism" + attemps);
        return this.self();
    }
    
    
    public B voronoiOverlap() {
        this.attributes.attribute("overlap", "voronoi");
        return this.self();
    }
    
    
    public B scalexyOverlap() {
        this.attributes.attribute("overlap", "scalexy");
        return this.self();
    }
    
    
    public B compressOverlap() {
        this.attributes.attribute("overlap", "compress");
        return this.self();
    }
    
    
    public B overlapScaling(double scaling) {
        this.attributes.attribute("overlap_scaling", scaling);
        return this.self();
    }
    
    
    public B pack() {
        this.attributes.attribute("pack", true);
        return this.self();
    }

    
    public B pack(int margin) {
        this.attributes.attribute("pack", margin);
        return this.self();
    }
    
    
    public B packMode(PackingMode mode) {
        this.attributes.attribute("packmode", mode.formatted());
        return this.self();
    }
    
    
    public B arrayPackMode(String flags) {
        this.attributes.attribute("packmode", "array_" + flags);
        return this.self();
    }
    
    
    public B arrayPackMode(String flags, int columns) {
        this.attributes.attribute("packmode", "array_" + flags + columns);
        return this.self();
    }
    
    
    public B pad(double spec) {
        this.attributes.attribute("pad", spec);
        return this.self();
    }
    
    
    public B pad(Point spec) {
        this.attributes.attribute("pad", spec.formatted());
        return this.self();
    }
    
    
    public B page(double spec) {
        this.attributes.attribute("page", spec);
        return this.self();
    }
    
    
    public B page(Point spec) {
        this.attributes.attribute("page", spec.formatted());
        return this.self();
    }
    
    
    public B pageDir(Direction dir) {
        this.attributes.attribute("pagedir", dir.formatted());
        return this.self();
    }
    
    
    public B quadTree(QuadType type) {
        this.attributes.attribute("quadtree", type.formatted());
        return this.self();
    }
    
    
    public B quantum(double quantum) {
        this.attributes.attribute("quantum", quantum);
        return this.self();
    }
    
    
    public B rank(RankType type, Direction direction) {
        this.attributes.attribute("rank", type.formatted());
        this.attributes.attribute("rankdir", direction.formatted());
        return this.self();
    }
    
    
    public B rankSeparation(String spec) {
        this.attributes.attribute("ranksep", spec);
        return this.self();
    }
    
    
    public B aspectRatio(double ratio) {
        this.attributes.attribute("ratio", ratio);
        return this.self();
    }
    
    
    public B aspectRatio(AspectRatioType type) {
        this.attributes.attribute("ratio", type.formatted());
        return this.self();
    }
    
    
    public B runCrossMinimizationTwice() {
        this.attributes.attribute("remincross", true);
        return this.self();
    }
    
    
    public B repulsiveForcePower(double force) {
        this.attributes.attribute("repulsiveforce", force);
        return this.self();
    }
    
    
    public B resolution(double dpi) {
        this.attributes.attribute("resolution", dpi);
        return this.self();
    }
    
    
    public B rootNode(String node) {
        this.attributes.attribute("root", node);
        return this.self();
    }
    
    
    public B rotate(int angle) {
        this.attributes.attribute("rotate", angle);
        return this.self();
    }
    
    
    public B rotation(double counterClockwise) {
        this.attributes.attribute("rotation", counterClockwise);
        return this.self();
    }
    
    
    public B scale(double spec) {
        this.attributes.attribute("scale", spec);
        return this.self();
    }
    
    
    public B scale(Point spec) {
        this.attributes.attribute("scale", spec.formatted());
        return this.self();
    }
    
    
    public B searchsize(int searchsize) {
        this.attributes.attribute("searchsize", searchsize);
        return this.self();
    }
    
    
    public B size(double size) {
        this.attributes.attribute("size", size);
        return this.self();
    }

    
    public B smoothing(SmootType type) {
        this.attributes.attribute("smoothing", type.formatted());
        return this.self();
    }
    
    
    public B sortv(int sortv) {
        this.attributes.attribute("sortv", sortv);
        return this.self();
    }
    
    
    public B splines() {
        this.attributes.attribute("splines", true);
        return this.self();
    }
    
    
    public B splines(SplineType type) {
        this.attributes.attribute("splines", type.formatted());
        return this.self();
    }
    
    
    public B start(StartType type, int seed) {
        this.attributes.attribute("start", type.formatted() + " " + seed);
        return this.self();
    }
    
    
    public B start(StartType type) {
        this.attributes.attribute("start", type.formatted());
        return this.self();
    }
    
    
    public B style(Style.GraphStyle style) {
        this.attributes.attribute("style", style.formatted());
        return this.self();
    }
    
    public B style(Style.EdgeStyle style) {
        this.attributes.attribute("style", style.formatted());
        return this.self();
    }
    
    public B style(Style.NodeStyle style) {
        this.attributes.attribute("style", style.formatted());
        return this.self();
    }
    
    
    public B stylesheet(String path) {
        this.attributes.attribute("stylesheet", path);
        return this.self();
    }
    
    
    public B target(String target) {
        this.attributes.attribute("target", target);
        return this.self();
    }
    
    
    public B trueColor() {
        this.attributes.attribute("truecolor", true);
        return this.self();
    }
    
    
    public B voroMargin(double size) {
        this.attributes.attribute("voro_margin", size);
        return this.self();
    }

}
