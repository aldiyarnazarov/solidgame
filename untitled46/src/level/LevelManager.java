package level;

import player.Player;

public class LevelManager {
    private int currentLevel;

    public LevelManager() {
        this.currentLevel = 1;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void advanceLevel() {
        currentLevel++;
    }

    public void resetPlayerHealth(Player player) {
        player.updateHealth(100 - player.getHealth());
    }
}