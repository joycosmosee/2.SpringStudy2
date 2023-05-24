package windwish.com.example.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class _5HelloLombok {

    private String name;
    private int age;

    public static void main(String[] ages){
        _5HelloLombok helloLombok = new _5HelloLombok();
        helloLombok.setName("asdfas");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
