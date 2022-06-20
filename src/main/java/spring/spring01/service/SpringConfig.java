package spring.spring01.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring01.domain.Member;
import spring.spring01.repository.MemberRepository;
import spring.spring01.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
// 자바 코드로 직접 스프링 빈 등록하기
// 이렇게 하면
// memberService, memberRepository 둘 다 등록하고 memberRepository 를 memberService 에 등록해 준다

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
