package org.skypro.skyshop.service;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> storageProduct = new HashMap<>();
    private final Map<UUID, Article> storageArticla = new HashMap<>();

    public StorageService(){
        fillingStorage();
    }

    private void fillingStorage(){
        SimpleProduct firstProduct = new SimpleProduct("чай", 100,UUID.randomUUID());
        FixPriceProduct secondProduct = new FixPriceProduct("банан",UUID.randomUUID());
        DiscountedProduct thirdProduct = new DiscountedProduct("Огурец", 150, 5, UUID.randomUUID());
        DiscountedProduct lastProduct = new DiscountedProduct("помидор", 150, 5, UUID.randomUUID());

        storageProduct.put(UUID.randomUUID(),firstProduct);
        storageProduct.put(UUID.randomUUID(),secondProduct);
        storageProduct.put(UUID.randomUUID(),thirdProduct);
        storageProduct.put(UUID.randomUUID(),lastProduct);

        Article firstArticle = new Article("Свойства чая", "Чаи бывают разные. Чай имеет много положительных свойств для организма",UUID.randomUUID());
        Article secondArticle = new Article("Хлеб", "Хлеб имеет множество рецептов таких как...",UUID.randomUUID());
        Article thirdArticle = new Article("Огурец", "Огурец является овощем",UUID.randomUUID());
        Article fourthArticle = new Article("Огурцы", "Огурец является овощем и очень полезен",UUID.randomUUID());

        storageArticla.put(UUID.randomUUID(),firstArticle);
        storageArticla.put(UUID.randomUUID(),secondArticle);
        storageArticla.put(UUID.randomUUID(),thirdArticle);
        storageArticla.put(UUID.randomUUID(),fourthArticle);

    }

    public Collection<Product> getProduct(){
        return storageProduct.values();
    }

    public Collection<Article> getArticle(){
        return storageArticla.values();
    }

    public Collection<Searchable> getAllSearchObject(){

        Set<Searchable> searchableArray = new HashSet<>();

        Iterator<Map.Entry<UUID, Product>> iteratorProduct = storageProduct.entrySet().iterator();
        while (iteratorProduct.hasNext()) {
            Map.Entry<UUID, Product> entry = iteratorProduct.next();
            Product value = entry.getValue();
            searchableArray.add(value);
        }

        Iterator<Map.Entry<UUID, Article>> iteratorArticle = storageArticla.entrySet().iterator();
        while (iteratorArticle.hasNext()) {
            Map.Entry<UUID, Article> entry = iteratorArticle.next();
            Article value = entry.getValue();
            searchableArray.add(value);
        }

        return searchableArray;
    }

}
