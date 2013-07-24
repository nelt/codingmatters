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
    
    public MethodModel usedMember(MemberModel memberModel) {
        this.usedMembers.add(memberModel);
        return this;
    }

    public Set getUsedMembers() {
        return this.usedMembers;
    }

    public MethodModel usedMethod(MethodModel usedMethod) {
        this.usedMethods.add(usedMethod);
        return this;
    }

    public Set getUsedMethods() {
        return this.usedMethods;
    }

    public boolean uses(MemberModel memberModel) {
        return this.usedMembers.contains(memberModel);
    }

    public boolean uses(MethodModel usedMethod) {
        return this.usedMethods.contains(usedMethod);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodModel that = (MethodModel) o;

        if (classModel != null ? !classModel.equals(that.classModel) : that.classModel != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = method != null ? method.hashCode() : 0;
        result = 31 * result + (classModel != null ? classModel.hashCode() : 0);
        return result;
    }
}
