package com.example.MPR_LAB03.exceptions;

public class CatAlreadyExists extends RuntimeException{

    public CatAlreadyExists(){
        super("com.kotki.backend.Cat already exists ;p");
    }

}
