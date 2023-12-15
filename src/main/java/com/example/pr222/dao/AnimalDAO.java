package com.example.pr222.dao;

import com.example.pr222.models.Animal;
import com.example.pr222.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class AnimalDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public AnimalDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Animal> index() {

        return jdbcTemplate.query("SELECT * FROM Animal", new BeanPropertyRowMapper<>(Animal.class));
    }
    public Animal show(int id){
        return jdbcTemplate.query("SELECT * FROM Animal WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Animal.class))
                .stream().findAny().orElse(null);
    }
    public void save(Animal Animal){
//
        jdbcTemplate.update("INSERT INTO Animal(name, years, type) VALUES(?, ?, ?)", Animal.getName(), Animal.getYears(), Animal.getType());
    }
    public void update(int id, Animal updatedAnimal){

        jdbcTemplate.update("UPDATE Animal SET name=?, years=?, type=? WHERE id=?", updatedAnimal.getName(), updatedAnimal.getYears(), updatedAnimal.getType(), id);
    }
    public void delete(int id){

        jdbcTemplate.update("DELETE FROM Animal WHERE id=?", id);
    }
    public List<Animal> findByName(String name) {
        String sql = "SELECT * FROM Animal WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Animal.class));
    }
}

