package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.attributes.values.*;
import org.codingmatters.graph.layout.formatting.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:39
 */
public class GenericAttributesFormatter<F extends AttributesFormatter> implements AttributesFormatter, 
        GraphAttributes<F>, 
        EdgeAttributes<F>,
        NodeAttributes<F> {
        
    private final AttributeList attributes = new AttributeList();
    
    @Override
    public void append(IndentedFormatter formatter) {
        this.attributes.format(formatter);
    }
    


    @Override
    public F damping(double damping) {
        this.attributes.attribute("Damping", damping);
        return (F)this;
    }
    
    @Override
    public F k(double damping) {
        this.attributes.attribute("K", damping);
        return (F)this;
    }

    @Override
    public F url(String url) {
        this.attributes.attribute("URL", url);
        return (F)this;
    }
    
    @Override
    public F aspect(double ratio) {
        this.attributes.attribute("aspect", ratio);
        return (F)this;
    }
    
    @Override
    public F aspect(double ratio, int passCount) {
        this.attributes.attribute("aspect", Double.toString(ratio) + ", " + passCount);
        return (F)this;
    }

    @Override
    public F boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY) {
        this.attributes.attribute("bb", String.format("%s,%s,%s,%s", lowerLeftX,lowerLeftY, upperRightX, upperRightY));
        return (F)this;
    }

    @Override
    public F backgroundColor(Color color) {
        this.attributes.attribute("bgcolor", color.formatted());
        return (F)this;
    }

    @Override
    public F backgroundGradient(WeightedColors weightedColors) {
        this.attributes.attribute("bgcolor", weightedColors.formatted());
        return (F)this;
    }
    
    @Override
    public F center(boolean center) {
        this.attributes.attribute("center", center);
        return (F)this;
    }

    @Override
    public F center() {
        return this.center(true);
    }
    
    @Override
    public F charset(String charset) {
        this.attributes.attribute("charset", charset);
        return (F)this;
    }

    @Override
    public F clusterRank(ClusterMode mode) {
        this.attributes.attribute("clusterrank", mode.formatted());
        return (F)this;
    }
    
    @Override
    public F colorScheme(String scheme) {
        this.attributes.attribute("colorscheme", scheme);
        return (F)this;
    }
    
    @Override
    public F comment(String comment) {
        this.attributes.attribute("comment", comment);
        return (F)this;
    }
    
    @Override
    public F compound(boolean compound) {
        this.attributes.attribute("compound", compound);
        return (F)this;
    }
    @Override
    public F compound() {
        this.attributes.attribute("compound", true);
        return (F)this;
    }
    
    @Override
    public F concentrate(boolean concentrate) {
        this.attributes.attribute("concentrate", concentrate);
        return (F)this;
    }
    @Override
    public F concentrate() {
        this.attributes.attribute("concentrate", true);
        return (F)this;
    }
    
    @Override
    public F defaultdist(double dist) {
        this.attributes.attribute("defaultdist", dist);
        return (F)this;
    }
    
    @Override
    public F dimension(int dim) {
        this.attributes.attribute("dim", dim);
        return (F)this;
    }
    
    @Override
    public F dpi(double dpi) {
        this.attributes.attribute("dpi", dpi);
        return (F)this;
    }
    
    @Override
    public F epsilon(double epsilon) {
        this.attributes.attribute("epsilon", epsilon);
        return (F)this;
    }
    
    @Override
    public F fontColor(Color color) {
        this.attributes.attribute("fontcolor", color.formatted());
        return (F)this;
    }
    
    @Override
    public F fontName(String font) {
        this.attributes.attribute("fontname", font);
        return (F)this;
    }
    
    @Override
    public F fontNames(String fonts) {
        this.attributes.attribute("fontnames", fonts);
        return (F)this;
    }
    
    @Override
    public F fontPath(String path) {
        this.attributes.attribute("fontpath", path);
        return (F)this;
    }
    
    @Override
    public F fontSize(double size) {
        this.attributes.attribute("fontsize", size);
        return (F)this;
    }
    
    @Override
    public F forceLabels(boolean force) {
        this.attributes.attribute("forcelabels", force);
        return (F)this;
    }
    
    @Override
    public F forceLabels() {
        return this.forceLabels(true);
    }
    
    @Override
    public F gradientAngle(int angle) {
        this.attributes.attribute("gradientangle", angle);
        return (F)this;
    }
    
    @Override
    public F href(String href) {
        this.attributes.attribute("href", href);
        return (F)this;
    }
    
    @Override
    public F id(String id) {
        this.attributes.attribute("id", id);
        return (F)this;
    }
    
    @Override
    public F imagePath(String path) {
        this.attributes.attribute("imagepath", path);
        return (F)this;
    }

    @Override
    public F label(String label) {
        this.attributes.attribute("label", label);
        return (F)this;
    }
    
    @Override
    public F labelScheme(String scheme) {
        this.attributes.attribute("label_scheme", scheme);
        return (F)this;
    }
    
    @Override
    public F labelJustification(Justification justification) {
        this.attributes.attribute("labeljust", justification.formatted());
        return (F)this;
    }

    @Override
    public F labelLocalisation(VerticalLocalisation localisation) {
        this.attributes.attribute("labelloc", localisation.formatted());
        return (F)this;
    }


    @Override
    public F landscape(boolean landscape) {
        this.attributes.attribute("landscape", landscape);
        return (F)this;
    }

    @Override
    public F landscape() {
        return this.landscape(true);
    }
    
    @Override
    public F layers(String... layers) {
        this.attributes.attribute("layers", join(layers, ":"));
        return (F)this;
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
    public F selectedLayers(String... layers) {
        this.attributes.attribute("layerselect", join(layers, ":"));
        return (F)this;
    }
    
    @Override
    public F levels(int levels) {
        this.attributes.attribute("levels", levels);
        return (F)this;
    }
    
    @Override
    public F levelsGap(double gap) {
        this.attributes.attribute("levelsgap", gap);
        return (F)this;
    }
    
    @Override
    public F logicalHeight(double inches) {
        this.attributes.attribute("lheight", inches);
        return (F)this;
    }

    @Override
    public F logicalWidth(double inches) {
        this.attributes.attribute("lwidtth", inches);
        return (F)this;
    }
    
    @Override
    public F labelPosition(Point p) {
        this.attributes.attribute("lp", p.formatted());
        return (F)this;
    }
    
    @Override
    public F margin(double margin) {
        this.attributes.attribute("margin", margin);
        return (F)this;
    }
    
    @Override
    public F margin(Point margin) {
        this.attributes.attribute("margin", margin.formatted());
        return (F)this;
    }
    
    @Override
    public F maximumIteration(int max) {
        this.attributes.attribute("maxiter", max);
        return (F)this;
    }
    
    @Override
    public F multiplicativeScale(double factor) {
        this.attributes.attribute("mclimit", factor);
        return (F)this;
    }
    
    @Override
    public F minimumSeparation(double distance) {
        this.attributes.attribute("mclimit", distance);
        return (F)this;
    }
    
    @Override
    public F mode(String mode) {
        this.attributes.attribute("mode", mode);
        return (F)this;
    }
    
    @Override
    public F model(String model) {
        this.attributes.attribute("model", model);
        return (F)this;
    }
    
    @Override
    public F adjascentNodeSeparation(double distance) {
        this.attributes.attribute("nodesep", distance);
        return (F)this;
    }
    
    @Override
    public F nojustify(boolean no) {
        this.attributes.attribute("nojustify", no);
        return (F)this;
    }

    @Override
    public F nojustify() {
        return this.nojustify(true);
    }
    
    @Override
    public F normalize(double angle) {
        this.attributes.attribute("normalize", angle);
        return (F)this;
    }

    @Override
    public F nslimit(double v) {
        this.attributes.attribute("nslimit", v);
        return (F)this;
    }

    @Override
    public F nslimit1(double v) {
        this.attributes.attribute("nslimit1", v);
        return (F)this;
    }
    
    @Override
    public F ordering(Ordering ordering) {
        this.attributes.attribute("ordering", ordering.formatted());
        return (F)this;
    }
    
    @Override
    public F outputOrder(OutputMode mode) {
        this.attributes.attribute("outputorder", mode.formatted());
        return (F)this;
    }
    
    @Override
    public F overlap() {
        this.attributes.attribute("overlap", true);
        return (F)this;
    }
    
    @Override
    public F defaultOverlap() {
        this.attributes.attribute("overlap", "false");
        return (F)this;
    }
    
    @Override
    public F scaleOverlap() {
        this.attributes.attribute("overlap", "scale");
        return (F)this;
    }
    
    @Override
    public F prismOverlap() {
        this.attributes.attribute("overlap", "prism");
        return (F)this;
    }
    
    @Override
    public F prismOverlap(int attemps) {
        this.attributes.attribute("overlap", "prism" + attemps);
        return (F)this;
    }
    
    @Override
    public F voronoiOverlap() {
        this.attributes.attribute("overlap", "voronoi");
        return (F)this;
    }
    
    @Override
    public F scalexyOverlap() {
        this.attributes.attribute("overlap", "scalexy");
        return (F)this;
    }
    
    @Override
    public F compressOverlap() {
        this.attributes.attribute("overlap", "compress");
        return (F)this;
    }
    
    @Override
    public F overlapScaling(double scaling) {
        this.attributes.attribute("overlap_scaling", scaling);
        return (F)this;
    }
    
    @Override
    public F pack() {
        this.attributes.attribute("pack", true);
        return (F)this;
    }

    @Override
    public F pack(int margin) {
        this.attributes.attribute("pack", margin);
        return (F)this;
    }
    
    @Override
    public F packMode(PackingMode mode) {
        this.attributes.attribute("packmode", mode.formatted());
        return (F)this;
    }
    
    @Override
    public F arrayPackMode(String flags) {
        this.attributes.attribute("packmode", "array_" + flags);
        return (F)this;
    }
    
    @Override
    public F arrayPackMode(String flags, int columns) {
        this.attributes.attribute("packmode", "array_" + flags + columns);
        return (F)this;
    }
    
    @Override
    public F pad(double spec) {
        this.attributes.attribute("pad", spec);
        return (F)this;
    }
    
    @Override
    public F pad(Point spec) {
        this.attributes.attribute("pad", spec.formatted());
        return (F)this;
    }
    
    @Override
    public F page(double spec) {
        this.attributes.attribute("page", spec);
        return (F)this;
    }
    
    @Override
    public F page(Point spec) {
        this.attributes.attribute("page", spec.formatted());
        return (F)this;
    }
    
    @Override
    public F pageDir(Direction dir) {
        this.attributes.attribute("pagedir", dir.formatted());
        return (F)this;
    }
    
    @Override
    public F quadTree(QuadType type) {
        this.attributes.attribute("quadtree", type.formatted());
        return (F)this;
    }
    
    @Override
    public F quantum(double quantum) {
        this.attributes.attribute("quantum", quantum);
        return (F)this;
    }
    
    @Override
    public F rank(RankType type, Direction direction) {
        this.attributes.attribute("rank", type.formatted());
        this.attributes.attribute("rankdir", direction.formatted());
        return (F)this;
    }
    
    @Override
    public F rankSeparation(String spec) {
        this.attributes.attribute("ranksep", spec);
        return (F)this;
    }
    
    @Override
    public F aspectRatio(double ratio) {
        this.attributes.attribute("ratio", ratio);
        return (F)this;
    }
    
    @Override
    public F aspectRatio(AspectRatioType type) {
        this.attributes.attribute("ratio", type.formatted());
        return (F)this;
    }
    
    @Override
    public F runCrossMinimizationTwice() {
        this.attributes.attribute("remincross", true);
        return (F)this;
    }
    
    @Override
    public F repulsiveForcePower(double force) {
        this.attributes.attribute("repulsiveforce", force);
        return (F)this;
    }
    
    @Override
    public F resolution(double dpi) {
        this.attributes.attribute("resolution", dpi);
        return (F)this;
    }
    
    @Override
    public F rootNode(String node) {
        this.attributes.attribute("root", node);
        return (F)this;
    }
    
    @Override
    public F rotate(int angle) {
        this.attributes.attribute("rotate", angle);
        return (F)this;
    }
    
    @Override
    public F rotation(double counterClockwise) {
        this.attributes.attribute("rotation", counterClockwise);
        return (F)this;
    }
    
    @Override
    public F scale(double spec) {
        this.attributes.attribute("scale", spec);
        return (F)this;
    }
    
    @Override
    public F scale(Point spec) {
        this.attributes.attribute("scale", spec.formatted());
        return (F)this;
    }
    
    @Override
    public F searchsize(int searchsize) {
        this.attributes.attribute("searchsize", searchsize);
        return (F)this;
    }
    
    @Override
    public F size(double size) {
        this.attributes.attribute("size", size);
        return (F)this;
    }

    @Override
    public F smoothing(SmootType type) {
        this.attributes.attribute("smoothing", type.formatted());
        return (F)this;
    }
    
    @Override
    public F sortv(int sortv) {
        this.attributes.attribute("sortv", sortv);
        return (F)this;
    }
    
    @Override
    public F splines() {
        this.attributes.attribute("splines", true);
        return (F)this;
    }
    
    @Override
    public F splines(SplineType type) {
        this.attributes.attribute("splines", type.formatted());
        return (F)this;
    }
    
    @Override
    public F start(StartType type, int seed) {
        this.attributes.attribute("start", type.formatted() + " " + seed);
        return (F)this;
    }
    
    @Override
    public F start(StartType type) {
        this.attributes.attribute("start", type.formatted());
        return (F)this;
    }
    
    @Override
    public F style(Style.GraphStyle style) {
        this.attributes.attribute("style", style.formatted());
        return (F)this;
    }
    @Override
    public F style(Style.EdgeStyle style) {
        this.attributes.attribute("style", style.formatted());
        return (F)this;
    }
    @Override
    public F style(Style.NodeStyle style) {
        this.attributes.attribute("style", style.formatted());
        return (F)this;
    }
    
    @Override
    public F stylesheet(String path) {
        this.attributes.attribute("stylesheet", path);
        return (F)this;
    }
    
    @Override
    public F target(String target) {
        this.attributes.attribute("target", target);
        return (F)this;
    }
    
    @Override
    public F trueColor() {
        this.attributes.attribute("truecolor", true);
        return (F)this;
    }
    
    @Override
    public F voroMargin(double size) {
        this.attributes.attribute("voro_margin", size);
        return (F)this;
    }

}
