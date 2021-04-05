public interface Karakter {

    String getNimi();
    int getTugevus();
    int getTäpsus();
    int getKaitse();
    int getElud();

    boolean kasOnElus();

    // takeDamage
    void kaotaElusid(int kaotatudElud);

}
