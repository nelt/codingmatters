package org.codingmatters.random.values.base.string;

import org.codingmatters.random.values.base.string.characters.CharacterRange;
import org.codingmatters.random.values.base.utils.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
public class RandomStringTest {

    @Test
    public void testDefault() throws Exception {
        RandomString random = new RandomString() ;
        String actual = random.value();

        Assert.assertNotNull(actual);
        Assert.assertInRange( 0 , 256 , actual.length() );
    }

    @Test
    public void testSizeRange() throws Exception {
        RandomString random = new RandomString().minLength(8).maxLength(10) ;
        String actual = random.value();

        Assert.assertNotNull(actual);
        Assert.assertInRange( 8 , 10 , actual.length() );
    }

    @Test
    public void testFixedLength() throws Exception {
        RandomString random = new RandomString().length(10) ;
        Assert.assertEquals( 10 , random.value().length() ) ;
    }

    @Test
    public void testFromRange() throws Exception {
        String characters = "abc";
        RandomString random = new RandomString().length(10).characters( new CharacterRange( characters )) ;
        String actual = random.value() ;
        Assert.assertAllCharactersExpected(characters, actual);
    }


    @Test
    public void testFromRangeShortcut() throws Exception {
        RandomString random = new RandomString().length(10).characters("abc") ;
        String actual = random.value() ;
        Assert.assertAllCharactersExpected("abc", actual);
    }

}
