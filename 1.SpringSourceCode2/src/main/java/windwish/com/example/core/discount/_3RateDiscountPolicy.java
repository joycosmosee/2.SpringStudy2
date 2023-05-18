package windwish.com.example.core.discount;

import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;

public class _3RateDiscountPolicy implements _1DiscountPolicy{

    //discountpercent를 10%로만 하겠음
    private int discountPercent = 10;

    @Override
    public int discount(_2Member member, int price) {
        //등급이 VIP면
        if(member.getGrade() == _1Grade.VIP){
            //10% 할인
            return price * discountPercent / 100;
        } else {
            int a = price * discountPercent / 100;
            System.out.println(a);
            return 0;
        }
    }
}
