package CharacterCreation;

public class HealerCreator extends CharacterCreator{

    /**
     * create a new Healer
     * @return a new Healer
     */
    @Override
    public PlayerCharacter createCharacter() {
        return new Healer();
    }
}
