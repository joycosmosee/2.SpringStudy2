package windwish.com.example.core.order;

import windwish.com.example.core.discount._1DiscountPolicy;
import windwish.com.example.core.discount._2FixDiscountPolicy;
import windwish.com.example.core.discount._3RateDiscountPolicy;
import windwish.com.example.core.member._2Member;
import windwish.com.example.core.member._3MemberRepository;
import windwish.com.example.core.member._4MemoryMemberRepository;

//구현체
public class _3OrderServiceimpl implements _2OrderService {

    //회원찾기
    private final _3MemberRepository memberRepository = new _4MemoryMemberRepository();
    //할인 정책 : OCP 위반
    //private final _1DiscountPolicy discountPolicy = new _2FixDiscountPolicy();
    //% 할인으로 변경 : OCP 위반
    //private final _1DiscountPolicy discountPolicy = new _3RateDiscountPolicy();
    //위 OCP 위반 변경 -> 대신 : null position 발생
    private _1DiscountPolicy discountPolicy;

    @Override
    public _1Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 정보 조회
        _2Member member = memberRepository.findById(memberId);
        //할인 얼마인지 모름 -> discountPolicy 결과만 던져줘
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //최종 생성된 금액 반환
        return new _1Order(memberId, itemName, itemPrice, discountPrice);
    }
}
