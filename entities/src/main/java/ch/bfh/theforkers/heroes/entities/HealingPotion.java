package ch.bfh.theforkers.heroes.entities;

import org.springframework.data.annotation.Id;

public class HealingPotion {

    @Id
    private String id;
    private int price;
    private String name;
    private double healingAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(double healingAmount) {
        this.healingAmount = healingAmount;
    }

}
