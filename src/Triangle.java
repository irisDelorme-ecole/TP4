import geometry.Point;

import java.util.*;

/**javadoc par github copilot
 * <p>
 * La classe Triangle représente un triangle défini par ses sommets.
 * Elle fournit des méthodes pour vérifier si le triangle contient l'origine
 * ou touche le centre, ainsi que pour obtenir les sommets et les longueurs des côtés.
 */
public class Triangle {
    private final List<Point> sommets;

    private List<Double> xSommets;
    private List<Double> ySommets;

    private Set<Double> sideLengths;

    /**
     * Constructeur pour créer un triangle avec un ensemble de sommets.
     *
     * @param sommets Un ensemble contenant les sommets du triangle.
     */
    public Triangle(HashSet<Point> sommets) {
        this.sommets = new ArrayList<>(sommets);
        setSideLengths();
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
     * Vérifie si le triangle touche le centre (origine).
     *
     * @return true si le triangle touche le centre, sinon false.
     */
    public boolean touchesCenter() {
        Point origine = new Point(0, 0);
        if (!sommets.contains(origine)) {
            double angle0 = Math.atan(sommets.get(0).getX() / sommets.get(0).getY());
            double angle1 = Math.atan(sommets.get(1).getX() / sommets.get(0).getY());
            double angle2 = Math.atan(sommets.get(2).getX() / sommets.get(0).getY());
            return (angle0 == -angle1 || angle0 == -angle2 || angle1 == -angle2);
        }
        return true;
    }

    /**
     * Retourne la liste des sommets du triangle.
     *
     * @return Une liste contenant les sommets du triangle.
     */
    public List<Point> getSommets() {
        return sommets;
    }

    /**
     * Initialise les longueurs des côtés du triangle.
     */
    private void setSideLengths() {
        sideLengths = new TreeSet<>();

        sideLengths.add(
                Math.sqrt(
                        Math.pow(sommets.get(0).getX(), 2) + Math.pow(sommets.get(0).getY(), 2)
                                - Math.pow(sommets.get(1).getX(), 2) + Math.pow(sommets.get(1).getY(), 2))
        );
        sideLengths.add(
                Math.sqrt(
                        Math.pow(sommets.get(0).getX(), 2) + Math.pow(sommets.get(0).getY(), 2)
                                - Math.pow(sommets.get(2).getX(), 2) + Math.pow(sommets.get(2).getY(), 2))
        );
        sideLengths.add(
                Math.sqrt(
                        Math.pow(sommets.get(2).getX(), 2) + Math.pow(sommets.get(1).getY(), 2)
                                - Math.pow(sommets.get(1).getX(), 2) + Math.pow(sommets.get(1).getY(), 2))
        );
    }

    /**
     * Vérifie si un autre objet est égal à ce triangle.
     *
     * @param o L'objet à comparer.
     * @return true si l'objet est égal à ce triangle, sinon false.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return true;
    }
}