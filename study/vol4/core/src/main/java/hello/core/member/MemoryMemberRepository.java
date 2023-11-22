package hello.core.member;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeaha on 11/21/23
 */
public class MemoryMemberRepository implements MemberRepository {
    
    private static Map<Long, Member> store = new HashMap<>();
    
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }
    
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
