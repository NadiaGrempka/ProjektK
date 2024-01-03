package com.example.MPR_LAB03.exceptions;

public class CatAgeIsNegativeException extends RuntimeException{
    public CatAgeIsNegativeException(){
        super("Age cannot be nagative >;[ ");
    }
}
