package actions;

public class Defense extends Action {
    /**
     * The amount of defense the defense will do.
     */
    private int defenseAmount;

    /**
     * Constructor for the Defense class.
     * @param defenseAmount the amount of defense
     * @param message the message to be displayed
     */
    public Defense(int defenseAmount, String message) {
        super(message);
        this.defenseAmount = defenseAmount;
    }

    /**
     * Get the amount of defense the defense will do.
     * @return the amount of defense
     */
    public int getDefenseAmount() {
        return defenseAmount;
    }

    /**
     * Set the amount of defense the defense will do.
     * @param defenseAmount the amount of defense
     */
    public void setDefenseAmount(int defenseAmount) {
        this.defenseAmount = defenseAmount;
    }

}
