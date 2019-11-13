package service;

import java.util.Random;

import entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import repo.HeroRepo;

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
