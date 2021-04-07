import java.util.List;

public class Pood {

    private List<Relv> relvadMüügiks;

    public Pood(List<Relv> relvadMüügiks) {
        this.relvadMüügiks = relvadMüügiks;
    }

    private void väljastaInformatsioon() {
        System.out.println("Tere tulemast poodi.");
        System.out.println("Siit on võimalik osta relvi, mis muudavad mängija paremaks.");
        System.out.println("Ostmiseks sisesta relva ees olev number!\n");
        System.out.println("Iga relva kohta on toodud tugevus, täpsus, kaitse ja hind:");
        System.out.println("0. Välju poest");
    }

    public void sisene(Mängija mängija) {
        väljastaInformatsioon();

        /*for (int i = 0; i < relvadMüügiks.size(); i++)
            if (mängija.getKott().kasSeeRelvOnKotis(relvadMüügiks.get(i)))
                System.out.println(String.valueOf(i + 1) + ". " + relvadMüügiks.get(i) + " - See relv on juba ostetud.");
            else
                System.out.println(String.valueOf(i + 1) + ". " + relvadMüügiks.get(i));
            System.out.println(String.valueOf(i + 1) + ". " + relvadMüügiks.get(i));*/

        while (relvadMüügiks.size() > 0) {
            for (int i = 0; i < relvadMüügiks.size(); i++)
                System.out.println(String.valueOf(i + 1) + ". " + relvadMüügiks.get(i));
            System.out.println("\nSinu raha:" + mängija.getRaha());
            System.out.println("\nSisesta relva number, mida soovid osta: ");
            int valik = Konsool.skanner(relvadMüügiks.size() + 1);
            if (valik == 0) break;

            Relv ostetavRelv = relvadMüügiks.get(valik - 1);
            if (ostetavRelv.getHind() < mängija.getRaha()) {
                mängija.getKott().lisaRelv(ostetavRelv);
                mängija.võtaRaha(ostetavRelv.getHind());
                System.out.println(ostetavRelv.getNimi() + " on lisatud ostetud relvade hulka!");
                System.out.println("Allesjäänud raha: " + mängija.getRaha());
                relvadMüügiks.remove(ostetavRelv);
            }
            else System.out.println("Sul pole selle relva jaoks piisavalt raha!");
        }
    }
}

