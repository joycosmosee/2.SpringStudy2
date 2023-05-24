package windwish.com.example.core.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import windwish.com.example.core.discount._2FixDiscountPolicy;
import windwish.com.example.core.member._1Grade;
import windwish.com.example.core.member._2Member;
import windwish.com.example.core.member._4MemoryMemberRepository;

import java.lang.reflect.Member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _3OrderServiceImplTest {

    @Test
    void createOrder() {
        _4MemoryMemberRepository memoryMemberRepository = new _4MemoryMemberRepository();
        memoryMemberRepository.save(new _2Member(1L, "name", _1Grade.VIP));

        _3OrderServiceImpl orderService = new _3OrderServiceImpl(new _4MemoryMemberRepository(), new _2FixDiscountPolicy());
        _1Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}