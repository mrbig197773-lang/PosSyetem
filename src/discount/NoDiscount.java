package discount;
import cart.Cart;

public class NoDiscount implements DiscountPolicy{

    @Override 
    public String getPolicyName(){
        return "할인없음";
    }

    @Override 
    public int calculateDiscount(Cart cart){
        return 0;
    }
}