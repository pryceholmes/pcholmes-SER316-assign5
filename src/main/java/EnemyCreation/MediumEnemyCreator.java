package EnemyCreation;

public class MediumEnemyCreator extends EnemyCreator {

    @Override
    public Enemy createEnemy(int level) {
        return new MediumEnemy(level);
    }
}
