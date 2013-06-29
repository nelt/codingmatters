package org.codingmatters.random.values.base.string;

import org.codingmatters.random.values.base.RandomValueBuilder;
import org.codingmatters.random.values.base.RandomValues;
import org.codingmatters.random.values.base.string.characters.CharacterRange;
import org.codingmatters.random.values.base.string.characters.CharacterRangeBuilder;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 10:16
 * To change this template use File | Settings | File Templates.
 */
public class RandomString implements RandomValueBuilder <String> {
    
    private CharacterRange range = CharacterRangeBuilder.charset( "UTF-8" ).range() ;
    
    private int min = 0 ;
    private int max = 256 ;

    @Override
    public String value() {
        assert this.min <= this.max ;
        
        StringBuilder result = new StringBuilder() ;
        int length = this.min == this.max ? this.min : this.min + RandomValues.random().nextInt( this.max - this.min ) ;
        for( int i = 0 ; i < length ; i++ ) {
            int r = RandomValues.random().nextInt( this.range.size() ) ;
            result.append( this.range.get( r ) ) ;
        }
        return result.toString() ;
    }

    public RandomString minLength(int min) {
        this.min = min;
        return this ;
    }

    public RandomString maxLength(int max) {
        this.max = max;
        return this ;
    }


    public RandomString length(int fixed) {
        this.min = fixed ;
        this.max = fixed ;
        return this ;
    }

    public RandomString characters(CharacterRange characterRange) {
        this.range = characterRange ;
        return this ;
    }

    public RandomString characters(String characters) {
        this.range = new CharacterRange(characters) ;
        return this ;
    }
}
