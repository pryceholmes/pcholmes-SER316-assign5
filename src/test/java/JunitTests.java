import static org.junit.Assert.assertEquals;

import actions.Attack;
import actions.Defense;
import actions.Heal;
import charactercreation.*;
import enemycreation.Enemy;
import enemycreation.MediumEnemyCreator;
import enemycreation.BossEnemyCreator;
import enemycreation.EasyEnemyCreator;
import enemycreation.EnemyCreator;
import org.junit.BeforeClass;
import org.junit.Test;
import states.Cycle1;
import states.Cycle2;
import states.Cycle3;
import states.Cycle4;
import states.State;

import java.util.Random;


public class JunitTests {

    private static Random rand;
    @BeforeClass
    public static void setup() {
        rand = new Random();
    }

    //////////////////////////////////////////
    // TEST CHARACTER CREATION
    //////////////////////////////////////////
    @Test
    public void testFighterAttackPoints() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assertEquals(25, fighter.getAttackPoints());
        fighter.setAttackPoints(50);
        assertEquals(50, fighter.getAttackPoints());
    }

    @Test
    public void testFighterDefensePoints() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assertEquals(15, fighter.getDefensePoints());
        fighter.setDefensePoints(30);
        assertEquals(30, fighter.getDefensePoints());
    }

    @Test
    public void testFighterHealPoints() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assertEquals(15, fighter.getHealPoints());
        fighter.setHealPoints(30);
        assertEquals(30, fighter.getHealPoints());
    }

    @Test
    public void testFighterSpeed() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assertEquals(10, fighter.getSpeed());
        fighter.setSpeed(20);
        assertEquals(20, fighter.getSpeed());
    }

    @Test
    public void testFighterMaxHealth() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assertEquals(100, fighter.getMaxHealth());
        fighter.setMaxHealth(200);
        assertEquals(200, fighter.getMaxHealth());
    }

    @Test
    public void testFighterHealth() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assertEquals(100, fighter.getHealth());
        fighter.setHealth(200);
        assertEquals(200, fighter.getHealth());
    }

    @Test
    public void testFighterLevel() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assertEquals(0, fighter.getLevel());
        fighter.setLevel(2);
        assertEquals(2, fighter.getLevel());
    }

    @Test
    public void testFighterExp() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assertEquals(0, fighter.getExp());
        fighter.gainExp(99);
        assertEquals(99, fighter.getExp());
    }

    @Test
    public void testFighterLevelUp() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        fighter.levelUp();
        assertEquals(1, fighter.getLevel());
    }

    @Test
    public void testPlayerAttack() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assert(fighter.attack() != null);
    }

    @Test
    public void testPlayerDefend() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assert(fighter.defend() != null);
    }

    @Test
    public void testPlayerHeal() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        assert(fighter.heal() != null);
    }

    @Test
    public void testPlayerTakeDamage() {
        CharacterCreator creator = new FighterCreator();
        Fighter fighter = (Fighter) creator.createCharacter(rand);
        int health = fighter.getHealth();
        fighter.takeDamage(10);
        assertEquals(health - 10, fighter.getHealth());
    }

    @Test
    public void testGiantAttackPoints() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        assertEquals(25, giant.getAttackPoints());
        giant.setAttackPoints(50);
        assertEquals(50, giant.getAttackPoints());
    }

    @Test
    public void testGiantDefensePoints() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        assertEquals(25, giant.getDefensePoints());
        giant.setDefensePoints(50);
        assertEquals(50, giant.getDefensePoints());
    }

    @Test
    public void testGiantHealPoints() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        assertEquals(5, giant.getHealPoints());
        giant.setHealPoints(10);
        assertEquals(10, giant.getHealPoints());
    }

    @Test
    public void testGiantSpeed() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        assertEquals(5, giant.getSpeed());
        giant.setSpeed(10);
        assertEquals(10, giant.getSpeed());
    }

    @Test
    public void testGiantMaxHealth() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        assertEquals(150, giant.getMaxHealth());
        giant.setMaxHealth(200);
        assertEquals(200, giant.getMaxHealth());
    }

    @Test
    public void testGiantHealth() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        assertEquals(150, giant.getHealth());
        giant.setHealth(200);
        assertEquals(200, giant.getHealth());
    }

    @Test
    public void testGiantLevel() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        assertEquals(0, giant.getLevel());
        giant.setLevel(2);
        assertEquals(2, giant.getLevel());
    }

    @Test
    public void testGiantExp() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        assertEquals(0, giant.getExp());
        giant.gainExp(99);
        assertEquals(99, giant.getExp());
    }

    @Test
    public void testGiantLevelUp() {
        CharacterCreator creator = new GiantCreator();
        Giant giant = (Giant) creator.createCharacter(rand);
        giant.levelUp();
        assertEquals(1, giant.getLevel());
    }

    @Test
    public void testHealerAttackPoints() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        assertEquals(15, healer.getAttackPoints());
        healer.setAttackPoints(30);
        assertEquals(30, healer.getAttackPoints());
    }

    @Test
    public void testHealerDefensePoints() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        assertEquals(25, healer.getDefensePoints());
        healer.setDefensePoints(50);
        assertEquals(50, healer.getDefensePoints());
    }

    @Test
    public void testHealerHealPoints() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        assertEquals(25, healer.getHealPoints());
        healer.setHealPoints(50);
        assertEquals(50, healer.getHealPoints());
    }

    @Test
    public void testHealerSpeed() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        assertEquals(15, healer.getSpeed());
        healer.setSpeed(30);
        assertEquals(30, healer.getSpeed());
    }

    @Test
    public void testHealerMaxHealth() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        assertEquals(100, healer.getMaxHealth());
        healer.setMaxHealth(200);
        assertEquals(200, healer.getMaxHealth());
    }

    @Test
    public void testHealerHealth() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        assertEquals(100, healer.getHealth());
        healer.setHealth(200);
        assertEquals(200, healer.getHealth());
    }

    @Test
    public void testHealerLevel() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        assertEquals(0, healer.getLevel());
        healer.setLevel(2);
        assertEquals(2, healer.getLevel());
    }

    @Test
    public void testHealerExp() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        assertEquals(0, healer.getExp());
        healer.gainExp(99);
        assertEquals(99, healer.getExp());
    }

    @Test
    public void testHealerLevelUp() {
        CharacterCreator creator = new HealerCreator();
        Healer healer = (Healer) creator.createCharacter(rand);
        healer.levelUp();
        assertEquals(1, healer.getLevel());
    }

    //////////////////////////////////////////
    // TEST ACTIONS
    //////////////////////////////////////////
    @Test
    public void testAttackAction() {
        Attack attack = new Attack(10, "This is a test attack!");
        assertEquals(10, attack.getAttackAmount());
        assertEquals("This is a test attack!", attack.getMessage());
    }

    @Test
    public void testDefenseAction() {
        Defense defense = new Defense(10, "This is a test defense!");
        assertEquals(10, defense.getDefenseAmount());
        assertEquals("This is a test defense!", defense.getMessage());
    }

    @Test
    public void testHealAction() {
        Heal heal = new Heal(10, "This is a test heal!");
        assertEquals(10, heal.getHealAmount());
        assertEquals("This is a test heal!", heal.getMessage());
    }

    //////////////////////////////////////////
    // TEST ENEMY CREATION
    //////////////////////////////////////////
    @Test
    public void testEasyEnemyAttackPoints() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(10, enemy.getAttackPoints());
        enemy.setAttackPoints(20);
        assertEquals(20, enemy.getAttackPoints());
    }

    @Test
    public void testEasyEnemyDefensePoints() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(5, enemy.getDefensePoints());
        enemy.setDefensePoints(10);
        assertEquals(10, enemy.getDefensePoints());
    }

    @Test
    public void testEasyEnemySpeed() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(7, enemy.getSpeed());
        enemy.setSpeed(10);
        assertEquals(10, enemy.getSpeed());
    }

    @Test
    public void testEasyEnemyMaxHealth() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(50, enemy.getMaxHealth());
        enemy.setMaxHealth(100);
        assertEquals(100, enemy.getMaxHealth());
    }

    @Test
    public void testEasyEnemyHealth() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(50, enemy.getHealth());
        enemy.setHealth(100);
        assertEquals(100, enemy.getHealth());
    }

    @Test
    public void testEasyEnemyAttack() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.attack() != null);
    }

    @Test
    public void testEasyEnemyDefend() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.defend() != null);
    }

    @Test
    public void testEasyEnemyHeal() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.heal() != null);
    }

    @Test
    public void testEasyEnemyTakeDamage() {
        EnemyCreator creator = new EasyEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        int health = enemy.getHealth();
        enemy.takeDamage(10);
        assertEquals(health - 10, enemy.getHealth());
    }

    @Test
    public void testMediumEnemyAttackPoints() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(15, enemy.getAttackPoints());
        enemy.setAttackPoints(30);
        assertEquals(30, enemy.getAttackPoints());
    }

    @Test
    public void testMediumEnemyDefensePoints() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(15, enemy.getDefensePoints());
        enemy.setDefensePoints(20);
        assertEquals(20, enemy.getDefensePoints());
    }

    @Test
    public void testMediumEnemySpeed() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(9, enemy.getSpeed());
        enemy.setSpeed(20);
        assertEquals(20, enemy.getSpeed());
    }

    @Test
    public void testMediumEnemyMaxHealth() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(55, enemy.getMaxHealth());
        enemy.setMaxHealth(100);
        assertEquals(100, enemy.getMaxHealth());
    }

    @Test
    public void testMediumEnemyHealth() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(55, enemy.getHealth());
        enemy.setHealth(100);
        assertEquals(100, enemy.getHealth());
    }

    @Test
    public void testMediumEnemyAttack() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.attack() != null);
    }

    @Test
    public void testMediumEnemyDefend() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.defend() != null);
    }

    @Test
    public void testMediumEnemyHeal() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.heal() != null);
    }

    @Test
    public void testMediumEnemyTakeDamage() {
        EnemyCreator creator = new MediumEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        int health = enemy.getHealth();
        enemy.takeDamage(10);
        assertEquals(health - 10, enemy.getHealth());
    }

    @Test
    public void testBossEnemyAttackPoints() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(25, enemy.getAttackPoints());
        enemy.setAttackPoints(40);
        assertEquals(40, enemy.getAttackPoints());
    }

    @Test
    public void testBossEnemyDefensePoints() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(25, enemy.getDefensePoints());
        enemy.setDefensePoints(40);
        assertEquals(40, enemy.getDefensePoints());
    }

    @Test
    public void testBossEnemySpeed() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(15, enemy.getSpeed());
        enemy.setSpeed(20);
        assertEquals(20, enemy.getSpeed());
    }

    @Test
    public void testBossEnemyMaxHealth() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(75, enemy.getMaxHealth());
        enemy.setMaxHealth(100);
        assertEquals(100, enemy.getMaxHealth());
    }

    @Test
    public void testBossEnemyHealth() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assertEquals(75, enemy.getHealth());
        enemy.setHealth(100);
        assertEquals(100, enemy.getHealth());
    }

    @Test
    public void testBossEnemyAttack() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.attack() != null);
    }

    @Test
    public void testBossEnemyDefend() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.defend() != null);
    }

    @Test
    public void testBossEnemyHeal() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        assert(enemy.heal() != null);
    }

    @Test
    public void testBossEnemyTakeDamage() {
        EnemyCreator creator = new BossEnemyCreator();
        Enemy enemy = creator.createEnemy(0, rand);
        int health = enemy.getHealth();
        enemy.takeDamage(10);
        assertEquals(health - 10, enemy.getHealth());
    }

    //////////////////////////////////////////
    // TEST CYCLES
    //////////////////////////////////////////

    @Test
    public void testCycle1PlayerTurn() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        Enemy enemy = new EasyEnemyCreator().createEnemy(0, rand);
        State cycle = new Cycle1(rand);
        int result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testCycle1EnemyTurn() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        Enemy enemy = new EasyEnemyCreator().createEnemy(0, rand);
        State cycle = new Cycle1(rand);
        int result = cycle.simulateEnemyTurn(fighter, enemy);
        cycle.simulateEnemyTurn(fighter, enemy);
        cycle.simulateEnemyTurn(fighter, enemy);
        cycle.simulateEnemyTurn(fighter, enemy);
        cycle.simulateEnemyTurn(fighter, enemy);
        cycle.simulateEnemyTurn(fighter, enemy);
        cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testCycle2PlayerTurn() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        Enemy enemy = new EasyEnemyCreator().createEnemy(0, rand);
        State cycle = new Cycle2(rand);
        int result = cycle.simulatePlayerTurn(fighter, enemy);
        cycle.simulatePlayerTurn(fighter, enemy);
        cycle.simulatePlayerTurn(fighter, enemy);
        cycle.simulatePlayerTurn(fighter, enemy);
        cycle.simulatePlayerTurn(fighter, enemy);
        cycle.simulatePlayerTurn(fighter, enemy);
        cycle.simulatePlayerTurn(fighter, enemy);
        cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testCycle2EnemyTurn() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        Enemy enemy = new EasyEnemyCreator().createEnemy(0, rand);
        State cycle = new Cycle2(rand);
        int result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testCycle3PlayerTurn() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        Enemy enemy = new EasyEnemyCreator().createEnemy(0, rand);
        State cycle = new Cycle3(rand);
        int result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testCycle3EnemyTurn() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        Enemy enemy = new EasyEnemyCreator().createEnemy(0, rand);
        State cycle = new Cycle3(rand);
        int result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testCycle4PlayerTurn() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        Enemy enemy = new EasyEnemyCreator().createEnemy(0, rand);
        State cycle = new Cycle4(rand);
        int result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        result = cycle.simulatePlayerTurn(fighter, enemy);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testCycle4EnemyTurn() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        Enemy enemy = new EasyEnemyCreator().createEnemy(0, rand);
        State cycle = new Cycle4(rand);
        int result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        result = cycle.simulateEnemyTurn(fighter, enemy);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testEnemyEncounter() {
        PlayerCharacter fighter = new FighterCreator().createCharacter(rand);
        State cycle = new Cycle1(rand);
        int result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        result = cycle.enemyEncounter(0, fighter);
        assert(result == 0 || result == 1 || result == 2);
    }

    @Test
    public void testMain() { // not required
        Main.main(null);
    }

}
