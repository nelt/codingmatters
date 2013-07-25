package org.codingmatters.code.analysis.model;

import org.codingmatters.code.analysis.model.lookup.Lookup;
import org.codingmatters.code.analysis.model.lookup.LookupException;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 25/07/13
 * Time: 04:02
 * To change this template use File | Settings | File Templates.
 */
public class CodeBaseModel {
    private final HashMap<String, ClassModel> classes = new HashMap<>();

    public CodeBaseModel addClass(ClassModel classModel) {
        this.classes.put(classModel.qualifiedName(), classModel);
        return this;
    }

    public ClassModel classForName(String qualifiedName) {
        return this.classes.get(qualifiedName);
    }

    public Lookup<ClassModel> allClassesLookup() {
        return new Lookup<ClassModel>() {
            @Override
            public Iterable<ClassModel> lookup() throws LookupException {
                return classes.values();
            }
        } ;
    }

    public Lookup<ClassModel> packageClassesLookup(final String packageName) {
        return new Lookup<ClassModel>() {
            @Override
            public Iterable<ClassModel> lookup() throws LookupException {
                HashSet result = new HashSet();
                for (ClassModel classModel : classes.values()) {
                    if(classModel.getPackageName().equals(packageName)) {
                        result.add(classModel);
                    }
                }

                return result;
            }
        };
    }

    public Lookup<MethodModel> usageLookup(final MemberModel member) {
        return new Lookup<MethodModel>() {
            @Override
            public Iterable<MethodModel> lookup() throws LookupException {
                HashSet result = new HashSet();
                for (ClassModel classModel : classes.values()) {
                    for (MethodModel methodModel : classModel.usingLookup(member).lookup()) {
                        result.add(methodModel);
                    }
                }

                return result;
            }
        };
    }

    public Lookup<MethodModel> usageLookup(final MethodModel method) {
        return new Lookup<MethodModel>() {
            @Override
            public Iterable<MethodModel> lookup() throws LookupException {
                HashSet result = new HashSet();
                for (ClassModel classModel : classes.values()) {
                    for (MethodModel methodModel : classModel.usingLookup(method).lookup()) {
                        result.add(methodModel);
                    }
                }

                return result;
            }
        };
    }
}