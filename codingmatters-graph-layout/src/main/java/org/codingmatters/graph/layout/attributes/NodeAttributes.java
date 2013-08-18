package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 18/08/13
 * Time: 07:53
 */
public interface NodeAttributes<F extends AttributesFormatter> extends AttributesFormatter {
    F url(String url);
    F colorScheme(String scheme);
    F comment(String comment);
    F fontColor(Color color);
    F fontName(String font);
    F fontSize(double size);
    F gradientAngle(int angle);
    F href(String href);
    F id(String id);
    F label(String label);
    F labelLocalisation(VerticalLocalisation localisation);
    F margin(double margin);
    F margin(Point margin);
    F nojustify(boolean no);
    F nojustify();
    F ordering(Ordering ordering);
    F sortv(int sortv);
    F style(Style.NodeStyle style);
    F target(String target);
}
