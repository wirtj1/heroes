package ch.bfh.theforkers.heroes.healer.client;


import ch.bfh.theforkers.heroes.entities.PotionShop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "potion-service", path = "/potionshop", fallback = FallBackPotionShop.class)
public interface PotionShopClient {

    @PostMapping("/create")
    PotionShop createPotionShop(@RequestBody String name);
}
