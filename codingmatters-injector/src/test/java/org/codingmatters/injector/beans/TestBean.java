package org.codingmatters.injector.beans;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 25/06/13
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
public class TestBean {
    
    private String rawField ;
    
    @TestAnotation(name = "test")
    private String annotatedField;
    
    public String getRawField() {
        return rawField;
    }

    public String getAnnotatedField() {
        return annotatedField;
    }
}
