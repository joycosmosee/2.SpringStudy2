package windwish.com.example.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import windwish.com.example.core.member._3MemberRepository;
import windwish.com.example.core.member._4MemoryMemberRepository;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class _3ApplicationContextSameBeanFindTest {

    //기본 셋팅
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(_3MemberRepository.class));
    }

    //오류가 발생하지 않게 bean이름 지정
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByName(){
        //memberRepository1 이처럼 bean 이름을 지정하면 오류가 발생하지 않음
        _3MemberRepository memberRepository = ac.getBean("memberRepository1", _3MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(_3MemberRepository.class);
    }

    //memberRepository1, memberRepository2 - 둘 다 꺼내고 싶을 때
    @Test
    @DisplayName("특정 타이을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, _3MemberRepository> beansOfType = ac.getBeansOfType(_3MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        //검증 : 갯수가 2개여야 함
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    //static : class 안의 class : scope을 여기 안에서만 사용하겠다.
    @Configuration
    static class SameBeanConfig{

        @Bean
        public _3MemberRepository memberRepository1(){
            return new _4MemoryMemberRepository();
        }

        @Bean
        public _3MemberRepository memberRepository2(){
            return new _4MemoryMemberRepository();
        }
    }
}
