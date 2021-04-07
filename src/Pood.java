import java.util.Arrays;
import java.util.List;

public class Pood {

    private static List<Relv> relvadMüügiks = Arrays.asList(
            new Relv(10, 5, 2, "Pistoda", 30),
            new Relv(5, 10, 2, "Vibu", 60),
            new Relv(1, 1, 15, "Puidust kilp", 100),
            new Relv(20, 10, 5, "Mõõk", 150),
            new Relv(5, 20, 10, "Amb", 150),
            new Relv(10, 5, 20, "Rauast kilp", 200));

    private static void väljastaInformatsioon() {
        System.out.println("Tere tulemast poodi.");
        System.out.println("Siit on võimalik osta relvi, mis muudavad mängija paremaks.");
        System.out.println("Ostmiseks sisesta relva ees olev number!\n");
        System.out.println("Iga relva kohta on toodud tugevus, täpsus, kaitse ja hind:");
        System.out.println("0. Välju poest");
    }

    public static void sisene(Mängija mängija) {
        väljastaInformatsioon();

        for (int i = 0; i < relvadMüügiks.size(); i++)
            if (mängija.kasSeeRelvOnOstetud(relvadMüügiks.get(i)))
                System.out.println(String.valueOf(i + 1) + ". " + relvadMüügiks.get(i) + " - See relv on juba ostetud.");
            else
                System.out.println(String.valueOf(i + 1) + ". " + relvadMüügiks.get(i));

        while (true) {
            System.out.println("\nSinu raha:" + mängija.getRaha());
            System.out.println("\nSisesta relva number, mida soovid osta: ");
            int valik = Konsool.skanner(relvadMüügiks.size());
            if (valik == 0) break;
            // kasOnPiisavaltRaha
            Relv ostetavRelv = relvadMüügiks.get(valik - 1);
            if (ostetavRelv.getHind() < mängija.getRaha()) {
                // kasMängijalOnRelvOstetud
                if (!mängija.kasSeeRelvOnOstetud(ostetavRelv)) {
                    mängija.ostaRelv(ostetavRelv);
                    mängija.võtaRaha(ostetavRelv.getHind());
                    System.out.println(ostetavRelv.getNimi() + " on lisatud ostetud relvade hulka!");
                    System.out.println("Allesjäänud raha: " + mängija.getRaha());
                }
                else System.out.println("See relv on juba ostetud!");
            }
            else System.out.println("Sul pole selle relva jaoks piisavalt raha!");
        }
    }
}

