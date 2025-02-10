package player;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int experience;
    private List<String> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void updateHealth(int delta) {
        this.health += delta;
    }

    public int getExperience() {
        return experience;
    }

    public void addExperience(int points) {
        this.experience += points;
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void displayStatus() {
        System.out.println("Player: " + name + ", Health: " + health + ", Experience: " + experience);
    }
}
