package windwish.com.example.core.member;

public interface _5MemberService {

    //회원 가입
    void join(_2Member member);

    //회원 조회
    _2Member findMember(Long memberId);
}
