package discount;
import cart.Cart;

public interface DiscountPolicy{
    String getPolicyName();
    int calculateDiscount(Cart cart);
}