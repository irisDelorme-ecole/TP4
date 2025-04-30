import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Triangle {
    private final List<Point> sommets;

    private List<Double> xSommets;
    private List<Double> ySommets;

    private Set<Double> sideLengths;

    public Triangle(HashSet<Point> sommets) {
        this.sommets = new ArrayList<>(sommets);

        setSideLengths();

    }
    public double crossProduct(Point a, Point b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }
    public boolean containsOrigin(){
        Point origine = new Point(0, 0);
        if (Objects.equals(sommets.get(0), origine) || sommets.get(1).equals(origine) || sommets.get(2).equals(origine)) {
            return false;
        }
        return (crossProduct(sommets.get(0), sommets.get(1)) >= 0 && crossProduct(sommets.get(0), sommets.get(2)) >= 0 && crossProduct(sommets.get(2), sommets.get(1)) >= 0) ||
                (crossProduct(sommets.get(0), sommets.get(1)) <= 0 && crossProduct(sommets.get(0), sommets.get(2)) <= 0 && crossProduct(sommets.get(2), sommets.get(1)) <= 0);
    }

    public List<Point> getSommets() {
        return sommets;
    }

    private void setSideLengths() {
        sideLengths = new HashSet<>();


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





    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(sideLengths, triangle.sideLengths);
    }

}
