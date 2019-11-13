package repo;

import entities.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepo extends MongoRepository<Hero, String> {

}
