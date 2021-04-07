import java.util.Scanner;

public class Konsool {

    // ootab kasutajalt millegi siestamist või lihtsalt ENTER vajutamist, siis jätkub normaalne tegevus
    public static void ootaEnterVajutamist(){
        System.out.println("---------------------------------------");
        System.out.println("Vajuta ENTER nuppu, et liikuda EDASI!");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }

    public static void tühjadRead(int ridadeArv){
        for (int i = 0; i < ridadeArv; i++)
            System.out.println();
    }

    public static int skanner(int valikuteArv) {
        return skaneerima(valikuteArv, 0);
    }

    public static int skanner(int valikuteArv, int esimeneArv) {
        return skaneerima(valikuteArv, esimeneArv);
    }

    // kontrollib konsooli sisendid, ootab numbrilist vastust
    // valikuteArv - mitu valikut peaks kasutajal olema
    // esimeneArv - milliest arvust alates võiks kasutajal valikud alata
    // näiteks: skanneerima(4, 2) - 2, 3, 4, 5 - on valikud
    private static int skaneerima(int valikuteArv, int esimeneArv) {
        while (true) {
            Scanner valik = new Scanner(System.in);
            if (valik.hasNextInt()) {
                int sisestatudNumber = valik.nextInt();
                if (sisestatudNumber <= valikuteArv + esimeneArv - 1 && sisestatudNumber >= esimeneArv) return sisestatudNumber;
                else System.out.println("Sisesta uuesti: ");
            }
            else System.out.println("Sisesta number!");
        }
    }
}
