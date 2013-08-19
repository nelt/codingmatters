package org.codingmatters.code.analysis.model.from.code.inspected.methodusage;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 05/08/13
 * Time: 07:54
 */
public class SimpleMethodUsage {
    
    public void used() {}
    
    public void noUsage() {}
    
    public void qualifiedUsage() {
        this.used();
    }
    
    public void unqualifiedUsage() {
        used();
    }
}
