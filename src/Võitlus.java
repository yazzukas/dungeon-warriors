import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Võitlus {

    private static List<Vastane> vastased = Arrays.asList(
            new Vastane("Nimi1", 10, 10, 10, 50),
            new Vastane("Nimi2",25, 30, 35, 100),
            new Vastane("Nimi3", 80, 80, 80, 500));

    private static int tase = 0;

    private static boolean mängibEsimestKorda = true;

    public static void võitle(Mängija mängija){
        if(mängibEsimestKorda) {
            väljastaInformatsioon();
            mängibEsimestKorda = false;
        }

        Vastane vastane = vastased.get(tase);
        System.out.println(vastane);

        //boolean kasVõitlusKäib = true;
        //while(kasVõitlusKäib){
        while(true){
            mängjaKäik(mängija, vastane);
            if(vastane.kasOnElus() == false){
                mängija.annaRaha(vastane.getAuhind());
                System.out.println("Võitsid võitluse!");
                System.out.println("Said juurde " + vastane.getAuhind() + " kuldmünti.");
                //kasVõitlusKäib = false;
                tase++;
                break;
            }

            arvutiKäik(mängija, vastane);
            if(mängija.kasOnElus() == false){
                System.out.println("Kaotasid võitluse!");
                System.out.println("Kahjuks said sa surma, kuid tegemist on siiski mänguga ja saad uuesti alustada! :)");
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

        System.out.println("Vali tegevus: 1 - Tugev löök | 2 - Täpne löök | 3 - blokeeri vastase löök");

        // 1 - Tugev löök | 2 - Täpne löök | 3 - blokeeri vastase löök
        int tegevus = Konsool.skanner(2, 1);
        if(tegevus == 1) löögiTäpsus /= 2;
        else if(tegevus == 2) löögiTugevus /= 2;

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

        // 1 - Tugev löök | 2 - Täpne löök | 3 - blokeeri vastase löök
        int tegevus = ThreadLocalRandom.current().nextInt(1, 3);
        if(tegevus == 1) löögiTäpsus /= 2;
        else if(tegevus == 2) löögiTugevus /= 2;

        int löök = löögiTugevus + löögiTäpsus - mängijaKaitse;
        if(löök > 0) {
            mängija.kaotaElusid(löök);
            System.out.println("Said pihta ja kaotasid " + löök + " elu, elusid järel " + mängija.getElud());
        }
        else System.out.println("Suutsid blokeerida vastase löögi, elusid järel " + mängija.getElud());
    }

    private static void väljastaInformatsioon(){
        System.out.println("Teretulemast võitlusareenile!");
        System.out.println("Siin saad võidelda vastaste vastu ning võitmise eest saad vastu kuldmünte.");
        System.out.println("Ole ettevaatlik! Kaotus tähendab, et sinu karakter sureb ning pead mängu uuesti alustama.");
        System.out.println("Vastasega võitlemiseks on kolm erinevat moodust:");
        System.out.println("1. Tugev löök - lööd vastast tugeva, kuid ebatäpse löögiga");
        System.out.println("2. Täpne löök - lööd vastast täpse, kuid nõrga löögiga");
        System.out.println("3. Blokeeri vastase löök - proovib blokeerida vastase lööki, see ei pruugi alati õnnestuda ning vahest suudad blokeerida löögi vaid osaliselt");
        System.out.println("Vajuta ENTER, et liikuda EDASI!");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
}