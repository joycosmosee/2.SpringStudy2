package windwish.com.example.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import windwish.com.example.core._3AppConfig;

public class _1MemberTest {

    //memberService 인스턴스 만듦
    //_5MemberService memberService = new _6MemberServiceImpl();
    //아래 수정
    _5MemberService memberService;

    //@BeforeEach : 테스트 실행 전에 무조건 실행
    @BeforeEach
    public void beforeEach(){
        _3AppConfig appConfig = new _3AppConfig();
        //memberService를 위 memberService에 할당해줌
        memberService = appConfig.memberService();
    }

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
