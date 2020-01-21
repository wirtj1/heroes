package ch.bfh.theforkers.heroes.camp.repo;

import ch.bfh.theforkers.heroes.camp.entities.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HeroRepo extends CrudRepository<Hero, String> {
    Long countByAtkGreaterThan(Integer atk);

}
