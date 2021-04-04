import java.util.Scanner;

public class Võitlus {

    private static boolean mängibEsimestKorda = true;

    public void võitle(Mängija mängija){
        if(mängibEsimestKorda) {
            sissejuhatusTekst();
            mängibEsimestKorda = false;
        }
    }

    private static void sissejuhatusTekst(){
        System.out.println("Teretulemast võitlusareenile!");
        System.out.println("Siin saad võidelda vastaste vastu ning võitmise eest saad vastu kuldmünte.");
        System.out.println("Ole ettevaatlik! Kaotus tähendab, et sinu karakter sureb ning pead mängu uuesti alustama.");
        System.out.println("Vastasega võitlemiseks on kolm erinevat moodust:");
        System.out.println("1. Tugev löök - lööd vastast tugeva, kuid ebatäpse löögiga");
        System.out.println("2. Täpne löök - lööd vastast täpse, kuid nõrga löögiga");
        System.out.println("3. Blokeeri vastase löök - proovib blokeerida vastase lööki, see ei pruugi alati õnnestuda ning vahest suudad blokeerida löögi vaid osaliselt");
        System.out.println("Vajuta ENTER, et liikuda EDASI!");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
}