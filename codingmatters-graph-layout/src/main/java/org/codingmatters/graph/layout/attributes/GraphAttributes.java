package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 17/08/13
 * Time: 13:51
 */
public interface GraphAttributes {
    void append(IndentedFormatter formatter);

    GraphAttributes damping(double damping);

    GraphAttributes k(double damping);

    GraphAttributes url(String url);

    GraphAttributes aspect(double ratio);

    GraphAttributes aspect(double ratio, int passCount);

    GraphAttributes boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY);

    GraphAttributes backgroundColor(Color color);

    GraphAttributes backgroundGradient(WeightedColors weightedColors);

    GraphAttributes center(boolean center);

    GraphAttributes center();

    GraphAttributes charset(String charset);

    GraphAttributes clusterRank(ClusterMode mode);

    GraphAttributes colorScheme(String scheme);

    GraphAttributes comment(String comment);

    GraphAttributes compound(boolean compound);

    GraphAttributes compound();

    GraphAttributes concentrate(boolean concentrate);

    GraphAttributes concentrate();

    GraphAttributes defaultdist(double dist);

    GraphAttributes dimension(int dim);

    GraphAttributes dpi(double dpi);

    GraphAttributes epsilon(double epsilon);

    GraphAttributes fontColor(Color color);

    GraphAttributes fontName(String font);

    GraphAttributes fontNames(String fonts);

    GraphAttributes fontPath(String path);

    GraphAttributes fontSize(double size);

    GraphAttributes forceLabels(boolean force);

    GraphAttributes forceLabels();

    GraphAttributes gradientAngle(int angle);

    GraphAttributes href(String href);

    GraphAttributes id(String id);

    GraphAttributes imagePath(String path);

    GraphAttributes label(String label);

    GraphAttributes labelScheme(String scheme);

    GraphAttributes labelJustification(Justification justification);

    GraphAttributes labelLocalisation(VerticalLocalisation localisation);

    GraphAttributes landscape(boolean landscape);

    GraphAttributes landscape();

    GraphAttributes layers(String... layers);

    GraphAttributes selectedLayers(String... layers);

    GraphAttributes levels(int levels);

    GraphAttributes levelsGap(double gap);

    GraphAttributes logicalHeight(double inches);

    GraphAttributes logicalWidth(double inches);

    GraphAttributes labelPosition(Point p);

    GraphAttributes margin(double margin);

    GraphAttributes margin(Point margin);

    GraphAttributes maximumIteration(int max);

    GraphAttributes multiplicativeScale(double factor);

    GraphAttributes minimumSeparation(double distance);

    GraphAttributes mode(String mode);

    GraphAttributes model(String model);

    GraphAttributes adjascentNodeSeparation(double distance);

    GraphAttributes nojustify(boolean no);

    GraphAttributes nojustify();

    GraphAttributes normalize(double angle);

    GraphAttributes nslimit(double v);

    GraphAttributes nslimit1(double v);

    GraphAttributes ordering(Ordering ordering);

    GraphAttributes outputOrder(OutputMode mode);

    GraphAttributes overlap();

    GraphAttributes defaultOverlap();

    GraphAttributes scaleOverlap();

    GraphAttributes prismOverlap();

    GraphAttributes prismOverlap(int attemps);

    GraphAttributes voronoiOverlap();

    GraphAttributes scalexyOverlap();

    GraphAttributes compressOverlap();

    GraphAttributes overlapScaling(double scaling);

    GraphAttributes pack();

    GraphAttributes pack(int margin);

    GraphAttributes packMode(PackingMode mode);

    GraphAttributes arrayPackMode(String flags);

    GraphAttributes arrayPackMode(String flags, int columns);

    GraphAttributes pad(double spec);

    GraphAttributes pad(Point spec);

    GraphAttributes page(double spec);

    GraphAttributes page(Point spec);

    GraphAttributes pageDir(Direction dir);

    GraphAttributes quadTree(QuadType type);

    GraphAttributes quantum(double quantum);

    GraphAttributes rank(RankType type, Direction direction);

    GraphAttributes rankSeparation(String spec);

    GraphAttributes aspectRatio(double ratio);

    GraphAttributes aspectRatio(AspectRatioType type);

    GraphAttributes runCrossMinimizationTwice();

    GraphAttributes repulsiveForcePower(double force);

    GraphAttributes resolution(double dpi);

    GraphAttributes rootNode(String node);

    GraphAttributes rotate(int angle);

    GraphAttributes rotation(double counterClockwise);

    GraphAttributes scale(double spec);

    GraphAttributes scale(Point spec);

    GraphAttributes searchsize(int searchsize);

    GraphAttributes size(double size);

    GraphAttributes smoothing(SmootType type);

    GraphAttributes sortv(int sortv);

    GraphAttributes splines();

    GraphAttributes splines(SplineType type);

    GraphAttributes start(StartType type, int seed);

    GraphAttributes start(StartType type);

    GraphAttributes style(Style.GraphStyle style);

    GraphAttributes stylesheet(String path);

    GraphAttributes target(String target);

    GraphAttributes trueColor();

    GraphAttributes voroMargin(double size);
}
