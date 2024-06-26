package EnemyCreation;

public class EasyEnemy extends Enemy {
    public EasyEnemy() {
        //TODO: init enemies depending on current game floor
    }

    // TODO: Implement these methods
    @Override
    public void attack() {
        System.out.println("Easy enemy attacks!");
    }

    @Override
    public void defend() {
        System.out.println("Easy enemy defends!");
    }

    @Override
    public void heal() {
        System.out.println("Easy enemy heals!");
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Easy enemy takes damage!");
    }

    @Override
    public void doSkill() {
        System.out.println("Easy enemy uses a skill!");
    }

}
