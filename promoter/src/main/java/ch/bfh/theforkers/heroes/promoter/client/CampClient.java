package ch.bfh.theforkers.heroes.promoter.client;

import ch.bfh.theforkers.heroes.promoter.model.Party;
import org.springframework.hateoas.EntityModel;

public interface CampClient {

    EntityModel<Party> createParty(String name);
}
