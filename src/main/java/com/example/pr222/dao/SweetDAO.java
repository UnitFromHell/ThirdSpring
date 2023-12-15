package com.example.pr222.dao;


import com.example.pr222.models.Sweet;
import com.example.pr222.models.Sweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class SweetDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SweetDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Sweet> index() {

        return jdbcTemplate.query("SELECT * FROM Sweet", new BeanPropertyRowMapper<>(Sweet.class));
    }
    public Sweet show(int id){
        return jdbcTemplate.query("SELECT * FROM Sweet WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Sweet.class))
                .stream().findAny().orElse(null);
    }
    public void save(Sweet sweet){
//
        jdbcTemplate.update("INSERT INTO Sweet(name, kolvo, type) VALUES(?, ?, ?)", sweet.getName(), sweet.getKolvo(), sweet.getType());
    }
    public void update(int id, Sweet updatedSweet){

        jdbcTemplate.update("UPDATE Sweet SET name=?, kolvo=?, type=? WHERE id=?", updatedSweet.getName(), updatedSweet.getKolvo(), updatedSweet.getType(), id);
    }
    public void delete(int id){

        jdbcTemplate.update("DELETE FROM Sweet WHERE id=?", id);
    }
    public List<Sweet> findByName(String name) {
        String sql = "SELECT * FROM Sweet WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Sweet.class));
    }
}

