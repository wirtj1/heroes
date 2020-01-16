package ch.bfh.theforkers.heroes.promoter.client;

import ch.bfh.theforkers.heroes.promoter.model.Party;

import java.util.List;

public interface ArenaClient {
    public String battle(List<Party> challangers);
}
