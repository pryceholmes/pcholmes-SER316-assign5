package EnemyCreation;

import Actions.Action;
import Actions.Attack;
import Actions.Defense;
import Actions.Heal;

import java.util.Random;

public class MediumEnemy extends Enemy {
    public MediumEnemy(int level) {
        EnemyConstants constants = EnemyConstants.getInstance();
        this.setAttackPoints(constants.getValue("MediumAttackPoints") + (int) (level*1.8));
        this.setDefensePoints(constants.getValue("MediumDefensePoints") + (int) (level*1.8));
        this.setSpeed(constants.getValue("MediumSpeed") + (int) (level*1.8));
        this.setMaxHealth(constants.getValue("MediumMaxHealth") + (int) (level*1.8));
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public Attack attack() {
        Random rand = new Random();
        int attackAmount = rand.nextInt(this.getAttackPoints()) + 1;
        if (attackAmount < this.getAttackPoints()*0.15) {
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
        Random rand = new Random();
        int defenseAmount = rand.nextInt(this.getDefensePoints()) + 1;
        return new Defense(defenseAmount, "Medium enemy defends with " + defenseAmount + " defense points!");
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
        return new Heal(healAmount, "Medium enemy heals by " + healAmount + " health points");
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
     * The medium enemy's skill is to defend with a 75% chance of 2x defense
     */
    @Override
    public Action doSkill() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 75) {
            return new Defense((this.getDefensePoints() * 2),
                    "Medium enemy uses a skill! Their skill defends with 2x defense!");
        } else {
            return new Defense(0,
                    "Medium Enemy uses a skill and tried to use a defense but missed!");
        }

    }

}
