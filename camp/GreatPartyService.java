import java.util.ArrayList;
import java.util.List;

public class GreatPartyService implements PartyService {

    private HeroService heroService;

    public GreatPartyService(HeroService heroService) {
        this.heroService = heroService;
    }

    public Party createParty(String name) {
        Party party = new Party();
        party.setName(name);
        List<Hero> heroes = new ArrayList<Hero>();
        heroes.add(heroService.createHero("Joy"));
        heroes.add(heroService.createHero("Gabriel"));
        heroes.add(heroService.createHero("Batman"));
        party.setMembers(heroes);
        return party;
    }
}
