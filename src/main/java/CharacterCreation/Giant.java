package CharacterCreation;

public class Giant implements PlayerCharacter {
    private int attackPoints;
    private int defensePoints;
    private int healPoints;
    private int health;
    private int MAX_HEALTH;
    private int exp;
    private int level;

    //TODO add a character type

    public Giant() {
        // initialize the attack points to 25 for a healer
        attackPoints = 25;

        // initialize the defense points to 25 for a healer
        defensePoints = 25;

        // initialize the heal points to 5 for a healer
        healPoints = 5;

        // initialize the Max health to 150 for a healer
        MAX_HEALTH = 150;
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
        // increase the attack points by 7
        attackPoints += 7;

        // increase the defense points by 7
        defensePoints += 7;

        // increase the heal points by 2
        healPoints += 2;

        // increase the max health by 10
        MAX_HEALTH += 10;
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
        System.out.println("Giant attacks");
    }

    @Override
    public void defend() {
        System.out.println("Giant defends");
    }

    @Override
    public void heal() {
        System.out.println("Giant heals themself");
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Giant takes damage");
    }

    @Override
    public void doSkill() {
        System.out.println("Giant rages, attack +15 and defense +10 for 3 turns");
    }
}
