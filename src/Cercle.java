import java.util.*;
import geometry.Point;
import geometry.Point;
/**javadoc par github copilot
 * <p>
 * Représente un cercle et calcule les points et triangles associés à son rayon.
 */
public class Cercle {

    /**
     * Rayon du cercle.
     */
    private int rayon;

    /**
     * Liste des points entiers à l'intérieur du cercle.
     */
    private List<Point> pointsInt;

    /**
     * Liste de tous les triangles possibles formés par les points.
     */
    private List<Triangle> allTriangles;

    /**
     * Ensemble des triangles uniques contenant l'origine.
     */
    private Set<Triangle> uniqueTriangles;

    /**
     * Constructeur de la classe Cercle.
     *
     * @param rayon Le rayon du cercle.
     */
    public Cercle(int rayon) {
        this.rayon = rayon;
        setPoints(rayon);
        setAllTriangles(pointsInt);
        setUniqueTriangles(allTriangles);
    }

    /**
     * Retourne la liste des points entiers à l'intérieur du cercle.
     *
     * @return Liste des points entiers.
     */
    public List<Point> getPointsInt() {
        return pointsInt;
    }

    /**
     * Retourne l'ensemble des triangles uniques contenant l'origine.
     *
     * @return Ensemble des triangles uniques.
     */
    public Set<Triangle> getUniqueTriangles() {
        return uniqueTriangles;
    }

    /**
     * Retourne le rayon du cercle.
     *
     * @return Rayon du cercle.
     */
    public int getRayon() {
        return rayon;
    }

    /**
     * Initialise les points entiers à l'intérieur du cercle en fonction du rayon.
     *
     * @param rayon Le rayon du cercle.
     */
    private void setPoints(int rayon) {
        pointsInt = new ArrayList<>();
        for (int x = -(rayon - 1); x < rayon; x++) {
            for (int y = -(rayon - 1); y < rayon; y++) {
                if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) < rayon) {
                    pointsInt.add(new Point(x, y));
                }
            }
        }
    }

    /**
     * Retourne le nombre total de triangles uniques contenant l'origine.
     *
     * @return Nombre de triangles uniques.
     */
    public long getNumUniques() {
        return uniqueTriangles.size();
    }

    /**
     * Définit l'ensemble des triangles uniques contenant l'origine.
     *
     * @param triangles Liste des triangles à vérifier.
     */
    private void setUniqueTriangles(List<Triangle> triangles) {
        HashSet<Triangle> uniqueTriangles = new HashSet<>();
        List<Triangle> prev = new ArrayList<>();

        for (Triangle triangle : triangles) { // Vérifie tous les triangles
            if (triangle.containsOrigin()) { // Vérifie si le triangle contient l'origine
                prev.add(triangle);
                uniqueTriangles.add(triangle); // Élimine les rotations grâce à l'égalité des ensembles.
            }
        }
        this.uniqueTriangles = uniqueTriangles;
    }

    /**
     * Définit tous les triangles possibles formés par les points.
     *
     * @param set Liste des points à utiliser pour former les triangles.
     */
    public void setAllTriangles(List<Point> set) {
        allTriangles = new ArrayList<>();
        HashSet<Point> subset = new HashSet<>();

        for (int i = 0; i < set.size(); i++) {
            for (int j = i + 1; j < set.size(); j++) {
                for (int k = j + 1; k < set.size(); k++) {
                    subset.add(set.get(i));
                    subset.add(set.get(j));
                    subset.add(set.get(k));
                    if (subset.size() > 2) {
                        allTriangles.add(new Triangle(subset));
                    }
                    subset.clear();
                }
            }
        }
    }
}