package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    MemberRepository memberRepository;
    
    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hell");
        
        // when
        Long memberId = memberService.join(member);
        
        // then
        Member findMember = memberService.findOne(memberId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    
    @Test
    void 중복_회원_예외() {
        // given
        Member m1 = new Member();
        m1.setName("1");
        
        Member m2 = new Member();
        m2.setName("1");
    
        // when
        memberService.join(m1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(m2));
    
        // then
        assertThat(e.getMessage()).isEqualTo("Member Is Already Exists.");
    }
    
//    @Test
//    void findMembers() {
//        // given
//
//        // when
//
//        // then
//
//    }
//
//    @Test
//    void findOne() {
//        // given
//
//        // when
//
//        // then
//
//    }
}