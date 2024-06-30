package States;

import EnemyCreation.*;
import CharacterCreation.*;

/**
 * Abstract class for the State pattern.
 * This class is the parent class for all the states. A state represents the current cycle
 * the game is currently in. Cycles change every 4 floors.
 */
abstract public class State {

    private int turnNumber = 0; // Number of turns that have passed
    private int turn = 0; // 0 for player turn, 1 for enemy turn

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
        switch (floor % 10) {
            case 0:
                enemy = new BossEnemy(floor);
                System.out.println("Player is encountering a boss enemy on floor " + floor);
                break;
            case 5:
                enemy = new MediumEnemy(floor);
                System.out.println("Player is encountering a medium enemy on floor " + floor);
                break;
            default:
                enemy = new EasyEnemy(floor);
                System.out.println("Player is encountering an easy enemy on floor " + floor);
        }

        turn = (player.getSpeed() > enemy.getSpeed()) ? 0 : 1;

        boolean finished = false;
        int returnResult = 0;
        turnNumber = 0;
        while (!finished) {
            if (turn == 0) {
                int result = simulatePlayerTurn(player, enemy);
                if (result == 1) {
                    System.out.println("Player wins the battle!");
                    finished = true;
                    returnResult = 0;
                } else if (result == 2) {
                    System.out.println("Player loses the battle!");
                    finished = true;
                    returnResult = 1;
                }
            } else {
                int result = simulateEnemyTurn(player, enemy);
                if (result == 1) {
                    System.out.println("Player wins the battle!");
                    finished = true;
                    returnResult = 0;
                } else if (result == 2) {
                    System.out.println("Player loses the battle!");
                    finished = true;
                    returnResult = 1;
                }
            }

            turn = (turn == 0) ? 1 : 0;
            turnNumber++;
            if (turnNumber == 50) {
                System.out.println("You have exhausted the enemy, you win!");
                finished = true;
                returnResult = 0;

            }
        }
        return returnResult;
    }

    /**
     * Method to handle a single player turn in the game.
     *
     * @return 0 if battle is still ongoing, 1 if player wins, 2 if player loses
     */
    abstract public int simulatePlayerTurn(PlayerCharacter player, Enemy enemy);

    /**
     * Method to handle a single enemy turn in the game.
     *
     * @return 0 if battle is still ongoing, 1 if player wins, 2 if player loses
     */
    abstract public int simulateEnemyTurn(PlayerCharacter player, Enemy enemy);

    // TODO: Add more methods to help the enemy encounter to be used by all states.
}
