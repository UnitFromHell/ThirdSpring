package com.example.pr222.models;

public class Animal {
    private int id;
    private String name;
    private int years;
    private String type;

    public Animal(){

    }
    public Animal(int id, String name, int years, String type) {
        this.id = id;
        this.name = name;
        this.years = years;
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
