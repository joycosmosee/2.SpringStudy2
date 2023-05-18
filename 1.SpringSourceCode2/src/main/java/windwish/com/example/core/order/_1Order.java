package windwish.com.example.core.order;

public class _1Order {

    private Long memberId;
    private String itemName;
    //아이템 가격
    private int itemPrice;
    //할인 금액
    private int discountPrice;

    //constructor - 객체를 생성할 때 호출되는 특별한 메소드. 객체 초기화 담당
    public _1Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    //getter and setter
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    //최종 계산된 결과 : 최종 금액
    public int calculatePrice(){
        return itemPrice - discountPrice;
    }

    //객체를 출력하면 toString이 나옴
    //alt + insert : toString
    @Override
    public String toString() {
        return "_1Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
