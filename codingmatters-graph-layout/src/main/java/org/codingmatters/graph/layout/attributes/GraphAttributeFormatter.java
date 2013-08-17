package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:39
 */
public class GraphAttributeFormatter implements GraphAttributes {
    
    private final AttributeList attributes = new AttributeList();

    @Override
    public void append(IndentedFormatter formatter) {
        this.attributes.format(formatter);
    }
    


    @Override
    public GraphAttributes damping(double damping) {
        this.attributes.attribute("Damping", damping);
        return this;
    }
    
    @Override
    public GraphAttributes k(double damping) {
        this.attributes.attribute("K", damping);
        return this;
    }

    @Override
    public GraphAttributes url(String url) {
        this.attributes.attribute("URL", url);
        return this;
    }
    
    @Override
    public GraphAttributes aspect(double ratio) {
        this.attributes.attribute("aspect", ratio);
        return this;
    }
    
    @Override
    public GraphAttributes aspect(double ratio, int passCount) {
        this.attributes.attribute("aspect", Double.toString(ratio) + ", " + passCount);
        return this;
    }

    @Override
    public GraphAttributes boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY) {
        this.attributes.attribute("bb", String.format("%s,%s,%s,%s", lowerLeftX,lowerLeftY, upperRightX, upperRightY));
        return this;
    }

    @Override
    public GraphAttributes backgroundColor(Color color) {
        this.attributes.attribute("bgcolor", color.formatted());
        return this;
    }

    @Override
    public GraphAttributes backgroundGradient(WeightedColors weightedColors) {
        this.attributes.attribute("bgcolor", weightedColors.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes center(boolean center) {
        this.attributes.attribute("center", center);
        return this;
    }

    @Override
    public GraphAttributes center() {
        return this.center(true);
    }
    
    @Override
    public GraphAttributes charset(String charset) {
        this.attributes.attribute("charset", charset);
        return this;
    }

    @Override
    public GraphAttributes clusterRank(ClusterMode mode) {
        this.attributes.attribute("clusterrank", mode.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes colorScheme(String scheme) {
        this.attributes.attribute("colorscheme", scheme);
        return this;
    }
    
    @Override
    public GraphAttributes comment(String comment) {
        this.attributes.attribute("comment", comment);
        return this;
    }
    
    @Override
    public GraphAttributes compound(boolean compound) {
        this.attributes.attribute("compound", compound);
        return this;
    }
    @Override
    public GraphAttributes compound() {
        this.attributes.attribute("compound", true);
        return this;
    }
    
    @Override
    public GraphAttributes concentrate(boolean concentrate) {
        this.attributes.attribute("concentrate", concentrate);
        return this;
    }
    @Override
    public GraphAttributes concentrate() {
        this.attributes.attribute("concentrate", true);
        return this;
    }
    
    @Override
    public GraphAttributes defaultdist(double dist) {
        this.attributes.attribute("defaultdist", dist);
        return this;
    }
    
    @Override
    public GraphAttributes dimension(int dim) {
        this.attributes.attribute("dim", dim);
        return this;
    }
    
    @Override
    public GraphAttributes dpi(double dpi) {
        this.attributes.attribute("dpi", dpi);
        return this;
    }
    
    @Override
    public GraphAttributes epsilon(double epsilon) {
        this.attributes.attribute("epsilon", epsilon);
        return this;
    }
    
    @Override
    public GraphAttributes fontColor(Color color) {
        this.attributes.attribute("fontcolor", color.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes fontName(String font) {
        this.attributes.attribute("fontname", font);
        return this;
    }
    
    @Override
    public GraphAttributes fontNames(String fonts) {
        this.attributes.attribute("fontnames", fonts);
        return this;
    }
    
    @Override
    public GraphAttributes fontPath(String path) {
        this.attributes.attribute("fontpath", path);
        return this;
    }
    
    @Override
    public GraphAttributes fontSize(double size) {
        this.attributes.attribute("fontsize", size);
        return this;
    }
    
    @Override
    public GraphAttributes forceLabels(boolean force) {
        this.attributes.attribute("forcelabels", force);
        return this;
    }
    
    @Override
    public GraphAttributes forceLabels() {
        return this.forceLabels(true);
    }
    
    @Override
    public GraphAttributes gradientAngle(int angle) {
        this.attributes.attribute("gradientangle", angle);
        return this;
    }
    
    @Override
    public GraphAttributes href(String href) {
        this.attributes.attribute("href", href);
        return this;
    }
    
    @Override
    public GraphAttributes id(String id) {
        this.attributes.attribute("id", id);
        return this;
    }
    
    @Override
    public GraphAttributes imagePath(String path) {
        this.attributes.attribute("imagepath", path);
        return this;
    }

    @Override
    public GraphAttributes label(String label) {
        this.attributes.attribute("label", label);
        return this;
    }
    
    @Override
    public GraphAttributes labelScheme(String scheme) {
        this.attributes.attribute("label_scheme", scheme);
        return this;
    }
    
    @Override
    public GraphAttributes labelJustification(Justification justification) {
        this.attributes.attribute("labeljust", justification.formatted());
        return this;
    }

    @Override
    public GraphAttributes labelLocalisation(VerticalLocalisation localisation) {
        this.attributes.attribute("labelloc", localisation.formatted());
        return this;
    }


    @Override
    public GraphAttributes landscape(boolean landscape) {
        this.attributes.attribute("landscape", landscape);
        return this;
    }

    @Override
    public GraphAttributes landscape() {
        return this.landscape(true);
    }
    
    @Override
    public GraphAttributes layers(String... layers) {
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

    @Override
    public GraphAttributes selectedLayers(String... layers) {
        this.attributes.attribute("layerselect", join(layers, ":"));
        return this;
    }
    
    @Override
    public GraphAttributes levels(int levels) {
        this.attributes.attribute("levels", levels);
        return this;
    }
    
    @Override
    public GraphAttributes levelsGap(double gap) {
        this.attributes.attribute("levelsgap", gap);
        return this;
    }
    
    @Override
    public GraphAttributes logicalHeight(double inches) {
        this.attributes.attribute("lheight", inches);
        return this;
    }

    @Override
    public GraphAttributes logicalWidth(double inches) {
        this.attributes.attribute("lwidtth", inches);
        return this;
    }
    
    @Override
    public GraphAttributes labelPosition(Point p) {
        this.attributes.attribute("lp", p.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes margin(double margin) {
        this.attributes.attribute("margin", margin);
        return this;
    }
    
    @Override
    public GraphAttributes margin(Point margin) {
        this.attributes.attribute("margin", margin.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes maximumIteration(int max) {
        this.attributes.attribute("maxiter", max);
        return this;
    }
    
    @Override
    public GraphAttributes multiplicativeScale(double factor) {
        this.attributes.attribute("mclimit", factor);
        return this;
    }
    
    @Override
    public GraphAttributes minimumSeparation(double distance) {
        this.attributes.attribute("mclimit", distance);
        return this;
    }
    
    @Override
    public GraphAttributes mode(String mode) {
        this.attributes.attribute("mode", mode);
        return this;
    }
    
    @Override
    public GraphAttributes model(String model) {
        this.attributes.attribute("model", model);
        return this;
    }
    
    @Override
    public GraphAttributes adjascentNodeSeparation(double distance) {
        this.attributes.attribute("nodesep", distance);
        return this;
    }
    
    @Override
    public GraphAttributes nojustify(boolean no) {
        this.attributes.attribute("nojustify", no);
        return this;
    }

    @Override
    public GraphAttributes nojustify() {
        return this.nojustify(true);
    }
    
    @Override
    public GraphAttributes normalize(double angle) {
        this.attributes.attribute("normalize", angle);
        return this;
    }

    @Override
    public GraphAttributes nslimit(double v) {
        this.attributes.attribute("nslimit", v);
        return this;
    }

    @Override
    public GraphAttributes nslimit1(double v) {
        this.attributes.attribute("nslimit1", v);
        return this;
    }
    
    @Override
    public GraphAttributes ordering(Ordering ordering) {
        this.attributes.attribute("ordering", ordering.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes outputOrder(OutputMode mode) {
        this.attributes.attribute("outputorder", mode.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes overlap() {
        this.attributes.attribute("overlap", true);
        return this;
    }
    
    @Override
    public GraphAttributes defaultOverlap() {
        this.attributes.attribute("overlap", "false");
        return this;
    }
    
    @Override
    public GraphAttributes scaleOverlap() {
        this.attributes.attribute("overlap", "scale");
        return this;
    }
    
    @Override
    public GraphAttributes prismOverlap() {
        this.attributes.attribute("overlap", "prism");
        return this;
    }
    
    @Override
    public GraphAttributes prismOverlap(int attemps) {
        this.attributes.attribute("overlap", "prism" + attemps);
        return this;
    }
    
    @Override
    public GraphAttributes voronoiOverlap() {
        this.attributes.attribute("overlap", "voronoi");
        return this;
    }
    
    @Override
    public GraphAttributes scalexyOverlap() {
        this.attributes.attribute("overlap", "scalexy");
        return this;
    }
    
    @Override
    public GraphAttributes compressOverlap() {
        this.attributes.attribute("overlap", "compress");
        return this;
    }
    
    @Override
    public GraphAttributes overlapScaling(double scaling) {
        this.attributes.attribute("overlap_scaling", scaling);
        return this;
    }
    
    @Override
    public GraphAttributes pack() {
        this.attributes.attribute("pack", true);
        return this;
    }

    @Override
    public GraphAttributes pack(int margin) {
        this.attributes.attribute("pack", margin);
        return this;
    }
    
    @Override
    public GraphAttributes packMode(PackingMode mode) {
        this.attributes.attribute("packmode", mode.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes arrayPackMode(String flags) {
        this.attributes.attribute("packmode", "array_" + flags);
        return this;
    }
    
    @Override
    public GraphAttributes arrayPackMode(String flags, int columns) {
        this.attributes.attribute("packmode", "array_" + flags + columns);
        return this;
    }
    
    @Override
    public GraphAttributes pad(double spec) {
        this.attributes.attribute("pad", spec);
        return this;
    }
    
    @Override
    public GraphAttributes pad(Point spec) {
        this.attributes.attribute("pad", spec.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes page(double spec) {
        this.attributes.attribute("page", spec);
        return this;
    }
    
    @Override
    public GraphAttributes page(Point spec) {
        this.attributes.attribute("page", spec.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes pageDir(Direction dir) {
        this.attributes.attribute("pagedir", dir.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes quadTree(QuadType type) {
        this.attributes.attribute("quadtree", type.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes quantum(double quantum) {
        this.attributes.attribute("quantum", quantum);
        return this;
    }
    
    @Override
    public GraphAttributes rank(RankType type, Direction direction) {
        this.attributes.attribute("rank", type.formatted());
        this.attributes.attribute("rankdir", direction.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes rankSeparation(String spec) {
        this.attributes.attribute("ranksep", spec);
        return this;
    }
    
    @Override
    public GraphAttributes aspectRatio(double ratio) {
        this.attributes.attribute("ratio", ratio);
        return this;
    }
    
    @Override
    public GraphAttributes aspectRatio(AspectRatioType type) {
        this.attributes.attribute("ratio", type.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes runCrossMinimizationTwice() {
        this.attributes.attribute("remincross", true);
        return this;
    }
    
    @Override
    public GraphAttributes repulsiveForcePower(double force) {
        this.attributes.attribute("repulsiveforce", force);
        return this;
    }
    
    @Override
    public GraphAttributes resolution(double dpi) {
        this.attributes.attribute("resolution", dpi);
        return this;
    }
    
    @Override
    public GraphAttributes rootNode(String node) {
        this.attributes.attribute("root", node);
        return this;
    }
    
    @Override
    public GraphAttributes rotate(int angle) {
        this.attributes.attribute("rotate", angle);
        return this;
    }
    
    @Override
    public GraphAttributes rotation(double counterClockwise) {
        this.attributes.attribute("rotation", counterClockwise);
        return this;
    }
    
    @Override
    public GraphAttributes scale(double spec) {
        this.attributes.attribute("scale", spec);
        return this;
    }
    
    @Override
    public GraphAttributes scale(Point spec) {
        this.attributes.attribute("scale", spec.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes searchsize(int searchsize) {
        this.attributes.attribute("searchsize", searchsize);
        return this;
    }
    
    @Override
    public GraphAttributes size(double size) {
        this.attributes.attribute("size", size);
        return this;
    }

    @Override
    public GraphAttributes smoothing(SmootType type) {
        this.attributes.attribute("smoothing", type.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes sortv(int sortv) {
        this.attributes.attribute("sortv", sortv);
        return this;
    }
    
    @Override
    public GraphAttributes splines() {
        this.attributes.attribute("splines", true);
        return this;
    }
    
    @Override
    public GraphAttributes splines(SplineType type) {
        this.attributes.attribute("splines", type.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes start(StartType type, int seed) {
        this.attributes.attribute("start", type.formatted() + " " + seed);
        return this;
    }
    
    @Override
    public GraphAttributes start(StartType type) {
        this.attributes.attribute("start", type.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes style(Style.GraphStyle style) {
        this.attributes.attribute("style", style.formatted());
        return this;
    }
    
    @Override
    public GraphAttributes stylesheet(String path) {
        this.attributes.attribute("stylesheet", path);
        return this;
    }
    
    @Override
    public GraphAttributes target(String target) {
        this.attributes.attribute("target", target);
        return this;
    }
    
    @Override
    public GraphAttributes trueColor() {
        this.attributes.attribute("truecolor", true);
        return this;
    }
    
    @Override
    public GraphAttributes voroMargin(double size) {
        this.attributes.attribute("voro_margin", size);
        return this;
    }

}
