import CharacterCreation.*;

public class Main {

    public static void main(String[] args) {

        CharacterCreator charCreator = new GiantCreator();
        PlayerCharacter giant = charCreator.createCharacter();

        giant.attack();
        giant.defend();
        giant.doSkill();
    }
}
