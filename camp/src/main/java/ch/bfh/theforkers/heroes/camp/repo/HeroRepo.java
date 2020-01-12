package ch.bfh.theforkers.heroes.camp.repo;

import ch.bfh.theforkers.heroes.camp.entities.Hero;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
//public interface HeroRepo extends MongoRepository<Hero, String> {
public interface HeroRepo extends CrudRepository<Hero, String> {
    Long countByAtkGreaterThan(Integer atk);

}
