
public class Relv {
    private int tugevus;
    private int täpsus;
    private int kaitse;
    private String nimi;
    private int hind;

    public Relv(int tugevus, int täpsus, int kaitse, String nimi, int hind){
        this.tugevus = tugevus;
        this.täpsus = täpsus;
        this.kaitse = kaitse;
        this.nimi = nimi;
        this.hind = hind;
    }

    public int getTugevus() { return tugevus; }
    public int getTäpsus() { return täpsus; }
    public int getKaitse() { return kaitse; }
    public String getNimi() { return nimi; }
    public int getHind() { return hind; }

    public void setTugevus(int tugevus) { this.tugevus = tugevus; }
    public void setTäpsus(int täpsus) { this.täpsus = täpsus; }
    public void setKaitse(int kaitse) { this.kaitse = kaitse; }
    public void setHind(int hind) { this.hind = hind; }

    public String toString() {
        return nimi+" "+tugevus+" "+täpsus+" "+kaitse+" "+hind;
    }
}

