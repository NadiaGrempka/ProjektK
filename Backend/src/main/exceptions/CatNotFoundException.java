package com.example.MPR_LAB03.exceptions;

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException() {
        super("Cat not found :'<");
    }
}
