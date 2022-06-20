package spring.spring01.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Repository;
import spring.spring01.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null 반환 될 수 있는 경우 Optional.ofNullable()로 감싸 준다
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

// 여기까지 작성한 코드가 잘 작동하는지 [테스트 코드]를 통해 확인하기 -> test/repository/MemoryMemberRepositoryTest
