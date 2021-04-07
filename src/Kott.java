import java.util.ArrayList;
import java.util.List;

public class Kott {

    // kotis saab mängija hoiustada enda relvi, mis ta on poest ostnud

    private List<Relv> relvad;
    private Mängija mängija;

    public Kott(Mängija mängija) {
        this.relvad = new ArrayList<Relv>();
        this.mängija = mängija;
    }

    public List<Relv> getRelvad() { return relvad; }

    public void lisaRelv(Relv relv) { relvad.add(relv); }

    public boolean kasVähemaltÜksRelvOnKotis() {
        if (this.getRelvad().size() == 0) return false;
        return true;
    }

    // eemaldab relva kotist ja lisab relva vastavale mängija relva slotile
    // kui mängijal oli seal slotis relv ees, siis lisatakse see ennem kotti
    private void võtaKotistRelv(Relv relv, int misRelvaAsendada) {
        if (misRelvaAsendada == 1) {
            if (mängija.getRelv1() != null) lisaRelv(mängija.getRelv1());
            relvad.remove(relv);
            mängija.setRelv1(relv);
        }
        else if (misRelvaAsendada == 2) {
            if (mängija.getRelv2() != null) lisaRelv(mängija.getRelv2());
            relvad.remove(relv);
            mängija.setRelv2(relv);
        }
    }

    private void väljastaInformatsioon() {
        System.out.println("Siin on võimalik valida oma ostetud relvade vahel.");
        System.out.println("Kokku on võimalik valida kaks  relva, mis parandavad mängija parameetreid");
    }

    private void kuvaRelvad() {
        System.out.println("0. Välju");
        for (int i = 0; i < relvad.size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + relvad.get(i));
        }
        System.out.println("\nSisesta relva number, mida soovid kotist valida: ");
    }

    public void ava() {
        if (kasVähemaltÜksRelvOnKotis()) {
            väljastaInformatsioon();

            boolean valibRelva = true;
            while(valibRelva && kasVähemaltÜksRelvOnKotis()){
                System.out.println();
                System.out.println("Praegune esimene relv: " + mängija.getRelv1());
                System.out.println("Praegune teine relv: " + mängija.getRelv2());
                System.out.println();
                kuvaRelvad();

                int valik = Konsool.skanner(relvad.size() + 1);
                if (valik == 0) valibRelva = false;
                else {
                    Relv kotistVõetavRelv = relvad.get(valik - 1);
                    //if(mängija.getRelv1() == null) võtaKotistRelv(kotistVõetavRelv, 1);
                    //else if(mängija.getRelv2() == null) võtaKotistRelv(kotistVõetavRelv, 2);
                    //else{

                        System.out.println("Millist relva soovid asendada?");
                        System.out.println("1. " + mängija.getRelv1().toString());
                        System.out.println("2. " + mängija.getRelv2().toString());

                        int misRelvaAsendada = Konsool.skanner(2, 1);
                        if (valik == 0) valibRelva = false;
                        else{
                            if(misRelvaAsendada == 1) System.out.println("Panid kotti " + mängija.getRelv1());
                            else if (misRelvaAsendada == 2) System.out.println("Panid kotti " + mängija.getRelv2());
                            võtaKotistRelv(kotistVõetavRelv, misRelvaAsendada);
                        }
                    //}
                    System.out.println("Võtsid kotist " + kotistVõetavRelv.getNimi());
                }
            }
        }
        else {
            System.out.println("Sul ei ole ühtegi relva kotis! Mine poodi ja osta üks!");
            Konsool.ootaEnterVajutamist();
        }
        Konsool.tühjadRead(10);
    }
}
