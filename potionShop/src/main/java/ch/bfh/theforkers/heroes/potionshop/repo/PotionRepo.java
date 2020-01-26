package ch.bfh.theforkers.heroes.potionshop.repo;

import ch.bfh.theforkers.heroes.entities.HealingPotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PotionRepo extends CrudRepository<HealingPotion, String> {

}
