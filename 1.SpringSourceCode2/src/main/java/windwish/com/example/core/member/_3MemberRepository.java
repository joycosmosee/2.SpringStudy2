package windwish.com.example.core.member;

public interface _3MemberRepository {

    //회원 저장 기능 : member 변수 선언
    void save(_2Member member);

    //회원 찾는 기능 :memberId 변수 선언
    _2Member findById(Long memberId);
}
