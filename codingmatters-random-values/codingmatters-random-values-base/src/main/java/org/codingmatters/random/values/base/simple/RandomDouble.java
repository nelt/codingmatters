package org.codingmatters.random.values.base.simple;

import org.codingmatters.random.values.base.RandomValueBuilder;
import org.codingmatters.random.values.base.RandomValues;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/04/13
 * Time: 22:14
 * To change this template use File | Settings | File Templates.
 */
public class RandomDouble implements RandomValueBuilder <Double>{

    private Double min = Double.MIN_VALUE ;
    private Double max = Double.MAX_VALUE ;

    @Override
    public Double value() {
        double length = this.max - this.min ;
        return ( length * RandomValues.random().nextDouble() ) + this.min ;
    }

    public RandomDouble min( Double min ) {
        assert min <= this.max ;
        this.min = min;
        return this ;
    }

    public RandomDouble max( Double max ) {
        assert max >= this.min ;
        this.max = max;
        return this;
    }
}
