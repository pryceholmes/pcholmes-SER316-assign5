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
     * The medium enemy's skill is to attack with a 50% chance of 1.75x damage.
     */
    @Override
    public Action doSkill() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 50) {
            return new Attack((int) (this.getAttackPoints() * 1.75), "Medium enemy uses skill and attacks with 1.75x damage!");
        } else {
            return new Attack(this.getAttackPoints(), "Medium enemy uses skill and attacks with normal damage!");
        }

    }

}
