package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {

    private final int costProduct;

    public SimpleProduct(String nameProduct, int costProduct, UUID id) {
        super(nameProduct,id);
        if (costProduct>0){
            this.costProduct = costProduct;
        }else {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0");
        }
    }

    @Override
    public int getCostProduct() {
        return this.costProduct;
    }

    @Override
    public boolean inSpecial(){
        return false;
    }

    @Override
    public String toString(){
        return  getNameProduct()+" :"+getCostProduct()+" руб";
    }


}
