package discount;

import cart.Cart;
import product.Product;

public class PercentDiscount implements DiscountPolicy{

    @Override 
    public String getPolicyName(){
        return "10% 할인";
    }

    @Override 
    public int calculateDiscount(Cart cart){
        int discountableTotal=0;

        for(int i=0;i<cart.getSize();i++){
            Product product=cart.getProduct(i);

            if(product.isDiscountable()){
                discountableTotal += product.getPrice()*cart.getQuantity(i);
            }
        }
        return discountableTotal/10;
    }
}