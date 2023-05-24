package windwish.com.example.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import windwish.com.example.core.discount._1DiscountPolicy;
import windwish.com.example.core.discount._2FixDiscountPolicy;
import windwish.com.example.core.discount._3RateDiscountPolicy;
import windwish.com.example.core.member._2Member;
import windwish.com.example.core.member._3MemberRepository;
import windwish.com.example.core.member._4MemoryMemberRepository;

@Component
//구현체
public class _3OrderServiceImpl implements _2OrderService {

    //final은 값을 다 채워야 함 -> 수정자는 final을 빼야함
    //회원찾기
    //private final _3MemberRepository memberRepository = new _4MemoryMemberRepository();
    //단일화 원칙에 의해
    //private final _3MemberRepository memberRepository;
    private _3MemberRepository memberRepository;
    //할인 정책 : OCP 위반
    //private final _1DiscountPolicy discountPolicy = new _2FixDiscountPolicy();
    //% 할인으로 변경 : OCP 위반
    //private final _1DiscountPolicy discountPolicy = new _3RateDiscountPolicy();
    //위 OCP 위반 변경 -> 대신 : null position 발생
    //private _1DiscountPolicy discountPolicy;
    //단일화 원칙에 의해
    //private final _1DiscountPolicy discountPolicy;
    private _1DiscountPolicy discountPolicy;

    //생성자 만들기(생성자를 통해 값이 넘어가서 할당 됨)
    //생성자 통해 1번 호출
    @Autowired
    public _3OrderServiceImpl(_3MemberRepository memberRepository, _1DiscountPolicy discountPolicy) {
        //System.out.println("memberRepository = " + memberRepository);
        //System.out.println("discountPolicy = " + discountPolicy);
        //System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //수정자 주입
//    @Autowired
//    public void setMemberRepository(_3MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }

    //수정자 주입
//    @Autowired
//    public void setDiscountPolicy(_1DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    //일반 메서드 주입
//    @Autowired
//    public void init(_3MemberRepository memberRepository, _1DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    @Override
    public _1Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 정보 조회
        _2Member member = memberRepository.findById(memberId);
        //할인 얼마인지 모름 -> discountPolicy 결과만 던져줘
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //최종 생성된 금액 반환
        return new _1Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 코드
    public _3MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
