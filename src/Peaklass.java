import java.util.Arrays;
import java.util.List;

public class Peaklass {

    private static List<Mängija> mängijaValikud = Arrays.asList(new Mängija("Tugev Madis",80, 40, 60, 10),
            new Mängija("Täpne Legolas",60, 80, 40, 10),
            new Mängija("Hiiliv Silver",40, 60, 80, 10));

    public static void väljastaInformatsioon() {
        System.out.println("Tere tulemast!");
        System.out.println("Mängu eesmärgiks on alistada kõik vastased võitlusareenilt.");
        System.out.println("Vastaste alistamise eest saad raha ning raha eest saad poest osta uusi relvi.");
        System.out.println("Relvadega saad enda mängija oskusi parandada.");
        System.out.println("Kui peaksid vastasele kaotama, sureb sinu karakter ning pead kahjuks mängu uuesti alustama.");
        Konsool.ootaEnterVajutamist();
        //System.out.println("Mängijad:" + "\n" + "1. Tugev Madis \n" + "2. Täpne Legolas \n" + "3. Hiiliv Silver");
        System.out.println("Mängu alustamiseks vali endale mängija.");
        kuvaMängijaValikud();
        System.out.println("Valimiseks sisesta mängija number: \n");
    }

    public static void kuvaMängijaValikud(){
        int i = 1;
        for (Mängija mängija : mängijaValikud){
            System.out.println(i + ": " + mängija.getNimi());
            System.out.println("Tugevus: " + mängija.getTugevus());
            System.out.println("Täpsus: " + mängija.getTäpsus());
            System.out.println("Kaitse: " + mängija.getKaitse());
            //System.out.println("Raha: " + mängija.getRaha());
            System.out.println();
            i++;
        }
    }

    public static Mängija mängijaValik(){
        int valik = Konsool.skanner(3, 1);
        return mängijaValikud.get(valik - 1);
        /*if (valik == 1) return new Mängija("Tugev Madis",80, 40, 60, 300);
        else if (valik == 2) return new Mängija("Täpne Legolas",60, 85, 40, 0);
        else return new Mängija("Hiiliv Silver",40, 60, 80, 0);*/
    }

    public static void main(String[] args) {
        väljastaInformatsioon();

        Mängija mängija = mängijaValik();

        Konsool.tühjadRead(10);

        boolean mängKäib = true;
        while (mängKäib) {
            System.out.println("MENÜÜ\n" + "Vali tegevus sisestades tegevuse ees olev number:");
            System.out.println("0. Välju mängust\n" + "1. Pood \n" + "2. Kott\n" + "3. Võitlusareen \n" + "4. Näita karakterit \n");
            System.out.println("Vali tegevus: ");

            int valik = Konsool.skanner(5);
            Konsool.tühjadRead(10);
            if (valik == 0) mängKäib = false;
            else if (valik == 1) Pood.sisene(mängija);
            else if (valik == 2) Kott.ava(mängija);
            else if(valik == 3) Võitlus.võitle(mängija);
            else if(valik == 4){
                System.out.println("Mängija karakter: ");
                System.out.println("--------------------");
                System.out.println(mängija);
                Konsool.ootaEnterVajutamist();
            }

            // kas mängija sai võitluses surma
            if(mängija.kasOnElus() == false) mängKäib = false;
            // kas on veel vastaseid järgi või kõik on surnud
            if(Võitlus.kasOnVastaseid() == false){
                System.out.println("Alistasid kõik vastased ja sinu jaoks on praegu mäng läbi!");
                System.out.println("Alati saad alustada uue karakteriga ja mängida uuesti!");
                mängKäib = false;
            }
        }
    }
}
