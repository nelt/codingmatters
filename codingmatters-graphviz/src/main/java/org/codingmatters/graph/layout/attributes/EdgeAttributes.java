package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.attributes.values.Color;
import org.codingmatters.graph.layout.attributes.values.Point;
import org.codingmatters.graph.layout.attributes.values.Style;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 18/08/13
 * Time: 07:45
 */
public interface EdgeAttributes extends AttributesFormatter {
    EdgeAttributes url(String url);
    EdgeAttributes colorScheme(String scheme);
    EdgeAttributes comment(String comment);
    EdgeAttributes fontColor(Color color);
    EdgeAttributes fontName(String font);
    EdgeAttributes fontSize(double size);
    EdgeAttributes href(String href);
    EdgeAttributes id(String id);
    EdgeAttributes label(String label);
    EdgeAttributes labelPosition(Point p);
    EdgeAttributes nojustify(boolean no);
    EdgeAttributes nojustify();
    EdgeAttributes style(Style.EdgeStyle style);
    EdgeAttributes target(String target);
}
