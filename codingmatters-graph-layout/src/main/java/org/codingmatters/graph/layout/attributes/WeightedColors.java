package org.codingmatters.graph.layout.attributes;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 14/08/13
 * Time: 08:07
 */
public class WeightedColors {


    static public WeightedColor weighted(Color color, float weight) {
        return new WeightedColor(color, weight);
    }
    
    static public WeightedColor weighted(Color color) {
        return new WeightedColor(color, null);
    }
    
    static public WeightedColors list(WeightedColor... colors) {
        return new WeightedColors(Arrays.asList(colors));
    }


    private final List<WeightedColor> colors;

    public WeightedColors(List<WeightedColor> colors) {
        this.colors = colors;
    }
    
    public String formatted() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (WeightedColor color : this.colors) {
            if(! first) {
                result.append(":");
            } else {
                first = false;
            }
            result.append(color.formatted());
        }
        return result.toString();
        
    }
    
    static public class WeightedColor {
        private final Color color;
        private final Float weight;

        private WeightedColor(Color color, Float weight) {
            this.color = color;
            this.weight = weight;
        }
        
        public String formatted() {
            return this.color.formatted() + this.formattedWeight();
        }

        private String formattedWeight() {
            return this.weight != null ? ";" + this.weight.toString() : ""; 
        }
    }
}
