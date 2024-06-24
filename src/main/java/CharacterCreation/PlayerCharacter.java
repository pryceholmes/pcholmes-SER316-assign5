package CharacterCreation;

public interface PlayerCharacter {

    /**
     * get this character's attack points
     * @return attackPoints
     */
    public int getAttackPoints();

    /**
     * set this character's attack points
     * @param attackPoints the attackPoints to set
     */
    public void setAttackPoints(int attackPoints);

    /**
     * get this character's defense points
     * @return defensePoints
     */
    public int getDefensePoints();

    /**
     * set this character's defense points
     * @param defensePoints the defensePoints to set
     */
    public void setDefensePoints(int defensePoints);

    /**
     * get this character's heal points
     * @return healPoints
     */
    public int getHealPoints();

    /**
     * set this character's heal points
     * @param healPoints the healPoints to set
     */
    public void setHealPoints(int healPoints);

    /**
     * get this character's health
     * @return health
     */
    public int getHealth();

    /**
     * set this character's health
     * @param health the health to set
     */
    public void setHealth(int health);

    /**
     * get this character's max health
     * @return MAX_HEALTH
     */
    public int getMAX_HEALTH();

    /**
     * set this character's max health
     * @param MAX_HEALTH the MAX_HEALTH to set
     */
    public void setMAX_HEALTH(int MAX_HEALTH);

    /**
     * get this character's experience points
     * @return exp
     */
    public int getExp();

    /**
     * level up this character
     */
    public void levelUp();

    /**
     * get this character's level
     * @return level
     */
    public int getLevel();

    /**
     * set this character's level
     * @param level the level to set
     */
    public void setLevel(int level);

    /**
     * gain experience points
     * @param exp the exp to set
     */
    public void gainExp(int exp);

    /**
     * attack an enemy
     */
    public void attack(); //TODO add enemy

    /**
     * defend against an enemy
     */
    public void defend(); //TODO add enemy

    /**
     * heal this character
     */
    public void heal();

    /**
     * take damage
     * @param damage the damage to take
     */
    public void takeDamage(int damage);

    /**
     * do a skill
     */
    public void doSkill();



}
