
import java.util.ArrayList;
import java.util.List;

public class Mängija {
        private int tugevus;
        private int täpsus;
        private int kaitse;
        private String nimi;
        private int raha;
        private List<Relv> ostetud_relvad;
        private List<Relv> kasutuses_relvad;

        public Mängija(int tugevus, int täpsus, int kaitse, String nimi, int raha){
            this.tugevus = tugevus;
            this.täpsus = täpsus;
            this.kaitse = kaitse;
            this.nimi = nimi;
            this.raha = raha;
            this.ostetud_relvad = new ArrayList<>();
            this.kasutuses_relvad = new ArrayList<>();
        }


    public int getTugevus() { return tugevus; }
    public int getTäpsus() { return täpsus; }
    public int getKaitse() { return kaitse; }
    public String getNimi() { return nimi; }
    public int getRaha() { return raha; }
    public List<Relv> getOstetud_relvad() {
        return ostetud_relvad;
    }
    public List<Relv> getKasutuses_relvad() {
        return kasutuses_relvad;
    }

    public void setTugevus(int tugevus) { this.tugevus = tugevus; }
    public void setTäpsus(int täpsus) { this.täpsus = täpsus; }
    public void setKaitse(int kaitse) { this.kaitse = kaitse; }
    public void setRaha(int raha) { this.raha = raha; }
    public void setOstetud_relvad(List<Relv> ostetud_relvad) {
        this.ostetud_relvad = ostetud_relvad;
    }
    public void setKasutuses_relvad(List<Relv> kasutuses_relvad) {
        this.kasutuses_relvad = kasutuses_relvad;
    }

    public void LisaRelv(Relv relv){
        ostetud_relvad.add(relv);
        }
    public void ValiRelv(Relv relv){
        kasutuses_relvad.add(relv);
        }

        public boolean kasRelvOnOstetud(){
            if(this.getOstetud_relvad().size() == 0) return false;
            return true;
        }

    public String toString() {
        return "Mängija nimi: " + nimi + "\n"+
                "Tugevus: " + tugevus + "\n"+
                "Täpsus: " + täpsus + "\n"+
                "Kaitse: " + kaitse + "\n"+
                "Raha: " + raha + "\n"+
                "Ostetud relvad: " + ostetud_relvad +
                "Valitud relvad: "+ kasutuses_relvad;
    }
}


