package windwish.com.example.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import windwish.com.example.core._3AppConfig;
import windwish.com.example.core.member._5MemberService;
import windwish.com.example.core.member._6MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class _2ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(_3AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        _5MemberService memberService = ac.getBean("memberService", _5MemberService.class);

        //잘 나오는 지 확인
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(_6MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        _5MemberService memberService = ac.getBean(_5MemberService.class);
        assertThat(memberService).isInstanceOf(_6MemberServiceImpl.class);
    }

    //인터페이스가 아닌 구체로 조회 -> 별로 좋지 않음 -> 역할. 기능 구분하는 게 좋음(의존에 대하여)
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        _5MemberService memberService = ac.getBean("memberService", _6MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(_6MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        //ac.getBean("xxxx", _5MemberService.class);
        //예외가 터져야 성공
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", _5MemberService.class));
    }
}

