package org.codingmatters.code.analysis.model.from.code.internal;

import com.sun.source.tree.*;
import com.sun.source.util.TreeScanner;
import org.codingmatters.code.analysis.model.ClassModel;
import org.codingmatters.code.analysis.model.MethodModel;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 17:24
 */
public class MethodScanner extends TreeScanner<Void, Void> {

    private final ClassModel model;
    private MethodModel currentMethodModel = null;
    private SymbolTable currentSymbolTable;

    public MethodScanner(ClassModel model) {
        this.model = model;
    }

    @Override
    public Void visitMethod(MethodTree methodTree, Void aVoid) {
        this.model.method(methodTree.getName().toString());
        this.currentMethodModel = this.model.getMethod(methodTree.getName().toString());

        this.currentSymbolTable = new SymbolTable();
        return super.visitMethod(methodTree, aVoid);
    }

    @Override
    public Void visitMemberSelect(MemberSelectTree memberSelectTree, Void aVoid) {
        this.currentMethodModel.usedMember(this.model.getMember(memberSelectTree.getIdentifier().toString()));
        return super.visitMemberSelect(memberSelectTree, aVoid);
    }

    @Override
    public Void visitIdentifier(IdentifierTree identifierTree, Void aVoid) {
        String variable = identifierTree.getName().toString();
        if(this.isMember(variable) && ! this.isMasked(variable)) {
            this.currentMethodModel.usedMember(this.model.getMember(variable));
        }
        return super.visitIdentifier(identifierTree, aVoid);    //To change body of overridden methods use File | Settings | File Templates.
    }

    private boolean isMember(String variable) {
        return this.model.getMember(variable) != null;
    }

    private boolean isMasked(String variable) {
        return this.currentSymbolTable.contains(variable);
    }

    @Override
    public Void visitVariable(VariableTree variableTree, Void aVoid) {
        this.currentSymbolTable.add(variableTree.getName().toString());
        return super.visitVariable(variableTree, aVoid);
    }

    @Override
    public Void visitBlock(BlockTree blockTree, Void aVoid) {
        this.currentSymbolTable = this.currentSymbolTable.child();
        try {
            return super.visitBlock(blockTree, aVoid);
        } finally {
            this.currentSymbolTable = this.currentSymbolTable.parent();
        }
    }
}
