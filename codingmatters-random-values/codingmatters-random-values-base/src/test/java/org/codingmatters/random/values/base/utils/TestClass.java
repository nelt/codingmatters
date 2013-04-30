package org.codingmatters.random.values.base.utils;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 21:57
 * To change this template use File | Settings | File Templates.
 */
public class TestClass {
    
    static public TestClass create( String str , Float f ) {
        return new TestClass( str , f ) ;
    }

    private final String str;
    private final Float f;

    public TestClass( String str , Float f ) {
        this.str = str;
        this.f = f;
    }

    public String getStr() {
        return str;
    }

    public Float getF() {
        return f;
    }
}
