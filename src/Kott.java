public class Kott {

    private static void väljastaInformatsioon() {
        System.out.println("Siin on võimalik valida oma ostetud relvade vahel.");
        System.out.println("Kokku on võimalik valida kaks  relva, mis parandavad mängija parameetreid");
    }

    private static void kuvaRelvad(Mängija mängija) {
        System.out.println("Sisesta relva number, mida soovid kotist valida: ");
        System.out.println("0. Välju");
        for (int i = 0; i < mängija.relvadKotis().size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + mängija.relvadKotis().get(i));
        }
    }

    public static void ava(Mängija mängija) {
        if (mängija.kasVähemaltÜksRelvOnOstetud()) {
            väljastaInformatsioon();
            System.out.println();
            System.out.println("Praegused kasutused olevad relvad: ");
            System.out.println(mängija.getRelv1());
            System.out.println(mängija.getRelv2());
            System.out.println();
            kuvaRelvad(mängija);

            boolean valibRelva = true;
            while(valibRelva){
                System.out.println();
                System.out.println(mängija.getRelv1());
                System.out.println(mängija.getRelv2());
                System.out.println();
                int valik = Konsool.skanner(mängija.relvadKotis().size() + 1);
                if (valik == 0) valibRelva = false;
                else {
                    Relv kotistVõetavRelv = mängija.relvadKotis().get(valik - 1);
                    //if(mängija.getRelv1() == null || mängija.getRelv2() == null)
                    if(mängija.getRelv1() == null) mängija.võtaKotistRelv(kotistVõetavRelv, 1);
                    else if(mängija.getRelv2() == null) mängija.võtaKotistRelv(kotistVõetavRelv, 2);
                    else{
                        System.out.println("Millist relva soovid asendada?");
                        System.out.println("1. " + mängija.getRelv1().toString());
                        System.out.println("2. " + mängija.getRelv1().toString());

                        int misRelvaAsendada = Konsool.skanner(2, 1);
                        if (valik == 0) valibRelva = false;
                        else{
                            if(misRelvaAsendada == 1)
                                System.out.println("Panid kotti " + mängija.getRelv1());
                            else if (misRelvaAsendada == 2)
                                System.out.println("Panid kotti " + mängija.getRelv2());
                            mängija.võtaKotistRelv(kotistVõetavRelv, misRelvaAsendada);
                        }
                    }
                    System.out.println("Võtsid kotist " + kotistVõetavRelv.getNimi());
                }
            }
        }
        else System.out.println("Sul ei ole ostetud relvi! Mine poodi ja osta üks!");
        Konsool.tühjadRead(10);
    }
}
