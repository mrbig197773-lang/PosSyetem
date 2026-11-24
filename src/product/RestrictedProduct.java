package product;

public class RestrictedProduct extends Product{
   
    public RestrictedProduct(String barcode, String name, int price, int stock){
        super(barcode, name, price, stock);
    }

    @Override 
    public boolean isDiscountable(){
        return false;
    }

    @Override 
    public boolean canSell(boolean adultConfirmed){
        return adultConfirmed;
    }


}