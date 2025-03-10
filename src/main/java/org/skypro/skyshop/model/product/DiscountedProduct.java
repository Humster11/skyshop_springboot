package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product{
    private final int baseCost;
    private final int discountInWholePercentages;

    public  DiscountedProduct(String nameProduct, int baseCost, int discountInWholePercentages, UUID id){
        super(nameProduct, id);
        if (baseCost>0){
            this.baseCost = baseCost;
        }
        else {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0");
        }
        if (discountInWholePercentages>0 || discountInWholePercentages<=100){
            this.discountInWholePercentages = discountInWholePercentages;
        }
        else {
            throw new IllegalArgumentException("Скидка может быть от 0 до 100%");
        }
    }

    @Override
    public int getCostProduct() {
        int discountedPrice = 0;
        return discountedPrice = baseCost - baseCost/100*discountInWholePercentages;
    }

    @Override
    public boolean inSpecial(){
        return true;
    }

    @Override
    public String toString(){
        return  getNameProduct()+" :"+getCostProduct()+" руб (Скидка "+discountInWholePercentages+" %)";
    }
}
