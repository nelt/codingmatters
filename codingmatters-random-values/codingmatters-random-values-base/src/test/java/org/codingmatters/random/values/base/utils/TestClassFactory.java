package org.codingmatters.random.values.base.utils;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 30/04/13
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public class TestClassFactory {
    
    public TestClass create( String str , Float f ) {
        return new TestClass( str , f ) ;
    }
    
}
