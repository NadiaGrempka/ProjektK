package com.example.MPR_LAB03.exceptions;

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException() {
        super("com.kotki.backend.Cat not found :'<");
    }
}
