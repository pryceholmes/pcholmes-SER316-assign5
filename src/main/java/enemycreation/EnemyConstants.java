package enemycreation;

import java.util.HashMap;

/**
 * A class that contains the constants for the enemies.
 * This class is a singleton pattern and used intertwined with the
 * factory pattern for enemy creation.
 */
public class EnemyConstants {
    private static EnemyConstants instance;
    private final HashMap<String, Integer> enemyStats;

    /**
     * Constructor for the EnemyConstants class.
     */
    private EnemyConstants() {
        enemyStats = new HashMap<>();

        enemyStats.put("EasyAttackPoints", 10);
        enemyStats.put("EasyDefensePoints", 5);
        enemyStats.put("EasySpeed", 7);
        enemyStats.put("EasyMaxHealth", 50);

        enemyStats.put("MediumAttackPoints", 15);
        enemyStats.put("MediumDefensePoints", 15);
        enemyStats.put("MediumSpeed", 9);
        enemyStats.put("MediumMaxHealth", 55);

        enemyStats.put("BossAttackPoints", 25);
        enemyStats.put("BossDefensePoints", 25);
        enemyStats.put("BossSpeed", 15);
        enemyStats.put("BossMaxHealth", 75);
    }

    /**
     * Returns the instance of the EnemyConstants class.
     * @return the instance of the EnemyConstants class
     */
    public static EnemyConstants getInstance() {
        if (instance == null) {
            instance = new EnemyConstants();
        }
        return instance;
    }

    /**
     * Returns the value of the given key.
     * @param key the key to get the value of
     * @return the value of the given key
     */
    public int getValue(String key) {
        return enemyStats.get(key);
    }
}
