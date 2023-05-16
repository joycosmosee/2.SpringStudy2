package windwish.com.example.core.member;

//_5MemberService의 구현체
public class _6MemberServiceImpl implements _5MemberService {

    //인터페이스 = new 클래스
    private final _4MemoryMemberRepository memberRepository = new _4MemoryMemberRepository();

    //회원 가입
    @Override
    public void join(_2Member member) {
        //다형성에 의해 _4MemoryMemberRepository의 내용 호출
        memberRepository.save(member);
    }

    //회원 조회
    @Override
    public _2Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
