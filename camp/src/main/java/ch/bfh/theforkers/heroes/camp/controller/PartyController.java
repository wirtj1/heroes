package ch.bfh.theforkers.heroes.camp.controller;

import ch.bfh.theforkers.heroes.camp.entities.Hero;
import ch.bfh.theforkers.heroes.camp.entities.Party;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import ch.bfh.theforkers.heroes.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @GetMapping(value = "/createParty")
    public Party createParty(@RequestParam String name) {
        Party party = partyService.createParty(name);
        party.add(linkTo(methodOn(PartyController.class).createParty(name)).withSelfRel());
        for (int i = 0; i < party.getMembers().size(); i++) {
            party.add(entityLinks.linkToSingleResource(Hero.class, party.getMembers().get(i).getId()).withRel("hero"+i));
        }
        return party;
    }

}

