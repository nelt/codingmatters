package org.codingmatters.random.values.base.object.internal;

import org.codingmatters.random.values.base.object.RandomObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
public class RandomObjectFromStaticConstructor<T> extends AbtsractRandomObject<T> {
    private final Method staticConstructor;

    public RandomObjectFromStaticConstructor(Method staticConstructor, Object ... params) {
        super( params ) ;
        this.staticConstructor = staticConstructor;
    }

    @Override
    public T value() {
        try {
            return (T) this.staticConstructor.invoke( null , this.argumentValues());
        } catch (Exception e) {
            return null ;
        }
    }
}
