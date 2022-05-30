package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용 되어야 함")
    void vip_o() {
        // given
        Member vipMember = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(vipMember, 10012);

        // then
        assertThat(discount).isEqualTo(1001);

    }

    @Test
    @DisplayName("VIP가 아닐 경우 할인 미적용")
    void vip_x() {
        // given
        Member vipMember = new Member(1L, "memberBASIC", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(vipMember, 10000);

        // then
        assertThat(discount).isEqualTo(0);

    }
}