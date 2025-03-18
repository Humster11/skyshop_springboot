package org.skypro.skyshop.exception;

public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException(){
        super();
    }

    @Override
    public String getMessage(){
        ShopError shopError = new ShopError();
        return shopError.getError();
    }

}
