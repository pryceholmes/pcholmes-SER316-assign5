package EnemyCreation;

public class BossEnemyCreator extends EnemyCreator {

    @Override
    public Enemy createEnemy(int level) {
        return new BossEnemy(level);
    }
}
