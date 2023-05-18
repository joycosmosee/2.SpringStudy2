package windwish.com.example.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import windwish.com.example.core._3AppConfig;
import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;
import windwish.com.example.core.member._5MemberService;
import windwish.com.example.core.member._6MemberServiceImpl;

public class _1OrderServiceTest {

    //_5MemberService memberService = new _6MemberServiceImpl();
    //_2OrderService orderService = new _3OrderServiceimpl();
    //아래 수정
    _5MemberService memberService;
    _2OrderService orderService;

    //@BeforeEach : 테스트 실행 전에 무조건 실행
    @BeforeEach
    public void beforeEach(){
        _3AppConfig appConfig = new _3AppConfig();
        //memberService를 위 memberService에 할당해줌
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        //given(주어짐) //when(되었을 때) //then(검증)

        //given
        Long memberId = 1L;
        _2Member member = new _2Member(memberId, "memberA", _1Grade.VIP);
        memberService.join(member);

        // when
        _1Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
