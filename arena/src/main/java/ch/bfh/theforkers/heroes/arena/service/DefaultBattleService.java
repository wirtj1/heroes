package ch.bfh.theforkers.heroes.arena.service;


import ch.bfh.theforkers.heroes.arena.client.HealerClient;
import ch.bfh.theforkers.heroes.entities.Hero;
import ch.bfh.theforkers.heroes.entities.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultBattleService implements BattleService {

    /*
    @Autowired
    private HealerClient healerClient;
    */

    private static final Logger LOG = LoggerFactory.getLogger(DefaultBattleService.class);
    private static final DecimalFormat f = new DecimalFormat("##.00");
    @Override
    public String battle(Party challengeeParty, Party challengerParty) {

        List<Hero> challengees = new ArrayList<>(challengeeParty.getMembers());
        List<Hero> challengers = new ArrayList<>(challengerParty.getMembers());

        LOG.info("Party '"+challengeeParty.getName()+"' fights against party '"+challengerParty.getName()+"'.");

        int duelCount;
        int roundCount = 0;

        while (true) {

            List<Hero> loosers = new ArrayList<>();
            roundCount++;

            LOG.info("============================================================================================================");
            LOG.info("Starting round no. "+roundCount);

            // there can be only as much duels as the count of remaining members in the smallest party
            if (challengees.size() > challengers.size()) {
                duelCount = challengers.size();
            } else {
                duelCount = challengees.size();
            }

            // execute the duels
            for (int i = 0; i < duelCount; i++) {
                Hero challengee = challengees.get(i);
                Hero challenger = challengers.get(i);
                Hero looser = duel(challengee, challenger);
                loosers.add(looser);
            }

            // remove the loosers from both parties
            challengees.removeAll(loosers);
            challengers.removeAll(loosers);

            LOG.info("Party '"+challengeeParty.getName()+"' has "+challengees.size()+" members left.");
            LOG.info("Party '"+challengerParty.getName()+"' has "+challengers.size()+" members left.");

            // check if a party has already lost (no members left), return the winners party name
            if (challengees.isEmpty()) {
                LOG.info("Party '"+challengerParty.getName()+"' wins this battle in "+roundCount+" rounds.");
                return challengerParty.getName();
            }

            if (challengers.isEmpty()) {
                LOG.info("Party '"+challengeeParty.getName()+"' wins this battle in "+roundCount+" rounds.");
                return challengeeParty.getName();
            }
        }
    }

    private Hero duel(Hero challengee, Hero challenger) {

        // Chalangee has home advantage
        Hero attacker = challenger;
        Hero defender = challengee;

        LOG.info("------------------------------------------------------------------------------------------------------------");
        LOG.info(attacker.getName()+" (ATK:"+attacker.getAtk()+", DEF:"+attacker.getDef()+") with "+f.format(attacker.getHp())+" hp left fights against "+defender.getName()+" (ATK:"+defender.getAtk()+", DEF:"+defender.getDef()+") with "+f.format(defender.getHp())+" hp left.");

        // battle until hp runs out
        while(defender.getHp() >= 0) {
            if(Math.random() > 0.9){
                //defender = healerClient.heal(defender);
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity entity = new HttpEntity(defender,headers);
                ResponseEntity<Hero> out = new RestTemplate().exchange("http://localhost:8083/healer/heal", HttpMethod.POST, entity
                        , Hero.class);
                Hero hero = out.getBody();
                defender = hero;
            }
            // swap attacker and defender
            Hero temp = attacker;
            attacker = defender;
            defender = temp;

            // duel round
            round(attacker, defender);
        }
        LOG.info(defender.getName()+" has lost the duel against "+attacker.getName()+".");
        return defender;
    }

    private void round(Hero attacker, Hero defender) {
        double defenderHp = defender.getHp();

        // damage is 1/10 of ATK
        double damage = attacker.getAtk();
        if (damage < 1) damage++;
        damage = damage/10.0;
        LOG.info("Attacking "+attacker.getName()+" caused "+damage+" damage.");

        // defense blocks DEF percent of ATK
        double defense = defender.getDef();
        if (defense > 1) defense--;
        LOG.info("Defending "+defender.getName()+" blocked "+defense+" percent of damage.");

        // harm = damage - defense
        double harm = damage - (damage * (defense/100));
        LOG.info("Defending "+defender.getName()+" lost "+f.format(harm)+" of health.");

        // harm is drawn from defenders hp
        defenderHp -= harm;
        LOG.info("Defending "+defender.getName()+" has "+f.format(Math.max(0,defenderHp))+" health points left.");

        defender.setHp(defenderHp);
    }
}
