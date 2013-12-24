package org.codingmatters.code.analysis.model.from.code.internal;

import net.sourceforge.pmd.dcd.graph.*;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/09/13
 * Time: 06:32
 * To change this template use File | Settings | File Templates.
 */
public class DcdAnalysisVisitor extends NodeVisitorAdapter {

    private final DcdAnalysisContext context;

    public DcdAnalysisVisitor(DcdAnalysisContext context) {
        this.context = context;
    }

    @Override
    public Object visit(ClassNode classNode, Object data) {
        this.context.setClassContext(classNode);
        return super.visit(classNode, data);
    }

    @Override
    public Object visit(FieldNode fieldNode, Object data) {
        this.context.setMemberContext(fieldNode);
        return super.visit(fieldNode, data);
    }

    @Override
    public Object visit(ConstructorNode constructorNode, Object data) {
        this.context.setMemberContext(constructorNode);
        return super.visit(constructorNode, data);
    }

    @Override
    public Object visit(MethodNode methodNode, Object data) {
        this.context.setMemberContext(methodNode);
        return super.visit(methodNode, data);
    }

    @Override
    public Object visitUse(MemberNode memberNode, Object data) {
        this.context.uses(memberNode);
        return super.visitUse(memberNode, data);
    }
}
