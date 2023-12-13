package com.example.pr222.models;

public class Team {
    private int id;
    private String name;
    private String type;
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
