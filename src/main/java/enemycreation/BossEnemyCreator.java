package enemycreation;

import java.util.Random;

public class BossEnemyCreator extends EnemyCreator {

    @Override
    public Enemy createEnemy(int level, Random rand) {
        return new BossEnemy(level, rand);
    }
}
