package ch.bfh.theforkers.heroes.promoter.client;

import ch.bfh.theforkers.heroes.promoter.model.Party;
import org.springframework.hateoas.Resource;

public interface CampClient {

    public Resource<Party> createParty(String name);
}
