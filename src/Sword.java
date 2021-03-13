public class Sword {
    private String name;
    private int strength;
    private int speed;

    public Sword(String name, int strength, int speed) {
        this.name = name;
        this.strength = strength;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", speed=" + speed +
                '}';
    }
}
