import java.util.concurrent.ThreadLocalRandom;

public class Võitlus {

    // 1. Tugev löök - Täpsus ja Kaitse on 2 korda kehvemad | löögiTugevus /= 2; mängijaKaitse /= 2;
    // 2. Täpne löök - Tugevus ja Kaitse on 2 korda kehvemad | löögiTäpsus /= 2; mängijaKaitse /= 2;
    // 3. Kaitsev löök - Tugevus ja Täpsus on 2 korda kehvemad | löögiTugevus /= 2; löögiTäpsus /= 2;

    // igast oskusest võetakse random meetodiga suvaline väärtus
    // näiteks: mängija tugevus on 80, siis random võtab 0 kuni 80 suvalise arvu ja lisab selle löögiTugevus väärtuseks
    // Mängija löögi tugevus =  löögiTugevus + löögiTäpsus - vastaseKaitse;

    private Mängija mängija;
    private Vastane vastane;

    private boolean kasMängijaKaitseb = false;
    private boolean kasVastaneKaitseb = false;

    public Võitlus(Mängija mängija, Vastane vastane) {
        this.mängija = mängija;
        this.vastane = vastane;
    }

    public void võitle(){
        System.out.println("\nSinu vastaseks on " + vastane.getNimi() + ".");
        System.out.println("Külas räägitakse, et tema tugevus on " + vastane.getTugevus() +
                ", täpsus " + vastane.getTäpsus() + " ja kaitse " + vastane.getKaitse() + ".\n");

        while(true){
            mängjaKäik();
            if(vastane.kasOnElus() == false){
                mängija.saaRaha(vastane.getAuhind());
                System.out.println("Võitsid võitluse!");
                System.out.println("Said juurde " + vastane.getAuhind() + " münti.");
                break;
            }

            arvutiKäik();
            if(mängija.kasOnElus() == false){
                System.out.println("Kaotasid võitluse ja said surma!");
                System.out.println("Tegemist on siiski mänguga ja saad uuesti alustada! :)");
                break;
            }
        }
    }

    private void mängjaKäik(){
        int löögiTugevus = ThreadLocalRandom.current().nextInt(mängija.getTugevus());
        int löögiTäpsus = ThreadLocalRandom.current().nextInt(mängija.getTäpsus());
        int vastaseKaitse = ThreadLocalRandom.current().nextInt(vastane.getKaitse());

        System.out.println("Vali tegevus:\n 1 - Tugev löök \n 2 - Täpne löök \n 3 - Kaitsev löök");

        // 1 - Tugev löök | 2 - Täpne löök | 3 - blokeeri vastase löök
        int tegevus = Konsool.skanner(3, 1);
        if(tegevus == 1) löögiTäpsus /= 2;
        else if(tegevus == 2) löögiTugevus /= 2;
        else if(tegevus == 3) {
            löögiTäpsus /= 2;
            löögiTugevus /= 2;
            kasMängijaKaitseb = true;
        }

        if(kasVastaneKaitseb == false) vastaseKaitse /= 2;

        int löök = löögiTugevus + löögiTäpsus - vastaseKaitse;
        if(löök > 0) {
            vastane.kaotaElusid(löök);
            System.out.println("Vastane sai pihta ja kaotas " + löök + " elu, elusid järel " + vastane.getElud());
        }
        else System.out.println("Vastane suutis blokeerida sinu löögi, elusid järel " + mängija.getElud());
    }

    private void arvutiKäik(){
        int löögiTugevus = ThreadLocalRandom.current().nextInt(vastane.getTugevus());
        int löögiTäpsus = ThreadLocalRandom.current().nextInt(vastane.getTäpsus());
        int mängijaKaitse = ThreadLocalRandom.current().nextInt(mängija.getKaitse());

        // 1 - Tugev löök | 2 - Täpne löök | 3 - Kaitsev löök
        int tegevus = ThreadLocalRandom.current().nextInt(1, 4);
        if(tegevus == 1) löögiTäpsus /= 2;
        else if(tegevus == 2) löögiTugevus /= 2;
        else if(tegevus == 3){
            löögiTäpsus /= 2;
            löögiTugevus /= 2;
            kasVastaneKaitseb = true;
        }

        if(kasMängijaKaitseb == false) mängijaKaitse /= 2;

        int löök = löögiTugevus + löögiTäpsus - mängijaKaitse;
        if(löök > 0) {
            mängija.kaotaElusid(löök);
            System.out.println("Said pihta ja kaotasid " + löök + " elu, elusid järel " + mängija.getElud());
        }
        else System.out.println("Suutsid blokeerida vastase löögi, elusid järel " + mängija.getElud());
    }

    public void väljastaInformatsioon(){
        System.out.println("Teretulemast võitlusareenile!\n");
        System.out.println("Siin saad võidelda vastastega ning võitmise eest saad vastu raha.");
        System.out.println("Ole ettevaatlik! Kaotus tähendab, et sinu karakter sureb ning pead mängu uuesti alustama.\n");
        System.out.println("Vastasega võitlemiseks on kolm erinevat moodust:");
        System.out.println("1. Tugev löök - lööd vastast tugeva, kuid ebatäpse löögiga");
        System.out.println("2. Täpne löök - lööd vastast täpse, kuid nõrga löögiga");
        System.out.println("3. Kaitsev löök - keskendub vastase löögi blokeerimisele ja seetõttu enda löök ei ole nii tugev ega täpne");
        Konsool.ootaEnterVajutamist();
    }
}