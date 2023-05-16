package windwish.com.example.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;
import windwish.com.example.core.member._5MemberService;
import windwish.com.example.core.member._6MemberServiceImpl;

public class _1OrderServiceTest {

    _5MemberService memberService = new _6MemberServiceImpl();
    _2OrderService orderService = new _3OrderServiceimpl();

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
