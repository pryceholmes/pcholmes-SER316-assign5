package charactercreation;

import actions.Action;
import actions.Heal;
import java.util.Random;

/**
 * The Healer class is a concrete class that represents a Healer character in the game (Factory Pattern).
 */
public class Healer extends PlayerCharacter {

    /**
     * Constructor for Healer class.
     * @param rand Random Object Generator
     */
    public Healer(Random rand) {
        // initialize the attack points to 15 for a healer
        this.setAttackPoints(15);

        // initialize the defense points to 25 for a healer
        this.setDefensePoints(25);

        // initialize the heal points to 25 for a healer
        this.setHealPoints(25);

        // initialize the Max health to 100 for a healer
        this.setMaxHealth(100);
        this.setHealth(this.getMaxHealth());

        // initialize the speed to 15 for a healer
        this.setSpeed(15);

        // initialize the experience to 0 for a healer
        this.setExp(0);

        // Set the random Object
        this.rand = rand;
    }

    @Override
    public void levelUp() {
        // increase the level by 1
        this.setLevel(this.getLevel() + 1);

        // increase the attack points by 5
        this.setAttackPoints(this.getAttackPoints() + 5);

        // increase the defense points by 5
        this.setDefensePoints(this.getDefensePoints() + 5);

        // increase the heal points by 8
        this.setHealPoints(this.getHealPoints() + 8);

        // increase the speed by 5
        this.setSpeed(this.getSpeed() + 5);

        // increase the max health by 15
        this.setMaxHealth(this.getMaxHealth() + 15);
        this.setHealth(this.getMaxHealth());

        this.setExp(0);
    }

    /**
     * Healer's skill is a 25% chance to heal to 1.5 max health.
     * If it misses, a normal heal action is done.
     *
     * @return the heal action done.
     */
    @Override
    public Action doSkill() {
        int chance = rand.nextInt(100);
        int healAmount;
        if (chance < 25) {
            healAmount = (int) (this.getMaxHealth() * 1.5) - this.getHealth();
            this.setHealth((int) (this.getMaxHealth() * 1.5));
            return new Heal(healAmount, "Player heals by "
                    + healAmount + " health points using a skill");
        } else {
            return super.heal();
        }
    }
}
