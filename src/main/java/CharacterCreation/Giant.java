package CharacterCreation;

import Actions.*;

import java.util.Random;

public class Giant extends PlayerCharacter {
    //TODO add a character type

    int cooldown = 0;

    public Giant() {
        // initialize the attack points to 25 for a giant
        this.setAttackPoints(25);

        // initialize the defense points to 25 for a giant
        this.setDefensePoints(25);

        // initialize the heal points to 5 for a giant
        this.setHealPoints(5);

        // initialize the Max health to 150 for a giant
        this.setMaxHealth(150);
        this.setHealth(this.getMaxHealth());

        // initialize the experience to 0 for a giant
        this.setExp(0);
    }

    @Override
    public Attack attack() {
        checkCooldown();
        return super.attack();
    }

    @Override
    public Defense defend() {
        checkCooldown();
        return super.defend();
    }

    @Override
    public Heal heal() {
        checkCooldown();
        return super.heal();
    }

    @Override
    public void levelUp() {
        // increase the attack points by 7
        this.setAttackPoints(this.getAttackPoints() + 7);

        // increase the defense points by 7
        this.setDefensePoints(this.getDefensePoints() + 7);

        // increase the heal points by 2
        this.setHealPoints(this.getHealPoints() + 2);

        // increase the max health by 10
        this.setMaxHealth(this.getMaxHealth() + 10);
        this.setHealth(this.getMaxHealth());
    }

    /**
     * The giant's skill is to rage, increasing attack by 25% and defense by 25% for two turns.
     */
    @Override
    public Action doSkill() {
        cooldown = 2;
        this.setAttackPoints((int) (this.getAttackPoints() * 1.25));
        this.setDefensePoints((int) (this.getDefensePoints() * 1.25));
        return new Attack(0, "Giant rages, increasing attack and defense by 25% for two turns.");
    }

    public void checkCooldown() {
        if (cooldown > 0) {
            cooldown--;
            if (cooldown == 0) {
                this.setAttackPoints((int) (this.getAttackPoints() / 1.25));
                this.setDefensePoints((int) (this.getDefensePoints() / 1.25));
            }
        }
    }
}
