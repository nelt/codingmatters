package org.codingmatters.code.analysis.processors;

import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.ReturnTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.TreeScanner;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 19/07/13
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
public class VariableReferenceInMethodChecker extends TreeScanner<Void, Void> {
    @Override
    public Void visitMemberSelect(MemberSelectTree memberSelectTree, Void aVoid) {
        System.out.println("---------------------\n" + memberSelectTree.getKind() + "\n" + memberSelectTree);
        return super.visitMemberSelect(memberSelectTree, aVoid);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Void visitIdentifier(IdentifierTree identifierTree, Void aVoid) {
        System.out.println("---------------------\n" + identifierTree.getKind() + "\n" + identifierTree);
        return super.visitIdentifier(identifierTree, aVoid);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Void visitReturn(ReturnTree returnTree, Void aVoid) {
        System.out.println("---------------------\n" + returnTree.getKind() + "\n" + returnTree);
        return super.visitReturn(returnTree, aVoid);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
