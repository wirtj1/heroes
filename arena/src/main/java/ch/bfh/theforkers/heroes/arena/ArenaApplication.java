package ch.bfh.theforkers.heroes.arena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
public class ArenaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArenaApplication.class, args);
    }

}
