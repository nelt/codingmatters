package org.codingmatters.code.analysis.model.from.code.internal;

import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.VariableTree;
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

    public MethodScanner(ClassModel model) {
        this.model = model;
    }

    @Override
    public Void visitMethod(MethodTree methodTree, Void aVoid) {
        this.model.method(methodTree.getName().toString());
        this.currentMethodModel = this.model.getMethod(methodTree.getName().toString());
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
        if(this.model.getMember(variable) != null) {
            this.currentMethodModel.usedMember(this.model.getMember(variable));
        }
        return super.visitIdentifier(identifierTree, aVoid);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
