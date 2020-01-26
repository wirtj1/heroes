package ch.bfh.theforkers.heroes.promoter.client;

import ch.bfh.theforkers.heroes.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "camp-service")
public interface CampClient {

    @RequestMapping(method = RequestMethod.GET, value = "/createParty?name={name}")
    EntityModel<Party> createParty(@PathVariable("name") String name);
}
