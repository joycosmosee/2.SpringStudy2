package windwish.com.example.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import windwish.com.example.core._3AppConfig;
import windwish.com.example.core.member._5MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class _1SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        //AppConfig 인스턴스 생성
        _3AppConfig appConfig = new _3AppConfig();

        //1. 조회1: 호출할 때 마다 객체를 생성
        _5MemberService memberService1 = appConfig.memberService();

        //2. 조회2: 호출할 때 마다 객체를 생성
        _5MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1과 memberService2 다르다.
        assertThat(memberService1).isNotSameAs(memberService2);
    }
}
