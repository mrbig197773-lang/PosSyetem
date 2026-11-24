package product;

public class GeneralProduct extends Product{

    public GeneralProduct(String barcode, String name, int price, int stock){
        super(barcode, name, price, stock);
    }

    @Override 
    public boolean isDiscountable(){
        return true;
    }

    @Override
    public boolean canSell(boolean adultConfirmed){
        return true;
    }


}