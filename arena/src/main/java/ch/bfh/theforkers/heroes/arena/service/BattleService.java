package ch.bfh.theforkers.heroes.arena.service;

import ch.bfh.theforkers.heroes.arena.model.Party;

public interface BattleService {
    public String battle(Party challengeeParty, Party challengerParty);
}

