package ch.bfh.theforkers.heroes.potionshop.service;

import ch.bfh.theforkers.heroes.entities.HealingPotion;

public interface PotionService {

	HealingPotion createPotion(String name, int price, double healingAmount);
}
