package windwish.com.example.core.member;

import java.util.HashMap;
import java.util.Map;

//interface의 구현체
//상속 : alt + enter : override
public class _4MemoryMemberRepository implements _3MemberRepository {

    //저장소 만들기 : 키 값, 데이터 값
    private static Map<Long, _2Member> store = new HashMap<>();

    @Override
    public void save(_2Member member) {
        //put해서 member 객체를 store Map에 저장
        store.put(member.getId(), member);
    }

    @Override
    public _2Member findById(Long memberId) {
        //get해서 id를 찾음
        return store.get(memberId);
    }
}
