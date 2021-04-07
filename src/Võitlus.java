import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Võitlus {

    private static List<Vastane> vastased = Arrays.asList(
            new Vastane("Oskar", 10, 5, 10, 25),
            new Vastane("Leo", 25, 20, 5, 50),
            new Vastane("Voldemar", 25, 30, 20, 75),
            new Vastane("Vambola",25, 40, 35, 100),
            new Vastane("Jakob", 80, 50, 20, 150),
            new Vastane("Karl",100, 125, 75, 300));

    private static int tase = 0;

    private static boolean mängibEsimestKorda = true;

    public static void võitle(Mängija mängija){
        if(mängibEsimestKorda) {
            väljastaInformatsioon();
            mängibEsimestKorda = false;
        }

        Vastane vastane = vastased.get(tase);
        //System.out.println(vastane);
        System.out.println("\nSinu vastaseks on " + vastane.getNimi());
        System.out.println("Külas räägitakse, et tema tugevus on " + vastane.getTugevus() +
                ", täpsus " + vastane.getTäpsus() + " ja kaitse " + vastane.getKaitse() + ".\n");

        //boolean kasVõitlusKäib = true;
        //while(kasVõitlusKäib){

        while(true){
            mängjaKäik(mängija, vastane);
            if(vastane.kasOnElus() == false){
                mängija.annaRaha(vastane.getAuhind());
                System.out.println("Võitsid võitluse!");
                System.out.println("Said juurde " + vastane.getAuhind() + " münti.");
                //kasVõitlusKäib = false;
                tase++;
                break;
            }

            arvutiKäik(mängija, vastane);
            if(mängija.kasOnElus() == false){
                System.out.println("Kaotasid võitluse ja said surma!");
                System.out.println("Tegemist on siiski mänguga ja saad uuesti alustada! :)");
                //kasVõitlusKäib = false;
                break;
            }
        }
    }

    public static boolean kasOnVastaseid(){
        if(tase > vastased.size()) return false;
        return true;
    }

    private static void mängjaKäik(Mängija mängija, Vastane vastane){
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
            mängija.setVõitlusKaitseb(true);
        }

        if(vastane.isVõitlusKaitseb() == false) vastaseKaitse /= 2;

        int löök = löögiTugevus + löögiTäpsus - vastaseKaitse;
        if(löök > 0) {
            vastane.kaotaElusid(löök);
            System.out.println("Vastane sai pihta ja kaotas " + löök + " elu, elusid järel " + vastane.getElud());
        }
        else System.out.println("Vastane suutis blokeerida sinu löögi, elusid järel " + mängija.getElud());
    }

    private static void arvutiKäik(Mängija mängija, Vastane vastane){
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
            vastane.setVõitlusKaitseb(true);
        }

        if(mängija.isVõitlusKaitseb() == false) mängijaKaitse /= 2;

        int löök = löögiTugevus + löögiTäpsus - mängijaKaitse;
        if(löök > 0) {
            mängija.kaotaElusid(löök);
            System.out.println("Said pihta ja kaotasid " + löök + " elu, elusid järel " + mängija.getElud());
        }
        else System.out.println("Suutsid blokeerida vastase löögi, elusid järel " + mängija.getElud());
    }

    private static void väljastaInformatsioon(){
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