public abstract class Karakter {
    private String nimi;
    private int elud;
    int tugevus;
    int täpsus;
    int kaitse;

    public Karakter(String nimi, int tugevus, int täpsus, int kaitse) {
        this.nimi = nimi;
        this.tugevus = tugevus;
        this.täpsus = täpsus;
        this.kaitse = kaitse;
        this.elud = 100;
    }

    String getNimi() { return nimi; }
    int getElud() { return elud; }

    abstract int getTugevus();
    abstract int getTäpsus();
    abstract int getKaitse();

    boolean kasOnElus() {
        if(this.elud > 0) return true;
        return false;
    }

    // lahutab mängijalt kindel arv elusid maha ning kontrollib, et elud alla 0 ei läheks
    void kaotaElusid(int kaotatudElud) {
        if(kaotatudElud > this.elud) this.elud = 0;
        else this.elud -= kaotatudElud;
    }

    @Override
    public String toString() {
        return "Tegelase nimi: " + nimi + "\n";
    }
}
