package org.codingmatters.random.values.base.string.characters;

import org.codingmatters.random.values.base.string.characters.internal.Restrictions;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public class CharacterRangeBuilder {
    
    static public String DEFAULT_CHARSET = "UTF-8" ;
    
    private final Restrictions restrictions;

    static public CharacterRangeBuilder builder() {
        return charset( DEFAULT_CHARSET ) ;
    } 
    
    static public CharacterRangeBuilder charset( String charset ) {
        return new CharacterRangeBuilder( charset ) ;
    }

    private CharacterRangeBuilder( String charset ) {
        this.restrictions = new Restrictions( charset ) ;        
    }

    public CharacterRange range() {
        StringBuilder result = new StringBuilder();
        for(char c = 0 ; c < Character.MAX_VALUE ; c++ ) {
            if( this.restrictions.matches(c) ) {
                result.append(c);
            }
        }
        return new CharacterRange( result.toString() ) ;
    }

    public CharacterRangeBuilder digits() {
        this.restrictions.digits(true) ;
        return this ;
    }

    public CharacterRangeBuilder letters() {
        this.restrictions.letters( true ) ;
        return this ;
    }

    public static CharacterRange characters(String characters) {
        return new CharacterRange( characters ) ;
    }
}
