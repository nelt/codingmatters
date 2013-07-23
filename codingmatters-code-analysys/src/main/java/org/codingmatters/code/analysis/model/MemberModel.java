package org.codingmatters.code.analysis.model;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 06:09
 * To change this template use File | Settings | File Templates.
 */
public class MemberModel {

    private final String field;
    private final ClassModel classModel;

    public MemberModel(String field, ClassModel classModel) {
        this.field = field;
        this.classModel = classModel;
    }

    public String getName() {
        return this.field;
    }

    public ClassModel getClassModel() {
        return this.classModel;
    }
}
