package hello.core.order;

/**
 * Created by jeaha on 11/22/23
 */
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
