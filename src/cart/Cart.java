package cart;

import product.Product;

public class Cart{

    private Product[] items=new Product[30];
    private int[] quantities=new int[30];
    private int size=0;

    //장바구니에 상품 추가하는 함수
    public void addProduct(Product product){
        if(product==null){
            throw new IllegalArgumentException("상품이 없습니다.");
        }

        //이미 장바구니에 있는 상품인지 검색
        for(int i=0;i<size;i++){

            if(items[i].getBarcode().equals(product.getBarcode())){
                if(!items[i].hasStock(quantities[i]+1)){
                throw new IllegalArgumentException("재고가 부족합니다.");
            }

            quantities[i]++;
            return;
            }
        }

        //처음 담는 상품인경우

        if(size>= items.length){
            throw new IllegalArgumentException("장바구니가 가득 찼습니다.");
        }

        if(!product.hasStock(1)){
            throw new IllegalAccessException("재고가 없습니다.");
        }

        items[size]=product;
        quantities[size]=1;
        size++;
    }

    //바코드로 장바구니 수량확인
    public int getQuantity(String barcode){
        for(int i=0;i<size;i++){
            if(items[i].getBarcode().equals(barcode)){
                return quantities[i];
            }
        }
        return 0;
    }
}