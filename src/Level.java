public class Level {
    private String name;
    private Enemy enemy;

    public Level(String name, Enemy enemy) {
        this.name = name;
        this.enemy = enemy;
    }

    public String getName() {
        return name;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
