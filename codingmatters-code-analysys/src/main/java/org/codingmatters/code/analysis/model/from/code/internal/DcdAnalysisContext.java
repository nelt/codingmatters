package org.codingmatters.code.analysis.model.from.code.internal;

import net.sourceforge.pmd.dcd.graph.ClassNode;
import net.sourceforge.pmd.dcd.graph.FieldNode;
import net.sourceforge.pmd.dcd.graph.MemberNode;
import org.codingmatters.code.analysis.model.ClassModel;
import org.codingmatters.code.analysis.model.CodeBaseModel;
import org.codingmatters.code.analysis.model.MemberModel;
import org.codingmatters.code.analysis.model.MethodModel;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/09/13
 * Time: 06:29
 * To change this template use File | Settings | File Templates.
 */
public class DcdAnalysisContext {
    
    private final CodeBaseModel model;
    
    private ClassNode classNode;
    private ClassModel classModel;
            
    private MemberNode memberNode;
    private MemberModel memberModel;
    private MethodModel methodModel;

    public DcdAnalysisContext(CodeBaseModel model) {
        this.model = model;
    }

    public void setClassContext(ClassNode classNode) {
        this.classNode = classNode;
        this.setMemberContext(null);
        this.classModel = this.getClassModel(this.classNode.getName());
    }
    
    public void setMemberContext(MemberNode memberNode) {
        this.memberNode = memberNode;
        if(this.memberNode != null) {
            if(this.isMethod(memberNode)) {
                this.methodModel = this.getMethodModel(this.memberNode);
            } else {
                this.memberModel = this.getMemberModel(this.memberNode);
            }
        } else {
            this.memberModel = null;
            this.methodModel = null;
        }
    }
    
    private boolean isMethod(MemberNode memberNode) {
        return memberNode instanceof FieldNode; 
    }
    
    public void uses(MemberNode usedMember) {
        if(this.isMethod(usedMember)) {
            this.addMethodUsage(usedMember);
        } else {
            this.addMemberUsage(usedMember);
        }
    }
    
    private void addMemberUsage(MemberNode memberNode) {
        this.methodModel.uses(this.getMemberModel(memberNode));
    }

    private MemberModel getMemberModel(MemberNode memberNode) {
        ClassModel classModel = this.getClassModel(memberNode.getClassNode().getName());
        if(classModel.getMember(memberNode.getName()) == null) {
            classModel.member(memberNode.getName());
        }
        return classModel.getMember(memberNode.getName());
    }

    private void addMethodUsage(MemberNode memberNode) {
        this.methodModel.uses(this.getMethodModel(memberNode));
    }
    
    private MethodModel getMethodModel(MemberNode memberNode) {
        ClassModel classModel = this.getClassModel(memberNode.getClassNode().getName());
        if(classModel.getMethod(memberNode.getName()) == null) {
            classModel.method(memberNode.getName());
        }
        return classModel.getMethod(memberNode.getName());
    }
    
    
    

    private ClassModel getClassModel(String name) {
        ClassModel classModel = this.model.classForName(name);
        if(classModel == null) {
            this.model.addClass(ClassModel.forName(name));
            classModel = this.model.classForName(name);
        }
        return classModel;
    }
}
