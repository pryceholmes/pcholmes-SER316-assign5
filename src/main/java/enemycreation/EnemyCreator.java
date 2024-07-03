package enemycreation;

import java.util.Random;

public abstract class EnemyCreator {

    /**
     * create a new Enemy.
     * @param level the current floor level
     * @param rand the random object generator
     * @return a new Enemy
     */
    public abstract Enemy createEnemy(int level, Random rand);

}
