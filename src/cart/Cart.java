package cart;

import product.Product;
import java.util.ArrayList;

public class Cart{
    private ArrayList<Product> items= new ArrayList<>();
    private ArrayList<Integer> quantities= new ArrayList<>();

    public void addProduct(Product product){

        if(product==null){
            throw new IllegalArgumentException("상품이 없습니다");
        }

        for(int i=0;i<items.size();i++){
            if(items.get(i).getBarcode().equals(product.getBarcode())){
                //재고확인
                if(!items.get(i).hasStock(quantities.get(i)+1)){
                    throw new IllegalArgumentException("재고가 부족합니다.");
                }

                //기존 상품 수량증가
                quantities.set(i,quantities.get(i)+1);

                return;
            }
        }

        if(!product.hasStock(1)){
            throw new IllegalArgumentException("재고가 없습니다.");
        }

        items.add(product);
        quantities.add(1);
    }

    public int getQuantity(String barcode){
        for(int i=0;i<items.size();i++){
            if(items.get(i).getBarcode().equals(barcode)){
                return quantities.get(i);
            }
        }
        return 0;
    }
    public void removeProduct(String barcode){
        for(int i=0;i<items.size();i++){
            if(items.get(i).getBarcode().equals(barcode)){
                items.remove(i);
                quantities.remove(i);

                return;
            }
        }
        throw new IllegalArgumentException("장바구니에 없는 상품입니다.");
    }

    //전체가격계산
    public int getSubtotal(){
        int total=0;

        for(int i=0;i<items.size();i++){
            total+=items.get(i).getPrice()*quantities.get(i);
        }
        return total;
    }

    public void clear(){
        items.clear();
        quantities.clear();
    }

    //장바구니가 비었는지 검사
    public boolean isEmpty(){
        return items.isEmpty(); //기본제공
    }


    //private으로 array를 선언해서 다른클래스에서는 접근X
    public int getSize(){
        return items.size();
    }

    public Product getProduct(int index){
        return items.get(index);
    }

    public int getQuantity(int index){
        return quantities.get(index);
    }
}