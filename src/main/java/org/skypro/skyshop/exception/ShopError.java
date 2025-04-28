package org.skypro.skyshop.exception;

 public class  ShopError {
    private String code;
    private String message;

    ShopError(){
        this.code = "404";
        this.message = "Такого продукта не существует";
    }

    public String getError() {
        return code+" "+message;
    }

}
