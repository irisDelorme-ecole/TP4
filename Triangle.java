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
    public static double dotProduct(Point a, Point b) {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }

    public boolean containsOrigin(){
        Point origine = new Point(0, 0);
        if (Objects.equals(sommets.get(0), origine) || sommets.get(1).equals(origine) || sommets.get(2).equals(origine)) {
            return false;
        }
        return ((!(dotProduct(sommets.get(0), sommets.get(1)) >= 0 && dotProduct(sommets.get(0), sommets.get(2)) >= 0 && dotProduct(sommets.get(2), sommets.get(1)) >= 0)) &&
                (!(dotProduct(sommets.get(0), sommets.get(1)) <= 0 && dotProduct(sommets.get(0), sommets.get(2)) <= 0 && dotProduct(sommets.get(2), sommets.get(1)) <= 0))) &&
                !touchesCenter2();
    }

    public boolean touchesCenter2(){
        double angle0 = Math.atan(sommets.get(0).getX()/sommets.get(0).getY());
        double angle1 = Math.atan(sommets.get(1).getX()/sommets.get(0).getY());
        double angle2 = Math.atan(sommets.get(2).getX()/sommets.get(0).getY());
        return (angle0 == -angle1 || angle0 == -angle2 || angle1 == -angle2);
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