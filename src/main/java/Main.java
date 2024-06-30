import CharacterCreation.*;

import EnemyCreation.*;
import Actions.*;
import States.*;

import java.util.Random;

public class Main {

    static int floor = 1;

    static PlayerCharacter player;

    public static void main(String[] args) {
        State state = new Cycle1();

        System.out.println("Choose your character type: ");
        System.out.println("1. Fighter");
        System.out.println("2. Giant");
        System.out.println("3. Healer");

        // since game is simulated, we don't actually ask for an input, but this is where we would.

        Random rand = new Random();
        int choice = rand.nextInt(3) + 1;

        switch (choice) {
            case 1:
                player = new Fighter();
                break;
            case 2:
                player = new Giant();
                break;
            case 3:
                player = new Healer();
                break;
        }

        while (floor < 100) {
            int result = state.enemyEncounter(floor, player);
            if (result == 0) {
                floor++;
                player.gainExp(15);
                if (player.getExp() >= 100) {
                    player.levelUp();
                }
            } else {
                System.out.println("Game over! You made it to floor " + floor);
                break;
            }
        }
    }
}
