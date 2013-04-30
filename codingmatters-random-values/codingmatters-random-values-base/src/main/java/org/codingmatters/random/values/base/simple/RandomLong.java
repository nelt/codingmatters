package org.codingmatters.random.values.base.simple;

import org.codingmatters.random.values.base.RandomValueBuilder;
import org.codingmatters.random.values.base.RandomValues;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
public class RandomLong implements RandomValueBuilder <Long> {
    private long min;
    private long max;

    @Override
    public Long value() {
        assert this.min <= this.max ;
        long length = this.max - this.min ;
        long offset = (long) Math.floor( length * RandomValues.random().nextDouble() );
        return offset + this.min ;
    }

    public RandomLong min(long min) {
        this.min = min;
        return this ;
    }

    public RandomLong max(long max) {
        this.max = max;
        return this ;
    }
}
