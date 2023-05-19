//package windwish.com.example.core.xml;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import windwish.com.example.core.member._5MemberService;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class XmlAppContext {
//
//    @Test
//    void xmlAppContext() {
//        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
//
//        _5MemberService memberService = ac.getBean("memberService", _5MemberService.class);
//        assertThat(memberService).isInstanceOf(_5MemberService.class);
//    }
//}
