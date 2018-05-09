package com.pojo;

public class Pojo {

    public int id;
    public String name;
    public Pojo(){

    }

    public Pojo(int id , String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
