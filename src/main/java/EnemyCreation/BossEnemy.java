package EnemyCreation;

public class BossEnemy extends Enemy{
    public BossEnemy() {
        //TODO: init enemies depending on current game floor
    }

    // TODO: Implement these methods
    @Override
    public void attack() {
        System.out.println("Boss enemy attacks!");
    }

    @Override
    public void defend() {
        System.out.println("Boss enemy defends!");
    }

    @Override
    public void heal() {
        System.out.println("Boss enemy heals!");
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Boss enemy takes damage!");
    }

    @Override
    public void doSkill() {
        System.out.println("Boss enemy uses a skill!");
    }
}
