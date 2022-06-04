package spring.spring01.repository;

import spring.spring01.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // id 회원 찾기 기능
    Optional<Member> findByName(String name); // name 회원 찾기 기능
    List<Member> findAll(); // 모든 회원 정보 반환
}
