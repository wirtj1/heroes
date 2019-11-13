package config;

import java.io.IOException;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import service.EpicHeroService;
import service.GreatPartyService;
import service.HeroService;
import service.PartyService;

@Configuration
@EnableMongoRepositories(basePackages = "repo")
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