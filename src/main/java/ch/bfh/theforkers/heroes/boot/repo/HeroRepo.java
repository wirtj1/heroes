package ch.bfh.theforkers.heroes.boot.repo;

import ch.bfh.theforkers.heroes.boot.entities.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepo extends MongoRepository<Hero, String> {

}
