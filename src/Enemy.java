public class Enemy {
    private String name;
    private Sword sword;
    private int attack;

    public Enemy(String name, Sword sword) {
        this.name = name;
        this.sword = sword;
        this.attack = sword.getStrength() + sword.getSpeed();
    }

    public String getName() {
        return name;
    }

    public Sword getSword() {
        return sword;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", sword=" + sword +
                ", attack=" + attack +
                '}';
    }
}
