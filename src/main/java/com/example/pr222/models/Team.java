package com.example.pr222.models;
import javax.persistence.*;

import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Название команды не может быть пустым")
    @Size(min = 2, max = 30, message = "Длина названия минимум 2 символа и максимум 30 символов")
    private String name;
    @NotEmpty(message = "Тип команды не может быть пустым")
    @Size(min = 2, max = 30, message = "Длина типа минимум 2 символа и максимум 30 символов")
    private String type;
    @NotEmpty(message = "Название лиги не может быть пустым")
    @Size(min = 2, max = 30, message = "Длина лиги минимум 2 символа и максимум 30 символов")
    private String league;

    public Team(){
    }
    public Team(int id, String name, String type, String league) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.league = league;
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getLeague() {
        return league;
    }
    public void setLeague(String league) {
        this.league = league;
    }
}
