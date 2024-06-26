package EnemyCreation;

public class MediumEnemy extends Enemy {
    public MediumEnemy() {
        //TODO: init enemies depending on current game floor
    }

    // TODO: Implement these methods
    @Override
    public void attack() {
        System.out.println("Medium enemy attacks!");
    }

    @Override
    public void defend() {
        System.out.println("Medium enemy defends!");
    }

    @Override
    public void heal() {
        System.out.println("Medium enemy heals!");
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Medium enemy takes damage!");
    }

    @Override
    public void doSkill() {
        System.out.println("Medium enemy uses a skill!");
    }

}
