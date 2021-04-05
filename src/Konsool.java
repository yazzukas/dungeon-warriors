import java.util.Scanner;

public class Konsool {
    public static int skanner(int valikuteArv) {
        return skaneerima(valikuteArv, 0);
    }

    public static int skanner(int valikuteArv, int esimeneArv) {
        return skaneerima(valikuteArv, esimeneArv);
    }

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
