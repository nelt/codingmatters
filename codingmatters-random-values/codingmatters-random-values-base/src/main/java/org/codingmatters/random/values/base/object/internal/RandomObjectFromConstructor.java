package org.codingmatters.random.values.base.object.internal;

import org.codingmatters.random.values.base.RandomValueBuilder;
import org.codingmatters.random.values.base.object.RandomObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class RandomObjectFromConstructor<T> extends AbtsractRandomObject<T> {
    private final Constructor<T> constructor;

    public RandomObjectFromConstructor(Constructor<T> constructor, Object ... params) {
        super(params) ;
        this.constructor = constructor;
    }

    @Override
    public T value() {
        try {
            return this.constructor.newInstance(this.argumentValues()) ;
        } catch (Exception e) {
            return null ;
        }
    }
}
