package ch.bfh.theforkers.heroes.healer.controller;


import ch.bfh.theforkers.heroes.entities.Hero;
import ch.bfh.theforkers.heroes.healer.service.HealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healer")
public class HealerController {


    @Autowired
    private HealerService healerService;

    @GetMapping(value = "/heal")
    public Hero heal(Hero hero) {
        return healerService.healHero(hero);
    }
}
