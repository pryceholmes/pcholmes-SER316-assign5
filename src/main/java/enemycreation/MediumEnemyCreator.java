package enemycreation;

import java.util.Random;

public class MediumEnemyCreator extends EnemyCreator {

    @Override
    public Enemy createEnemy(int level, Random rand) {
        return new MediumEnemy(level, rand);
    }
}
