package org.skypro.skyshop.exception;

 class ShopError {
    String code;
    String message;

    ShopError(){
        this.code = "404";
        this.message = "Такого продукта не существует";
    }

    public String getError() {
        return code+" "+message;
    }

    /*public String getMessage(){
        return message;
    }*/
}
