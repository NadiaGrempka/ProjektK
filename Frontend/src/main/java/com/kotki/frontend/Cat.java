package com.kotki.frontend;

public class Cat {
//    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    public String name;
    public  int age;

    public Cat(String name, int age) {
        this.name =name;
        this.age = age;
    }


    protected Cat(){}

    public String setName(String name){
        return this.name = name;
    }
    public String getName(){
        return name;
    }

    public int setAge(int age){
        return this.age = age;
    }
    public int getAge(){
        return age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
