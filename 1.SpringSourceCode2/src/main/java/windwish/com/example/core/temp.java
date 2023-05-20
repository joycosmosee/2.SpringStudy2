package windwish.com.example.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;
import windwish.com.example.core.member._5MemberService;
import windwish.com.example.core.member._6MemberServiceImpl;

//테스트 코드
//잘 실행 되는 지 간단 테스트 -> 한계 : 메인메소드로 하는 건 한계 -> test 코드로 재구성
public class _1MemberApp {
    public static void main(String[] args) {

        //_3AppConfig를 이용해서 MemberService 개발하기 위해
        //_3AppConfig appConfig = new _3AppConfig();
        //appConfig의 memberService를 꺼내야 함
        //_5MemberService memberService = appConfig.memberService();
        //_5MemberService memberService = new _6MemberServiceImpl();
        //아래 내용
        //스프링의 시작 : 항상 이걸 써줌 : _3AppConfig의 내용을 가져옴
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(_3AppConfig.class);
        //메서드 이름 : memberService를 찾아옴
        _5MemberService memberService = applicationContext.getBean("memberService", _5MemberService.class);

        //새로운 멤버 추가
        //1L : long타입이라 L붙임
        _2Member member = new _2Member(1L, "memberA", _1Grade.VIP);

        //회원 가입 member
        memberService.join(member);

        //찾는 member
        _2Member findMember = memberService.findMember(1L);

        //가입 member 찾은 memeber 비교
        System.out.println("new member = " + member.getName());
        System.out.println("find findMember = " + findMember.getName());
    }
}
