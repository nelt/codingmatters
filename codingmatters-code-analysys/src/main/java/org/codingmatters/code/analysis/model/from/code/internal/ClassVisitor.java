package org.codingmatters.code.analysis.model.from.code.internal;

import com.sun.source.util.Trees;
import org.codingmatters.code.analysis.model.ClassModel;

import javax.lang.model.element.*;
import javax.lang.model.util.AbstractElementVisitor7;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 15:04
 */
public class ClassVisitor extends AbstractElementVisitor7<Void, Void> {
    
    private final ClassModel model;
    private final Trees trees;
    
    public ClassVisitor(ClassModel model, Trees trees) {
        this.model = model;
        this.trees = trees;
    }

    @Override
    public Void visitType(TypeElement e, Void aVoid) {
        for (Element element : e.getEnclosedElements()) {
            element.accept(this, null);
        }
        return null;
    }

    @Override
    public Void visitExecutable(ExecutableElement e, Void aVoid) {
        this.trees.getTree(e).accept(new MethodScanner(this.model), null);
        return null;
    }

    @Override
    public Void visitVariable(VariableElement e, Void aVoid) {
        this.model.member(e.getSimpleName().toString());
        return null;
    }

    @Override
    public Void visitPackage(PackageElement e, Void aVoid) {
        return null;
    }


    @Override
    public Void visitTypeParameter(TypeParameterElement e, Void aVoid) {
        return null;
    }
}