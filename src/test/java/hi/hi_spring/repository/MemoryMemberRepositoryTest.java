package hi.hi_spring.repository;

import hi.hi_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    //한클래스에서 여러개를 테스트 할때 한 메서드가 테스트후 정보를 지우기위해 선언

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // Optional<Member> byId = repository.findById(member.getId());
        // System.out.println("result = " + (result == member)); 결과괎이 result == true로나옴
        assertEquals(member , result); // 결과값이 트루일때는 아무것도 나오지 않고 초록색 체크표시 아닐경우 에러나옴 대부분 이것을 씀

    }
        @Test
        public void findByName(){

            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);

            Member result = repository.findByName("spring1").get();
            assertEquals(result , member1);

        }

        @Test
        public void findAll(){

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findALl();

        assertEquals(result.size(),2);
        }


}
