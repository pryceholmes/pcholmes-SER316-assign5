/**
 * This file is the main file for the game. It is where the game is run
 * and the player character is created.
 *
 * @author Pryce Holmes
 * @version 7/2/2024
 */

//////////////////////////////////////////////////////////////////////////
// IMPORT STATEMENTS
import charactercreation.CharacterCreator;
import charactercreation.FighterCreator;
import charactercreation.GiantCreator;
import charactercreation.HealerCreator;
import charactercreation.PlayerCharacter;
import java.util.Random;
import states.Cycle1;
import states.Cycle2;
import states.Cycle3;
import states.Cycle4;
import states.State;
//////////////////////////////////////////////////////////////////////////

/**
 * Main class to run the game.
 */
public class Main {

    /**
     * The current floor the player is on.
     */
    static int floor = 1;

    /**
     * The current cycle the game is in.
     */
    static int cycleCounter = 0;

    /**
     * The current state of the game.
     */
    static State state;

    /**
     * The character creator used to create the player character.
     */
    static CharacterCreator characterCreator;

    /**
     * The player character.
     */
    static PlayerCharacter player;

    /**
     * Random object to generate random numbers.
     */
    static Random rand = new Random();

    /**
     * Main method to run the game.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Game Starts here
        // Player chooses a character type
        System.out.println("Choose your character type: ");
        System.out.println("1. Fighter");
        System.out.println("2. Giant");
        System.out.println("3. Healer");

        // since game is simulated, we don't actually ask for an input,
        // but this is where we would.
        // For now, we will randomly choose a character type for the player

        // Requirement 1. Choose a character class
        int choice = rand.nextInt(3) + 1;

        // switch statement to create the player character based on the choice
        switch (choice) {
            case 1:
                // use character creator to create a fighter, uses the factory pattern
                characterCreator = new FighterCreator();
                System.out.println("Player is a Fighter!");
                System.out.println();
                break;
            case 2:
                // use character creator to create a giant, uses the factory pattern
                characterCreator = new GiantCreator();
                System.out.println("Player is a Giant!");
                System.out.println();
                break;
            case 3:
                // use character creator to create a healer, uses the factory pattern
                characterCreator = new HealerCreator();
                System.out.println("Player is a Healer!");
                System.out.println();
                break;
            default:
                System.err.println("Invalid choice");
                break;
        }

        // create the player character using the factory creator
        player = characterCreator.createCharacter(rand);

        // Game loop
        while (floor < 26) {
            // determine the state of the game based on the cycle counter
            // Requirement 2. Game runs in cycles of 4 parts
            // Cycles are implemented using the State pattern
            if (cycleCounter == 0) {
                // Requirement 3. Game cycle lasts for 5 floors and each have their own event
                // Cycle events are outlined in cycle classes
                state = new Cycle1(rand);
                System.out.println("Cycle 1: ");
                System.out.println("All attacks do 2% more damage.");
                System.out.println();
            } else if (cycleCounter == 5) {
                state = new Cycle2(rand);
                System.out.println("Cycle 2: ");
                System.out.println("Both player and enemy defend actions "
                        + "have a 5% increase in defense points.");
                System.out.println();
            } else if (cycleCounter == 10) {
                state = new Cycle3(rand);
                System.out.println("Cycle 3: ");
                System.out.println("15% more exp is gained per battle.");
                System.out.println();
            } else if (cycleCounter == 15) {
                state = new Cycle4(rand);
                System.out.println("Cycle 4: ");
                System.out.println("Players get a 0.5% health boost after every player attack.");
                System.out.println();
            }

            // Enemy encounter is implemented in cycle class like outlined in state pattern
            int result = state.enemyEncounter(floor, player);
            if (result == 0) {
                // Requirement 4. After each floor you go back to first floor
                // if health is below 15%.
                // Going back to floor 1 gives the player full health.
                if (player.getHealth() < (int) (player.getMaxHealth() * 0.15)) {
                    System.out.println("Health too low! Going back to floor 1");
                    floor = 1;
                    cycleCounter = 0;
                    player.setHealth(player.getMaxHealth());
                }
                floor++;
                // Requirement 5. You gain experience from winning battles and
                // can level up upgrades. Since the game is simulated,
                // the leveling up process is done automatically and stats
                // are automatically upgraded.
                // If the game was not simulated, the player would be able to
                // choose which stats to upgrade upon a level up.
                player.gainExp(15);
                if (player.getExp() >= 100) {
                    player.levelUp();
                }
            } else {
                // If the player loses a battle, the game is over.
                System.out.println("Game over! You made it to floor " + floor);

                break;
            }
            // Increment the game cycle, every 20 floors the cycle will reset.
            cycleCounter++;
            if (cycleCounter == 20) {
                cycleCounter = 0;
            }
        }
    }
}
