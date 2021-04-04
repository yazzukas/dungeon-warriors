import java.util.Scanner;

public class Konsool {
    public static int skanner(int valikuteArv) {
        return skaneerima(valikuteArv, 0);
    }

    public static int skanner(int valikuteArv, int esimeneArv) {
        return skaneerima(valikuteArv, esimeneArv);
    }

    public static int skaneerima(int valikuteArv, int esimeneArv) {
        while (true) {
            Scanner valik = new Scanner(System.in);
            if (valik.hasNextInt()) {
                int nr = valik.nextInt();
                if (nr <= valikuteArv + esimeneArv - 1 && nr >= esimeneArv) return nr;
                else System.out.println("Sisesta uuesti: ");
            }
            else System.out.println("Sisesta number!");
        }
    }
}
