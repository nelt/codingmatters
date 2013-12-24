package org.codingmatters.code.analysis.model.from.code.inspected.methodusage;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 14/09/13
 * Time: 07:30
 * To change this template use File | Settings | File Templates.
 */
public class MethodAndMemberWithSameNameMethodUsage {
    private String used;
    public void used() {}

    public void noUsage() {}

    public void methodQualifiedUsage() {
        this.used();
    }
    
    public void memberQualifiedUsage() {
        this.used = "yopyop";
    }

}
