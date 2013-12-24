package org.codingmatters.code.analysis.model.from.code.inspected.memberusage;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 14/09/13
 * Time: 07:04
 * To change this template use File | Settings | File Templates.
 */
public class MemberDeclaredAfterMemberUsage {
    public void memberAssignement() {
        member = "yopyop";
    }

    public void thisMemberAssignement() {
        this.member = "yopyop";
    }

    private String member;
}
