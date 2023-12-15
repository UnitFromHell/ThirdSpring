package com.example.pr222.dao;
import com.example.pr222.models.Fish;
import com.example.pr222.models.Fish;
import com.example.pr222.models.Fish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class FishDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public FishDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Fish> index() {

        return jdbcTemplate.query("SELECT * FROM Fish", new BeanPropertyRowMapper<>(Fish.class));
    }
    public Fish show(int id){
        return jdbcTemplate.query("SELECT * FROM Fish WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Fish.class))
                .stream().findAny().orElse(null);
    }
    public void save(Fish fish){
//
        jdbcTemplate.update("INSERT INTO Fish(name, years, type) VALUES(?, ?, ?)", fish.getName(), fish.getYears(), fish.getType());
    }
    public void update(int id, Fish updatedFish){

        jdbcTemplate.update("UPDATE Fish SET name=?, years=?, type=? WHERE id=?", updatedFish.getName(), updatedFish.getYears(), updatedFish.getType(), id);
    }
    public void delete(int id){

        jdbcTemplate.update("DELETE FROM Fish WHERE id=?", id);
    }
    public List<Fish> findByName(String name) {
        String sql = "SELECT * FROM Fish WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Fish.class));
    }
}

