package EnemyCreation;

import Actions.*;


import java.util.Random;


public class EasyEnemy extends Enemy {
    public EasyEnemy(int level) {
        EnemyConstants constants = EnemyConstants.getInstance();
        this.setAttackPoints(constants.getValue("EasyAttackPoints") + (int) (level*1.5));
        this.setDefensePoints(constants.getValue("EasyDefensePoints") + (int) (level*1.5));
        this.setSpeed(constants.getValue("EasySpeed") + (int) (level*1.5));
        this.setMaxHealth(constants.getValue("EasyMaxHealth") + (int) (level*1.5));
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public Attack attack() {
        Random rand = new Random();
        int attackAmount = rand.nextInt(this.getAttackPoints()) + 1;
        if (attackAmount < this.getAttackPoints()*0.25) {
            attackAmount = 0;
        }
        if (attackAmount == 0) {
            return new Attack(attackAmount, "Easy enemy attacks but misses!");
        }
        String message = "Easy enemy attacks with + " + attackAmount + " attack points!";
        return new Attack(attackAmount, message);

    }

    @Override
    public Defense defend() {
        Random rand = new Random();
        int defenseAmount = rand.nextInt(this.getDefensePoints()) + 1;
        return new Defense(defenseAmount, "Easy enemy defends with " + defenseAmount + " defense points!");
    }

    @Override
    public Heal heal() {
        Random rand = new Random();
        int healAmount;
        try {
            healAmount = rand.nextInt(this.getMaxHealth() - this.getHealth()) + 1;
        } catch (IllegalArgumentException e) {
            healAmount = 0;
        }
        this.setHealth(this.getHealth() + healAmount);
        return new Heal(healAmount, "Easy enemy heals by " + healAmount + " health points");
    }

    @Override
    public int takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() < 0) {
            this.setHealth(0);
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * The easy enemy's skill is to attack with a 5% chance of 1.5x damage
     */
    @Override
    public Action doSkill() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 5) {
            return new Attack((int) (this.getAttackPoints() * 1.5),
                    "Easy enemy uses a skill! Their skill dealt an attack with 1.5x damage!");
        } else {
            return new Attack(0,
                    "Easy Enemy uses a skill and tried to deal an attack but missed!");
        }

    }

}
