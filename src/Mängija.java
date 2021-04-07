
import java.util.ArrayList;
import java.util.List;

public class Mängija implements Karakter {
    private String nimi;
    private int tugevus;
    private int täpsus;
    private int kaitse;
    private int raha;
    private List<Relv> ostetudRelvad;
    //private List<Relv> kasutuses_relvad;
    private Relv relv1;
    private Relv relv2;
    private int elud;
    private boolean võitlusKaitseb;

    public Mängija(String nimi, int tugevus, int täpsus, int kaitse, int raha) {
        this.nimi = nimi;
        this.tugevus = tugevus;
        this.täpsus = täpsus;
        this.kaitse = kaitse;
        this.raha = raha;
        this.elud = 100;
        this.ostetudRelvad = new ArrayList<>();
        //this.kasutuses_relvad = new ArrayList<>();
    }

    @Override
    public String getNimi() { return nimi; }

    @Override
    public int getTugevus() {
        int tugevus = this.tugevus;
        if (this.getRelv1() != null) tugevus += this.getRelv1().getTugevus();
        if (this.getRelv2() != null) tugevus += this.getRelv2().getTugevus();
        return tugevus;
    }

    @Override
    public int getTäpsus() {
        int täpsus = this.täpsus;
        if (this.getRelv1() != null) täpsus += this.getRelv1().getTäpsus();
        if (this.getRelv2() != null) täpsus += this.getRelv2().getTäpsus();
        return täpsus;
    }

    @Override
    public int getKaitse() {
        int kaitse = this.kaitse;
        if (this.getRelv1() != null) kaitse += this.getRelv1().getKaitse();
        if (this.getRelv2() != null) kaitse += this.getRelv2().getKaitse();
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

    public boolean isVõitlusKaitseb() { return võitlusKaitseb; }

    public void setVõitlusKaitseb(boolean võitlusKaitseb) {
        this.võitlusKaitseb = võitlusKaitseb;
    }

    public int getRaha() { return raha; }
    public List<Relv> getOstetudRelvad() { return ostetudRelvad; }
    public Relv getRelv1() { return relv1; }
    public Relv getRelv2() { return relv2; }

    @Override
    public void kaotaElusid(int kaotatudElud) {
        if(kaotatudElud > this.elud) this.elud = 0;
        else this.elud -= kaotatudElud;
    }

    public void setRelv1(Relv relv1) {
        if (this.relv1 != null) this.relv1.paneKotti();
        this.relv1 = relv1;
        this.relv1.võtaKätte();
    }

    public void setRelv2(Relv relv2) {
        if (this.relv2 != null) this.relv2.paneKotti();
        this.relv2 = relv2;
        this.relv2.võtaKätte();
    }

    public void võtaRaha(int raha) { this.raha -= raha; }
    public void annaRaha(int raha) { this.raha += raha; }

    public void võtaKotistRelv(Relv relv, int misRelvaAsendada) {
        if (misRelvaAsendada == 1) setRelv1(relv);
        else if (misRelvaAsendada == 2) setRelv2(relv);
    }

    public List<Relv> relvadKotis() {
        List<Relv> relvad = new ArrayList<>();
        for (Relv relv : this.getOstetudRelvad()) {
            if (relv.isKotis()) relvad.add(relv);
        }
        return relvad;
    }

    public void ostaRelv(Relv relv) { ostetudRelvad.add(relv); }

    public boolean kasVähemaltÜksRelvOnOstetud() {
        if (this.getOstetudRelvad().size() == 0) return false;
        return true;
    }

    public boolean kasSeeRelvOnOstetud(Relv relv) {
        if (this.getOstetudRelvad().contains(relv)) return true;
        return false;
    }

    public String toString() {
        return "Mängija nimi: " + nimi + "\n" +
                "Tugevus: " + tugevus + " | Relvadega koos tugevus: " + this.getTugevus() + "\n" +
                "Täpsus: " + täpsus + " | Relvadega koos täpsus: " + this.getTäpsus() + "\n" +
                "Kaitse: " + kaitse + " | Relvadega koos kaitse: " + this.getKaitse() + "\n" +
                "Raha: " + raha + "\n" +
                "Põhirelv: " + relv1 + "\n" +
                "Teine relv: " + relv2 + "\n" +
                "Ostetud relvad: " + ostetudRelvad;
        //"Valitud relvad: "+ kasutuses_relvad;
    }
}


