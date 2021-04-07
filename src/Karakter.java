public abstract class Karakter {
    String nimi;
    int tugevus;
    int täpsus;
    int kaitse;
    int elud;

    public Karakter(String nimi, int tugevus, int täpsus, int kaitse) {
        this.nimi = nimi;
        this.tugevus = tugevus;
        this.täpsus = täpsus;
        this.kaitse = kaitse;
        this.elud = 100;
    }

    String getNimi() { return nimi; }
    abstract int getTugevus();
    abstract int getTäpsus();
    abstract int getKaitse();
    int getElud() { return elud; }

    boolean kasOnElus() {
        if(this.elud > 0) return true;
        return false;
    }

    void kaotaElusid(int kaotatudElud) {
        if(kaotatudElud > this.elud) this.elud = 0;
        else this.elud -= kaotatudElud;
    }
}
