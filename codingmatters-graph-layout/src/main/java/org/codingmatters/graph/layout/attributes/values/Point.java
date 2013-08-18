package org.codingmatters.graph.layout.attributes.values;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 15/08/13
 * Time: 06:33
 */
public class Point {

    public static Point xy(long x, long y) {
        return new Point(x, y);
    }


    private final Double x;
    private final Double y;
    private Double z = null;
    private boolean inputOnly = false;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point z(double z) {
        this.z = z;
        return this;
    }
    
    public Point inputOnly() {
        this.inputOnly = true;
        return this;
    }
    
    
    
    public String formatted() {
        StringBuilder result = new StringBuilder()
                .append(this.x)
                .append(",")
                .append(this.y)
                ;
        if(this.z != null) {
            result
                .append(",")
                .append(this.z)
                ;
        }
        if(this.inputOnly) {
            result.append("!");
        }
        return result.toString();
    }
}
