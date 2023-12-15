package com.example.pr222.Controller;
import com.example.pr222.dao.TeamDAO;
import com.example.pr222.models.Person;
import com.example.pr222.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/people/team")
public class TeamController { private final TeamDAO teamDAO;
    @Autowired
    public TeamController(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }
    @GetMapping()
    public String index2(Model model){ model.addAttribute("team", teamDAO.index()); return "people/team/index2"; }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){ model.addAttribute("team", teamDAO.show(id)); return "people/team/show"; }
    @GetMapping("/new")
    public String newTeam(@ModelAttribute("team") Team team){
        return "people/team/new";
    }

    @PostMapping()
    public String create( @ModelAttribute("team")  @Valid Team team,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/team/new";

        teamDAO.save(team);
        return "redirect:/people/team";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){ model.addAttribute("team", teamDAO.show(id)); return "people/team/edit"; }
    @PostMapping("/{id}")
    public String update(@ModelAttribute("team") @Valid Team team, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "people/team/edit";

        teamDAO.update(id, team);
        return "redirect:/people/team";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        teamDAO.delete(id);
        return "redirect:people/team";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Team> searchResults = teamDAO.findByName(name);
        model.addAttribute("searchResults", searchResults);
        return "people/team/search-results";
    }
}


