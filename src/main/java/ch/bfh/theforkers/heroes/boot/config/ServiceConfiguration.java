package ch.bfh.theforkers.heroes.boot.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ch.bfh.theforkers.heroes.boot.service.EpicHeroService;
import ch.bfh.theforkers.heroes.boot.service.GreatPartyService;
import ch.bfh.theforkers.heroes.boot.service.HeroService;
import ch.bfh.theforkers.heroes.boot.service.PartyService;

import java.io.IOException;

@Configuration
@EnableMongoRepositories(basePackages = "ch/bfh/theforkers/heroes/boot/repo")
public class ServiceConfiguration {
	@Bean
	public HeroService heroService() {
		return new EpicHeroService();
	}

	@Bean
	public PartyService campService(HeroService heroService) {
		return new GreatPartyService(heroService);
	}

	@Bean
	@DependsOn("mongo")
	public MongoClient mongoClient() {
	return new MongoClient("localhost");
	}
	@Bean
	public MongoTemplate mongoTemplate() {
	return new MongoTemplate(mongoClient(), "myDatabase");
	}
	@Bean(destroyMethod="close")
	public Mongo mongo() throws IOException {
	return new EmbeddedMongoBuilder()
	.version("3.4.17")
	.bindIp("localhost")
	.port(27017)
	.build();
	}
}