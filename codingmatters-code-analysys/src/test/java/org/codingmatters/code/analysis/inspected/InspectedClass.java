package org.codingmatters.code.analysis.inspected;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 19/07/13
 * Time: 06:24
 * To change this template use File | Settings | File Templates.
 */
public class InspectedClass {
    
    private String stringField ;
    
    public String aMethodUsingStringField(String param) {
        String result = param + this.stringField;
        return result;
    }
    
    public String aMethodNotUsingStringField(String param) {
        String result = param ;
        return result;
    }
    
}
