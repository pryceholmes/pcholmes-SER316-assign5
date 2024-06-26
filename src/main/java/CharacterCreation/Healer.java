package CharacterCreation;

public class Healer implements PlayerCharacter {

    private int attackPoints;
    private int defensePoints;
    private int healPoints;
    private int speed;
    private int health;
    private int MAX_HEALTH;
    private int exp;
    private int level;

    //TODO add a character type

    public Healer() {
        // initialize the attack points to 15 for a healer
        attackPoints = 15;

        // initialize the defense points to 25 for a healer
        defensePoints = 15;

        // initialize the heal points to 25 for a healer
        healPoints = 25;

        // initialize the Max health to 100 for a healer
        MAX_HEALTH = 115;
        health = MAX_HEALTH;

        // initialize the experience to 0 for a healer
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
    public int getExp() {
        return exp;
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
    public void levelUp() {
        // increase the attack points by 5
        attackPoints += 5;

        // increase the defense points by 5
        defensePoints += 5;

        // increase the heal points by 8
        healPoints += 8;

        // increase the max health by 15
        MAX_HEALTH += 15;
        health = MAX_HEALTH;
    }

    @Override
    public void gainExp(int exp) {
        this.exp += exp;
        if (this.exp >= 100) {
            levelUp();
            this.exp = 0;
        }
    }

    @Override
    public void attack() {
        System.out.println("Healer attacks");
    }

    @Override
    public void defend() {
        System.out.println("Healer defends");
    }

    @Override
    public void heal() {
        System.out.println("Healer heals themself");
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Healer takes damage");
    }

    @Override
    public void doSkill() {
        System.out.println("Healer heals themself to 1.5x MAXHEALTH");
    }
}
