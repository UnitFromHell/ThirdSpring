package com.example.pr222.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Sweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Название конфеты не может быть пустым")
    @Size(min = 2, max = 30, message = "Длина названия минимум 2 символа и максимум 30 символов")
    private String name;
    @Min(value = 0, message = "Количество должен быть не меньше 0")
    private int kolvo;
    @NotEmpty(message = "Тип не может быть пустым")
    private String type;

    public Sweet(){
    }
    public Sweet(int id, String name, int kolvo, String type) {
        this.id = id;
        this.name = name;
        this.kolvo = kolvo;
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
    public int getKolvo() {
        return kolvo;
    }
    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
