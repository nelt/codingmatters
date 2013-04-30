package org.codingmatters.random.values.base.utils;

import org.codingmatters.random.values.base.string.characters.CharacterRange;

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

    public static void assertInRange( String message , Integer lower, Integer upper, Integer value) {
        assertTrue( message , lower <= value && value <= upper );
    }

    public static void assertInRange(Integer lower, Integer upper, Integer value) {
        assertInRange(
                String.format( "value not in range : %s : [%s ; %s]" , value , lower , upper) ,
                lower , upper , value );
    }

    public static void assertInRange( String message , Long lower, Long upper, Long value) {
        assertTrue( message , lower <= value && value <= upper );
    }

    public static void assertInRange(Long lower, Long upper, Long value) {
        assertInRange(
                String.format( "value not in range : %s : [%s ; %s]" , value , lower , upper) ,
                lower , upper , value );
    }

    static public void assertIsCharacterRange(String expectedChars , CharacterRange actual) {
        assertEquals(expectedChars.length(), actual.size()) ;
        for( int i = 0 ; i < expectedChars.length() ; i++ ) {
            actual.contains( expectedChars.charAt( i )) ;
        }
    }

    public static void assertAllCharactersExpected(String expected, String actual) {
        for( int i = 0 ; i < actual.length() ; i++ ) {
            assertTrue(expected.indexOf(actual.charAt(i)) != -1);
        }
    }
}
