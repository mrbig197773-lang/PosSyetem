package cart;

import product.Product;
import java.util.ArrayList;

public class Cart{
    private ArrayList<Product> items= new ArrayList<>();
    private ArrayList<Integer> quantities= new ArrayList<>();

    public void addProduct(Product Product){

        if(Product==null){
            throw new IllegalArgumentException("상품이 없습니다");
        }
    }



}