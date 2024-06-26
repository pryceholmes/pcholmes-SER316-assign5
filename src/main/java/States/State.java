package States;

/**
 * Abstract class for the State pattern.
 * This class is the parent class for all the states. A state represents the current cycle
 * the game is currently in. Cycles change every 4 floors.
 */
abstract public class State {

    /**
     * Method to handle the player's encounter with an enemy.
     * Encounters can be different depending on what cycle the game is in.
     */
    public abstract void enemyEncounter();

    // TODO: Add more methods to help the enemy encounter to be used by all states.
}
