package org.codingmatters.code.analysis.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 06:09
 * To change this template use File | Settings | File Templates.
 */
public class MethodModel {

    private final String method;
    private final ClassModel classModel;
    private final HashSet<MemberModel> usedMembers = new HashSet<>() ;
    private final HashSet<MethodModel> usedMethods = new HashSet<>() ;

    public MethodModel(String method, ClassModel classModel) {
        this.method = method;
        this.classModel = classModel;
    }

    public String getName() {
        return this.method;
    }

    public ClassModel getClassModel() {
        return this.classModel;
    }
    
    public MethodModel uses(MemberModel memberModel) {
        this.usedMembers.add(memberModel);
        return this;
    }

    public Set getUsedMembers() {
        return this.usedMembers;
    }

    public MethodModel uses(MethodModel usedMethod) {
        this.usedMethods.add(usedMethod);
        return this;
    }

    public Set getUsedMethods() {
        return this.usedMethods;
    }
}
