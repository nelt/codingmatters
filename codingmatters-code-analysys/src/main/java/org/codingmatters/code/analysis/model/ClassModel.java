package org.codingmatters.code.analysis.model;

import org.codingmatters.code.analysis.model.lookup.Lookup;
import org.codingmatters.code.analysis.model.lookup.LookupException;

import java.util.HashMap;
import java.util.LinkedList;

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
    
    public String qualifiedName() {
        return this.getPackageName() + "." + this.getClassName();
    }

    public ClassModel member(String field) {
        this.members.put(field, new MemberModel(field, this));
        return this;
    }

    public MemberModel getMember(String field) {
        return this.members.get(field);
    }

    public ClassModel method(String method) {
        return this.method(method, Usage.EMPTY);
    }
    
    public ClassModel method(String method, Usage usage) {
        MethodModel methodModel = new MethodModel(method, this);
        this.methods.put(method, methodModel);
        usage.apply(methodModel);
        return this;
    }

    public MethodModel getMethod(String method) {
        return this.methods.get(method);
    }

    public Lookup<MethodModel> usingLookup(final MemberModel member) {
        return new Lookup<MethodModel>() {
            @Override
            public Iterable<MethodModel> lookup() throws LookupException {
                LinkedList<MethodModel> result = new LinkedList<>() ;
                for (MethodModel methodModel : ClassModel.this.methods.values()) {
                    if(methodModel.uses(member)) {
                        result.add(methodModel) ;
                    }
                }
                return result;
            }
        };
    }

    public Lookup<MethodModel> usingLookup(final MethodModel method) {
        return new Lookup<MethodModel>() {
            @Override
            public Iterable<MethodModel> lookup() throws LookupException {
                LinkedList<MethodModel> result = new LinkedList<>() ;
                for (MethodModel methodModel : ClassModel.this.methods.values()) {
                    if(methodModel.uses(method)) {
                        result.add(methodModel) ;
                    }
                }
                return result;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassModel that = (ClassModel) o;

        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (packageName != null ? !packageName.equals(that.packageName) : that.packageName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageName != null ? packageName.hashCode() : 0;
        result = 31 * result + (className != null ? className.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClassModel{" +
                "packageName='" + packageName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
