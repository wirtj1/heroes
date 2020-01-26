package ch.bfh.theforkers.heroes.entities;

import java.util.List;

public class PotionShop {
    private String name;
    private List<HealingPotion> potions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HealingPotion> getPotions() {
        return potions;
    }

    public void setPotions(List<HealingPotion> potions) {
        this.potions = potions;
    }
}
