package Mäng;

import java.util.Scanner;

public class Peaklass {
    public static int Skänner(int valikute_arv){
        while(true){
            Scanner valik = new Scanner(System.in);
            if(valik.hasNextInt()) {
                int nr = valik.nextInt();
                if(nr <= valikute_arv && nr > 0){
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
        System.out.println("Menüü\n"+"1. Võitle vastasega \n"+"2. Mäng.Pood \n"+"3. Vali relvad\n" +"4. Välju mängust");
        System.out.println("Vali tegevus: ");
        //int valik = Skänner(4);
        //if(valik == 1){võitluse meetodi käivitamine}
        //else if(valik == 2){pood.Kuva(mängija);}
        //else if(valik == 3){....
    }
    public static void main(String[] args) {
    Mängija mängija_1 = Intro();
    Relva_valimine rv = new Relva_valimine();
    rv.määra_intro_mängija(new Mängija(mängija_1.getTugevus(), mängija_1.getTäpsus(), mängija_1.getKaitse(), "baas_statsid", 0));
    Pood pood = new Pood();
    Mängija mängija_2 = pood.Kuva(mängija_1);
    Mängija mängija_3 = rv.Kuva(mängija_2);
    Mängija mängija_4 = rv.Kuva(mängija_3);


    // tagastab mängija muudetud raha hulgaga
        //Relva_valimine relva_valimine = new Relva_valimine();
        //relva_valimine.Kuva(mängija);

    //while(true){ Mäng kestab senikaua kuni elud saavad otsa või väljutakse mängust
    //Menüü(pood, mängija);



    }
}
