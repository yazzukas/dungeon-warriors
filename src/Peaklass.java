package Mäng;

import java.util.Scanner;

public class Peaklass {
    public static int Skänner(int valikute_arv){
        while(true){
            Scanner valik = new Scanner(System.in);
            if(valik.hasNextInt()) {
                int nr = valik.nextInt();
                if(nr <= valikute_arv && nr >= 0){
                    return nr;
                }
                else System.out.println("Sisesta uuesti: ");
            }
            else System.out.println("Sisesta number!");
        }
    }
    public static Mängija Intro(){
        System.out.println("Tere tulemast mängu X. Mängu alustamiseks vali endale mängija. " +
                "Valimiseks vajuta vastavat numbri");
        System.out.println("Mängijad:"+"\n"+"1. Tugev Madis \n"+"2. Täpne Legolas \n"+"3. Hiiliv Silver");
        System.out.println("Sisesta mängija number: ");
        int valik = Skänner(3);
        if (valik == 1) { return new Mängija(80, 40, 60, "Tugev Madis",300);}
        else if (valik == 2) { return new Mängija(60, 85, 40, "Täpne Legolas",0);}
        else { return new Mängija(40, 60, 80, "Hiiliv Silver",0);}

    }
    public static void Menüü(Pood pood, Mängija mängija){
        //int valik = Skänner(4);
        //if(valik == 1){võitluse meetodi käivitamine}
        //else if(valik == 2){pood.Kuva(mängija);}
        //else if(valik == 3){....
    }
    public static void main(String[] args) {
    Mängija mängija = Intro();
    Relva_valimine relva_valimine = new Relva_valimine();
    relva_valimine.määra_intro_mängija(new Mängija(mängija.getTugevus(), mängija.getTäpsus(), mängija.getKaitse(), "baas_statsid", 0));
    Pood pood = new Pood();
    while(true){
        System.out.println("MENÜÜ\n"+"Vali tegevus sisestades tegevuse ees olev number:");
        System.out.println("0. Välju mängust\n"+"1. Pood \n"+"2. Vali relvad\n"+"3. Võitle vastasega \n");
        System.out.println("Vali tegevus: ");
        int valik = Skänner(2);
        if (valik == 0) {
            break;
        }
        else if(valik == 1){
            mängija = pood.Kuva(mängija);
        }
        else if(valik == 2){
            mängija = relva_valimine.Kuva(mängija);
        }
        //else if(valik == 3){
            //mängija = võitle_vastasega.võitlus();
        //}
    }
    }
}
