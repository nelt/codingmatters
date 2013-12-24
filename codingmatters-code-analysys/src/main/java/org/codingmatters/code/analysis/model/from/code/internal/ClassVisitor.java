package org.codingmatters.code.analysis.model.from.code.internal;

import com.sun.source.util.Trees;
import org.codingmatters.code.analysis.model.ClassModel;
import org.codingmatters.code.analysis.model.MethodModel;

import javax.lang.model.element.*;
import javax.lang.model.util.AbstractElementVisitor7;
import java.util.HashMap;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 15:04
 */
public class ClassVisitor extends AbstractElementVisitor7<Void, Void> {
    
    private final ClassModel model;
    private final Trees trees;
    
    private HashMap<MethodModel, Set<String>> usages = new HashMap<>();
    
    public ClassVisitor(ClassModel model, Trees trees) {
        this.model = model;
        this.trees = trees;
    }

    @Override
    public Void visitType(TypeElement e, Void aVoid) {
        for (Element element : e.getEnclosedElements()) {
            element.accept(this, null);
        }
        for (MethodModel methodModel : this.usages.keySet()) {
            for (String symbol : this.usages.get(methodModel)) {
                if(this.model.getMember(symbol) != null) {
                    methodModel.usedMember(this.model.getMember(symbol));
                } else if(this.model.getMethod(symbol) != null) {
                    methodModel.usedMethod(this.model.getMethod(symbol));
                } else {
                    System.err.println("no model for symbol " + symbol);
                }
            }
        }

        return null;
    }

    @Override
    public Void visitExecutable(ExecutableElement e, Void aVoid) {
        MethodScanner methodScanner = new MethodScanner(this.model);
        this.trees.getTree(e).accept(methodScanner, null);
        this.usages.put(methodScanner.getMethodModel(), methodScanner.getSymbolUsage());
        System.out.println("-----------" + methodScanner.getMethodModel().getName() + " : " + methodScanner.getSymbolUsage());
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
