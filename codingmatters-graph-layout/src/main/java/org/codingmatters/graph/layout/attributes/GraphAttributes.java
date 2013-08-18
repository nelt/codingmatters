package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.attributes.values.*;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 17/08/13
 * Time: 13:51
 */
public interface GraphAttributes <F extends AttributesFormatter> extends AttributesFormatter {
    F damping(double damping);
    F k(double damping);
    F url(String url);
    F aspect(double ratio);
    F aspect(double ratio, int passCount);
    F boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY);
    F backgroundColor(Color color);
    F backgroundGradient(WeightedColors weightedColors);
    F center(boolean center);
    F center();
    F charset(String charset);
    F clusterRank(ClusterMode mode);
    F colorScheme(String scheme);
    F comment(String comment);
    F compound(boolean compound);
    F compound();
    F concentrate(boolean concentrate);
    F concentrate();
    F defaultdist(double dist);
    F dimension(int dim);
    F dpi(double dpi);
    F epsilon(double epsilon);
    F fontColor(Color color);
    F fontName(String font);
    F fontNames(String fonts);
    F fontPath(String path);
    F fontSize(double size);
    F forceLabels(boolean force);
    F forceLabels();
    F gradientAngle(int angle);
    F href(String href);
    F id(String id);
    F imagePath(String path);
    F label(String label);
    F labelScheme(String scheme);
    F labelJustification(Justification justification);
    F labelLocalisation(VerticalLocalisation localisation);
    F landscape(boolean landscape);
    F landscape();
    F layers(String... layers);
    F selectedLayers(String... layers);
    F levels(int levels);
    F levelsGap(double gap);
    F logicalHeight(double inches);
    F logicalWidth(double inches);
    F labelPosition(Point p);
    F margin(double margin);
    F margin(Point margin);
    F maximumIteration(int max);
    F multiplicativeScale(double factor);
    F minimumSeparation(double distance);
    F mode(String mode);
    F model(String model);
    F adjascentNodeSeparation(double distance);
    F nojustify(boolean no);
    F nojustify();
    F normalize(double angle);
    F nslimit(double v);
    F nslimit1(double v);
    F ordering(Ordering ordering);
    F outputOrder(OutputMode mode);
    F overlap();
    F defaultOverlap();
    F scaleOverlap();
    F prismOverlap();
    F prismOverlap(int attemps);
    F voronoiOverlap();
    F scalexyOverlap();
    F compressOverlap();
    F overlapScaling(double scaling);
    F pack();
    F pack(int margin);
    F packMode(PackingMode mode);
    F arrayPackMode(String flags);
    F arrayPackMode(String flags, int columns);
    F pad(double spec);
    F pad(Point spec);
    F page(double spec);
    F page(Point spec);
    F pageDir(Direction dir);
    F quadTree(QuadType type);
    F quantum(double quantum);
    F rank(RankType type, Direction direction);
    F rankSeparation(String spec);
    F aspectRatio(double ratio);
    F aspectRatio(AspectRatioType type);
    F runCrossMinimizationTwice();
    F repulsiveForcePower(double force);
    F resolution(double dpi);
    F rootNode(String node);
    F rotate(int angle);
    F rotation(double counterClockwise);
    F scale(double spec);
    F scale(Point spec);
    F searchsize(int searchsize);
    F size(double size);
    F smoothing(SmootType type);
    F sortv(int sortv);
    F splines();
    F splines(SplineType type);
    F start(StartType type, int seed);
    F start(StartType type);
    F style(Style.GraphStyle style);
    F stylesheet(String path);
    F target(String target);
    F trueColor();
    F voroMargin(double size);
}
