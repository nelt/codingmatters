package org.codingmatters.random.values.base.simple;

import org.codingmatters.random.values.base.RandomValueBuilder;
import org.codingmatters.random.values.base.RandomValues;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 09:44
 * To change this template use File | Settings | File Templates.
 */
public class RandomInteger implements RandomValueBuilder<Integer> {
    private int min = Integer.MIN_VALUE;
    private int max = Integer.MAX_VALUE;

    @Override
    public Integer value() {
        assert this.min <= this.max ;
        int length = this.max - this.min ;
        int offset = (int) Math.floor( length * RandomValues.random().nextDouble() );
        return offset + this.min ;
    }

    public RandomInteger min(int min) {
        this.min = min;
        return this ;
    }

    public RandomInteger max(int max) {
        this.max = max;
        return this ;
    }
}
