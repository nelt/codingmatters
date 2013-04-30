package org.codingmatters.random.values.base.string.characters;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 11:39
 * To change this template use File | Settings | File Templates.
 */
public class CharacterRange {


    private final String characters;

    public CharacterRange( String characters ) {
        this.characters = characters;
    }

    public int size() {
        return this.characters.length() ;
    }

    public char get(int i) {
        return this.characters.charAt( i ) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterRange that = (CharacterRange) o;

        if (characters != null ? !characters.equals(that.characters) : that.characters != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return characters != null ? characters.hashCode() : 0;
    }

    public boolean contains(char c) {
        return this.characters.indexOf( c ) != -1 ;
    }
}
