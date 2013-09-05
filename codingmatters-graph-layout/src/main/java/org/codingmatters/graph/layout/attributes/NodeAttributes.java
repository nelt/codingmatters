package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.attributes.values.*;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 18/08/13
 * Time: 07:53
 */
public interface NodeAttributes extends AttributesFormatter {
    NodeAttributes url(String url);
    NodeAttributes colorScheme(String scheme);
    NodeAttributes comment(String comment);
    NodeAttributes color(Color color);
    NodeAttributes fontColor(Color color);
    NodeAttributes fontName(String font);
    NodeAttributes fontSize(double size);
    NodeAttributes gradientAngle(int angle);
    NodeAttributes href(String href);
    NodeAttributes id(String id);
    NodeAttributes label(String label);
    NodeAttributes labelLocalisation(VerticalLocalisation localisation);
    NodeAttributes margin(double margin);
    NodeAttributes margin(Point margin);
    NodeAttributes nojustify(boolean no);
    NodeAttributes nojustify();
    NodeAttributes ordering(Ordering ordering);
    NodeAttributes sortv(int sortv);
    NodeAttributes style(Style.NodeStyle style);
    NodeAttributes target(String target);
    NodeAttributes shape(Shape shape);
}
