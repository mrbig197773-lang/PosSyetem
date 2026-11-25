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
                if(items[i].hasStock(quantities[i]+1)==false){
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
            throw new IllegalArgumentException("재고가 없습니다.");
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
    //삭제하려는 상품과 동일한걸 일단찾음
    public void removeProduct(String barcode){
        for(int i=0;i<size;i++){
            if(items[i].getBarcode().equals(barcode)){
                //찾고나면 걔 뒤에있는걸 하나씩 앞으로 땡겨온다
                for(int j=i;j<size-1;j++){
                    items[j]=items[j+1];
                    quantities[j]=quantities[j+1];
                }
            //맨 끝칸 null로 바꿔주고, 양도 줄여준다.
            items[size-1]=null;
            quantities[size-1]=0;

            size--;

            return;

            }
        }
        throw new IllegalArgumentException("장바구니에 없는 상품입니다.");
    }
}

