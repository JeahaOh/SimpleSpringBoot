package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

/**
 * Created by jeaha on 11/21/23
 */
public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        
        MemberService memberService = appConfig.memberService();
        
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
    
        Member findMember = memberService.findMember(1L);
    }
}
