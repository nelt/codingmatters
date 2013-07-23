package org.codingmatters.code.analysis.model;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class Usage {
    static public Usage EMPTY = new Usage();
    
    private final HashSet<MemberModel> members = new HashSet<>() ;
    private final HashSet<MethodModel> methods = new HashSet<>() ;
    
    public Usage member(MemberModel member) {
        this.members.add(member) ;
        return this;
    }
    
    public Usage method(MethodModel method) {
        this.methods.add(method) ;
        return this;
    }
    
    public void apply(MethodModel usingMethod) {
        for (MemberModel member : this.members) {
            usingMethod.usedMember(member);
        }
        for (MethodModel method : this.methods) {
            usingMethod.usedMethod(method);
        }


    }
}
