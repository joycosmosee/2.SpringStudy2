package windwish.com.example.core.singleton;

public class _3StatefulService {

    //문제1 s ===============================================================================
    //가격 필드를 가지고 있음 // 주문해서 여기에 값 저장
//    private int price; //상태를 유지하는 필드
//
//    //주문할 때 가격 저장
//    public void order(String name, int price){
//        System.out.println("name = " + name + "price = " + price);
//        this.price = price; //여기가 문제!
//    }
    //문제1 e ===============================================================================

    //해결방법1 s ===============================================================================
    //가격 필드를 가지고 있음 // 주문해서 여기에 값 저장
    //private int price; //상태를 유지하는 필드

    //주문할 때 가격 저장
    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        //this.price = price; //여기가 문제!
        return price; //파라미터로 return price를 넘기기
    }
    //해결방법1 e ===============================================================================

    //값을 꺼냄
//    public int getPrice(){
//        return price;
//    }
}
