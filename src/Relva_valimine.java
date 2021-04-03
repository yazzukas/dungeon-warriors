import java.util.ArrayList;
import java.util.Scanner;



public class Relva_valimine {

    private Mängija uus_mängija;
    private Mängija intro_mängija;

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

    public Mängija Vali(int valik) {
        uus_mängija.ValiRelv(uus_mängija.getOstetud_relvad().get(valik));
        System.out.println(uus_mängija.getOstetud_relvad().get(valik).getNimi() + " on valitud võitluseks!");
        uus_mängija.setKaitse(intro_mängija.getKaitse() + uus_mängija.getOstetud_relvad().get(valik).getKaitse()+uus_mängija.getKasutuses_relvad().get(0).getKaitse());
        uus_mängija.setTugevus(intro_mängija.getTugevus() + uus_mängija.getOstetud_relvad().get(valik).getTugevus()+uus_mängija.getKasutuses_relvad().get(0).getTugevus());
        uus_mängija.setTäpsus(intro_mängija.getTäpsus() + uus_mängija.getOstetud_relvad().get(valik).getTäpsus()+uus_mängija.getKasutuses_relvad().get(0).getTäpsus());
        return uus_mängija;
    }

    public void määra_intro_mängija(Mängija intro_mängija){
        this.intro_mängija = intro_mängija;
    }

    public Mängija Kuva(Mängija mängija) {
        this.uus_mängija = mängija;
        System.out.println("Siin on võimalik valida oma ostetud relvade vahel. Kokku on võimalik " +
                "valida kaks  relva, mis parandavad mängija parameetreid\n" +
                "Mängija andmed:\n" + uus_mängija);
        //System.out.println("Valimiseks sisesta relva ees olev number!");
        System.out.println("0. " + "Välju");
        if (mängija.getOstetud_relvad().size() == 0) {
            System.out.println("Sul ei ole ostetud relvi!");}
        else {
            System.out.println("Ostetud relvad:");
            for (int i = 0; i < mängija.getOstetud_relvad().size(); i++) {
                System.out.println(String.valueOf(i + 1) + ". " + mängija.getOstetud_relvad().get(i));
            }
        }

        System.out.println("Sisesta relva number, mida soovid valida või välju: ");
        int valik = Skänner(mängija.getOstetud_relvad().size());
        if (valik == 0) {
            return uus_mängija;
        }
        else {
            uus_mängija.setKasutuses_relvad(new ArrayList<>());
            this.uus_mängija = Vali(valik - 1);
            if(mängija.getOstetud_relvad().size() > 1) {
                System.out.println("Vali 2. relv: ");
                while (true) {
                    int relva_nr = Skänner(mängija.getOstetud_relvad().size());
                    if(relva_nr == 0){
                        break;
                    }
                    if (relva_nr == valik) {
                        System.out.println("Sul on see relv juba valitud!");
                    }
                    else {
                        this.uus_mängija = Vali(relva_nr - 1);
                        break;
                    }
                }
            }
            System.out.println("Uued parameetrid: ");
            System.out.println(uus_mängija);
            System.out.println("Menüüsse naasmiseks vajuta '0': ");
            if(Skänner(0) == 0){return uus_mängija;}
            else {return uus_mängija;} //ei jõua selle tingimuslauseni nagunii
        }
    }
}
