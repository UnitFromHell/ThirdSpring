package com.example.pr222.Controller;


import com.example.pr222.dao.SweetDAO;
import com.example.pr222.dao.SweetDAO;
import com.example.pr222.models.Fish;
import com.example.pr222.models.Sweet;
import com.example.pr222.models.Sweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/people/sweet")

public class SweetController {  private final SweetDAO sweetDAO;
    @Autowired
    public SweetController(SweetDAO sweetDAO) {
        this.sweetDAO = sweetDAO;
    }
    @GetMapping()
    public String index2(Model model){ model.addAttribute("sweet", sweetDAO.index()); return "people/sweet/index2";}
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){ model.addAttribute("sweet", sweetDAO.show(id)); return "people/sweet/show"; }
    @GetMapping("/new")
    public String newSweet(@ModelAttribute("sweet") Sweet sweet){
        return "people/sweet/new";
    }
    @PostMapping()
    public String create( @ModelAttribute("sweet")  @Valid Sweet sweet,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/sweet/new";

        sweetDAO.save(sweet);
        return "redirect:/people/sweet";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){ model.addAttribute("sweet", sweetDAO.show(id)); return "people/sweet/edit"; }
    @PostMapping("/{id}")
    public String update(@ModelAttribute("sweet") @Valid Sweet sweet, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "people/sweet/edit";

        sweetDAO.update(id, sweet);
        return "redirect:/people/sweet";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        sweetDAO.delete(id);
        return "redirect:people/sweet";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Sweet> searchResults = sweetDAO.findByName(name);
        model.addAttribute("searchResults", searchResults);
        return "people/sweet/search-results";
    }
}

