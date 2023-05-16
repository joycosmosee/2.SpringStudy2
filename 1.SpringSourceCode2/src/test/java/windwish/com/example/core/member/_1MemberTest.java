package windwish.com.example.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class _1MemberTest {

    //memberService 인스턴스 만듦
    _5MemberService memberService = new _6MemberServiceImpl();

    //테스트 코드
    @Test
    void join(){
        //given(주어짐) //when(되었을 때) //then(검증)

        //given
        //새로운 멤버 추가
        _2Member member = new _2Member(1L, "memberA", _1Grade.VIP);

        // when
        //회원 가입 member
        memberService.join(member);
        //회원 조회
        _2Member findMember = memberService.findMember(1L);

        // then : member와 findMember가 똑같냐
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
