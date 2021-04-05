public class Vastane implements Karakter {
    private String nimi;
    private int tugevus;
    private int täpsus;
    private int kaitse;
    private int elud;
    private int auhind;

    public Vastane(String nimi, int tugevus, int täpsus, int kaitse, int auhind) {
        this.nimi = nimi;
        this.tugevus = tugevus;
        this.täpsus = täpsus;
        this.kaitse = kaitse;
        this.elud = 100;
        this.auhind = auhind;
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    @Override
    public int getTugevus() {
        return tugevus;
    }

    @Override
    public int getTäpsus() {
        return täpsus;
    }

    @Override
    public int getKaitse() {
        return kaitse;
    }

    @Override
    public int getElud() {
        return elud;
    }

    @Override
    public boolean kasOnElus() {
        if(this.elud > 0) return true;
        return false;
    }

    public int getAuhind() {
        return auhind;
    }

    @Override
    public void kaotaElusid(int kaotatudElud) {
        if(kaotatudElud > this.elud) this.elud = 0;
        this.elud -= kaotatudElud;
    }

    @Override
    public String toString() {
        return "Vastane{" +
                "nimi='" + nimi + '\'' +
                ", tugevus=" + tugevus +
                ", täpsus=" + täpsus +
                ", kaitse=" + kaitse +
                '}';
    }
}
