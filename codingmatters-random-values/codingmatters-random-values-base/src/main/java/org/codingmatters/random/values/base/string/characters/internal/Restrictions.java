package org.codingmatters.random.values.base.string.characters.internal;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 16:25
 * To change this template use File | Settings | File Templates.
 */
public class Restrictions implements CharacterRestriction {
    private final CharsetEncoder charsetEncoder ;
    private Boolean digits = null ;
    private Boolean letters = null ;

    public Restrictions(String charset) {
        this.charsetEncoder = Charset.forName( charset ).newEncoder();
    }

    @Override
    public boolean matches(char c) {
        return this.matchesCharset(c) && this.matchesCharacterRestrictions(c) ;
    }

    private boolean matchesCharacterRestrictions(char c) {
        if( this.hasRestrictions() ) {
            boolean result = false ;
            if( this.digits != null ) {
                result = result || this.matchesDigitRestriction(c);
            }
            if( this.letters != null ) {
                result = result || this.matchesLetterRestriction(c);
            }
            return result ;
        } else {
            return true ;
        }
    }

    private boolean hasRestrictions() {
        return this.digits != null || this.letters != null ;
    }

    private boolean matchesLetterRestriction(char c) {
        if( this.letters ) {
            return Character.isLetter( c ) ;
        } else {
            return ! Character.isLetter( c ) ;
        }
    }

    private boolean matchesDigitRestriction(char c) {
        if( this.digits ) {
            return Character.isDigit( c ) ;
        } else {
            return ! Character.isDigit( c ) ;
        }
    }

    private boolean matchesCharset(char c) {
        return this.charsetEncoder.canEncode(c);
    }

    public void digits( boolean b ) {
        this.digits = b ;
    }

    public void letters(boolean b) {
        this.letters = b ;
    }
}
