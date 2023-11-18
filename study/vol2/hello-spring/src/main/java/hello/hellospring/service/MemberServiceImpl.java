package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by jeaha on 11/18/23
 */
//@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    
    //    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    /**
     * 회원 가입
     *
     * @param member
     * @return
     */
    @Override
    public Long join(Member member) {
        validateDuplicatedMemberName(member);
        memberRepository.save(member);
        return member.getId();
    }
    
    /**
     * 같은 이름의 회원 가입 방지
     *
     * @param member
     */
    private void validateDuplicatedMemberName(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("Member Is Already Exists.");
                });
    }
    
    /**
     * 전체 회원 조회
     */
    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    
    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
