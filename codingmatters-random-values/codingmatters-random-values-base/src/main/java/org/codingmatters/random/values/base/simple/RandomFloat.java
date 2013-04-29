package org.codingmatters.random.values.base.simple;

import org.codingmatters.random.values.base.RandomValueBuilder;
import org.codingmatters.random.values.base.RandomValues;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/04/13
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class RandomFloat implements RandomValueBuilder <Float> {

    private Float min = Float.MIN_VALUE ;
    private Float max = Float.MAX_VALUE ;

    @Override
    public Float value() {
        float length = this.max - this.min ;
        return ( length * RandomValues.random().nextFloat() ) + this.min ;
    }

    public RandomFloat min( Float min ) {
        assert min <= this.max ;
        this.min = min;
        return this ;
    }

    public RandomFloat max( Float max ) {
        assert max >= this.min ;
        this.max = max;
        return this;
    }
}

