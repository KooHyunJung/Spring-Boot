package spring.spring01.service;

import org.springframework.stereotype.Service;
import spring.spring01.domain.Member;
import spring.spring01.repository.MemberRepository;
import spring.spring01.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// 정말 편한 테스트만들기 단축키 command + sh + T
public class MemberService {
    private final MemberRepository memberRepository;
    // 외부에서 넣어주도록 변경
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public long join(Member member) {
        // 중복 회원 검증
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    // 단축기 사용 ^ + T
    // status method
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 이름입니다");
            });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 특정 회원 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
