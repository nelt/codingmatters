package org.codingmatters.random.values.base.string.characters;

import org.codingmatters.random.values.base.utils.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 11:44
 * To change this template use File | Settings | File Templates.
 */
public class CharacterRangeBuilderTest {

    @Test
    public void testUTF_8() throws Exception {
        CharsetEncoder expectedCharset = Charset.forName( "UTF-8" ).newEncoder();
        CharacterRange actual = CharacterRangeBuilder.charset("UTF-8").range();

        Assert.assertTrue( actual.size() > 0 );
        for( int i = 0 ; i < actual.size() ; i++ ) {
            Assert.assertTrue(actual.get(i) + " not in charset UTF-8", expectedCharset.canEncode(actual.get(i))) ;
        }
    }

    @Test
    public void testDefault() throws Exception {
        Assert.assertEquals(CharacterRangeBuilder.charset("UTF-8").range(), CharacterRangeBuilder.builder().range());
    }

    @Test
    public void testDigit() throws Exception {
        CharacterRange actual = CharacterRangeBuilder.charset("US-ASCII").digits().range();
        Assert.assertIsCharacterRange("0123456789", actual) ;
    }

    @Test
    public void testLetter() throws Exception {
        CharacterRange actual = CharacterRangeBuilder.charset("US-ASCII").letters().range();
        Assert.assertIsCharacterRange("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", actual) ;
    }

    @Test
    public void testLetterOrDigit() throws Exception {
        CharacterRange actual = CharacterRangeBuilder.charset("US-ASCII").letters().digits().range();
        Assert.assertIsCharacterRange("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", actual) ;
    }
}
