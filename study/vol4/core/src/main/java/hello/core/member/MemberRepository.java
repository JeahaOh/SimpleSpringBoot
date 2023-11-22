package hello.core.member;

/**
 * Created by jeaha on 11/21/23
 */
public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
