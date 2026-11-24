package product;

public abstract class Product{

    private String barcode;
    private String name;
    private int price;
    private int stock;

    public Product(String barcode, String name, int price, int stock){
        if(price<=0||stock<0){
            throw new IllegalArgumentException("잘못된 가격 또는 재고");
        }

        this.barcode=barcode;
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

    public String getBarcode(){
        return barcode;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public boolean hasStock(int quantity){
        return quantity < stock && quantity >0;
    }

    public void decreaseStock(int quantity){
        if(!hasStock(quantity)){
            throw new IllegalArgumentException("재고부족 또는 수량이 잘못됌");
        }
        else stock-=quantity;
    }

    public abstract boolean isDiscountable();
    public abstract boolean canSell(boolean adultConfirmed);

}