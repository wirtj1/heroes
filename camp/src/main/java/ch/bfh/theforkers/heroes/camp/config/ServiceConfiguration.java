package ch.bfh.theforkers.heroes.camp.config;

import ch.bfh.theforkers.heroes.camp.service.EpicHeroService;
import ch.bfh.theforkers.heroes.camp.service.GreatPartyService;
import ch.bfh.theforkers.heroes.camp.service.HeroService;
import ch.bfh.theforkers.heroes.camp.service.PartyService;
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@Configuration
//@EnableMongoRepositories(basePackages = "ch.bfh.theforkers.heroes.camp.repo")
public class ServiceConfiguration {
    @Bean
    public HeroService heroService() {
        return new EpicHeroService();
    }

    @Bean
    public PartyService partyService() {
        return new GreatPartyService();
    }

//    @Bean
//    @DependsOn("mongo")
//    public MongoClient mongoClient() {
//        return new MongoClient("localhost");
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoClient(), "myDatabase");
//    }
//
//    @Bean(destroyMethod = "close")
//    public Mongo mongo() throws IOException {
//        return new EmbeddedMongoBuilder()
//                .version("3.4.17")
//                .bindIp("localhost")
//                .port(27017)
//                .build();
//    }
}
