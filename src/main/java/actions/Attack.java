package actions;

public class Attack extends Action {
    /**
     * The amount of damage the attack will do.
     */
    private int attackAmount;

    /**
     * Constructor for the Attack class.
     * @param attackAmount the amount of damage
     * @param message the message to be displayed
     */
    public Attack(int attackAmount, String message) {
        super(message);
        this.attackAmount = attackAmount;
    }

    /**
     * Get the amount of damage the attack will do.
     * @return the amount of damage
     */
    public int getAttackAmount() {
        return attackAmount;
    }

    /**
     * Set the amount of damage the attack will do.
     * @param attackAmount the amount of damage
     */
    public void setAttackAmount(int attackAmount) {
        this.attackAmount = attackAmount;
    }
}
