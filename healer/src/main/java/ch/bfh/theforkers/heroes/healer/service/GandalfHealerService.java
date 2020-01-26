package ch.bfh.theforkers.heroes.healer.service;

import ch.bfh.theforkers.heroes.entities.HealingPotion;
import ch.bfh.theforkers.heroes.entities.Hero;
import ch.bfh.theforkers.heroes.entities.PotionShop;
import ch.bfh.theforkers.heroes.healer.client.PotionShopClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GandalfHealerService implements HealerService {

    @Autowired
    private PotionShopClient potionShopClient;

    @Override
    public Hero healHero(Hero hero) {
        PotionShop potionshop = potionShopClient.createPotionShop("Gandals Potion Shop");
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
}
