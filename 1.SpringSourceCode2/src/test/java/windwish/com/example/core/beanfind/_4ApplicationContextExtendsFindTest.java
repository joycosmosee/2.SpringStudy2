package windwish.com.example.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import windwish.com.example.core.discount._1DiscountPolicy;
import windwish.com.example.core.discount._2FixDiscountPolicy;
import windwish.com.example.core.discount._3RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class _4ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(_1DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    void findBeanByParentTypeBeanName() {
        _1DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy",
                _1DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(_3RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType(){
        _3RateDiscountPolicy bean = ac.getBean(_3RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(_3RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        Map<String, _1DiscountPolicy> beansOfType = ac.getBeansOfType(_1DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value=" + beansOfType.get(key));
        }
    }

    //Object 타입으로 다 꺼냄
    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value=" +
                    beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig {
        @Bean
        public _1DiscountPolicy rateDiscountPolicy() {
            return new _3RateDiscountPolicy();
        }
        @Bean
        public _1DiscountPolicy fixDiscountPolicy() {
            return new _2FixDiscountPolicy();
        }
    }


}
