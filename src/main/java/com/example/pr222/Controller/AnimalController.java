package com.example.pr222.Controller;


import com.example.pr222.dao.AnimalDAO;
import com.example.pr222.models.Animal;
import com.example.pr222.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/people/animal")
public class AnimalController { private final AnimalDAO animalDAO;
    @Autowired
    public AnimalController(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }
    @GetMapping()
    public String index2(Model model){ model.addAttribute("animal", animalDAO.index()); return "/people/animal/index2"; }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){ model.addAttribute("animal", animalDAO.show(id)); return "/people/animal/show";}
    @GetMapping("new")
    public String newAnimal(@ModelAttribute("animal") Animal animal){
        return "people/animal/new";
    }
    @PostMapping()
    public String create( @ModelAttribute("fish")  @Valid Animal animal,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/animal/new";

        animalDAO.save(animal);
        return "redirect:/people/animal";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){ model.addAttribute("animal", animalDAO.show(id)); return "people/animal/edit";}
    @PostMapping("/{id}")
    public String update(@ModelAttribute("animal") @Valid Animal animal, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "people/animal/edit";

        animalDAO.update(id, animal);
        return "redirect:/people/animal";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        animalDAO.delete(id);
        return "redirect:people/animal";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Animal> searchResults = animalDAO.findByName(name);
        model.addAttribute("searchResults", searchResults);
        return "people/animal/search-results";
    }
}
