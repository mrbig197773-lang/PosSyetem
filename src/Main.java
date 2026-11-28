
import product.Product;
import product.GeneralProduct;
import product.RestrictedProduct;
import cart.Cart;
import discount.DiscountPolicy;
import discount.NoDiscount;
import discount.PercentDiscount;

public class Main {
    public static void main(String[] args) {

        // 상품 데이터 생성
        Product cola = new GeneralProduct("101", "콜라", 2000, 20, true);
        Product snack = new GeneralProduct("102", "과자", 1500, 10, false);
        Product milk = new GeneralProduct("103", "우유", 1800, 15, true);
        Product beer = new RestrictedProduct("104", "맥주", 3000, 10);

        Cart cart = new Cart();

        // 장바구니에 상품 추가
        cart.addProduct(cola);
        cart.addProduct(cola);
        cart.addProduct(cola);

        cart.addProduct(snack);
        cart.addProduct(snack);

        cart.addProduct(milk);

        cart.addProduct(beer);
        cart.addProduct(beer);

        // 상품별 할인 가능 여부 확인
        System.out.println("=== 상품별 할인 가능 여부 ===");

        for (int i = 0; i < cart.getSize(); i++) {
            Product product = cart.getProduct(i);

            System.out.println(product.getName()
                    + " / 수량: " + cart.getQuantity(i)
                    + " / 할인 가능: " + product.isDiscountable());
        }

        int subtotal = cart.getSubtotal();

        System.out.println("\n=== 할인 미적용 ===");

        DiscountPolicy policy = new NoDiscount();
        int discount = policy.calculateDiscount(cart);

        System.out.println("총금액: " + subtotal);
        System.out.println("할인금액: " + discount);
        System.out.println("결제금액: " + (subtotal - discount));

        System.out.println("\n=== 10% 할인 적용 ===");

        policy = new PercentDiscount();
        discount = policy.calculateDiscount(cart);

        System.out.println("총금액: " + subtotal);
        System.out.println("할인금액: " + discount);
        System.out.println("결제금액: " + (subtotal - discount));
    }
}
