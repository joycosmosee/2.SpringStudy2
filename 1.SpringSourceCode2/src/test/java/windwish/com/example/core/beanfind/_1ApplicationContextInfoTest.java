package windwish.com.example.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import windwish.com.example.core._3AppConfig;

public class _1ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(_3AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name" + beanDefinitionName + "object = " + bean);
        }
    }

    //내가 등록한 빈만 출력
    //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈 출력
    //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈 출력
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            //BeanDefinition : Bean 하나하나에 대한 애플리케이션 정보
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name" + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
