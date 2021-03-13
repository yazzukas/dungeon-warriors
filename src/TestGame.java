import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestGame {
    public static void main(String[] args) {
        Sword sword1 = new Sword("Tavaline", 10, 10);
        Sword sword2 = new Sword("HyperSpeed", 1, 15);
        Sword sword3 = new Sword("HyperDamage", 10, 1);

        Player player = new Player("Sten", sword1);

        Enemy enemy1 = new Enemy("Goblin", sword2);
        Enemy enemy2 = new Enemy("Koletis", sword3);

        Level level1 = new Level("Koridor", enemy1);
        Level level2 = new Level("Kelder", enemy2);

        ArrayList<Level> levels = new ArrayList<>();
        levels.add(level1);
        levels.add(level2);

        System.out.println(player);
        System.out.println(enemy1);
        System.out.println(enemy2);

        int i = 1;
        for (Level level : levels){
            System.out.println();
            System.out.println(level.getName() + " (Level " + i + ")");
            System.out.println("Mängija tugevus: " + player.getAttack());
            System.out.println("Vastase tugevus: " + level.getEnemy().getAttack());

            int rand_int1 = ThreadLocalRandom.current().nextInt(player.getAttack() + level.getEnemy().getAttack());
            System.out.println("Random number: " + rand_int1);
            boolean playerWon = rand_int1 <= player.getAttack();

            if(playerWon){
                System.out.println("Alistasid " + level.getEnemy().getName() + "! Tubli!");
                // mäng läheb edasi
            }
            else{
                System.out.println("Seekord oli kahjuks " + level.getEnemy().getName() + " vastane parem!");
                System.out.println("GAME OVER");
                break;
            }
            i++;
        }
        System.out.println();
        System.out.println("Jõudsid " + i + " tasemeni");
    }
}
