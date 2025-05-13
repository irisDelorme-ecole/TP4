package geometry;

import java.util.*;

/**javadoc par github copilot
 * <p>
 * La classe geometry.Triangle représente un triangle défini par ses sommets.
 * Elle fournit des méthodes pour vérifier si le triangle contient l'origine
 * ou touche le centre, ainsi que pour obtenir les sommets et les longueurs des côtés.
 */
public class Triangle {
    private final List<Point> sommets;

    /**
     * Constructeur pour créer un triangle avec un ensemble de sommets.
     *
     * @param sommets Un ensemble contenant les sommets du triangle.
     */
    public Triangle(HashSet<Point> sommets) {
        this.sommets = new ArrayList<>(sommets);
    }

    /**
     * Vérifie si le triangle contient le point d'origine (0, 0).
     *
     * @return true si le triangle contient l'origine, sinon false.
     */
    public boolean containsOrigin() {
        Point origine = new Point(0, 0);
        if (Objects.equals(sommets.get(0), origine) || sommets.get(1).equals(origine) || sommets.get(2).equals(origine)) {
            return false;
        }

        double ax = sommets.get(0).getX();
        double bx = sommets.get(1).getX();
        double cx = sommets.get(2).getX();
        double ay = sommets.get(0).getY();
        double by = sommets.get(1).getY();
        double cy = sommets.get(2).getY();

        int x = 0;
        int y = 0;

        double det = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);

        return (det * ((bx - ax) * (y - ay) - (by - ay) * (x - ax)) > 0 &&
                det * ((cx - bx) * (y - by) - (cy - by) * (x - bx)) > 0 &&
                det * ((ax - cx) * (y - cy) - (ay - cy) * (x - cx)) > 0);
    }

    /**
     * Retourne la liste des sommets du triangle.
     *
     * @return Une liste contenant les sommets du triangle.
     */
    public List<Point> getSommets() {
        return sommets;
    }
}