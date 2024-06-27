package Actions;

public class Heal extends Action{
    /**
     * The amount of health the heal will restore
     */
    private int healAmount;

    /**
     * Constructor for the Heal class
     * @param healAmount the amount of health
     * @param message the message to be displayed
     */
    public Heal(int healAmount, String message) {
        super(message);
        this.healAmount = healAmount;
    }

    /**
     * Get the amount of health the heal will restore
     * @return the amount of health
     */
    public int getHealAmount() {
        return healAmount;
    }

    /**
     * Set the amount of health the heal will restore
     * @param healAmount the amount of health
     */
    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
}
