package Mäng;

public class Mängija {
        private int tugevus;
        private int täpsus;
        private int kaitse;
        private String nimi;
        private int raha;

        public Mängija(int tugevus, int täpsus, int kaitse, String nimi, int raha){
            this.tugevus = tugevus;
            this.täpsus = täpsus;
            this.kaitse = kaitse;
            this.nimi = nimi;
            this.raha = raha;
        }

    public int getTugevus() { return tugevus; }
    public int getTäpsus() { return täpsus; }
    public int getKaitse() { return kaitse; }
    public String getNimi() { return nimi; }
    public int getRaha() { return raha; }

    public void setTugevus(int tugevus) { this.tugevus = tugevus; }
    public void setTäpsus(int täpsus) { this.täpsus = täpsus; }
    public void setKaitse(int kaitse) { this.kaitse = kaitse; }
    public void setRaha(int raha) { this.raha = raha; }

    public String toString() {
        return "Mängija nimi: " + nimi + "\n"+
                "Täpsus: " + täpsus + "\n"+
                "Tugevus: " + tugevus + "\n"+
                "Kaitse: " + kaitse + "\n"+
                "Raha: " + raha + "\n";
    }
}


