package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * Created by jeaha on 11/22/23
 */
public class FixDiscountPolicy implements DiscountPolicy {
    // 1000원 할인
    private int discountFixAmount = 1000;
    
    @Override
    public int discout(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else return 0;
    }
}
