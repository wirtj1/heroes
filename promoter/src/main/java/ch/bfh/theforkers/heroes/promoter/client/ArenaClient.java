package ch.bfh.theforkers.heroes.promoter.client;


import ch.bfh.theforkers.heroes.entities.Party;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(value = "arena-ch.bfh.theforkers.heroes.potionshop.service", path = "/arena", fallback = DefaultArenaClient.class)
public interface ArenaClient {

    @PostMapping("/battle")
    String battle(@RequestBody List<Party> challengers);
}
