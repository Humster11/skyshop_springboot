package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> basketProduct = new HashMap<>();

    public void addBasket(UUID id){
        if (basketProduct.containsKey(id)){
            basketProduct.put(id,basketProduct.get(id)+1);
        }
        basketProduct.put(id,1);
    }

    public Map<UUID, Integer> listBasket(){
        Map<UUID, Integer> listProduct = Collections.unmodifiableMap(basketProduct);
        return listProduct;
    }
}
