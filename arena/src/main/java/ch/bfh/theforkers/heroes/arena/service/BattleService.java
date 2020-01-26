package ch.bfh.theforkers.heroes.arena.service;

import ch.bfh.theforkers.heroes.arena.client.HealerClient;
import ch.bfh.theforkers.heroes.entities.Party;

public interface BattleService {
    String battle(Party challengeeParty, Party challengerParty);
}

