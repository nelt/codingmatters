package org.codingmatters.code.analysis.model;

import org.codingmatters.code.analysis.model.lookup.Lookup;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 06:08
 * To change this template use File | Settings | File Templates.
 */
public class ClassModel {

    public static ClassModel forName(String packageName, String simpleName) {
        return new ClassModel(packageName, simpleName) ;
    }
    
    private String packageName ;
    private String className ;
    private final HashMap<String, MemberModel> members = new HashMap<>();
    private final HashMap<String, MethodModel> methods = new HashMap<>();


    public ClassModel(String packageName, String className) {
        this.packageName = packageName;
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public ClassModel member(String field) {
        this.members.put(field, new MemberModel(field, this));
        return this;
    }

    public MemberModel getMember(String field) {
        return this.members.get(field);
    }

    public ClassModel method(String method) {
        this.methods.put(method, new MethodModel(method, this));
        return this;
    }

    public MethodModel getMethod(String method) {
        return this.methods.get(method);
    }

    public Lookup<ClassModel, MethodModel> usingLookup(MemberModel first) {
        return null;
    }
}
