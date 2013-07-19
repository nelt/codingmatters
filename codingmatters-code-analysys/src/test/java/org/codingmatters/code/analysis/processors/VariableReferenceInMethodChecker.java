package org.codingmatters.code.analysis.processors;

import com.sun.source.tree.IdentifierTree;
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
    public Void visitIdentifier(IdentifierTree identifierTree, Void aVoid) {
        System.out.println("identifier: " + identifierTree.getName());
        
        return super.visitIdentifier(identifierTree, aVoid);
    }
}
