package ch.bfh.theforkers.heroes.camp.repo;

import ch.bfh.theforkers.heroes.camp.entities.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepo extends MongoRepository<Hero, String> {

}
