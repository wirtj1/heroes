package ch.bfh.theforkers.heroes.healer.controller;


import ch.bfh.theforkers.heroes.entities.Hero;
import ch.bfh.theforkers.heroes.healer.service.HealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/healer")
public class HealerController {


    @Autowired
    private HealerService healerService;


    @PostMapping(value = "/heal")
    public @ResponseBody Hero heal(@RequestBody Hero hero) {
        return healerService.healHero(hero);
    }

}
