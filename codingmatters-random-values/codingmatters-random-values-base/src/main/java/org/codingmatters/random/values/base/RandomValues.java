package org.codingmatters.random.values.base;

import org.codingmatters.random.values.base.simple.RandomDouble;
import org.codingmatters.random.values.base.simple.RandomFloat;
import org.codingmatters.random.values.base.simple.RandomInteger;
import org.codingmatters.random.values.base.simple.RandomLong;
import org.codingmatters.random.values.base.string.RandomString;

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
}
