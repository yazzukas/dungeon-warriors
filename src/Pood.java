package Mäng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pood {

    private List<Relv> relvad;
    public Pood(){
        this.relvad = Arrays.asList(new Relv(10, 5, 2, "Pistoda", 50),
                new Relv(20, 10, 5, "Mõõk", 100),
                new Relv(2, 10, 5, "Vibu", 50),
                new Relv(5, 20,10,"Amb", 100),
                new Relv(5,2,10,"Puidust kilp", 50),
                new Relv(10,5,20, "Rauast kilp", 100));
    }

    public void Kuva(Mängija mängija){
        System.out.println("Tere tulemast poodi. Siit on võimalik osta relvi, mis muudavad mängija paremaks\n" +
                "Mängija andmed:\n" + mängija);
        System.out.println("Ostmiseks sisesta relva ees olev number!");
        System.out.println("       Tugevus  Täpsus  Kaitse  Hind");
        for(int i = 0; i < relvad.size(); i++){
            System.out.println( String.valueOf(i+1)+". "+ relvad.get(i));
        }
    }
    //public Mängija Osta(){
        //return uute parameetritega mängija
    //}

}
