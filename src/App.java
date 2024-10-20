import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int raha = 5;  // Pelaajalla on aluksi 5 e

        // Github-harjoitus: Slots-peli (Lucky7-variaatio)
        // Pelin aloitus: kysytään haluaako pelaaja pelata (Y/N). (R) ilmoittaa jäljellä olevan rahan.

        while (raha > 0) {
            System.out.println("Haluatko pelata? (Y/N) (R) ilmoittaa jäljellä olevan rahan.");
            String vastaus = scanner.nextLine().toLowerCase();

            if (vastaus.equals("y")) {
                if (raha < 1) {
                    System.out.println("Rahasi loppuivat. Peli päättyy.");
                    break;
                }

                raha--;  // Vähennetään 1 euron pelistä
                System.out.println("Pelit maksavat 1 e. Jäljellä oleva rahamäärä: " + raha + " e");

                // Arvotaan kolme numeroa väliltä 1-10
                int num1 = random.nextInt(10) + 1;
                int num2 = random.nextInt(10) + 1;
                int num3 = random.nextInt(10) + 1;

                // Tulostetaan arvotut numerot
                System.out.println("Arvotut numerot: " + num1 + ", " + num2 + ", " + num3);

                // Laske, kuinka monta seitsemää saatiin
                int voitto = 0;
                if (num1 == 7) voitto++;
                if (num2 == 7) voitto++;
                if (num3 == 7) voitto++;

                // Voitot perustuvat seitsemien määrään
                if (voitto == 1) {
                    System.out.println("Onnittelut! Voitit 3 e.");
                    raha += 3;
                } else if (voitto == 2) {
                    System.out.println("Onnittelut! Voitit 5 e.");
                    raha += 5;
                } else if (voitto == 3) {
                    System.out.println("Onnittelut! Voitit 10 e.");
                    raha += 10;
                } else {
                    System.out.println("Hävisit. Yksikään numeroista ei ollut seitsemän.");
                }

                System.out.println("Jäljellä oleva rahamäärä: " + raha + " e");

            } else if (vastaus.equals("r")) {
                // Näytä jäljellä oleva raha
                System.out.println("Sinulla on " + raha + " e jäljellä.");
            } else if (vastaus.equals("n")) {
                System.out.println("Kiitos pelaamisesta!");
                break;  // Lopeta peli
            } else {
                System.out.println("Virheellinen valinta. Valitse Y, N tai R.");
            }
        }

        // Jos rahat loppuivat, peli päättyy
        if (raha <= 0) {
            System.out.println("Rahasi loppuivat. Peli päättyy.");
        }

        scanner.close();
    }
}