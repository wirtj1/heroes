package ch.bfh.theforkers.heroes.entities.service;


import ch.bfh.theforkers.heroes.entities.Party;

public interface BattleService {
    String battle(Party challengeeParty, Party challengerParty);
}

