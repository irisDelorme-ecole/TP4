
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
//
//        char reponse;
//        do {
//            System.out.print("Voulez vous export les triangle en images ? (O/N)");
//            reponse = sc.next().toUpperCase().charAt(0);
//            System.out.println("That is not a valid answer (O or N). Try again!");
//            sc.next();
//        }
//        while (reponse != 'O' && reponse != 'N');
//
//        System.out.println(reponse);

        Cercle c = new Cercle(number);
        System.out.println("Il y a " + c.getNumUniques() + " triangles uniques qui contiennent l'origine dans un cercle de rayon " + number);

        sc.close();
    }
}