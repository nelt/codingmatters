package org.codingmatters.graph.layout.attributes;

import org.codingmatters.graph.layout.internal.IndentedFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 11/08/13
 * Time: 07:39
 */
public class GraphAttributeFormatter {
    
    private final AttributeList attributes = new AttributeList();
    
    public GraphAttributeFormatter damping(double damping) {
        this.attributes.attribute("Damping", damping);
        return this;
    }
    
    public GraphAttributeFormatter k(double damping) {
        this.attributes.attribute("K", damping);
        return this;
    }

    public GraphAttributeFormatter url(String url) {
        this.attributes.attribute("URL", url);
        return this;
    }
    
    public GraphAttributeFormatter aspect(double ratio) {
        this.attributes.attribute("aspect", ratio);
        return this;
    }
    
    public GraphAttributeFormatter aspect(double ratio, int passCount) {
        this.attributes.attribute("aspect", Double.toString(ratio) + ", " + passCount);
        return this;
    }

    public GraphAttributeFormatter boundingBox(long lowerLeftX, long lowerLeftY, long upperRightX, long upperRightY) {
        this.attributes.attribute("bb", String.format("%s,%s,%s,%s", lowerLeftX,lowerLeftY, upperRightX, upperRightY));
        return this;
    }

    public GraphAttributeFormatter backgroundColor(Color color) {
        this.attributes.attribute("bgcolor", color.formatted());
        return this;
    }

    public GraphAttributeFormatter backgroundGradient(WeightedColors weightedColors) {
        this.attributes.attribute("bgcolor", weightedColors.formatted());
        return this;
    }
    
    

    public GraphAttributeFormatter label(String label) {
        this.attributes.attribute("label", label);
        return this;
    }
    
    

    public void format(IndentedFormatter formatter) {
        this.attributes.format(formatter);
    }
}
