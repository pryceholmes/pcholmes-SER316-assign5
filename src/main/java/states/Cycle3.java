package states;

import actions.Action;
import actions.Attack;
import actions.Defense;
import actions.Heal;
import charactercreation.PlayerCharacter;
import enemycreation.Enemy;
import java.util.Random;

public class Cycle3 extends State {

    /**
     * Constructor for the Cycle3 class.
     *
     * @param rand the random object generator
     */
    public Cycle3(Random rand) {
        super(rand);
    }

    /**
     * Method to handle a single player turn in the game.
     * in cycle 3, 15% more exp is gained per battle.
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
                gameStatus = enemy.takeDamage(playerAttack.getAttackAmount()
                        - enemyDefense.getDefenseAmount());
                System.out.println(playerAttack.getMessage());
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
                        gameStatus = enemy.takeDamage(playerSkillAttack
                                .getAttackAmount() - enemy.defend().getDefenseAmount());
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
                System.err.println("Invalid choice");
                break;
        }
        if (gameStatus == 1) {
            player.gainExp((int)(15 * 0.15));
            if (player.getExp() >= 100) {
                player.levelUp();
            }
        }
        return gameStatus;

    }

    /**
     * Method to handle a single enemy turn in the game.
     * in cycle 3, 15% more exp is gained per battle.
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
                gameStatus = player.takeDamage(enemyAttack.getAttackAmount()
                        - playerDefense.getDefenseAmount());
                if (gameStatus == 1) {
                    return 2;
                }
                System.out.println(enemyAttack.getMessage());
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
                        gameStatus = player.takeDamage(enemySkillAttack.getAttackAmount()
                                - player.defend().getDefenseAmount());
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
                System.err.println("Invalid choice");
                break;
        }
        return gameStatus;
    }

}