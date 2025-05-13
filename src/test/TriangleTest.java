package test;

import geometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**javadoc de github copilot
 * <p>
 * Classe de test pour la classe {@link Triangle}.
 * Cette classe vérifie les fonctionnalités de la classe Triangle avec des tests unitaires.
 */
class TriangleTest {

    /**
     * Triangle avec des sommets (1,1), (-1,1), et (0,-1) pour les tests.
     */
    static Triangle t;

    /**
     * Triangle avec des sommets (-1,-1), (-1,1), et (-1,0) pour les tests.
     */
    static Triangle t2;

    /**
     * Méthode d'initialisation exécutée avant tous les tests.
     * Initialise deux instances de {@link Triangle} avec des sommets différents.
     */
    @BeforeAll
    static void beforeAll() {
        HashSet<Point> som = new HashSet<>();
        som.add(new Point(1, 1));
        som.add(new Point(-1, 1));
        som.add(new Point(0, -1));
        t = new Triangle(som);

        som.clear();
        som.add(new Point(-1, -1));
        som.add(new Point(-1, 1));
        som.add(new Point(-1, 0));
        t2 = new Triangle(som);
    }

    /**
     * Teste la méthode {@code containsOrigin()} de la classe Triangle.
     * Vérifie si l'origine (0,0) est contenue dans le triangle.
     */
    @Test
    void containsOrigin() {
        assertTrue(t.containsOrigin());
        assertFalse(t2.containsOrigin());
    }

    /**
     * Teste la méthode {@code getSommets()} de la classe Triangle.
     * Vérifie si les sommets du triangle sont correctement retournés.
     */
    @Test
    void getSommets() {
        assertTrue(t.getSommets().contains(new Point(0, -1)));
        assertFalse(t.getSommets().contains(new Point(0, 0)));
    }
}