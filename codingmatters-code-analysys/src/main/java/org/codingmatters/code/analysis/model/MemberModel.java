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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberModel that = (MemberModel) o;

        if (classModel != null ? !classModel.equals(that.classModel) : that.classModel != null) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (classModel != null ? classModel.hashCode() : 0);
        return result;
    }
}
