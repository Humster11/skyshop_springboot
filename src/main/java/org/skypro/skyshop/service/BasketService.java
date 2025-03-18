package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProduct(UUID id) throws NoSuchProductException {
        Optional<Product> isPresent = storageService.getProductById(id);
        if (isPresent.isEmpty()) {
            throw new NoSuchProductException();
        } else {
            productBasket.addBasket(id);
        }
    }

    public UserBasket getUserBasket() {

        List<BasketItem> basketItems = productBasket.listBasket().entrySet().stream()
                .map(element -> {
                    Product product = storageService.getProductById(element.getKey()).orElseThrow();
                    return new BasketItem(product, element.getValue());
                })
                .collect(Collectors.toList());

        UserBasket userBasketList = new UserBasket(basketItems);

        return userBasketList;
    }

    public Map<UUID, Integer> getList(){
       return productBasket.listBasket();
    }

}
