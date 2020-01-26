package ch.bfh.theforkers.heroes.potionshop.controller;
import ch.bfh.theforkers.heroes.entities.PotionShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ch.bfh.theforkers.heroes.potionshop.service.PotionShopService;

@RestController
@RequestMapping("/potionshop")
public class PotionShopController {

        @Autowired
        private PotionShopService potionShopService;

        @GetMapping(value = "/createParty")
        public PotionShop createParty(@RequestParam String name) {
            PotionShop potionShop = potionShopService.createPotionShop(name);
            return potionShop;
        }
}
