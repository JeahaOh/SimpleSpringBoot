package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * Created by jeaha on 11/24/23
 */
public class RateDiscountPolicy implements DiscountPolicy {
    
    private int discountPercent = 10;
    
    @Override
    public int discout(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else return 0;
    }
}
