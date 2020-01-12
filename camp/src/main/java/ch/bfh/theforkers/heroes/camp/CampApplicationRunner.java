package ch.bfh.theforkers.heroes.camp;

import ch.bfh.theforkers.heroes.camp.repo.HeroRepo;
import ch.bfh.theforkers.heroes.camp.service.HeroService;
import ch.bfh.theforkers.heroes.camp.service.PartyService;
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

    @Autowired
    private PartyService partyService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        partyService.createParty("EpicParty");
        if (heroRepository.count() == 0) {
            heroService.createHero("Joy");
            heroService.createHero("Gabriel");
            heroService.createHero("Batman");
            heroService.createHero("Trudi");
        }
    }
}
