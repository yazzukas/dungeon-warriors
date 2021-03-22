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
        if (valik == 1) { return new Mängija(80, 40, 60, "Tugev Madis",0);}
        else if (valik == 2) { return new Mängija(60, 85, 40, "Täpne Legolas",0);}
        else { return new Mängija(40, 60, 80, "Hiiliv Silver",0);}

    }
    public static void Menüü(){
        System.out.println("Menüü\n"+"1. Võitle vastasega \n"+"2. Mäng.Pood \n"+"3. Välju mängust");
        System.out.println("Vali tegevus: ");

    }
    public static void main(String[] args) {
    Mängija mängija = Intro();
    //while(true){ Mäng kestab senikaua kuni elud saavad otsa või väljutakse mängust
    //Menüü();
    Pood pood = new Pood();
    pood.Kuva(mängija);


    }
}
