package windwish.com.example.core.beanfind.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import windwish.com.example.core._3AppConfig;
import windwish.com.example.core.member._3MemberRepository;
import windwish.com.example.core.member._6MemberServiceImpl;
import windwish.com.example.core.order._3OrderServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class _4ConfigurationSingletonTest {

        @Test
        void configurationTest() {

            ApplicationContext ac = new AnnotationConfigApplicationContext(_3AppConfig.class);

            _6MemberServiceImpl memberService = ac.getBean("memberService", _6MemberServiceImpl.class);
            _3OrderServiceImpl orderService = ac.getBean("orderService", _3OrderServiceImpl.class);
            _3MemberRepository memberRepository = ac.getBean("memberRepository", _3MemberRepository.class);

            _3MemberRepository memberRepository1 = memberService.getMemberRepository();
            _3MemberRepository memberRepository2 = memberService.getMemberRepository();

            //모두 같은 인스턴스를 참고하고 있다.
            System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
            System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
            System.out.println("memberRepository = " + memberRepository);
            //모두 같은 인스턴스를 참고하고 있다.

            assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
            assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
        }

        //임의의 다른 클래스가 바로 싱글톤이 되도록 보장함
        @Test
        void configurationDeep(){
            ApplicationContext ac = new AnnotationConfigApplicationContext(_3AppConfig.class);
            _3AppConfig bean = ac.getBean(_3AppConfig.class);
        }
}
