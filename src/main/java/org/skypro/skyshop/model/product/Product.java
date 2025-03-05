package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final String nameProduct;
    private final UUID id;

    public Product(String nameProduct, UUID id) {
        if (nameProduct.isBlank()) {
            throw new IllegalArgumentException("Не введено название продукта");
        } else {
            this.nameProduct = nameProduct;
        }
        this.id = id;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    public abstract int getCostProduct();

    public abstract boolean inSpecial();

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getNameProduct();
    }

    @JsonIgnore
    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String getNameSearchable() {
        return getNameProduct();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}
