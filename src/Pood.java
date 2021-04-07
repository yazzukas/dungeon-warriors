import java.util.List;

public class Pood {

    // mängija saab osta poest raha eest relvi ning igat relva saab osta ainult ühe korra

    private List<Relv> relvadMüügiks;

    public Pood(List<Relv> relvadMüügiks) {
        this.relvadMüügiks = relvadMüügiks;
    }

    private void väljastaInformatsioon() {
        System.out.println("Tere tulemast poodi.");
        System.out.println("Siit on võimalik osta relvi, mis muudavad mängija paremaks.");
        System.out.println("Ostmiseks sisesta relva ees olev number!\n");
        System.out.println("Iga relva kohta on toodud tugevus, täpsus, kaitse ja hind:");
    }

    private void kuvaRelvadMüügiks(){
        for (int i = 1; i < relvadMüügiks.size(); i++)
            System.out.println(i + ". " + relvadMüügiks.get(i));
    }

    public void sisene(Mängija mängija) {
        väljastaInformatsioon();

        while (relvadMüügiks.size() > 0) {
            System.out.println("0. Välju poest");
            kuvaRelvadMüügiks();

            System.out.println("\nSinu raha: " + mängija.getRaha());
            System.out.println("\nSisesta relva number, mida soovid osta: ");

            int valik = Konsool.skanner(relvadMüügiks.size() + 1);
            if (valik == 0) break;

            Relv ostetavRelv = relvadMüügiks.get(valik - 1);

            // kas mängijal on piisavalt raha
            if (ostetavRelv.getHind() < mängija.getRaha()) {
                // kui mängijal on käes tühi relva koht, siis lisab ostetud relva sinna
                if(mängija.getRelv1() == null) mängija.setRelv1(ostetavRelv);
                else if(mängija.getRelv2() == null) mängija.setRelv2(ostetavRelv);
                else mängija.getKott().lisaRelv(ostetavRelv); // lisab relva kotti
                mängija.võtaRaha(ostetavRelv.getHind());  // võtab mängijalt raha maha
                System.out.println(ostetavRelv.getNimi() + " on lisatud ostetud relvade hulka!");
                System.out.println("Allesjäänud raha: " + mängija.getRaha());
                relvadMüügiks.remove(ostetavRelv); // eemaldab relva müügilt
            }
            else System.out.println("Sul pole selle relva jaoks piisavalt raha!");
        }
    }
}

