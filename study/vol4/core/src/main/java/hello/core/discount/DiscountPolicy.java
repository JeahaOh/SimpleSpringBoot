package hello.core.discount;

import hello.core.member.Member;

/**
 * Created by jeaha on 11/22/23
 */
public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discout(Member member, int price);
}
