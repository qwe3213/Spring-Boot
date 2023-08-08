package hi.hi_spring.controller;

import hi.hi_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController{

    private final MemberService memberService;
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }  setter주입
    // @Autowired privateMemberService memberService; 필드주입

    @Autowired // 연결시킬때 Autowired 사용 , 생성자 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
