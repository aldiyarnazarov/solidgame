package enemies;

public class Enemy {
    private String type;
    private int healthImpact;
    private int experienceReward;

    public Enemy(String type, int healthImpact, int experienceReward) {
        this.type = type;
        this.healthImpact = healthImpact;
        this.experienceReward = experienceReward;
    }

    public String getType() {
        return type;
    }

    public int getHealthImpact() {
        return healthImpact;
    }

    public int getExperienceReward() {
        return experienceReward;
    }
}
