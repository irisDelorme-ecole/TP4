
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid integer. Try again!");
            sc.next(); // Clear invalid input
        }
        int number = sc.nextInt();

        char reponse;

        System.out.print("Voulez vous export les triangle en images ? (O/N)");
        do {
            reponse = sc.next().toUpperCase().charAt(0);
            if (reponse != 'O' && reponse != 'N') {
                System.out.println("That is not a valid answer (O or N). Try again!");
            }
        }
        while (reponse != 'O' && reponse != 'N');

        Cercle c = new Cercle(number);

        if (reponse == 'O') {
            new export(c);
        }

        System.out.println("Il y a " + c.getNumUniques() + " triangles uniques qui contiennent l'origine dans un cercle de rayon " + number);

        sc.close();
    }
}