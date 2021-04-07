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
    int getTugevus() { return tugevus; }
    int getTäpsus() { return täpsus; }
    int getKaitse() { return kaitse; }
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
