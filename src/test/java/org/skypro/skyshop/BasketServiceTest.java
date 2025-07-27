package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.StorageService;


import java.util.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    private BasketService basketService;

    @InjectMocks
    private StorageService storageService;
    private ProductBasket productBasket;


    @Test
    public void AddNoExistsProduct() {

        boolean exceptionThrown = false;
        UUID id = UUID.randomUUID();

        try {
            basketService.addProduct(id);
        } catch (NoSuchProductException e) {
            exceptionThrown = true;
        }

        Assertions.assertTrue(exceptionThrown);
    }

    @Test
    public void AddExistsProduct() {
        Map<UUID, Product> productMap = storageService.getStorageProduct();
        Collection<UUID> collectionIdProducts = productMap.keySet();
        List listId = new ArrayList(collectionIdProducts);
        UUID id = (UUID) listId.get(1);
        basketService.addProduct(id);
        Assertions.assertTrue(productBasket.listBasket().containsValue(id));
    }

    @Test
    public void EmptyGetUserBasketIfProductBasketNull(){
        productBasket.getBasketProduct();
        Assertions.assertNull(basketService.getUserBasket());

    }

    @Test
    public void SuitableBasketIfProductBasketFull(){
        Map<UUID, Product> productMap = storageService.getStorageProduct();
        Collection<UUID> collectionIdProducts = productMap.keySet();
        List listId = new ArrayList(collectionIdProducts);
        UUID id = (UUID) listId.get(1);
        basketService.addProduct(id);
        productBasket.getBasketProduct();
        Assertions.assertNull(basketService.getUserBasket());
    }


}
