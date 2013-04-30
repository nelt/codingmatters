package org.codingmatters.random.values.base;

import org.codingmatters.random.values.base.object.RandomObject;
import org.codingmatters.random.values.base.object.internal.RandomObjectFromConstructor;
import org.codingmatters.random.values.base.object.internal.RandomObjectFromFactoryMethod;
import org.codingmatters.random.values.base.object.internal.RandomObjectFromStaticConstructor;
import org.codingmatters.random.values.base.simple.RandomDouble;
import org.codingmatters.random.values.base.simple.RandomFloat;
import org.codingmatters.random.values.base.simple.RandomInteger;
import org.codingmatters.random.values.base.simple.RandomLong;
import org.codingmatters.random.values.base.string.RandomString;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/04/13
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class RandomValues {
    
    static private final Random RANDOM = new Random() ;
    
    static public Random random() {
        return RANDOM ;
    }
    
    static public RandomFloat float_() {
        return new RandomFloat() ;
    }

    public static RandomDouble double_() {
        return new RandomDouble() ;
    }

    public static RandomInteger integer() {
        return new RandomInteger() ;
    }

    public static RandomLong long_() {
        return new RandomLong() ;
    }

    public static RandomString string() {
        return new RandomString() ;
    }
    
    public static <T> RandomObject<T> fromConstructor( Constructor<T> constructor , Object ... params ) {
        return new RandomObjectFromConstructor<T>( constructor , params ) ;
    }

    public static <T> RandomObject<T> fromStaticConstructor(Method staticConstructor , Object ... params) {
        return new RandomObjectFromStaticConstructor<T>( staticConstructor , params ) ;
    }


    public static <T> RandomObject<T> fromFactory(Object factory, Method factoryMethod, Object ... params) {
        return new RandomObjectFromFactoryMethod<T>( factory , factoryMethod , params ) ;
    }
}
