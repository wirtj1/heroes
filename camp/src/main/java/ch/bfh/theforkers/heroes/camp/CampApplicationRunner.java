package ch.bfh.theforkers.heroes.camp;

import ch.bfh.theforkers.heroes.camp.repo.HeroRepo;
import ch.bfh.theforkers.heroes.camp.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements ApplicationRunner {

    @Autowired
    private HeroRepo heroRepository;

    @Autowired
    private HeroService heroService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (heroRepository.count() == 0) {
            heroService.createHero("Joy");
            heroService.createHero("Gabriel");
            heroService.createHero("Batman");
            heroService.createHero("Trudi");
        }
    }
}
