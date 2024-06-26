package EnemyCreation;

abstract public class Enemy {
    private int attackPoints;
    private int defensePoints;
    private int healPoints;
    private int speed;
    private int health;
    private int MAX_HEALTH;

    /**
     * get this enemy's attack points
     * @return attackPoints
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * set this enemy's attack points
     * @param attackPoints the attackPoints to set
     */
    public void setAttackPoints(int attackPoints) {this.attackPoints = attackPoints;}

    /**
     * get this enemy's defense points
     * @return defensePoints
     */
    public int getDefensePoints() {return defensePoints;}

    /**
     * set this enemy's defense points
     * @param defensePoints the defensePoints to set
     */
    public void setDefensePoints(int defensePoints) {this.defensePoints = defensePoints;}

    /**
     * get this enemy's heal points
     * @return healPoints
     */
    public int getHealPoints() {return healPoints;}

    /**
     * set this enemy's heal points
     * @param healPoints the healPoints to set
     */
    public void setHealPoints(int healPoints) {this.healPoints = healPoints;}

    /**
     * get this enemy's speed
     * @return speed
     */
    public int getSpeed() {return speed;}

    /**
     * set this enemy's speed
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {this.speed = speed;}

    /**
     * get this enemy's health
     * @return health
     */
    public int getHealth() {return health;}

    /**
     * set this enemy's health
     * @param health the health to set
     */
    public void setHealth(int health) {this.health = health;}

    /**
     * get this enemy's max health
     * @return MAX_HEALTH
     */
    public int getMaxHealth() {return MAX_HEALTH;}

    /**
     * set this enemy's max health
     * @param MAX_HEALTH the MAX_HEALTH to set
     */
    public void setMaxHealth(int MAX_HEALTH) {this.MAX_HEALTH = MAX_HEALTH;}

    /**
     * attack a character
     */
    abstract public void attack();

    /**
     * defend against a character
     */
    abstract public void defend();

    /**
     * heal this enemy
     */
    abstract public void heal();

    /**
     * take damage
     * @param damage the damage to take
     */
    abstract public void takeDamage(int damage);

    /**
     * do a skill
     */
    abstract public void doSkill();



}
