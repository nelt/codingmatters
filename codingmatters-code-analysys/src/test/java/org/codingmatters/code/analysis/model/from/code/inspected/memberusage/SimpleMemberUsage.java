package org.codingmatters.code.analysis.model.from.code.inspected.memberusage;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 02/08/13
 * Time: 07:00
 */
public class SimpleMemberUsage {
    private String member;
    
    public void memberAssignement() {
        member = "yopyop";
    }
    
    public void thisMemberAssignement() {
        this.member = "yopyop";
    }
    
    public void memberInLoop() {
        for(int i = 0; i < 10; i++) {
            member = "yopyop";
        }
    }
    
    public void memberInMethodCall() {
        this.method(member);
    }
    
    private void method(String arg) {}
    
    public String memberInReturn() {
        return this.member;
    }
    
    public String memberMasked() {
        String member = "yopyop tagada" ;
        return member;
    }
    
    public String maskedInBlock() {
        for(int i = 0; i < 10; i++) {
            String member = "yopyop tagada" ;
            return member;
        }
        return null;
    }
    
    public String previouslyMaskedMember() {
        for(int i = 0; i < 10; i++) {
            String member = "yopyop tagada" ;
        }
        return member ;
    }
}
