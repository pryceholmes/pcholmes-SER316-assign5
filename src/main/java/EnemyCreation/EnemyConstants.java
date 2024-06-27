package EnemyCreation;

import java.util.HashMap;

public class EnemyConstants {
    private static EnemyConstants instance;
    private final HashMap<String, Integer> EnemyStats;

    private EnemyConstants() {
        EnemyStats = new HashMap<>();

        EnemyStats.put("EasyAttackPoints", 10);
        EnemyStats.put("EasyDefensePoints", 10);
        EnemyStats.put("EasySpeed", 7);
        EnemyStats.put("EasyMaxHealth", 50);

        EnemyStats.put("MediumAttackPoints", 15);
        EnemyStats.put("MediumDefensePoints", 15);
        EnemyStats.put("MediumSpeed", 9);
        EnemyStats.put("MediumMaxHealth",75);

        EnemyStats.put("BossAttackPoints", 25);
        EnemyStats.put("BossDefensePoints", 25);
        EnemyStats.put("BossSpeed", 15);
        EnemyStats.put("BossMaxHealth", 100);
    }

   public static EnemyConstants getInstance() {
       if (instance == null) {
           instance = new EnemyConstants();
       }
       return instance;
   }

   public int getValue(String key) {
       return EnemyStats.get(key);
   }
}
