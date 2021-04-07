import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Peaklass {

    // mängijad, kelle vahel on võimalik valida
    private final static List<Mängija> mängijaValikud = Arrays.asList(
            new Mängija("Tugev Madis",80, 40, 60, 10),
            new Mängija("Täpne Legolas",60, 80, 40, 10),
            new Mängija("Hiiliv Silver",40, 60, 80, 10));

    private final static List<Vastane> vastased = Arrays.asList(
            new Vastane("Oskar", 10, 5, 10, 25),
            new Vastane("Leo", 25, 20, 5, 50),
            new Vastane("Voldemar", 25, 30, 20, 75),
            new Vastane("Vambola",25, 40, 35, 100),
            new Vastane("Jakob", 80, 50, 20, 150),
            new Vastane("Karl",100, 125, 75, 300));

    // relvad, mis on poes müügil; pärast relva ostmist kustutatakse listist
    private final static List<Relv> relvadMüügiks = new ArrayList<Relv>(Arrays.asList(
            new Relv(10, 5, 2, "Pistoda", 30),
            new Relv(5, 10, 2, "Vibu", 60),
            new Relv(1, 1, 15, "Puidust kilp", 100),
            new Relv(20, 10, 5, "Mõõk", 150),
            new Relv(5, 20, 10, "Amb", 150),
            new Relv(10, 5, 20, "Rauast kilp", 200)));

    // mitmenda tasame/vastase juures ollakse
    private static int tase = 0;
    // kui mängib esimest korda siis kuvab võitlusareeni esimest korda külastades informatsiooni
    private static boolean mängibEsimestKorda = true;

    // mängu sisenemisel kuvatav tekst
    private static void väljastaInformatsioon() {
        System.out.println("Tere tulemast! Oled asunud mängima mängu nimega Sõdalased.");
        System.out.println("Mängu eesmärgiks on alistada kõik vastased võitlusareenilt.");
        System.out.println("Vastaste alistamise eest saad raha ning raha eest saad poest osta uusi relvi.");
        System.out.println("Relvadega saad enda mängija oskusi parandada.");
        System.out.println("Kui peaksid vastasele kaotama, sureb sinu karakter ning pead kahjuks mängu uuesti alustama.");
        Konsool.ootaEnterVajutamist();
        System.out.println("Mängu alustamiseks vali endale mängija.");
        kuvaMängijaValikud();
        System.out.println("Valimiseks sisesta mängija number: \n");
    }

    // kuvab konsooli kõik mängijad, kelle vahel on võimalik valida
    public static void kuvaMängijaValikud(){
        int i = 1;
        for (Mängija mängija : mängijaValikud){
            System.out.println(i + ": " + mängija.getNimi());
            System.out.println("Tugevus: " + mängija.getTugevus());
            System.out.println("Täpsus: " + mängija.getTäpsus());
            System.out.println("Kaitse: " + mängija.getKaitse());
            System.out.println();
            i++;
        }
    }

    // tagastab selle mängija objekti, keda kasutaja valis konsooli kaudu
    public static Mängija mängijaValik(){
        int valik = Konsool.skanner(3, 1);
        return mängijaValikud.get(valik - 1);
    }

    public static void main(String[] args) {
        väljastaInformatsioon();

        Pood pood = new Pood(relvadMüügiks);
        Mängija mängija = mängijaValik();

        Konsool.tühjadRead(10);

        // mäng lõppeb, kui mängija on surnud või võidab kõik vastased
        while (mängija.kasOnElus()) {
            System.out.println("MENÜÜ\n" + "Vali tegevus sisestades tegevuse ees olev number:");
            System.out.println("0. Välju mängust\n" + "1. Pood \n" + "2. Kott\n" + "3. Võitlusareen \n" + "4. Näita karakterit \n");
            System.out.println("Vali tegevus: ");

            int valik = Konsool.skanner(5);
            Konsool.tühjadRead(10);
            if (valik == 0) break; // väljub mängust
            else if (valik == 1) pood.sisene(mängija); // siseneb poodi
            else if (valik == 2) mängija.getKott().ava(); // avab koti/saab vahetada relvi
            else if(valik == 3){ // valib järgmise vastase ja aktiveerib võitle meetodi
                Võitlus võitlus = new Võitlus(mängija, vastased.get(tase));
                if(mängibEsimestKorda) {
                    võitlus.väljastaInformatsioon();
                    mängibEsimestKorda = false;
                }
                võitlus.võitle();
                tase++;
            }
            else if(valik == 4){ // näitab konsoolis mängija andmeid
                System.out.println("Mängija karakter: ");
                System.out.println("--------------------");
                System.out.println(mängija);
                Konsool.ootaEnterVajutamist();
            }

            // kas on veel vastaseid järgi või on kõik surnud
            if(tase == vastased.size()){
                System.out.println("Alistasid kõik vastased ja sinu jaoks on praegu mäng läbi!");
                System.out.println("Alati saad alustada uue karakteriga ja mängida uuesti!");
                break;
            }
        }
    }
}
