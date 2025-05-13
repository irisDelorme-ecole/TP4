package test;

import geometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;


/**javadoc de github copilot
 * <p>
 * Classe de test pour la classe {@link Cercle}.
 * Cette classe vérifie les fonctionnalités de la classe Cercle à l'aide de tests unitaires.
 */
class CercleTest {

    /**
     * Cercle de rayon 2 pour les tests.
     */
    static Cercle c;

    /**
     * Cercle de rayon 3 pour les tests.
     */
    static Cercle c2;

    /**
     * Cercle de rayon 5 pour les tests.
     */
    static Cercle c3;

    /**
     * Méthode d'initialisation qui crée les instances de cercles avant l'exécution des tests.
     */
    @BeforeAll
    static void beforeAll() {
        c = new Cercle(2);
        c2 = new Cercle(3);
        c3 = new Cercle(5);
    }

    /**
     * Teste la méthode {@code getPointsInt()} de la classe Cercle.
     * Vérifie si un point est correctement reconnu comme étant à l'intérieur ou à l'extérieur du cercle.
     */
    @Test
    public void testPointsInt() {
        Point p = new Point(-2, -2);
        assertFalse(c.getPointsInt().contains(p));//does not contain point outside of circle
        assertTrue(c2.getPointsInt().contains(p)); //does contain correct point
    }

    /**
     * Teste la méthode {@code getNumUniques()} de la classe Cercle.
     * Vérifie si le nombre de points uniques est correctement calculé pour différents cercles.
     */
    @Test
    public void testNumUniques() {
        assertEquals(8, c.getNumUniques());
        assertEquals(360, c2.getNumUniques());
        assertEquals(10600, c3.getNumUniques());
    }
}