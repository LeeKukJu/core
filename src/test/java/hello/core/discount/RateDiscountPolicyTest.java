package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.") // JUnit 5부터는 @DisplayName을 사용하여 테스트 이름을 표기할 수 있다.
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(1000); // Assertions.assertThat()은 static import를 사용하여 assertThat()만으로 사용할 수 있다.
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.") // JUnit 5부터는 @DisplayName을 사용하여 테스트 이름을 표기할 수 있다.
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        assertThat(discount).isEqualTo(0); // Assertions.assertThat()은 static import를 사용하여 assertThat()만으로 사용할 수 있다.
    }

}