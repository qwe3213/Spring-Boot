package hi.hi_spring.controller;

import hi.hi_spring.domain.Member;
import hi.hi_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());

     //   System.out.println("member = " + member.getName());
     //   입력시 member = spring
        memberService.join(member);
        return "redirect:/";
    }
}
