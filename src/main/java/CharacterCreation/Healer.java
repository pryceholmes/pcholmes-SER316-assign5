package CharacterCreation;

import Actions.*;

import java.util.Random;

public class Healer extends PlayerCharacter {

    //TODO add a character type

    public Healer() {
        // initialize the attack points to 15 for a healer
        this.setAttackPoints(15);

        // initialize the defense points to 25 for a healer
        this.setDefensePoints(25);

        // initialize the heal points to 25 for a healer
        this.setHealPoints(25);

        // initialize the Max health to 100 for a healer
        this.setMaxHealth(100);
        this.setHealth(this.getMaxHealth());

        // initialize the experience to 0 for a healer
        this.setExp(0);
    }

    @Override
    public void levelUp() {
        // increase the attack points by 5
        this.setAttackPoints(this.getAttackPoints() + 5);

        // increase the defense points by 5
        this.setDefensePoints(this.getDefensePoints() + 5);

        // increase the heal points by 8
        this.setHealPoints(this.getHealPoints() + 8);

        // increase the max health by 15
        this.setMaxHealth(this.getMaxHealth() + 15);
        this.setHealth(this.getMaxHealth());
    }

    /**
     * Healer's skill is a 25% chance to heal to 1.5 max health. If it misses, a normal heal action is done.
     *
     * @return the heal action done.
     */
    @Override
    public Action doSkill() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        int healAmount;
        if (chance < 25) {
            healAmount = (int) (this.getMaxHealth() * 1.5) - this.getHealth();
            this.setHealth((int) (this.getMaxHealth() * 1.5));
            return new Heal(healAmount, "Player heals by " + healAmount + " health points using a skill");
        } else {
            return super.heal();
        }
    }
}
