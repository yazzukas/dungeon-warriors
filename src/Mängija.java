public class Mängija extends Karakter {
    private int raha;
    private Kott kott;
    // mängijal saab olla korraga käes/kasutuses 2 relva
    private Relv relv1;
    private Relv relv2;

    public Mängija(String nimi, int tugevus, int täpsus, int kaitse, int raha) {
        super(nimi, tugevus, täpsus, kaitse);
        this.raha = raha;
        this.kott = new Kott(this);
    }

    public Kott getKott(){
        return this.kott;
    }

    // iga relv annab mängija oskustele(tugevus, täpsus, kaitse) juurde relva enda oskused

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

    public int getRaha() { return raha; }
    public Relv getRelv1() { return relv1; }
    public Relv getRelv2() { return relv2; }

    public void setRelv1(Relv relv1) { this.relv1 = relv1; }
    public void setRelv2(Relv relv2) { this.relv2 = relv2; }

    public void võtaRaha(int raha) { this.raha -= raha; }
    public void saaRaha(int raha) { this.raha += raha; }

    @Override
    public String toString() {
        return super.toString() +
                "Tugevus: " + tugevus + " | Relvadega koos tugevus: " + this.getTugevus() + "\n" +
                "Täpsus: " + täpsus + " | Relvadega koos täpsus: " + this.getTäpsus() + "\n" +
                "Kaitse: " + kaitse + " | Relvadega koos kaitse: " + this.getKaitse() + "\n" +
                "Raha: " + raha + "\n" +
                "Esimene relv: " + relv1 + "\n" +
                "Teine relv: " + relv2 + "\n" +
                "Kott: " + getKott().getRelvad() + "\n";
    }

    /*public String toString() {
        return "Mängija nimi: " + getNimi() + "\n" +
                "Tugevus: " + tugevus + " | Relvadega koos tugevus: " + this.getTugevus() + "\n" +
                "Täpsus: " + täpsus + " | Relvadega koos täpsus: " + this.getTäpsus() + "\n" +
                "Kaitse: " + kaitse + " | Relvadega koos kaitse: " + this.getKaitse() + "\n" +
                "Raha: " + raha + "\n" +
                "Esimene relv: " + relv1 + "\n" +
                "Teine relv: " + relv2 + "\n" +
                "Ostetud relvad: " + kott.getRelvad();
    }*/
}


