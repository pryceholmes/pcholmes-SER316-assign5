package enemycreation;

import actions.Action;
import actions.Attack;
import actions.Defense;
import actions.Heal;

import java.util.Random;

public class BossEnemy extends Enemy {

    /**
     * Constructor for the BossEnemy class.
     * @param level the current floor level
     * @param rand the random object generator
     */
    public BossEnemy(int level, Random rand) {
        super(rand);
        // Get default values from singleton pattern class.
        EnemyConstants constants = EnemyConstants.getInstance();

        // Requirement 8: Enemy stats scale with level. Enemies on higher floors
        // are stronger than enemies on lower floors.
        this.setAttackPoints(constants.getValue("BossAttackPoints") + (int) (level * 0.8));
        this.setDefensePoints(constants.getValue("BossDefensePoints") + (int) (level * 0.8));
        this.setSpeed(constants.getValue("BossSpeed") + (int) (level * 0.8));
        this.setMaxHealth(constants.getValue("BossMaxHealth") + (int) (level * 0.8));
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public Attack attack() {
        if (this.getHealCooldown() != 0) {
            this.setHealCooldown(this.getHealCooldown() - 1);
        }
        int attackAmount = rand.nextInt(this.getAttackPoints()) + 1;
        if (attackAmount < this.getAttackPoints() * 0.5) {
            attackAmount = 0;
        }
        if (attackAmount == 0) {
            return new Attack(attackAmount,
                    "Boss enemy attacks but misses!");
        }
        String message = "Boss enemy attacks with + "
                + attackAmount + " attack points!";
        return new Attack(attackAmount, message);

    }

    @Override
    public Defense defend() {
        if (this.getHealCooldown() != 0) {
            this.setHealCooldown(this.getHealCooldown() - 1);
        }
        int defenseAmount = rand.nextInt(this.getDefensePoints()) + 1;
        if (defenseAmount < this.getDefensePoints() * 0.35) {
            defenseAmount = 0;
        }
        return new Defense(defenseAmount, "Boss enemy defends with "
                + defenseAmount + " defense points!");
    }

    @Override
    public Heal heal() {
        if (this.getHealCooldown() != 0) {
            this.setHealCooldown(this.getHealCooldown() - 1);
            return new Heal(0, "Boss enemy tried to heal but failed!");
        } else {
            int healAmount;
            try {
                healAmount = rand.nextInt(this.getMaxHealth()
                        - this.getHealth()) + 1;
            } catch (IllegalArgumentException e) {
                healAmount = 0;
            }
            this.setHealth(this.getHealth() + healAmount);
            this.setHealCooldown(2);
            return new Heal(healAmount, "Boss enemy heals by "
                    + healAmount + " health points");
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
     * The boss enemies skill is they have a 25% chance of healing back to full health... good luck.
     */
    @Override
    public Action doSkill() {
        if (this.getHealCooldown() != 0) {
            this.setHealCooldown(this.getHealCooldown() - 1);
        }
        int chance = rand.nextInt(100);
        if (chance < 25) {
            this.setHealth(this.getMaxHealth());
            return new Heal(this.getMaxHealth() - this.getHealth(),
                    "Boss enemy uses a skill! The boss is back to max health!");
        } else {
            return new Heal(0,
                    "Boss Enemy uses a skill and tried to heal but failed!");
        }

    }
}
