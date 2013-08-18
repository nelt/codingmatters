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
public interface EdgeAttributes <F extends AttributesFormatter> extends AttributesFormatter {
    F url(String url);
    F colorScheme(String scheme);
    F comment(String comment);
    F fontColor(Color color);
    F fontName(String font);
    F fontSize(double size);
    F href(String href);
    F id(String id);
    F label(String label);
    F labelPosition(Point p);
    F nojustify(boolean no);
    F nojustify();
    F style(Style.EdgeStyle style);
    F target(String target);
}
