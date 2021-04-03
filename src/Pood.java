import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pood {

    private List<Relv> relvad;
    private Mängija uus_mängija;

    public Pood() {
        this.relvad = Arrays.asList(new Relv(10, 5, 2, "Pistoda", 50),
                new Relv(20, 10, 5, "Mõõk", 100),
                new Relv(2, 10, 5, "Vibu", 50),
                new Relv(5, 20, 10, "Amb", 100),
                new Relv(5, 2, 10, "Puidust kilp", 50),
                new Relv(10, 5, 20, "Rauast kilp", 100));

    }

    public int Skänner(int valikute_arv) {
        while (true) {
            Scanner valik = new Scanner(System.in);
            if (valik.hasNextInt()) {
                int nr = valik.nextInt();
                if (nr <= valikute_arv && nr >= 0) {
                    return nr;
                } else System.out.println("Sisesta uuesti: ");
            } else System.out.println("Sisesta number!");
        }
    }

    public boolean Kontroll(Relv relv, Mängija mängija) {
        if (relv.getHind() > uus_mängija.getRaha()) {
            System.out.println("Sul pole selle relva jaoks piisavalt raha!");
            return false;
        }
        else {
            return true;
        }
    }

    public Mängija Osta(int valik) {
        if (!Kontroll(relvad.get(valik), uus_mängija)) {
            return uus_mängija;
        } else if (uus_mängija.getOstetud_relvad().contains(relvad.get(valik))) {
            System.out.println("See relv on juba ostetud!");
            return uus_mängija;
        } else {
            uus_mängija.LisaRelv(relvad.get(valik));
            System.out.println(relvad.get(valik).getNimi() + " on lisatud relvade hulka!");
            uus_mängija.setRaha(uus_mängija.getRaha() - relvad.get(valik).getHind());
            return uus_mängija;
        }
    }

    public Mängija Kuva(Mängija mängija) {
        this.uus_mängija = mängija;
        System.out.println("Tere tulemast poodi. Siit on võimalik osta relvi, mis muudavad mängija paremaks\n" +
                "Mängija andmed:\n" + uus_mängija);
        System.out.println("Ostmiseks sisesta relva ees olev number!");
        System.out.println("0. Välju poest");
        System.out.println("Iga relva kohta on toodud tugevus, täpsus, kaitse ja hind:");
        for (int i = 0; i < relvad.size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + relvad.get(i));
        }
        while (true) {
            System.out.println("Sisesta relva number, mida soovid osta, või välju poest: ");
            int valik = Skänner(6);
            if (valik == 0) {
                return uus_mängija;
            }
            else {
                uus_mängija = Osta(valik - 1);
                System.out.println("Allesjäänud raha: "+ uus_mängija.getRaha());
            }
        }
    }
}

