package windwish.com.example.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class _1RateDiscountPolicyTest {

    //_3RateDiscountPolicy가 정말 10% 할인 되는가?
    _3RateDiscountPolicy discountPolicy = new _3RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given : 멤버 생성
        _2Member member = new _2Member(1L, "memberVIP", _1Grade.VIP);

        //when : 멤버를 넘기고 1000을 넘김
        int discount = discountPolicy.discount(member, 10000);

        //then : 할인된 금액은 1000이어야 함
        //Assertions.assertThat(discount).isEqualTo(1000);
        //static method 사용 : art + enter : add on the mend~~
        assertThat(discount).isEqualTo(1000);
    }

    //BASIC : 할인이 되면 안 됨
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        _2Member member = new _2Member(2L, "memberBasic", _1Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }

}