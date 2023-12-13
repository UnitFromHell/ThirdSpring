package com.example.pr222.dao;

import com.example.pr222.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Test", "Testov", "Testovich"));
        people.add(new Person(++PEOPLE_COUNT, "Test2", "Testov2", "Testovich2"));
        people.add(new Person(++PEOPLE_COUNT, "Test3", "Testov3", "Testovich3"));
        people.add(new Person(++PEOPLE_COUNT, "Test4", "Testov4", "Testovich4"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setSurname(updatedPerson.getSurname());
        personToBeUpdated.setPatronic(updatedPerson.getPatronic());
    }
public void delete(int id){Person personToDelete = show(id);  if (personToDelete != null) { people.remove(personToDelete); }}
}
//    public void delete(int id){
//        people.removeIf(p -> p.getId() == id);
//
//    }