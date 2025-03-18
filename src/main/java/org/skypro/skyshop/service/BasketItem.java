package org.skypro.skyshop.service;

import org.skypro.skyshop.model.product.Product;

class BasketItem {
     Product product;
     int count;

     public BasketItem(Product product, int count){
          this.product = product;
          this.count = count;
     }

     public Product getProduct(){
          return product;
     }

     public int getCount(){
          return count;
     }
}
