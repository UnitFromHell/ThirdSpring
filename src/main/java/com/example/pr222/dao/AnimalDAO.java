package com.example.pr222.dao;

import com.example.pr222.models.Animal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class AnimalDAO {
    private static int ANIMAL_COUNT = 0;
    private List<Animal> animal;
    {
        animal = new ArrayList<>();
        animal.add(new Animal(++ANIMAL_COUNT, "Test", 1, "Кошка"));
        animal.add(new Animal(++ANIMAL_COUNT, "Test2", 2, "Собака"));
        animal.add(new Animal(++ANIMAL_COUNT, "Test3",3, "Попугая"));
        animal.add(new Animal(++ANIMAL_COUNT, "Test4", 4, "Корова"));
    }
    public List<Animal> index(){
        return animal;
    }
    public Animal show(int id){
        return animal.stream().filter(_animal -> _animal.getId() == id).findAny().orElse(null);
    }
    public void save(Animal _animal){
        _animal.setId(++ANIMAL_COUNT);
        animal.add(_animal);}
    public void update(int id, Animal updatedAnimal){
        Animal animalToBeUpdated = show(id);
        animalToBeUpdated.setName(updatedAnimal.getName());
        animalToBeUpdated.setYears(updatedAnimal.getYears());
        animalToBeUpdated.setType(updatedAnimal.getType());
    }
    public void delete(int id){ Animal animalToDelete = show(id); if (animalToDelete != null) { animal.remove(animalToDelete);}}
}
