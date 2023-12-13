package com.example.pr222.dao;
import com.example.pr222.models.Fish;
import com.example.pr222.models.Fish;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class FishDAO {
    private static int FISH_COUNT = 0;
    private List<Fish> fish;
    {
        fish = new ArrayList<>();
        fish.add(new Fish(++FISH_COUNT, "Test", 1, "Окунь"));
        fish.add(new Fish(++FISH_COUNT, "Test2", 2, "Сёмга"));
        fish.add(new Fish(++FISH_COUNT, "Test3",3, "Плотвичка"));
        fish.add(new Fish(++FISH_COUNT, "Test4", 4, "Селедь"));
    }
    public List<Fish> index(){
        return fish;
    }
    public Fish show(int id){
        return fish.stream().filter(_fish -> _fish.getId() == id).findAny().orElse(null);
    }
    public void save(Fish _fish){
        _fish.setId(++FISH_COUNT);
        fish.add(_fish);
    }
    public void update(int id, Fish updatedFish){
        Fish fishToBeUpdated = show(id);
        fishToBeUpdated.setName(updatedFish.getName());
        fishToBeUpdated.setYears(updatedFish.getYears());
        fishToBeUpdated.setType(updatedFish.getType());
    }
    public void delete(int id){ Fish fishToDelete = show(id); if (fishToDelete != null) { fish.remove(fishToDelete); }}
}

