package enemycreation;

import java.util.Random;

public class EasyEnemyCreator extends EnemyCreator {

    @Override
    public Enemy createEnemy(int level, Random rand) {
        return new EasyEnemy(level, rand);
    }
}
