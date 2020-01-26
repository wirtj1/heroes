package ch.bfh.theforkers.heroes.camp.service;

import ch.bfh.theforkers.heroes.camp.repo.HeroRepo;
import ch.bfh.theforkers.heroes.entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class EpicHeroService implements HeroService {

	@Autowired
	private HeroRepo heroRepo;

	public Hero createHero(String name) {
		Hero hero = new Hero();
		hero.setName(name);
		hero.setAtk(new Random().nextInt(100));
		hero.setDef(new Random().nextInt(100));
		hero.setGold(new Random().nextInt(1500));
		hero.setHp(100);
		String id = heroRepo.save(hero).getId();

		System.out.println("Hero "+name+" has been created");
		System.out.println("Heros with ATK greater than 50: "+heroRepo.countByAtkGreaterThan(50));

		return heroRepo.findById(id).get();

	}

	public void printCountHeroATKOver50() {
		Iterable<Hero> allHeroes =heroRepo.findAll();
		AtomicInteger cnt = new AtomicInteger();
		allHeroes.forEach(hero -> {
			if (hero.getAtk() > 50) {
				cnt.getAndIncrement();
			}});
		System.out.println(cnt.get());
	}
}
