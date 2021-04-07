public class Vastane extends Karakter {
    private int auhind;

    public Vastane(String nimi, int tugevus, int täpsus, int kaitse, int auhind) {
        super(nimi, tugevus, täpsus, kaitse);
        this.auhind = auhind;
    }

    public int getAuhind() { return auhind; }

    public String toString() {
        return "Vastane{" +
                "nimi='" + nimi + '\'' +
                ", tugevus=" + tugevus +
                ", täpsus=" + täpsus +
                ", kaitse=" + kaitse +
                '}';
    }
}
