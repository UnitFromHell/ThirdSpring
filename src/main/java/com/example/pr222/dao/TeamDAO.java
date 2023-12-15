package com.example.pr222.dao;

import com.example.pr222.models.Person;
import com.example.pr222.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class TeamDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public TeamDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Team> index() {

        return jdbcTemplate.query("SELECT * FROM Team", new BeanPropertyRowMapper<>(Team.class));
    }
    public Team show(int id){
        return jdbcTemplate.query("SELECT * FROM Team WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Team.class))
                .stream().findAny().orElse(null);
    }
    public void save(Team team){
//
        jdbcTemplate.update("INSERT INTO Team(name, type, league) VALUES(?, ?, ?)", team.getName(), team.getType(), team.getLeague());
    }
    public void update(int id, Team updatedTeam){

        jdbcTemplate.update("UPDATE Team SET name=?, type=?, league=? WHERE id=?", updatedTeam.getName(), updatedTeam.getType(), updatedTeam.getLeague(), id);
    }
    public void delete(int id){

        jdbcTemplate.update("DELETE FROM Team WHERE id=?", id);
    }
    public List<Team> findByName(String name) {
        String sql = "SELECT * FROM Team WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Team.class));
    }
}



