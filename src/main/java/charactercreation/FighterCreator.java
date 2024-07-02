package charactercreation;

import java.util.Random;

/**
 * A class to create a new Fighter (Factory Pattern).
 */
public class FighterCreator extends CharacterCreator {

    /**
     * create a new Fighter.
     * @return a new Fighter
     */
    @Override
    public PlayerCharacter createCharacter(Random rand) {
        return new Fighter(rand);
    }
}
