package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:39
 */
public class GenericAttributesFormatter<B extends AttributesFormatter> implements AttributesFormatter, GraphAttributes<B> {
        
    private final AttributeList attributes = new AttributeList();
    
    @Override
    public void append(IndentedFormatter formatter) {
        this.attributes.format(formatter);
    }
    


    @Override
    public B damping(double damping) {
        this.attributes.attribute("Damping", damping);
        return (B)this;
    }
    
    @Override
    public B k(double damping) {
        this.attributes.attribute("K", damping);
        return (B)this;
    }

    @Override
    public B url(String url) {
        this.attributes.attribute("URL", url);
        return (B)this;
    }
    
    @Override
    public B aspect(double ratio) {
        this.attributes.attribute("aspect", ratio);
        return (B)this;
    }
    
    @Override
    public B aspect(double ratio, int passCount) {
        this.attributes.attribute("aspect", Double.toString(ratio) + ", " + passCount);
        return (B)this;
    }

    @Override
    public B boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY) {
        this.attributes.attribute("bb", String.format("%s,%s,%s,%s", lowerLeftX,lowerLeftY, upperRightX, upperRightY));
        return (B)this;
    }

    @Override
    public B backgroundColor(Color color) {
        this.attributes.attribute("bgcolor", color.formatted());
        return (B)this;
    }

    @Override
    public B backgroundGradient(WeightedColors weightedColors) {
        this.attributes.attribute("bgcolor", weightedColors.formatted());
        return (B)this;
    }
    
    @Override
    public B center(boolean center) {
        this.attributes.attribute("center", center);
        return (B)this;
    }

    @Override
    public B center() {
        return this.center(true);
    }
    
    @Override
    public B charset(String charset) {
        this.attributes.attribute("charset", charset);
        return (B)this;
    }

    @Override
    public B clusterRank(ClusterMode mode) {
        this.attributes.attribute("clusterrank", mode.formatted());
        return (B)this;
    }
    
    @Override
    public B colorScheme(String scheme) {
        this.attributes.attribute("colorscheme", scheme);
        return (B)this;
    }
    
    @Override
    public B comment(String comment) {
        this.attributes.attribute("comment", comment);
        return (B)this;
    }
    
    @Override
    public B compound(boolean compound) {
        this.attributes.attribute("compound", compound);
        return (B)this;
    }
    @Override
    public B compound() {
        this.attributes.attribute("compound", true);
        return (B)this;
    }
    
    @Override
    public B concentrate(boolean concentrate) {
        this.attributes.attribute("concentrate", concentrate);
        return (B)this;
    }
    @Override
    public B concentrate() {
        this.attributes.attribute("concentrate", true);
        return (B)this;
    }
    
    @Override
    public B defaultdist(double dist) {
        this.attributes.attribute("defaultdist", dist);
        return (B)this;
    }
    
    @Override
    public B dimension(int dim) {
        this.attributes.attribute("dim", dim);
        return (B)this;
    }
    
    @Override
    public B dpi(double dpi) {
        this.attributes.attribute("dpi", dpi);
        return (B)this;
    }
    
    @Override
    public B epsilon(double epsilon) {
        this.attributes.attribute("epsilon", epsilon);
        return (B)this;
    }
    
    @Override
    public B fontColor(Color color) {
        this.attributes.attribute("fontcolor", color.formatted());
        return (B)this;
    }
    
    @Override
    public B fontName(String font) {
        this.attributes.attribute("fontname", font);
        return (B)this;
    }
    
    @Override
    public B fontNames(String fonts) {
        this.attributes.attribute("fontnames", fonts);
        return (B)this;
    }
    
    @Override
    public B fontPath(String path) {
        this.attributes.attribute("fontpath", path);
        return (B)this;
    }
    
    @Override
    public B fontSize(double size) {
        this.attributes.attribute("fontsize", size);
        return (B)this;
    }
    
    @Override
    public B forceLabels(boolean force) {
        this.attributes.attribute("forcelabels", force);
        return (B)this;
    }
    
    @Override
    public B forceLabels() {
        return this.forceLabels(true);
    }
    
    @Override
    public B gradientAngle(int angle) {
        this.attributes.attribute("gradientangle", angle);
        return (B)this;
    }
    
    @Override
    public B href(String href) {
        this.attributes.attribute("href", href);
        return (B)this;
    }
    
    @Override
    public B id(String id) {
        this.attributes.attribute("id", id);
        return (B)this;
    }
    
    @Override
    public B imagePath(String path) {
        this.attributes.attribute("imagepath", path);
        return (B)this;
    }

    @Override
    public B label(String label) {
        this.attributes.attribute("label", label);
        return (B)this;
    }
    
    @Override
    public B labelScheme(String scheme) {
        this.attributes.attribute("label_scheme", scheme);
        return (B)this;
    }
    
    @Override
    public B labelJustification(Justification justification) {
        this.attributes.attribute("labeljust", justification.formatted());
        return (B)this;
    }

    @Override
    public B labelLocalisation(VerticalLocalisation localisation) {
        this.attributes.attribute("labelloc", localisation.formatted());
        return (B)this;
    }


    @Override
    public B landscape(boolean landscape) {
        this.attributes.attribute("landscape", landscape);
        return (B)this;
    }

    @Override
    public B landscape() {
        return this.landscape(true);
    }
    
    @Override
    public B layers(String... layers) {
        this.attributes.attribute("layers", join(layers, ":"));
        return (B)this;
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

    @Override
    public B selectedLayers(String... layers) {
        this.attributes.attribute("layerselect", join(layers, ":"));
        return (B)this;
    }
    
    @Override
    public B levels(int levels) {
        this.attributes.attribute("levels", levels);
        return (B)this;
    }
    
    @Override
    public B levelsGap(double gap) {
        this.attributes.attribute("levelsgap", gap);
        return (B)this;
    }
    
    @Override
    public B logicalHeight(double inches) {
        this.attributes.attribute("lheight", inches);
        return (B)this;
    }

    @Override
    public B logicalWidth(double inches) {
        this.attributes.attribute("lwidtth", inches);
        return (B)this;
    }
    
    @Override
    public B labelPosition(Point p) {
        this.attributes.attribute("lp", p.formatted());
        return (B)this;
    }
    
    @Override
    public B margin(double margin) {
        this.attributes.attribute("margin", margin);
        return (B)this;
    }
    
    @Override
    public B margin(Point margin) {
        this.attributes.attribute("margin", margin.formatted());
        return (B)this;
    }
    
    @Override
    public B maximumIteration(int max) {
        this.attributes.attribute("maxiter", max);
        return (B)this;
    }
    
    @Override
    public B multiplicativeScale(double factor) {
        this.attributes.attribute("mclimit", factor);
        return (B)this;
    }
    
    @Override
    public B minimumSeparation(double distance) {
        this.attributes.attribute("mclimit", distance);
        return (B)this;
    }
    
    @Override
    public B mode(String mode) {
        this.attributes.attribute("mode", mode);
        return (B)this;
    }
    
    @Override
    public B model(String model) {
        this.attributes.attribute("model", model);
        return (B)this;
    }
    
    @Override
    public B adjascentNodeSeparation(double distance) {
        this.attributes.attribute("nodesep", distance);
        return (B)this;
    }
    
    @Override
    public B nojustify(boolean no) {
        this.attributes.attribute("nojustify", no);
        return (B)this;
    }

    @Override
    public B nojustify() {
        return this.nojustify(true);
    }
    
    @Override
    public B normalize(double angle) {
        this.attributes.attribute("normalize", angle);
        return (B)this;
    }

    @Override
    public B nslimit(double v) {
        this.attributes.attribute("nslimit", v);
        return (B)this;
    }

    @Override
    public B nslimit1(double v) {
        this.attributes.attribute("nslimit1", v);
        return (B)this;
    }
    
    @Override
    public B ordering(Ordering ordering) {
        this.attributes.attribute("ordering", ordering.formatted());
        return (B)this;
    }
    
    @Override
    public B outputOrder(OutputMode mode) {
        this.attributes.attribute("outputorder", mode.formatted());
        return (B)this;
    }
    
    @Override
    public B overlap() {
        this.attributes.attribute("overlap", true);
        return (B)this;
    }
    
    @Override
    public B defaultOverlap() {
        this.attributes.attribute("overlap", "false");
        return (B)this;
    }
    
    @Override
    public B scaleOverlap() {
        this.attributes.attribute("overlap", "scale");
        return (B)this;
    }
    
    @Override
    public B prismOverlap() {
        this.attributes.attribute("overlap", "prism");
        return (B)this;
    }
    
    @Override
    public B prismOverlap(int attemps) {
        this.attributes.attribute("overlap", "prism" + attemps);
        return (B)this;
    }
    
    @Override
    public B voronoiOverlap() {
        this.attributes.attribute("overlap", "voronoi");
        return (B)this;
    }
    
    @Override
    public B scalexyOverlap() {
        this.attributes.attribute("overlap", "scalexy");
        return (B)this;
    }
    
    @Override
    public B compressOverlap() {
        this.attributes.attribute("overlap", "compress");
        return (B)this;
    }
    
    @Override
    public B overlapScaling(double scaling) {
        this.attributes.attribute("overlap_scaling", scaling);
        return (B)this;
    }
    
    @Override
    public B pack() {
        this.attributes.attribute("pack", true);
        return (B)this;
    }

    @Override
    public B pack(int margin) {
        this.attributes.attribute("pack", margin);
        return (B)this;
    }
    
    @Override
    public B packMode(PackingMode mode) {
        this.attributes.attribute("packmode", mode.formatted());
        return (B)this;
    }
    
    @Override
    public B arrayPackMode(String flags) {
        this.attributes.attribute("packmode", "array_" + flags);
        return (B)this;
    }
    
    @Override
    public B arrayPackMode(String flags, int columns) {
        this.attributes.attribute("packmode", "array_" + flags + columns);
        return (B)this;
    }
    
    @Override
    public B pad(double spec) {
        this.attributes.attribute("pad", spec);
        return (B)this;
    }
    
    @Override
    public B pad(Point spec) {
        this.attributes.attribute("pad", spec.formatted());
        return (B)this;
    }
    
    @Override
    public B page(double spec) {
        this.attributes.attribute("page", spec);
        return (B)this;
    }
    
    @Override
    public B page(Point spec) {
        this.attributes.attribute("page", spec.formatted());
        return (B)this;
    }
    
    @Override
    public B pageDir(Direction dir) {
        this.attributes.attribute("pagedir", dir.formatted());
        return (B)this;
    }
    
    @Override
    public B quadTree(QuadType type) {
        this.attributes.attribute("quadtree", type.formatted());
        return (B)this;
    }
    
    @Override
    public B quantum(double quantum) {
        this.attributes.attribute("quantum", quantum);
        return (B)this;
    }
    
    @Override
    public B rank(RankType type, Direction direction) {
        this.attributes.attribute("rank", type.formatted());
        this.attributes.attribute("rankdir", direction.formatted());
        return (B)this;
    }
    
    @Override
    public B rankSeparation(String spec) {
        this.attributes.attribute("ranksep", spec);
        return (B)this;
    }
    
    @Override
    public B aspectRatio(double ratio) {
        this.attributes.attribute("ratio", ratio);
        return (B)this;
    }
    
    @Override
    public B aspectRatio(AspectRatioType type) {
        this.attributes.attribute("ratio", type.formatted());
        return (B)this;
    }
    
    @Override
    public B runCrossMinimizationTwice() {
        this.attributes.attribute("remincross", true);
        return (B)this;
    }
    
    @Override
    public B repulsiveForcePower(double force) {
        this.attributes.attribute("repulsiveforce", force);
        return (B)this;
    }
    
    @Override
    public B resolution(double dpi) {
        this.attributes.attribute("resolution", dpi);
        return (B)this;
    }
    
    @Override
    public B rootNode(String node) {
        this.attributes.attribute("root", node);
        return (B)this;
    }
    
    @Override
    public B rotate(int angle) {
        this.attributes.attribute("rotate", angle);
        return (B)this;
    }
    
    @Override
    public B rotation(double counterClockwise) {
        this.attributes.attribute("rotation", counterClockwise);
        return (B)this;
    }
    
    @Override
    public B scale(double spec) {
        this.attributes.attribute("scale", spec);
        return (B)this;
    }
    
    @Override
    public B scale(Point spec) {
        this.attributes.attribute("scale", spec.formatted());
        return (B)this;
    }
    
    @Override
    public B searchsize(int searchsize) {
        this.attributes.attribute("searchsize", searchsize);
        return (B)this;
    }
    
    @Override
    public B size(double size) {
        this.attributes.attribute("size", size);
        return (B)this;
    }

    @Override
    public B smoothing(SmootType type) {
        this.attributes.attribute("smoothing", type.formatted());
        return (B)this;
    }
    
    @Override
    public B sortv(int sortv) {
        this.attributes.attribute("sortv", sortv);
        return (B)this;
    }
    
    @Override
    public B splines() {
        this.attributes.attribute("splines", true);
        return (B)this;
    }
    
    @Override
    public B splines(SplineType type) {
        this.attributes.attribute("splines", type.formatted());
        return (B)this;
    }
    
    @Override
    public B start(StartType type, int seed) {
        this.attributes.attribute("start", type.formatted() + " " + seed);
        return (B)this;
    }
    
    @Override
    public B start(StartType type) {
        this.attributes.attribute("start", type.formatted());
        return (B)this;
    }
    
    @Override
    public B style(Style.GraphStyle style) {
        this.attributes.attribute("style", style.formatted());
        return (B)this;
    }
    
    @Override
    public B stylesheet(String path) {
        this.attributes.attribute("stylesheet", path);
        return (B)this;
    }
    
    @Override
    public B target(String target) {
        this.attributes.attribute("target", target);
        return (B)this;
    }
    
    @Override
    public B trueColor() {
        this.attributes.attribute("truecolor", true);
        return (B)this;
    }
    
    @Override
    public B voroMargin(double size) {
        this.attributes.attribute("voro_margin", size);
        return (B)this;
    }

}
