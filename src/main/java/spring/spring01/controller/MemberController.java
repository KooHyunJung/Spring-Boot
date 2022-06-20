package spring.spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.spring01.service.MemberService;

@Controller // 이게 있으면 처음에 컨테이너가 뜰때 MemberController 객체를 생성해서 컨테이너에 넣어두고 관리한다
public class MemberController {
    private final MemberService memberService;

    @Autowired // 이게 있으면 spring 컨테이너에서 memberService와 연결 시켜 준다
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
