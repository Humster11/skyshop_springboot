package org.skypro.skyshop.service;


import java.util.ArrayList;
import java.util.List;

public class UserBasket {
    List<BasketItem> basketItem = new ArrayList<>();
    int total;

    UserBasket(List<BasketItem> basketItem) {
        this.basketItem = basketItem;
        this.total = basketItem.stream()
                .mapToInt(x->x.getProduct().getCostProduct()).sum();
    }

    public List<BasketItem> getBasketItem(){
        return basketItem;
    }
}
