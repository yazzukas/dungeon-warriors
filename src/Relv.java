
public class Relv {
    private int tugevus;
    private int täpsus;
    private int kaitse;
    private String nimi;
    private int hind;
    private boolean kotis;

    public Relv(int tugevus, int täpsus, int kaitse, String nimi, int hind){
        this.tugevus = tugevus;
        this.täpsus = täpsus;
        this.kaitse = kaitse;
        this.nimi = nimi;
        this.hind = hind;
        this.kotis = true;
    }

    public int getTugevus() { return tugevus; }
    public int getTäpsus() { return täpsus; }
    public int getKaitse() { return kaitse; }
    public String getNimi() { return nimi; }
    public int getHind() { return hind; }
    public boolean isKotis() { return kotis; }

    public void paneKotti(){ this.kotis = true; }
    public void võtaKätte() { this.kotis = false; }

    public String toString() {
        return nimi+" "+tugevus+" "+täpsus+" "+kaitse+" "+hind;
    }
}

