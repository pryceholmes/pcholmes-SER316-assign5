package enemycreation;

import actions.Action;
import actions.Attack;
import actions.Defense;
import actions.Heal;

import java.util.Random;

public abstract class Enemy {
    private int attackPoints;
    private int defensePoints;
    private int speed;
    private int health;
    private int maxHealth;
    private int healCooldown;
    protected Random rand;

    /**
     * Constructor for the Enemy class.
     *
     * @param rand the random object to use
     */
    public Enemy(Random rand) {
        this.rand = rand;
    }

    /**
     * get this enemy's attack points.
     *
     * @return attackPoints
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * set this enemy's attack points.
     *
     * @param attackPoints the attackPoints to set
     */
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    /**
     * get this enemy's defense points.
     *
     * @return defensePoints
     */
    public int getDefensePoints() {
        return defensePoints;
    }

    /**
     * set this enemy's defense points.
     *
     * @param defensePoints the defensePoints to set
     */
    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    /**
     * get this enemy's speed.
     *
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * set this enemy's speed.
     *
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * get this enemy's health.
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * set this enemy's health.
     *
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * get this enemy's heal cooldown.
     *
     * @return healCooldown the healCooldown to get
     */
    public int getHealCooldown() {
        return healCooldown;
    }

    /**
     * set this enemy's heal cooldown.
     *
     * @param healCooldown the healCooldown to set
     */
    public void setHealCooldown(int healCooldown) {
        this.healCooldown = healCooldown;
    }

    /**
     * get this enemy's max health.
     *
     * @return maxHealth the maxHealth to get
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * set this enemy's max health.
     *
     * @param maxHealth the maxHealth to set
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * attack a character.
     */
    public abstract Attack attack();

    /**
     * defend against a character.
     */
    public abstract Defense defend();

    /**
     * heal this enemy.
     */
    public abstract Heal heal();

    /**
     * take damage, return 1 if dead, 0 if alive.
     *
     * @param damage the damage to take
     * @return 1 if dead, 0 if alive
     */
    public abstract int takeDamage(int damage);

    /**
     * do a skill.
     */
    public abstract Action doSkill();


}
