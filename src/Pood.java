import java.util.Arrays;
import java.util.List;

public class Pood {

    private static List<Relv> relvadMüügiks = Arrays.asList(new Relv(10, 5, 2, "Pistoda", 50),
            new Relv(20, 10, 5, "Mõõk", 100),
            new Relv(2, 10, 5, "Vibu", 50),
            new Relv(5, 20, 10, "Amb", 100),
            new Relv(5, 2, 10, "Puidust kilp", 50),
            new Relv(10, 5, 20, "Rauast kilp", 100));

    private static void väljastaInformatsioon() {
        System.out.println("Tere tulemast poodi. Siit on võimalik osta relvi, mis muudavad mängija paremaks");
        System.out.println("Ostmiseks sisesta relva ees olev number!");
        System.out.println("0. Välju poest");
        System.out.println("Iga relva kohta on toodud tugevus, täpsus, kaitse ja hind:");
    }

    public static void sisene(Mängija mängija) {
        väljastaInformatsioon();

        for (int i = 0; i < relvadMüügiks.size(); i++)
            if (mängija.kasSeeRelvOnOstetud(relvadMüügiks.get(i)))
                System.out.println(String.valueOf(i + 1) + ". " + relvadMüügiks.get(i) + " - See relv on juba ostetud.");
            else
                System.out.println(String.valueOf(i + 1) + ". " + relvadMüügiks.get(i));

        while (true) {
            System.out.println("Sisesta relva number, mida soovid osta, või välju poest: ");
            int valik = Konsool.skanner(relvadMüügiks.size());
            if (valik == 0) break;
            // kasOnPiisavaltRaha
            Relv ostetavRelv = relvadMüügiks.get(valik - 1);
            if (ostetavRelv.getHind() < mängija.getRaha()) {
                // kasMängijalOnRelvOstetud
                if (!mängija.kasSeeRelvOnOstetud(ostetavRelv)) {
                    mängija.LisaRelv(ostetavRelv);
                    mängija.setRaha(mängija.getRaha() - ostetavRelv.getHind());
                    System.out.println(ostetavRelv.getNimi() + " on lisatud relvade hulka!");
                    System.out.println("Allesjäänud raha: " + mängija.getRaha());
                }
                else System.out.println("See relv on juba ostetud!");
            }
            else System.out.println("Sul pole selle relva jaoks piisavalt raha!");
        }
    }
}

