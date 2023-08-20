package hi.hi_spring.service;

import hi.hi_spring.domain.Member;
import hi.hi_spring.repository.MemberRepository;
import hi.hi_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// service 쪽은 비지니스쪽 용어 사용 편리

@Transactional
public class MemberService {
// command + shift + t  테스트 겉보기 자동완성
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
// 외부에서 넣도록 설정
    /*
    * 회원 가입
    * */
    public Long join(Member member){
          // 같은 이름이 있는 중복 회원X
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
        // control + t -> Extract Method
    }

    /*
    * 전체 회원 조회
    * */

    public List<Member> findMembers() {
            return memberRepository.findALl();
    }

    public Optional<Member> findOne(Long memberId){

        return memberRepository.findById(memberId);
    }
}
