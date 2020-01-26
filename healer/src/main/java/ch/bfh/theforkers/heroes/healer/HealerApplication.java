package ch.bfh.theforkers.heroes.healer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages={"ch.bfh.theforkers.heroes.healer.client"})
@EnableEurekaClient
public class HealerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealerApplication.class, args);
    }

}
