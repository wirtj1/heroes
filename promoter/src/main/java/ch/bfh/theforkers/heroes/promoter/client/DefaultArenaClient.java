package ch.bfh.theforkers.heroes.promoter.client;

import ch.bfh.theforkers.heroes.entities.Party;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DefaultArenaClient implements ArenaClient {

    @Override
    public String battle(List<Party> challengers) {
        int winnerNumber = (int) Math.floor(Math.random()*challengers.size());
        Party winner = challengers.get(winnerNumber);
        return "The Arena is currently down for maintenance, the winner has been chosen randomly: " +winner.getName();
    }
}
