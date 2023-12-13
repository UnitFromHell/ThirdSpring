package com.example.pr222.dao;


import com.example.pr222.models.Sweet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class SweetDAO {
    private static int SWEET_COUNT = 0;
    private List<Sweet> sweet;
    {
        sweet = new ArrayList<>();
        sweet.add(new Sweet(++SWEET_COUNT, "Test", 1, "Шоколодная"));
        sweet.add(new Sweet(++SWEET_COUNT, "Test2", 2, "Сосулька"));
        sweet.add(new Sweet(++SWEET_COUNT, "Test3",3, "Фруктовая"));
        sweet.add(new Sweet(++SWEET_COUNT, "Test4", 4, "Мармелад"));
    }
    public List<Sweet> index(){
        return sweet;
    }
    public Sweet show(int id){
        return sweet.stream().filter(_sweet -> _sweet.getId() == id).findAny().orElse(null);
    }
    public void save(Sweet _sweet){
        _sweet.setId(++SWEET_COUNT);
        sweet.add(_sweet);
    }
    public void update(int id, Sweet updatedSweet){
        Sweet sweetToBeUpdated = show(id);
        sweetToBeUpdated.setName(updatedSweet.getName());
        sweetToBeUpdated.setKolvo(updatedSweet.getKolvo());
        sweetToBeUpdated.setType(updatedSweet.getType());
    }
    public void delete(int id){ Sweet sweetToDelete = show(id); if (sweetToDelete != null) { sweet.remove(sweetToDelete); }}
}

