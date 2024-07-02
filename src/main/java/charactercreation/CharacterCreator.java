/**
 * CharacterCreator.java
 *
 * This file contains an abstract class that creates a new Character (Factory Pattern)
 */

package charactercreation;

import java.util.Random;

/**
 * CharacterCreator class (Factory Pattern).
 */
public abstract class CharacterCreator {

    /**
     * create a new Character,
     * abstract method that is overridden in child classes.
     * @param rand A Random Object generator
     * @return a new Character
     */
    public abstract PlayerCharacter createCharacter(Random rand);

}
