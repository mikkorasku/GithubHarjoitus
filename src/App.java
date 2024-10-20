import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Github-harjoitus: Slots-peli (Lucky7-variaatio)
        // Pelin aloitus: kysytään haluaako pelaaja pelata (Y/N).

        while (true) {
            System.out.println("Haluatko pelata? (Y/N)");
            String vastaus = scanner.nextLine().toLowerCase();

            if (vastaus.equals("y")) {
                // Arvotaan kolme numeroa väliltä 1-10
                int num1 = random.nextInt(10) + 1;
                int num2 = random.nextInt(10) + 1;
                int num3 = random.nextInt(10) + 1;

                // Tulostetaan arvotut numerot
                System.out.println("Arvotut numerot: " + num1 + ", " + num2 + ", " + num3);

                // Tarkistetaan, voittiko pelaaja
                if (num1 == 7 || num2 == 7 || num3 == 7) {
                    System.out.println("Onnittelut! Voitit, koska vähintään yksi numero on seitsemän.");
                } else {
                    System.out.println("Hävisit. Yksikään numeroista ei ollut seitsemän.");
                }
                break;  // Peli päättyy, koska ei ole toistoa
            } else if (vastaus.equals("n")) {
                System.out.println("Kiitos kun pelasit!");
                break;  // Lopetetaan peli
            } else {    // Jos vastaus muu kuin Y/y tai N/n, pyydä valitsemaan uudelleen.
                System.out.println("Virheellinen valinta. Valitse Y tai N.");
            }
        }

        scanner.close();
    }
}
