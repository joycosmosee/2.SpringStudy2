package windwish.com.example.core.member;

public class _2Member {

    //변수 선언 : 아이디. 이름. 성적
    private Long id;
    private String name;
    private _1Grade Grade;

    //constructor
    public _2Member(Long id, String name, _1Grade Grade) {
        this.id = id;
        this.name = name;
        this.Grade = Grade;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public _1Grade getGrade() {
        return Grade;
    }

    public void setGrade(_1Grade Grade) {
        this.Grade = Grade;
    }
}
