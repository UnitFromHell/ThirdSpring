package com.example.pr222.models;

public class Sweet {
    private int id;
    private String name;
    private int kolvo;
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
