package hi.hi_spring.repository;

import hi.hi_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private  static long sequence = 0L;
    // 키값을 0,1,2 생성
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // null이 반횐되어도 클라이언트 쪽에서 해결 가능하게 Optional로 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        // member에서 membergetName이 파라메터에 넘어온 name과 같은지 확인하여 같은경우 반환됨
    }

    @Override
    public List<Member> findALl() {
        return new ArrayList<>(store.values());
        //맵의 값을 리스트에 넣어 반환
    }

    public void clearStore(){
        store.clear();
        // 한클래스에서 여러개를 테스트 할때 한 메서드가 테스트후 정보를 지우기위해 clearStore메서드 선언
    }
}
