package org.codingmatters.random.values.base.object.internal;

import org.codingmatters.random.values.base.object.RandomObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public class RandomObjectFromFactoryMethod<T> extends AbtsractRandomObject<T> {
    private final Object factory;
    private final Method factoryMethod;

    public RandomObjectFromFactoryMethod(Object factory, Method factoryMethod, Object ... params) {
        super(params);
        this.factory = factory;
        this.factoryMethod = factoryMethod;
    }

    @Override
    public T value() {
        try {
            return (T) factoryMethod.invoke( factory , this.argumentValues());
        } catch (Exception e) {
            return null ;
        }
    }
}
