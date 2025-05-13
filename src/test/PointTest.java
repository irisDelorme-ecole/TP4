package test;

import geometry.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**javadoc de github copilot
 * <p>
 * Classe de test pour la classe {@link Point}.
 * Cette classe vérifie les fonctionnalités de la classe Point avec des tests unitaires.
 */
class PointTest {

    /**
     * Point avec les coordonnées (0,0) pour les tests.
     */
    static Point p1;

    /**
     * Point avec les coordonnées (1,2) pour les tests.
     */
    static Point p2;

    /**
     * Point avec les coordonnées (-3,-5) pour les tests.
     */
    static Point p3;

    /**
     * Point avec les coordonnées (1,-1) pour les tests.
     */
    static Point p4;

    /**
     * Deuxième point avec les coordonnées (1,-1) pour vérifier l'égalité.
     */
    static Point p5;

    /**
     * Méthode d'initialisation exécutée avant tous les tests.
     * Initialise les différentes instances de {@link Point}.
     */
    @BeforeAll
    static void beforeAll() {
        p1 = new Point(0, 0);
        p2 = new Point(1, 2);
        p3 = new Point(-3, -5);
        p4 = new Point(1, -1);
        p5 = new Point(1, -1);
    }

    /**
     * Teste la méthode {@code getX()} de la classe Point.
     * Vérifie les valeurs des coordonnées X des différents points.
     */
    @org.junit.jupiter.api.Test
    void getX() {
        assertEquals(0, p1.getX());
        assertEquals(1, p2.getX());
        assertEquals(-3, p3.getX());
        assertEquals(1, p4.getX());
    }

    /**
     * Teste la méthode {@code getY()} de la classe Point.
     * Vérifie les valeurs des coordonnées Y des différents points.
     */
    @org.junit.jupiter.api.Test
    void getY() {
        assertEquals(0, p1.getY());
        assertEquals(2, p2.getY());
        assertEquals(-5, p3.getY());
        assertEquals(-1, p4.getY());
    }

    /**
     * Teste la méthode {@code equals()} de la classe Point.
     * Vérifie le comportement de la méthode pour différents cas d'égalité.
     */
    @org.junit.jupiter.api.Test
    void testEquals() {
        assertFalse(p1.equals(p2));
        assertTrue(p4.equals(p5));
        assertFalse(p3.equals(null));
        assertTrue(p4.equals(p4));
    }
}