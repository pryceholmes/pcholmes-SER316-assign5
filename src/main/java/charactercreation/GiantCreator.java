package charactercreation;

import java.util.Random;

/**
 * A class to create a new Giant (Factory Pattern).
 */

public class GiantCreator extends CharacterCreator {

    /**
     * create a new Giant.
     * @return a new Giant
     */
    @Override
    public PlayerCharacter createCharacter(Random rand) {
        return new Giant(rand);
    }
}
