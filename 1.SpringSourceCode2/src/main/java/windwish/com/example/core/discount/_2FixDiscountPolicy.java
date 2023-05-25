package windwish.com.example.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;

@Component
@Qualifier("fixDiscountPolicy")
public class _2FixDiscountPolicy implements _1DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인하겠다.

    @Override
    public int discount(_2Member member, int price) {
        //등급이 VIP일 경우
        //enum 타입은 ==임.
        if(member.getGrade() == _1Grade.VIP){
            //int a = price * discountFixAmount / 100;
            //System.out.println(a);
            return discountFixAmount;
        }else{
            return 0;
        }
    }

}
