package hello.core.member;

/**
 * Created by jeaha on 11/21/23
 */
public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
