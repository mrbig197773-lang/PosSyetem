
import product.Product;
import product.GeneralProduct;
import product.RestrictedProduct;

public class Main {
    public static void main(String[] args) {

        Product cola = new GeneralProduct("101", "콜라", 2000, 20);
        Product cigarette = new RestrictedProduct("999", "담배", 4500, 10);

        System.out.println("=== 일반 상품 ===");
        System.out.println("상품명: " + cola.getName());
        System.out.println("할인 가능: " + cola.isDiscountable());
        System.out.println("성인 인증 없이 판매: " + cola.canSell(false));

        System.out.println();

        System.out.println("=== 제한 상품 ===");
        System.out.println("상품명: " + cigarette.getName());
        System.out.println("할인 가능: " + cigarette.isDiscountable());
        System.out.println("성인 인증 없이 판매: " + cigarette.canSell(false));
        System.out.println("성인 인증 후 판매: " + cigarette.canSell(true));
    }
}
