
import product.Product;
import product.GeneralProduct;
import cart.Cart;

public class Main {
    public static void main(String[] args) {

        Product cola = new GeneralProduct("101", "콜라", 2000, 20);
        Product snack = new GeneralProduct("102", "과자", 1500, 10);
        Product milk = new GeneralProduct("103", "우유", 1800, 15);

        Cart cart = new Cart();

        cart.addProduct(cola);
        cart.addProduct(snack);
        cart.addProduct(milk);

        System.out.println("=== 삭제 전 ===");
        System.out.println("콜라: " + cart.getQuantity("101"));
        System.out.println("과자: " + cart.getQuantity("102"));
        System.out.println("우유: " + cart.getQuantity("103"));

        cart.removeProduct("102");

        System.out.println("=== 삭제 후 ===");
        System.out.println("콜라: " + cart.getQuantity("101"));
        System.out.println("과자: " + cart.getQuantity("102"));
        System.out.println("우유: " + cart.getQuantity("103"));
    }
}
