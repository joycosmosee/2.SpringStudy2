package windwish.com.example.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.lang.reflect.Member;
import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    //위에 TestBean으로 넣어주면 SpringBean으로 등록 됨
    static class TestBean{

        //false면 자동 주입할 대상이 없으면 호출이 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        //null로 호출 됨
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("setNoBean2 = " + noBean2);
        }
        //Optional.empty 호출
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("setNoBean3 = " + noBean3);
        }
    }
}
