public class Kott {

    private static void väljastaInformatsioon() {
        System.out.println("Siin on võimalik valida oma ostetud relvade vahel. Kokku on võimalik " +
                "valida kaks  relva, mis parandavad mängija parameetreid");
        System.out.println("0. Välju");
        System.out.println("Sisesta relva number, mida soovid valida või välju: ");
    }

    private static void kuvaRelvad(Mängija mängija) {
        System.out.println("Ostetud relvad:");
        for (int i = 0; i < mängija.getOstetud_relvad().size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + mängija.getOstetud_relvad().get(i));
        }
    }

    public static void ava(Mängija mängija) {
        if (mängija.kasRelvOnOstetud()) {
            väljastaInformatsioon();
            kuvaRelvad(mängija);
        } else System.out.println("Sul ei ole ostetud relvi! Mine poodi ja osta üks!");
    }
}
