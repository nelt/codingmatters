package org.codingmatters.code.analysis.processors;

import com.sun.source.tree.MethodTree;
import com.sun.source.util.TreeScanner;
import org.codingmatters.code.analysis.model.ClassModel;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 17:24
 */
public class MethodScanner extends TreeScanner<Void, Void> {

    private final ClassModel model;

    public MethodScanner(ClassModel model) {
        this.model = model;
    }

    @Override
    public Void visitMethod(MethodTree methodTree, Void aVoid) {
        this.model.method(methodTree.getName().toString());
        return super.visitMethod(methodTree, aVoid);
    }
}
