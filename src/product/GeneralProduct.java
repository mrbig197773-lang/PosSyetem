package product;

public class GeneralProduct extends Product{

    private boolean discountable;

    public GeneralProduct(String barcode, String name, int price, int stock,boolean discountable){
        super(barcode, name, price, stock);

        this.discountable=discountable;
    }

    @Override 
    public boolean isDiscountable(){
        return discountable;
    }

    @Override
    public boolean canSell(boolean adultConfirmed){
        return true;
    }


}