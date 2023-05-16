package windwish.com.example.core.order;

public interface _2OrderService {
    //id, itemName, Price -> 쵲종 _1Order을 반환
    _1Order createOrder(Long memberId, String itemName, int itemPrice);

}
