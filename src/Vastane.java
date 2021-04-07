public class Vastane extends Karakter {
    private int auhind;

    public Vastane(String nimi, int tugevus, int täpsus, int kaitse, int auhind) {
        super(nimi, tugevus, täpsus, kaitse);
        this.auhind = auhind;
    }

    @Override
    public int getTugevus() { return täpsus; }
    @Override
    public int getTäpsus() { return täpsus; }
    @Override
    public int getKaitse() { return kaitse; }

    public int getAuhind() { return auhind; }

    @Override
    public String toString() {
        return "Vastane{" +
                "nimi='" + getNimi() + '\'' +
                ", tugevus=" + tugevus +
                ", täpsus=" + täpsus +
                ", kaitse=" + kaitse +
                '}';
    }
}
