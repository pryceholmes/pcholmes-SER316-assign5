package CharacterCreation;

public class GiantCreator extends CharacterCreator{

    /**
     * create a new Giant
     * @return a new Giant
     */
    @Override
    public PlayerCharacter createCharacter() {
        return new Giant();
    }
}
