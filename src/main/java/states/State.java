package states;

import charactercreation.PlayerCharacter;
import enemycreation.BossEnemyCreator;
import enemycreation.EasyEnemyCreator;
import enemycreation.Enemy;
import enemycreation.EnemyCreator;
import enemycreation.MediumEnemyCreator;
import java.util.Random;


/**
 * Abstract class for the State pattern.
 * This class is the parent class for all the states. A state represents the current cycle
 * the game is currently in. Cycles change every 4 floors.
 */
public abstract class State {

    private EnemyCreator enemyCreator;
    private int turnNumber = 0; // Number of turns that have passed
    private int turn = 0; // 0 for player turn, 1 for enemy turn
    protected Random rand;

    /**
     * Constructor for the State class.
     *
     * @param rand Random object to generate random numbers
     */
    public State(Random rand) {
        this.rand = rand;
    }

    /**
     * Method to handle the player's encounter with an enemy.
     * Encounters can be different depending on what cycle the game is in.
     *
     * @param floor The current floor the player is on
     * @param player The player character
     * @return 0 if player wins, 1 if player loses
     */
    public int enemyEncounter(int floor, PlayerCharacter player) {
        Enemy enemy;
        // Requirement 6: Create an enemy based on the floor number.
        // Creates a small enemy every floor, a medium enemy every 5th floor,
        // and a boss enemy every 10th floor.
        switch (floor % 10) {
            case 0:
                enemyCreator = new BossEnemyCreator();
                System.out.println("Player is encountering a boss enemy on floor " + floor);
                break;
            case 5:
                enemyCreator = new MediumEnemyCreator();
                System.out.println("Player is encountering a medium enemy on floor " + floor);
                break;
            default:
                enemyCreator = new EasyEnemyCreator();
                System.out.println("Player is encountering an easy enemy on floor " + floor);
        }
        // Create the enemy
        enemy = enemyCreator.createEnemy(floor, rand);
        // Participant with the highest speed goes first
        turn = (player.getSpeed() > enemy.getSpeed()) ? 0 : 1;

        boolean finished = false;
        int returnResult = 0;
        turnNumber = 0;
        while (!finished) {
            if (turn == 0) {
                // Player's turn
                int result = simulatePlayerTurn(player, enemy);
                // Player wins
                if (result == 1) {
                    System.out.println("Player wins the battle!");
                    finished = true;
                    returnResult = 0;
                } else if (result == 2) { // Player loses
                    System.out.println("Player loses the battle!");
                    finished = true;
                    returnResult = 1;
                }
            } else {
                // Enemy's turn
                int result = simulateEnemyTurn(player, enemy);
                // Player wins
                if (result == 1) {
                    System.out.println("Player wins the battle!");
                    finished = true;
                    returnResult = 0;
                } else if (result == 2) { // Player loses
                    System.out.println("Player loses the battle!");
                    finished = true;
                    returnResult = 1;
                }
            }
            // Switch turns
            turn = (turn == 0) ? 1 : 0;
            // Increment turn number
            turnNumber++;

            // If 50 turns have passed, player wins
            // This is implemented because the random actions
            // can sometimes lead to a stalemate.
            // If the gameplay was not simulated, this would be removed.
            if (turnNumber == 50) {
                System.out.println("You have exhausted the enemy, you win!");
                finished = true;
                returnResult = 0;

            }

            if (!finished) {
                System.out.println("Current battle stats:");
                System.out.println("Player health: " + player.getHealth());
                System.out.println("Enemy health: " + enemy.getHealth());
                System.out.println();
            }
        }
        return returnResult;
    }

    /**
     * Method to handle a single player turn in the game.
     *
     * @return 0 if battle is still ongoing, 1 if player wins, 2 if player loses
     */
    public abstract int simulatePlayerTurn(PlayerCharacter player, Enemy enemy);

    /**
     * Method to handle a single enemy turn in the game.
     *
     * @return 0 if battle is still ongoing, 1 if player wins, 2 if player loses
     */
    public abstract int simulateEnemyTurn(PlayerCharacter player, Enemy enemy);
}
