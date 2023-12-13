package com.example.pr222.models;

public class Person {
    private int id;
    private String name;
    private String surname;
    private String patronic;
    public Person(){
    }
    public Person(int id, String name, String surname, String patronic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronic = patronic;
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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPatronic() {
        return patronic;
    }
    public void setPatronic(String patronic) {
        this.patronic = patronic;
    }
}
