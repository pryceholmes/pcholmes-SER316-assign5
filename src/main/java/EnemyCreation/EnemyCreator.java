package EnemyCreation;

abstract public class EnemyCreator {

    /**
     * create a new Enemy
     * @param level the current floor level
     * @return a new Enemy
     */
    public abstract Enemy createEnemy(int level);

}
