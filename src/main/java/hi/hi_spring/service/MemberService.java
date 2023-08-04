package hi.hi_spring.service;

import hi.hi_spring.domain.Member;
import hi.hi_spring.repository.MemberRepository;
import hi.hi_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// service 쪽은 비지니스쪽 용어 사용 편리
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
    * 회원 가입
    * */
    public Long join(Member member){
     // 같은 이름이 있는 중복 회원X

        validateDuplicateMember(member); // 중복 회원 검증하기
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
