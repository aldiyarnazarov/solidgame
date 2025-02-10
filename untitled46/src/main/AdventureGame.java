package main;

import player.Player;
import enemies.*;
import items.*;
import level.LevelManager;

public class AdventureGame {
    private Player player;
    private ItemManager itemManager;
    private LevelManager levelManager;

    public AdventureGame() {
        this.player = new Player("Aldiyar");
        this.itemManager = new ItemManager();
        this.levelManager = new LevelManager();
        initializeLevel();
    }

    private void initializeLevel() {
        switch (levelManager.getCurrentLevel()) {
            case 1:
                new Skeleton();
                new Zombie();
                itemManager.addItem(GoldCoin.TYPE);
                itemManager.addItem(HealthElixir.TYPE);
                break;
            case 2:
                new Vampire();
                itemManager.addItem(MagicScroll.TYPE);
                break;
            case 3:
                new Vampire();
                new Zombie();
                itemManager.addItem(HealthElixir.TYPE);
                itemManager.addItem(GoldCoin.TYPE);
                break;
        }
    }

    private void fightEnemy(Enemy enemy) {
        System.out.println(player.getName() + " fights " + enemy.getType());
        player.updateHealth(-enemy.getHealthImpact());
        player.addExperience(enemy.getExperienceReward());
        player.displayStatus();
    }

    private void pickUpItem(String item) {
        System.out.println(player.getName() + " picks up " + item);
        switch (item) {
            case GoldCoin.TYPE:
                player.addExperience(5);
                break;
            case HealthElixir.TYPE:
                player.updateHealth(20);
                break;
            case MagicScroll.TYPE:
                player.addExperience(15);
                break;
        }
        player.addItem(item);
        itemManager.removeItem(item);
        System.out.println("Inventory: " + player.getInventory());
    }

    private void advanceLevel() {
        System.out.println("Advancing to level " + (levelManager.getCurrentLevel() + 1));
        levelManager.advanceLevel();
        levelManager.resetPlayerHealth(player);
        initializeLevel();
    }

    public void playGame() {
        while (levelManager.getCurrentLevel() <= 3 && player.getHealth() > 0) {
            System.out.println("=== Level " + levelManager.getCurrentLevel() + " ===");
            if (player.getHealth() > 0 && levelManager.getCurrentLevel() < 3) {
                advanceLevel();
            }
        }
        if (player.getHealth() <= 0) {
            System.out.println(player.getName() + " has perished. Game over.");
        } else {
            System.out.println("Congratulations, " + player.getName() + "! You completed the adventure with " + player.getExperience() + " experience points!");
        }
    }

    public static void main(String[] args) {
        AdventureGame game = new AdventureGame();
        game.playGame();
    }
}