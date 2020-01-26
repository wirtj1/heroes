package ch.bfh.theforkers.heroes.healer.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healer")
public class HealerController {

    @GetMapping(value = "/heal")
    public Double heal(Double hp) {
        double newhp = hp+10;
        if(newhp > 100){
            return 100.0;
        }
        return hp+10;
    }
}
