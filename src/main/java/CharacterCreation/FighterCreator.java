package CharacterCreation;

public class FighterCreator extends CharacterCreator{

    /**
     * create a new Fighter
     * @return a new Fighter
     */
    @Override
    public PlayerCharacter createCharacter() {
        return new Fighter();
    }
}
