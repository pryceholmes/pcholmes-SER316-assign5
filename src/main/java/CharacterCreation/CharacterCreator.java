package CharacterCreation;

abstract public class CharacterCreator {

    /**
     * create a new Character
     * abstract method that is overridden in child classes
     * @return a new Character
     */
    public abstract PlayerCharacter createCharacter();

}
