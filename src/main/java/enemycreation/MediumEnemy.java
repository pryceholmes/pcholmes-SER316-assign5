package enemycreation;

import actions.Action;
import actions.Attack;
import actions.Defense;
import actions.Heal;

import java.util.Random;

public class MediumEnemy extends Enemy {

    /**
     * Constructor for the MediumEnemy class.
     * @param level the current floor level
     * @param rand the random object generator
     */
    public MediumEnemy(int level, Random rand) {
        super(rand);
        // Get default values from singleton pattern class.
        EnemyConstants constants = EnemyConstants.getInstance();

        // Requirement 8: Enemy stats scale with level. Enemies on higher floors
        // are stronger than enemies on lower floors.
        this.setAttackPoints(constants.getValue("MediumAttackPoints")
                + (int) (level * 0.8));
        this.setDefensePoints(constants.getValue("MediumDefensePoints")
                + (int) (level * 0.8));
        this.setSpeed(constants.getValue("MediumSpeed")
                + (int) (level * 0.8));
        this.setMaxHealth(constants.getValue("MediumMaxHealth")
                + (int) (level * 0.8));
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public Attack attack() {
        if (this.getHealCooldown() != 0) {
            this.setHealCooldown(this.getHealCooldown() - 1);
        }
        int attackAmount = rand.nextInt(this.getAttackPoints()) + 1;
        if (attackAmount < this.getAttackPoints() * 0.15) {
            attackAmount = 0;
        }
        if (attackAmount == 0) {
            return new Attack(attackAmount, "Medium enemy attacks but misses!");
        }
        String message = "Medium enemy attacks with + " + attackAmount + " attack points!";
        return new Attack(attackAmount, message);

    }

    @Override
    public Defense defend() {
        if (this.getHealCooldown() != 0) {
            this.setHealCooldown(this.getHealCooldown() - 1);
        }
        int defenseAmount = rand.nextInt(this.getDefensePoints()) + 1;
        if (defenseAmount < this.getDefensePoints() * 0.45) {
            defenseAmount = 0;
        }
        return new Defense(defenseAmount, "Medium enemy defends with "
                + defenseAmount + " defense points!");
    }

    @Override
    public Heal heal() {
        if (this.getHealCooldown() != 0) {
            this.setHealCooldown(this.getHealCooldown() - 1);
            return new Heal(0, "Medium enemy tried to heal but failed!");
        } else {
            int healAmount;
            try {
                healAmount = rand.nextInt(this.getMaxHealth() - this.getHealth()) + 1;
            } catch (IllegalArgumentException e) {
                healAmount = 0;
            }
            this.setHealth(this.getHealth() + healAmount);
            this.setHealCooldown(3);
            return new Heal(healAmount, "Medium enemy heals by " + healAmount + " health points");
        }
    }

    @Override
    public int takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() <= 0) {
            this.setHealth(0);
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * The medium enemy's skill is to attack with a 50% chance of 1.75x damage.
     */
    @Override
    public Action doSkill() {
        if (this.getHealCooldown() != 0) {
            this.setHealCooldown(this.getHealCooldown() - 1);
        }
        int chance = rand.nextInt(100);
        if (chance < 50) {
            return new Attack((int) (this.getAttackPoints() * 1.75),
                    "Medium enemy uses skill and attacks with 1.75x damage!");
        } else {
            return new Attack(this.getAttackPoints(),
                    "Medium enemy uses skill and attacks with normal damage!");
        }

    }

}
