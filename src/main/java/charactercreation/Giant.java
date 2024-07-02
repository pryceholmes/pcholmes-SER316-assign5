package charactercreation;

import actions.Action;
import actions.Attack;
import actions.Defense;
import actions.Heal;
import java.util.Random;

/**
 * The Giant class is a concrete class that represents a Giant character in the game (Factory Pattern).
 */
public class Giant extends PlayerCharacter {

    /**
     * Constructor for Giant class.
     * @param rand Random Object Generator
     */
    public Giant(Random rand) {
        // initialize the attack points to 25 for a giant
        this.setAttackPoints(25);

        // initialize the defense points to 25 for a giant
        this.setDefensePoints(25);

        // initialize the heal points to 5 for a giant
        this.setHealPoints(5);

        // initialize the Max health to 150 for a giant
        this.setMaxHealth(150);
        this.setHealth(this.getMaxHealth());

        // initialize the speed to 5 for a giant
        this.setSpeed(5);

        // initialize the experience to 0 for a giant
        this.setExp(0);

        // Set the random Object
        this.rand = rand;
    }

    @Override
    public Attack attack() {
        return super.attack();
    }

    @Override
    public Defense defend() {
        return super.defend();
    }

    @Override
    public Heal heal() {
        return super.heal();
    }

    @Override
    public void levelUp() {
        // increase the level by 1
        this.setLevel(this.getLevel() + 1);

        // increase the attack points by 7
        this.setAttackPoints(this.getAttackPoints() + 7);

        // increase the defense points by 7
        this.setDefensePoints(this.getDefensePoints() + 7);

        // increase the heal points by 2
        this.setHealPoints(this.getHealPoints() + 2);

        // increase the speed by 5
        this.setSpeed(this.getSpeed() + 5);

        // increase the max health by 10
        this.setMaxHealth(this.getMaxHealth() + 10);
        this.setHealth(this.getMaxHealth());

        this.setExp(0);

    }

    /**
     * The giant's skill is to rage, attacking with 3x damage.
     */
    @Override
    public Action doSkill() {
        Attack temp = super.attack();
        temp.setAttackAmount(temp.getAttackAmount() * 3);
        return temp;
    }

}
