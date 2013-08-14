package org.codingmatters.graph.layout.attributes;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 14/08/13
 * Time: 07:37
 */
public class Color {
    
    /*
string	color name

    
     */

    static public Color rgb(String red, String green, String blue) {
        return new Color(String.format("#%s%s%s", truncate(red, 2), truncate(green, 2), truncate(blue, 2)));
    }
    
    static public Color rgba(String red, String green, String blue, String alpha) {
        return new Color(String.format("#%s%s%s%s", truncate(red, 2), truncate(green, 2), truncate(blue, 2), truncate(alpha, 2)));
    }
    
    static public Color hsv(float hue, float saturation, float value) {
        return new Color(String.format("%s %s %s", hue, saturation, value));
    }
    
    static public Color named(String name) {
        return new Color(name);
    }
    
    private static String truncate(String str, int size) {
        return str.length() > size ? str.substring(0, size) : str;
    }


    private final String color;

    public Color(String color) {
        this.color = color;
    }
    
    public String formatted() {
        return this.color;
    }
}
