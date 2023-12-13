package com.example.pr222.Controller;


import com.example.pr222.dao.FishDAO;
import com.example.pr222.dao.FishDAO;
import com.example.pr222.models.Fish;
import com.example.pr222.models.Fish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/people/fish")
public class FishController { private final FishDAO fishDAO;
    @Autowired
    public FishController(FishDAO fishDAO) {
        this.fishDAO = fishDAO;
    }
    @GetMapping()
    public String index2(Model model){ model.addAttribute("fish", fishDAO.index()); return "/people/fish/index2";}
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){ model.addAttribute("fish", fishDAO.show(id)); return "/people/fish/show";}
    @GetMapping("new")
    public String newFish(@ModelAttribute("fish") Fish fish){
        return "people/fish/new";
    }
    @PostMapping
    public String create(@ModelAttribute("fish") Fish fish){ fishDAO.save(fish); return "redirect:/people/fish";}
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){ model.addAttribute("fish", fishDAO.show(id)); return "people/fish/edit";}
    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") Fish fish, @PathVariable("id") int id){ fishDAO.update(id, fish); return "redirect:/people/fish"; }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        fishDAO.delete(id);
        return "redirect:people/fish";
    }
}

