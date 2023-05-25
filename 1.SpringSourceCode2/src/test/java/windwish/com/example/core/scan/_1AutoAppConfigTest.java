package windwish.com.example.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import windwish.com.example.core._4AutoAppConfig;
import windwish.com.example.core.member._3MemberRepository;
import windwish.com.example.core.member._5MemberService;
import windwish.com.example.core.order._3OrderServiceImpl;

public class _1AutoAppConfigTest {


    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(_4AutoAppConfig.class);

        _5MemberService memberService = ac.getBean(_5MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(_5MemberService.class);

        _3OrderServiceImpl bean = ac.getBean(_3OrderServiceImpl.class);
        _3MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }
}
