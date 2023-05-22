package windwish.com.example.core.singleton;

//싱글톤
public class _2SingletonService {

    //자기 자신을 static으로 하나 선언 : 자기 자신 객체 생성 -> instance에 넣어 놓음
    private static final _2SingletonService instance = new _2SingletonService();

    //조회하기
    public static _2SingletonService getInstance(){
        return instance;
    }

    //싱글톤을 다른 사람이 생성자를 만들지 못하게 private으로 막아 놓음
    private _2SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
