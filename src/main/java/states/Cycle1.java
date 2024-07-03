package states;

import actions.Action;
import actions.Attack;
import actions.Defense;
import actions.Heal;
import charactercreation.PlayerCharacter;
import enemycreation.Enemy;
import java.util.Random;

public class Cycle1 extends State {

    /**
     * Constructor for the Cycle1 class.
     *
     * @param rand the random object generator
     */
    public Cycle1(Random rand) {
        super(rand);
    }

    // Requirement 7: Each cycle has its own event.
    // Cycle 1 has all attacks do 2% more damage.
    // Cycle 2 has both player and enemy defend actions
    // have a 5% increase in defense points.
    // Cycle 3 has 15% more exp is gained per battle.
    // Cycle 4 has players get a 0.5% health boost after every player attack.
    /**
     * Method to handle a single player turn in the game.
     * in cycle 1, all attacks do 2% more damage.
     *
     * @return 0 if battle is still ongoing, 1 if player wins, 2 if player loses
     */
    @Override
    public int simulatePlayerTurn(PlayerCharacter player, Enemy enemy) {
        System.out.println();
        System.out.println("Player it is your turn! Choose an action!");
        System.out.println("1. Attack");
        System.out.println("2. Heal");
        System.out.println("3. Use skill");

        // since game is simulated, we don't actually ask for an input,
        // but this is where we would.
        int choice = rand.nextInt(3) + 1;

        int gameStatus = 0;

        // switch statement to handle the player's choice
        switch (choice) {
            case 1:
                System.out.println("Player attacks!");
                System.out.println();
                Attack playerAttack = player.attack();
                Defense enemyDefense = enemy.defend();
                gameStatus = enemy.takeDamage((int) (playerAttack.getAttackAmount() * 1.02)
                        - enemyDefense.getDefenseAmount());
                System.out.println("Player attacks" + " for "
                        + (int) (playerAttack.getAttackAmount() * 1.02) + " damage!");
                System.out.println(enemyDefense.getMessage());
                break;
            case 2:
                System.out.println("Player heals!");
                System.out.println();
                Heal playerHeal = player.heal();
                System.out.println(playerHeal.getMessage());
                break;
            case 3:
                System.out.println("Player uses skill!");
                System.out.println();
                Action playerSkill = player.doSkill();
                if (playerSkill instanceof Attack) {
                    Attack playerSkillAttack = (Attack) playerSkill;
                    if (playerSkillAttack.getAttackAmount() != 0) {
                        gameStatus
                                = enemy.takeDamage((int) (playerSkillAttack.getAttackAmount()
                                * 1.02) - enemy.defend().getDefenseAmount());
                    }
                    System.out.println("Player uses skill: "
                            + playerSkillAttack.getMessage());
                } else {
                    Heal playerSkillHeal = (Heal) playerSkill;
                    System.out.println("Player uses skill: "
                            + playerSkillHeal.getMessage());
                }
                break;
            default:
                System.err.println("Invalid choice, please try again.");
                break;
        }

        return gameStatus;
    }

    /**
     * Method to handle a single enemy turn in the game.
     * in cycle 1, all attacks do 2% more damage.
     *
     * @return 0 if battle is still ongoing, 1 if player wins, 2 if player loses
     */
    @Override
    public int simulateEnemyTurn(PlayerCharacter player, Enemy enemy) {
        System.out.println();
        System.out.println("It is the enemies turn!");

        int choice = rand.nextInt(3) + 1;

        int gameStatus = 0;

        switch (choice) {
            case 1:
                Attack enemyAttack = enemy.attack();
                Defense playerDefense = player.defend();
                gameStatus = player.takeDamage((int) (enemyAttack.getAttackAmount()
                        * 1.02) - playerDefense.getDefenseAmount());
                if (gameStatus == 1) {
                    return 2;
                }
                System.out.println("Enemy attacks" + " for "
                        + (int) (enemyAttack.getAttackAmount() * 1.02) + " damage!");
                System.out.println(playerDefense.getMessage());
                break;
            case 2:
                Heal enemyHeal = enemy.heal();
                System.out.println(enemyHeal.getMessage());
                break;
            case 3:
                Action enemySkill = enemy.doSkill();
                if (enemySkill instanceof Attack) {
                    Attack enemySkillAttack = (Attack) enemySkill;
                    if (enemySkillAttack.getAttackAmount() != 0) {
                        gameStatus
                                = player.takeDamage((int) (enemySkillAttack.getAttackAmount()
                                * 1.02) - player.defend().getDefenseAmount());
                        if (gameStatus == 1) {
                            return 2;
                        }
                    }
                    System.out.println("Enemy uses skill: "
                            + enemySkillAttack.getMessage());
                } else {
                    Heal enemySkillHeal = (Heal) enemySkill;
                    System.out.println("Enemy uses skill: "
                            + enemySkillHeal.getMessage());
                }
                break;
            default:
                System.err.println("Invalid choice, please try again.");
                break;
        }
        return gameStatus;
    }

}
