package ch.bfh.theforkers.heroes.potionshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PotionShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PotionShopApplication.class, args);
	}

}
