package EnemyCreation;

public class EasyEnemyCreator extends EnemyCreator {

    @Override
    public Enemy createEnemy(int level) {
        return new EasyEnemy(level);
    }
}
