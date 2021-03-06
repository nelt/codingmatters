package org.codingmatters.code.analysis.model.from.code.internal;

import com.sun.source.tree.*;
import com.sun.source.util.TreeScanner;
import org.codingmatters.code.analysis.model.ClassModel;
import org.codingmatters.code.analysis.model.MethodModel;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 17:24
 */
public class MethodScanner extends TreeScanner<Void, Void> {

    private final ClassModel model;
    private MethodModel currentMethodModel = null;
    private SymbolTable currentSymbolTable = new SymbolTable() ;
    private HashSet<String> symbolUsage = new HashSet<>();

    public MethodModel getMethodModel() {
        return currentMethodModel;
    }

    public HashSet<String> getSymbolUsage() {
        return symbolUsage;
    }

    public MethodScanner(ClassModel model) {
        this.model = model;
    }

    @Override
    public Void visitMethod(MethodTree methodTree, Void aVoid) {
        this.model.method(methodTree.getName().toString());
        this.currentMethodModel = this.model.getMethod(methodTree.getName().toString());
        
        this.currentSymbolTable.clear();
        return super.visitMethod(methodTree, aVoid);
    }

    @Override
    public Void visitMemberSelect(MemberSelectTree memberSelectTree, Void aVoid) {
        this.symbolUsage.add(memberSelectTree.getIdentifier().toString());
        return super.visitMemberSelect(memberSelectTree, aVoid);
    }

    @Override
    public Void visitIdentifier(IdentifierTree identifierTree, Void aVoid) {
        String variable = identifierTree.getName().toString();
        if(! this.isMasked(variable)) {
            this.symbolUsage.add(variable);
        }
        return super.visitIdentifier(identifierTree, aVoid);
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

    @Override
    public Void visitMethodInvocation(MethodInvocationTree methodInvocationTree, Void aVoid) {
        return super.visitMethodInvocation(methodInvocationTree, aVoid);
    }
}
