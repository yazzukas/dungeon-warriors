public class Peaklass {

    public static void väljastaInformatsioon() {
        System.out.println("Tere tulemast mängu X. Mängu alustamiseks vali endale mängija. " +
                "Valimiseks vajuta vastavat numbri");
        System.out.println("Mängijad:" + "\n" + "1. Tugev Madis \n" + "2. Täpne Legolas \n" + "3. Hiiliv Silver");
        System.out.println("Sisesta mängija number: ");
    }

    public static Mängija mängijaValik(){
        int valik = Konsool.skanner(3, 1);
        if (valik == 1) return new Mängija(80, 40, 60, "Tugev Madis", 300);
        else if (valik == 2) return new Mängija(60, 85, 40, "Täpne Legolas", 0);
        else return new Mängija(40, 60, 80, "Hiiliv Silver", 0);
    }

    public static void main(String[] args) {
        väljastaInformatsioon();

        Mängija mängija = mängijaValik();
        Relva_valimine relva_valimine = new Relva_valimine();
        relva_valimine.määra_intro_mängija(new Mängija(mängija.getTugevus(), mängija.getTäpsus(), mängija.getKaitse(), "baas_statsid", 0));

        boolean mängKäib = true;
        while (mängKäib) {
            System.out.println("MENÜÜ\n" + "Vali tegevus sisestades tegevuse ees olev number:");
            System.out.println("0. Välju mängust\n" + "1. Pood \n" + "2. Vali relvad\n" + "3. Võitle vastasega \n");
            System.out.println("Vali tegevus: ");
            int valik = Konsool.skanner(4);
            if (valik == 0) mängKäib = false;
            else if (valik == 1) Pood.sisene(mängija);
            else if (valik == 2) mängija = relva_valimine.Kuva(mängija);
            else if(valik == 3) Võitlus.võitle(mängija);
        }
    }
}
