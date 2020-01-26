package ch.bfh.theforkers.heroes.arena.client;

import ch.bfh.theforkers.heroes.entities.Hero;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "healer-service")
@RequestMapping("/healer")
public interface HealerClient {

    @PostMapping("/heal")
    Hero heal(@RequestBody Hero hero);
}