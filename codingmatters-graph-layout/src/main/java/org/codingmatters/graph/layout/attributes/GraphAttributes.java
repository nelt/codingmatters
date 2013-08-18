package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 17/08/13
 * Time: 13:51
 */
public interface GraphAttributes <B extends AttributesFormatter> extends AttributesFormatter {

    B damping(double damping);

    B k(double damping);

    B url(String url);

    B aspect(double ratio);

    B aspect(double ratio, int passCount);

    B boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY);

    B backgroundColor(Color color);

    B backgroundGradient(WeightedColors weightedColors);

    B center(boolean center);

    B center();

    B charset(String charset);

    B clusterRank(ClusterMode mode);

    B colorScheme(String scheme);

    B comment(String comment);

    B compound(boolean compound);

    B compound();

    B concentrate(boolean concentrate);

    B concentrate();

    B defaultdist(double dist);

    B dimension(int dim);

    B dpi(double dpi);

    B epsilon(double epsilon);

    B fontColor(Color color);

    B fontName(String font);

    B fontNames(String fonts);

    B fontPath(String path);

    B fontSize(double size);

    B forceLabels(boolean force);

    B forceLabels();

    B gradientAngle(int angle);

    B href(String href);

    B id(String id);

    B imagePath(String path);

    B label(String label);

    B labelScheme(String scheme);

    B labelJustification(Justification justification);

    B labelLocalisation(VerticalLocalisation localisation);

    B landscape(boolean landscape);

    B landscape();

    B layers(String... layers);

    B selectedLayers(String... layers);

    B levels(int levels);

    B levelsGap(double gap);

    B logicalHeight(double inches);

    B logicalWidth(double inches);

    B labelPosition(Point p);

    B margin(double margin);

    B margin(Point margin);

    B maximumIteration(int max);

    B multiplicativeScale(double factor);

    B minimumSeparation(double distance);

    B mode(String mode);

    B model(String model);

    B adjascentNodeSeparation(double distance);

    B nojustify(boolean no);

    B nojustify();

    B normalize(double angle);

    B nslimit(double v);

    B nslimit1(double v);

    B ordering(Ordering ordering);

    B outputOrder(OutputMode mode);

    B overlap();

    B defaultOverlap();

    B scaleOverlap();

    B prismOverlap();

    B prismOverlap(int attemps);

    B voronoiOverlap();

    B scalexyOverlap();

    B compressOverlap();

    B overlapScaling(double scaling);

    B pack();

    B pack(int margin);

    B packMode(PackingMode mode);

    B arrayPackMode(String flags);

    B arrayPackMode(String flags, int columns);

    B pad(double spec);

    B pad(Point spec);

    B page(double spec);

    B page(Point spec);

    B pageDir(Direction dir);

    B quadTree(QuadType type);

    B quantum(double quantum);

    B rank(RankType type, Direction direction);

    B rankSeparation(String spec);

    B aspectRatio(double ratio);

    B aspectRatio(AspectRatioType type);

    B runCrossMinimizationTwice();

    B repulsiveForcePower(double force);

    B resolution(double dpi);

    B rootNode(String node);

    B rotate(int angle);

    B rotation(double counterClockwise);

    B scale(double spec);

    B scale(Point spec);

    B searchsize(int searchsize);

    B size(double size);

    B smoothing(SmootType type);

    B sortv(int sortv);

    B splines();

    B splines(SplineType type);

    B start(StartType type, int seed);

    B start(StartType type);

    B style(Style.GraphStyle style);

    B stylesheet(String path);

    B target(String target);

    B trueColor();

    B voroMargin(double size);
}
