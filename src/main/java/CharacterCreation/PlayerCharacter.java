package CharacterCreation;

import Actions.*;

import java.util.Random;


abstract public class PlayerCharacter {
    /**
     * This character's attack points
     */
    private int attackPoints;

    /**
     * This character's defense points
     */
    private int defensePoints;

    /**
     * This character's heal points
     */
    private int healPoints;

    /**
     * This character's speed
     */
    private int speed;

    /**
     * This character's health
     */
    private int health;

    /**
     * This character's maximum health
     */
    private int MAX_HEALTH;

    /**
     * This character's experience points
     */
    private int exp;

    /**
     * This character's level
     */
    private int level;

    /**
     * get this character's attack points
     * @return attackPoints
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * set this character's attack points
     * @param attackPoints the attackPoints to set
     */
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    /**
     * get this character's defense points
     * @return defensePoints
     */
    public int getDefensePoints() {
        return defensePoints;
    }

    /**
     * set this character's defense points
     * @param defensePoints the defensePoints to set
     */
    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    /**
     * get this character's heal points
     * @return healPoints
     */
    public int getHealPoints() {
        return healPoints;
    }

    /**
     * set this character's heal points
     * @param healPoints the healPoints to set
     */
    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    /**
     * set this character's speed
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * get this character's speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * get this character's health
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * set this character's health
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * get this character's max health
     * @return MAX_HEALTH
     */
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    /**
     * set this character's max health
     * @param MaxHealth the MAX_HEALTH to set
     */
    public void setMaxHealth(int MaxHealth) {
        this.MAX_HEALTH = MaxHealth;
    }

    /**
     * get this character's experience points
     * @return exp
     */
    public int getExp() {
        return exp;
    }

    /**
     * set this character's experience points
     * @param exp the exp to set
     */
    protected void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * gain experience points
     * @param exp the exp to set
     */
    public void gainExp(int exp) {
        // increase the experience by the amount of exp
        this.exp += exp;

        // if the experience is greater than 100
        if (this.exp >= 100) {
            // call the levelUp method
            levelUp();

            // set the experience to 0
            this.exp = 0;
        }
    }

    /**
     * get this character's level
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * set this character's level
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * level up this character
     */
    abstract public void levelUp();

    /**
     * attack an enemy
     * @return the attack
     */
    public Attack attack() {
        Random rand = new Random();
        int attackAmount = rand.nextInt(this.getAttackPoints()) + 1;
        if (attackAmount < this.getAttackPoints() * 0.10) {
            attackAmount = 0;
        }
        if (attackAmount == 0) {
            return new Attack(attackAmount, "Player attacks but misses!");
        }
        String message = "Player attacks with + " + attackAmount + " attack points!";
        return new Attack(attackAmount, message);
    }

    /**
     * defend against an enemy
     * @return the defense
     */
    public Defense defend() {
        Random rand = new Random();
        int defenseAmount = rand.nextInt(this.getDefensePoints()) + 1;
        return new Defense(defenseAmount, "Player defends with " + defenseAmount + " defense points!");
    }

    /**
     * heal this character
     * @return the heal object
     */
    public Heal heal() {
        Random rand = new Random();
        int healAmount;
        try {
            healAmount = rand.nextInt(this.getMaxHealth() - this.getHealth()) + 1;
        } catch (IllegalArgumentException e) {
            healAmount = 0;
        }
        this.setHealth(this.getHealth() + healAmount);
        return new Heal(healAmount, "Player heals by " + healAmount + " health points");
    }

    /**
     * take damage
     * @param damage the damage to take
     * @return 1 if the character is dead, 0 otherwise
     */
    public int takeDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        }

        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() < 0) {
            this.setHealth(0);
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * do a skill
     * @return the action
     */
    abstract public Action doSkill();



}
