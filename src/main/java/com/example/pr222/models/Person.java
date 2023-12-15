package com.example.pr222.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Длина имени минимум 2 символа и максимум 30 символов")
    private String name;

    @Min(value = 0, message = "Возраст должен быть не меньше 0")
    private int age;
    @NotEmpty(message = "Емейл не может быть пустым")
    @Size(min = 2, max = 30, message = "Длина типа минимум 2 символа и максимум 30 символов")
    private String email;

    public Person(){
    }
public Person(int id, String name,  String email, int age) {
    this.id = id;
    this.name = name;

    this.email = email;
    this.age = age;
}
//    public Person(int id, String name, String surname, String patronic, String email, int age) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.patronic = patronic;
//        this.email = email;
//        this.age = age;
//    }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//    public String getSurname() {
//        return surname;
//    }
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//    public String getPatronic() {
//        return patronic;
//    }
//    public void setPatronic(String patronic) {
//        this.patronic = patronic;
//    }
}
