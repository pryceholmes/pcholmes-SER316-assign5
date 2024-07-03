package charactercreation;

import java.util.Random;

/**
 * A class to create a new Healer (Factory Pattern).
 */
public class HealerCreator extends CharacterCreator {

    /**
     * create a new Healer.
     * @return a new Healer
     */
    @Override
    public PlayerCharacter createCharacter(Random rand) {
        return new Healer(rand);
    }
}
