package org.codingmatters.random.values.base.object.internal;

import org.codingmatters.random.values.base.RandomValueBuilder;
import org.codingmatters.random.values.base.object.RandomObject;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbtsractRandomObject<T> implements RandomObject<T> {
    private final Object[] params;

    public AbtsractRandomObject(Object ... params) {
        this.params = params;
    }
    
    protected Object[] argumentValues() {
        Object[] args = new Object[this.params.length];
        for( int i = 0 ; i < this.params.length ; i++ ) {
            if( params[i] instanceof RandomValueBuilder) {
                args[i] = ((RandomValueBuilder)params[i]).value() ;
            } else {
                args[i] = params[i] ;
            }
        }
        return args;
    }
}
