package com.example.MPR_LAB03.exceptions;

public class CatAlreadyExists extends RuntimeException{

    public CatAlreadyExists(){
        super("Cat already exists ;p");
    }

}
