package windwish.com.example.core;

import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;
import windwish.com.example.core.member._5MemberService;
import windwish.com.example.core.member._6MemberServiceImpl;
import windwish.com.example.core.order._1Order;
import windwish.com.example.core.order._2OrderService;
import windwish.com.example.core.order._3OrderServiceimpl;

public class _2OrderApp {

    public static void main(String[] args) {

        //_3AppConfig를 이용해서 MemberService 개발하기 위해
        _3AppConfig appConfig = new _3AppConfig();
        //appConfig의 memberService를 꺼내야 함
        _5MemberService memberService = appConfig.memberService();
        _2OrderService orderService = appConfig.orderService();
        //memberService
        //_5MemberService memberService = new _6MemberServiceImpl(null);
        //orderService
        //_2OrderService orderService = new _3OrderServiceimpl(null, null);

        //member 추가
        Long memberId = 1L;
        _2Member member = new _2Member(memberId, "memberA", _1Grade.VIP);
        //메모리 객체에 추가
        memberService.join(member);

        //order 생성
        _1Order order = orderService.createOrder(memberId, "itemA", 10000);

        //toString으로 출력됨
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
