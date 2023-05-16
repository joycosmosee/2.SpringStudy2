package windwish.com.example.core;

import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;
import windwish.com.example.core.member._5MemberService;
import windwish.com.example.core.member._6MemberServiceImpl;

//테스트 코드
//잘 실행 되는 지 간단 테스트 -> 한계 : 메인메소드로 하는 건 한계 -> test 코드로 재구성
public class _1MemberApp {
    public static void main(String[] args) {

        _5MemberService memberService = new _6MemberServiceImpl();

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
