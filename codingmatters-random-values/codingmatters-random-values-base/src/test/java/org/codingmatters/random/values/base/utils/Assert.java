package org.codingmatters.random.values.base.utils;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 29/04/13
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
public class Assert extends org.junit.Assert {

    public static void assertInRange( String message , Float lower, Float upper, Float value) {
        assertTrue( message , lower <= value && value <= upper );
    }
    
    public static void assertInRange(Float lower, Float upper, Float value) {
        assertInRange( 
                String.format( "value not in range : %s : [%s ; %s]" , value , lower , upper) , 
                lower , upper , value );
    }

    public static void assertInRange( String message , Double lower, Double upper, Double value) {
        assertTrue( message , lower <= value && value <= upper );
    }

    public static void assertInRange(Double lower, Double upper, Double value) {
        assertInRange(
                String.format( "value not in range : %s : [%s ; %s]" , value , lower , upper) ,
                lower , upper , value );
    }
}
