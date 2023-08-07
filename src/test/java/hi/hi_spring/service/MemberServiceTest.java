package hi.hi_spring.service;

import hi.hi_spring.domain.Member;
import hi.hi_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository ;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);

    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    //한클래스에서 여러개를 테스트 할때 한 메서드가 테스트후 정보를 지우기위해 선언
    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertEquals(member.getName(),findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {

        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");


        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
        //        try{
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
//        }
// try ~ catch 방법으로 예외처리하기
        // then

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}