package org.codingmatters.code.analysis.processors;

import com.sun.source.tree.MethodTree;
import com.sun.source.tree.TreeVisitor;
import com.sun.source.util.Trees;

import javax.lang.model.element.*;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.util.AbstractElementVisitor7;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 19/07/13
 * Time: 06:40
 * To change this template use File | Settings | File Templates.
 */
public class VariableNameIndexer extends AbstractElementVisitor7<Void, Void> {
    
    private final Set<Name> variableNames = new HashSet<>() ;
    private final Trees trees;

    public VariableNameIndexer(Trees trees) {
        this.trees = trees;
    }

    public static VariableNameIndexer index(TypeElement root, Trees trees) {
        VariableNameIndexer result = new VariableNameIndexer(trees);
        root.accept(result, null) ;
        return result ;
    }

    @Override
    public Void visitPackage(PackageElement e, Void aVoid) {
        return null;
    }

    @Override
    public Void visitType(TypeElement e, Void aVoid) {
        for (Element element : e.getEnclosedElements()) {
            element.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visitVariable(VariableElement e, Void aVoid) {
        System.out.println("visitVariable " + e);
        this.variableNames.add(e.getSimpleName()) ;
        return null;
    }

    @Override
    public Void visitExecutable(ExecutableElement e, Void aVoid) {
        System.out.println("visitExecutable " + e);
        MethodTree tree = this.trees.getTree(e);
        
        TreeVisitor<Void, Void> methodTreeVisitor = new VariableReferenceInMethodChecker() ;
        tree.accept(methodTreeVisitor, null);
        System.out.println("\t" + tree);
        return null;
    }

    @Override
    public Void visitTypeParameter(TypeParameterElement e, Void aVoid) {
        System.out.println("visitTypeParameter " + e);
        return null;
    }

    public Set<Name> indexed() {
        return this.variableNames;
    }
}
