package com.example.pr222.dao;

import com.example.pr222.models.Team;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class TeamDAO {
    private static int TEAM_COUNT = 0;
    private List<Team> team;
    {
        team = new ArrayList<>();
        team.add(new Team(++TEAM_COUNT, "Барселона", "футбольная", "Ла лига 1"));
        team.add(new Team(++TEAM_COUNT, "Бавария", "футбольная", "БундесЛига 1"));
        team.add(new Team(++TEAM_COUNT, "Арсенал","футбольная", "Английская Премьер-лига"));
        team.add(new Team(++TEAM_COUNT, "ПСЖ", "футбольная", "Лига 1"));
    }
    public List<Team> index(){
        return team;
    }
    public Team show(int id){
        return team.stream().filter(_team -> _team.getId() == id).findAny().orElse(null);
    }
    public void save(Team _team){
        _team.setId(++TEAM_COUNT);
        team.add(_team);
    }
    public void update(int id, Team updatedTeam){
        Team teamToBeUpdated = show(id);
        teamToBeUpdated.setName(updatedTeam.getName());
        teamToBeUpdated.setType(updatedTeam.getType());
        teamToBeUpdated.setLeague(updatedTeam.getLeague());
    }
    public void delete(int id){ Team teamToDelete = show(id); if (teamToDelete != null) { team.remove(teamToDelete); }}
}


