import java.util.*;

import geometry.Point;
import geometry.Point;

public class Cercle {
    public Cercle(int rayon) {
        this.rayon = rayon;
        setPoints(rayon);
        setAllTriangles(pointsInt);
        setUniqueTriangles(allTriangles);
    }

    private int rayon;

    private List<Point> pointsInt;

    private List<Triangle> allTriangles;

    private Set<Triangle> uniqueTriangles;

    public List<Point> getPointsInt() {
        return pointsInt;
    }

    public Set<Triangle> getUniqueTriangles() {
        return uniqueTriangles;
    }

    public int getRayon() {
        return rayon;
    }

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

    public int getNumTriangles() {
        return allTriangles.size();
    }

    public long getNumUniques() {
        return uniqueTriangles.size();
    }

    private void setUniqueTriangles(List<Triangle> triangles) {
        HashSet<Triangle> uniqueTriangles = new HashSet<>();
        List<Triangle> prev = new ArrayList<>();

        for (Triangle triangle : triangles) {//check tous les triangles
            if (triangle.containsOrigin() && triangle.touchesCenter()) {//&& !prev.contains(triangle)
                prev.add(triangle);
                uniqueTriangles.add(triangle);//should not have rotations because of the set equals().
            }
        }
        this.uniqueTriangles = uniqueTriangles;
    }


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

    }//backtracking((?not sure for name) subset generator)

}