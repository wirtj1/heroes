package ch.bfh.theforkers.heroes.potionshop.service;

import ch.bfh.theforkers.heroes.entities.HealingPotion;
import org.springframework.beans.factory.annotation.Autowired;
import ch.bfh.theforkers.heroes.potionshop.repo.PotionRepo;
import org.springframework.stereotype.Service;

@Service
public class HealthyPotionService implements PotionService {

	@Autowired
	private PotionRepo potionRepo;

	public HealingPotion createPotion(String name, int price, double healingAmount) {
		HealingPotion potion = new HealingPotion();
		potion.setName(name);
		potion.setPrice(price);
		potion.setHealingAmount(healingAmount);
		String id = potionRepo.save(potion).getId();

		System.out.println("Potion "+name+" has been created");

		return potionRepo.findById(id).get();

	}
}
