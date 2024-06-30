package CharacterCreation;

import Actions.*;


import java.util.Random;

public class Fighter extends PlayerCharacter {

    // TODO: Add a character type

    public Fighter() {
        // initialize the attack points to 25 for a fighter
        this.setAttackPoints(25);

        // initialize the defense points to 15 for a fighter
        this.setDefensePoints(15);

        // initialize the heal points to 15 for a fighter
        this.setHealPoints(15);

        // initialize the speed to 10 for a fighter
        this.setSpeed(10);

        // initialize the Max health to 100 for a fighter
        this.setMaxHealth(100);
        this.setHealth(this.getMaxHealth());

        // initialize the experience to 0 for a fighter
        this.setExp(0);
    }

    @Override
    public void levelUp() {
        // increase the level by 1
        this.setLevel(this.getLevel() + 1);

        // increase the attack points by 8
        this.setAttackPoints(this.getAttackPoints() + 8);

        // increase the defense points by 5
        this.setDefensePoints(this.getDefensePoints() + 5);

        // increase the heal points by 5
        this.setHealPoints(this.getHealPoints() + 5);

        // increase the max health by 15
        this.setMaxHealth(this.getMaxHealth() + 15);
        this.setHealth(this.getMaxHealth());
    }

    /**
     * The fighter's skill is to attack with a 25% of 2x damage.
     * @return the action that the fighter will take
     */
    @Override
    public Action doSkill() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 25) {
            return new Attack((this.getAttackPoints() * 2),
                    "Player uses a skill! Their skill dealt an attack with 2x damage!");
        } else {
            return new Attack(0,
                    "Player uses a skill and tried to deal an attack but missed!");
        }
    }
}
