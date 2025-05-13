
import geometry.Cercle;

import java.util.Scanner;

/**javadoc par github copilot
 * <p>
 * La classe principale contenant le point d'entrée du programme.
 * Elle permet de créer un cercle, d'exporter ses triangles en images,
 * et d'afficher des statistiques sur les triangles uniques.
 */
public class main {

    /**
     * Point d'entrée principal du programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Demande à l'utilisateur de saisir un entier représentant le rayon du cercle
        System.out.print("Enter an integer: ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid integer. Try again!");
            sc.next(); // Efface l'entrée invalide
        }
        int number = sc.nextInt();

        char reponse;

        // Demande à l'utilisateur s'il souhaite exporter les triangles en images
        System.out.print("Voulez vous export les triangle en images ? (O/N)");
        do {
            reponse = sc.next().toUpperCase().charAt(0);
            if (reponse != 'O' && reponse != 'N') {
                System.out.println("That is not a valid answer (O or N). Try again!");
            }
        }
        while (reponse != 'O' && reponse != 'N');

        // Crée un cercle avec le rayon fourni
        Cercle c = new Cercle(number);

        // Si l'utilisateur souhaite exporter les triangles, demande le nombre maximum d'images
        if (reponse == 'O') {

            System.out.print("Enter an integer for the max number of images: ");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a valid integer. Try again!");
                sc.next(); // Efface l'entrée invalide
            }
            int nbImg = sc.nextInt();

            // Crée une instance de la classe export pour générer les images
            new export(c, nbImg);
        }

        // Affiche le nombre de triangles uniques contenant l'origine
        System.out.println("Il y a " + c.getNumUniques() + " triangles uniques qui contiennent l'origine dans un cercle de rayon " + number);

        sc.close(); // Ferme le Scanner
    }
}