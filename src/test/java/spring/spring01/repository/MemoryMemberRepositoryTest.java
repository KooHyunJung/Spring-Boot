package spring.spring01.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spring.spring01.domain.Member;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// 모든 테스트는 순서가 보장이 안된다
// 따라서 순서와 상관없이 메서드 별로 따로 동작하도록 설계해야 된다
// 때문에 하나의 메서드가 끝날 때마다 repository 깨끗하게 해 줘야 한다 => public voi afterEach()
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메서드가 끝날때마다 어떤 동작을 하는 메서드이다
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
