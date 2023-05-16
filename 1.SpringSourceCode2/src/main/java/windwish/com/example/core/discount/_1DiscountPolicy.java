package windwish.com.example.core.discount;

import windwish.com.example.core.member._2Member;

public interface _1DiscountPolicy {

    /**
     *
     * @return 할인 대상 금액을 리턴함
     */
    int discount(_2Member member, int price);
}
