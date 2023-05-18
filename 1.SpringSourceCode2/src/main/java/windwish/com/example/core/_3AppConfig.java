package windwish.com.example.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import windwish.com.example.core.discount._1DiscountPolicy;
import windwish.com.example.core.discount._2FixDiscountPolicy;
import windwish.com.example.core.discount._3RateDiscountPolicy;
import windwish.com.example.core.member._4MemoryMemberRepository;
import windwish.com.example.core.member._5MemberService;
import windwish.com.example.core.member._6MemberServiceImpl;
import windwish.com.example.core.order._2OrderService;
import windwish.com.example.core.order._3OrderServiceimpl;

//스프링 설정 정보 : @Configuration
@Configuration
public class _3AppConfig {

    //메서드와 return 타입을 보면 역할이 보임

    //memberService를 여기서 만듦
    //_6MemberServiceImpl(생성자를 만듦)의 구현체를 이곳에서 만듦

    //@Bean : 스프링 컨테이너에 등록됨
    //memberserice 역할
    @Bean
   public _5MemberService memberService(){
        //나는 _6MemberServiceImpl인데, _4MemoryMemberRepository를 쓸 거야
        return new _6MemberServiceImpl(memberRepository());
    }

    //memberRepository 역할
    @Bean
    public _4MemoryMemberRepository memberRepository() {
        return new _4MemoryMemberRepository();
    }

    //OrderService 역할
    //_3OrderServiceimple
    @Bean
    public _2OrderService orderService(){
        return new _3OrderServiceimpl(memberRepository(), discountPolicy());
    }

    //DiscountPolicy 역할
    @Bean
    public _1DiscountPolicy discountPolicy(){
        //할인 정책 : _2FixDiscountPolicy 이걸 쓸 거야
        //return new _2FixDiscountPolicy();
        return new _3RateDiscountPolicy();
    }
}
