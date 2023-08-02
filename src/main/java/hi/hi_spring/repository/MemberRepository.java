package hi.hi_spring.repository;

import hi.hi_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // null일경우 그래도 받는 것 보다는 Optional을 감싸서 받는 방법사용
    List<Member> findALl();


}
