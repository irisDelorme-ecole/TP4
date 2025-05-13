package geometry;

/**javadoc par github copilot
 * <p>
 * Classe représentant un point en 2D avec des coordonnées x et y.
 */
public class Point {
    // Attributs privés immuables pour les coordonnées du point
    private final double x;
    private final double y;

    /**
     * Constructeur pour initialiser un point avec des coordonnées données.
     *
     * @param x La coordonnée x du point.
     * @param y La coordonnée y du point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retourne la coordonnée x du point.
     *
     * @return La coordonnée x.
     */
    public double getX() {
        return x;
    }

    /**
     * Retourne la coordonnée y du point.
     *
     * @return La coordonnée y.
     */
    public double getY() {
        return y;
    }

    /**
     * Vérifie si ce point est égal à un autre point donné.
     * Deux points sont égaux si leurs coordonnées x et y sont identiques.
     *
     * @param p Le point à comparer avec ce point.
     * @return {@code true} si les deux points sont égaux, sinon {@code false}.
     */
    public boolean equals(Point p) {
        if (p == null) {
            return false;
        }
        if (p == this) {
            return true;
        }
        return x == p.getX() && y == p.getY();
    }
}