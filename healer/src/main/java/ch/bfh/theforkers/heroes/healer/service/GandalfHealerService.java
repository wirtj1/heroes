package ch.bfh.theforkers.heroes.healer.service;

import ch.bfh.theforkers.heroes.entities.HealingPotion;
import ch.bfh.theforkers.heroes.entities.Hero;
import ch.bfh.theforkers.heroes.entities.PotionShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GandalfHealerService implements HealerService {

    @Override
    public Hero healHero(Hero hero) {
        PotionShop potionshop = new PotionShop();
        potionshop.setName("Gandalfs Potion Shop");
        fillPotionShop((potionshop));
        List<HealingPotion> potions = potionshop.getPotions();
        for (HealingPotion potion : potions) {
            if(potion.getPrice() > hero.getGold()){
                continue;
            }
            hero.setHp(hero.getHp() + potion.getHealingAmount());
            hero.setGold(hero.getGold() - potion.getPrice());
        }
        return hero;
    }

    private void fillPotionShop(PotionShop potionShop){
        List<HealingPotion> potions = new ArrayList<HealingPotion>();
        HealingPotion superior = new HealingPotion();
        superior.setName("superior healing potion");
        superior.setPrice(1000);
        superior.setHealingAmount(25.5);
        HealingPotion common = new HealingPotion();
        common.setName("common healing potion");
        common.setPrice(50);
        common.setHealingAmount(6.5);
        HealingPotion rare = new HealingPotion();
        rare.setName("rare healing potion");
        rare.setPrice(200);
        rare.setHealingAmount(13.5);
        potionShop.setPotions(potions);
    }
}
