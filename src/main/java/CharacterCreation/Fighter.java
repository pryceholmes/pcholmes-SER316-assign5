package CharacterCreation;

public class Fighter implements PlayerCharacter {


    private int attackPoints;
    private int defensePoints;
    private int healPoints;
    private int speed;
    private int health;
    private int MAX_HEALTH;
    private int exp;

    private int level;

    // TODO: Add a character type

    public Fighter() {
        // initialize the attack points to 25 for a fighter
        attackPoints = 25;

        // initialize the defense points to 15 for a fighter
        defensePoints = 15;

        // initialize the heal points to 15 for a fighter
        healPoints = 15;

        // initialize the speed to 10 for a fighter
        speed = 10;

        // initialize the Max health to 100 for a fighter
        MAX_HEALTH = 100;
        health = MAX_HEALTH;

        // initialize the experience to 0 for a fighter
        exp = 0;
    }

    @Override
    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public int getDefensePoints() {
        return defensePoints;
    }

    @Override
    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    @Override
    public int getHealPoints() {
        return healPoints;
    }

    @Override
    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    @Override
    public void setMAX_HEALTH(int MAX_HEALTH) {
        this.MAX_HEALTH = MAX_HEALTH;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public void levelUp() {
        // increase the level by 1
        level++;

        // increase the attack points by 8
        attackPoints += 8;

        // increase the defense points by 5
        defensePoints += 5;

        // increase the heal points by 5
        healPoints += 5;

        // increase the max health by 15
        MAX_HEALTH += 15;
        health = MAX_HEALTH;
    }

    @Override
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

    //TODO implement these methods when enemies have been created
    @Override
    public void attack() {
        System.out.println("Fighter attacks the enemy");
    }

    @Override
    public void defend() {
        System.out.println("Fighter defends the player");
    }

    @Override
    public void heal() {
        System.out.println("Fighter heals the player");
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Fighter takes damage");
    }

    @Override
    public void doSkill() {
        System.out.println("Fighter does an attack with double damage for one turn");
    }
}
