package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by jeaha on 11/18/23
 */
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    
    @Test
    public void save() {
        Member member = new Member();
        member.setName("ASDF");
        
        repository.save(member);
        
        Member result = repository.findById(member.getId()).get();
    
        assertThat(member).isEqualTo(result);
    }
    
    @Test
    public void findByName() {
        Member m1 = new Member();
        m1.setName("1");
        repository.save(m1);
        
        Member m2 = new Member();
        m2.setName("2");
        repository.save(m2);
    
        Member result = repository.findByName("1").get();
        assertThat(result).isEqualTo(m1);
    }
    
    @Test
    public void findAll() {
        Member m1 = new Member();
        m1.setName("1");
        repository.save(m1);
    
        Member m2 = new Member();
        m2.setName("2");
        repository.save(m2);
    
        List<Member> result = repository.findAll();
        
        assertThat(result.size()).isEqualTo(2);
    }
}
