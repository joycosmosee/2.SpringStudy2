package windwish.com.example.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class _3StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        _3StatefulService statefulService1 = ac.getBean(_3StatefulService.class);
        _3StatefulService statefulService2 = ac.getBean(_3StatefulService.class);

        //문제1 s ===============================================================================
//        //ThreadA : A 사용자가 10000원을 주문
//        statefulService1.order("userA", 10000);
//
//        //ThreadB : B 사용자가 20000원을 주문
//        statefulService2.order("userB", 20000);
//
//        //ThreadA : 사용자A 주문 금액 조회 -> 문제 : 같은 인스턴스를 쓰기 때문에 statefulService1는 statefulService2로 나옴
//        int price = statefulService1.getPrice();
//        System.out.println("price = "+ price);
//
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        //문제1 e ===============================================================================

        //해결방법1 s ===============================================================================
        //ThreadA : A 사용자가 10000원을 주문
        //지역 변수 이기에 A, B의 값이 다름
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB : B 사용자가 20000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회 -> 문제 : 같은 인스턴스를 쓰기 때문에 statefulService1는 statefulService2로 나옴
        //int price = statefulService1.getPrice();
        System.out.println("price = "+ userAPrice);

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        //해결방법1 e ===============================================================================
    }


    static class TestConfig{

        @Bean
        public _3StatefulService stataefulService(){
            return new _3StatefulService();
        }
    }
}