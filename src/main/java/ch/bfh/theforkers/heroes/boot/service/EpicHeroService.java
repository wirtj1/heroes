package ch.bfh.theforkers.heroes.boot.service;

import ch.bfh.theforkers.heroes.boot.entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import ch.bfh.theforkers.heroes.boot.repo.HeroRepo;

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

		return heroRepo.save(hero);

	}

	public void printCountHeroATKOver50() {
		//		TODO
		//		System.out.println(heroRepo.count(...));
	}
}
