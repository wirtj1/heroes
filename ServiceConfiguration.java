import org.springframework.context.annotation.Bean;

public class ServiceConfiguration {
    @Bean
    public HeroService heroService() {
        return new EpicHeroService();
    }

    @Bean
    public PartyService campService(HeroService heroService) {
        return new GreatPartyService(heroService);
    }
}