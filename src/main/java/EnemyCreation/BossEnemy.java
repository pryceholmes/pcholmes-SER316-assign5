package EnemyCreation;

import Actions.Action;
import Actions.Attack;
import Actions.Defense;
import Actions.Heal;

import java.util.Random;

public class BossEnemy extends Enemy{
    public BossEnemy(int level) {
        EnemyConstants constants = EnemyConstants.getInstance();
        this.setAttackPoints(constants.getValue("BossAttackPoints") + (level*2));
        this.setDefensePoints(constants.getValue("BossDefensePoints") + (level*2));
        this.setSpeed(constants.getValue("BossSpeed") + (level*2));
        this.setMaxHealth(constants.getValue("BosMaxHealth") + (level*2));
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public Attack attack() {
        Random rand = new Random();
        int attackAmount = rand.nextInt(this.getAttackPoints()) + 1;
        if (attackAmount < this.getAttackPoints()*0.5) {
            attackAmount = 0;
        }
        if (attackAmount == 0) {
            return new Attack(attackAmount, "Boss enemy attacks but misses!");
        }
        String message = "Boss enemy attacks with + " + attackAmount + " attack points!";
        return new Attack(attackAmount, message);

    }

    @Override
    public Defense defend() {
        Random rand = new Random();
        int defenseAmount = rand.nextInt(this.getDefensePoints()) + 1;
        return new Defense(defenseAmount, "Boss enemy defends with " + defenseAmount + " defense points!");
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
        return new Heal(healAmount, "Boss enemy heals by " + healAmount + " health points");
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
     * The boss enemies skill is they have a 25% chance of healing back to full health... good luck
     */
    @Override
    public Action doSkill() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 25) {
            this.setHealth(this.getMaxHealth());
            return new Heal(this.getMaxHealth()-this.getHealth(),
                    "Boss enemy uses a skill! The boss is back to max health!");
        } else {
            return new Heal(0,
                    "Boss Enemy uses a skill and tried to heal but failed!");
        }

    }
}
