package ch.bfh.theforkers.heroes.potionshop.service;

import ch.bfh.theforkers.heroes.entities.HealingPotion;
import ch.bfh.theforkers.heroes.entities.PotionShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class HealthyPotionShopService implements PotionShopService {

	@Autowired
	private PotionService potionService;

	@Override
	public PotionShop createPotionShop(String name) {
		PotionShop potionShop = new PotionShop();
		potionShop.setName(name);
		List<HealingPotion> potions = new ArrayList<HealingPotion>();
		potions.add(potionService.createPotion("commmon healing potion", 50, 6.5));
		potions.add(potionService.createPotion("greater healing potion", 200, 12.5));
		potions.add(potionService.createPotion("superior healing potion", 1000, 25.0));
		potionShop.setPotions(potions);
		return potionShop;
	}
}
