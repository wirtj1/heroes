package ch.bfh.theforkers.heroes.camp.service;

import ch.bfh.theforkers.heroes.camp.entities.Hero;
import ch.bfh.theforkers.heroes.camp.repo.HeroRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class EpicHeroService implements HeroService {

	@Autowired
	private HeroRepo heroRepo;

	public Hero createHero(String name) {
		Hero hero = new Hero();
		hero.setName(name);
		hero.setAtk(new Random().nextInt(100));
		hero.setDef(new Random().nextInt(100));
		hero.setHp(100);
		String id = heroRepo.save(hero).getId();

		System.out.println("Hero "+name+" has been created");
		System.out.println("Heros with ATK greater than 50: "+heroRepo.countByAtkGreaterThan(50));

		return heroRepo.findById(id).get();

	}

	public void printCountHeroATKOver50() {
		//		TODO
		//		System.out.println(heroRepo.count(...));
	}
}
