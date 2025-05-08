import geometry.Point;

import java.util.*;

public class Triangle {
    private final List<Point> sommets;

    private List<Double> xSommets;
    private List<Double> ySommets;

    private Set<Double> sideLengths;

    public Triangle(HashSet<Point> sommets) {
        this.sommets = new ArrayList<>(sommets);

        setSideLengths();
    }

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

        return  (det * ((bx - ax) * (y - ay) - (by - ay) * (x - ax)) > 0 &&
                det * ((cx - bx) * (y - by) - (cy - by) * (x - bx)) > 0 &&
                det * ((ax - cx) * (y - cy) - (ay - cy) * (x - cx)) > 0);
    }

    public boolean touchesCenter(){
        Point origine = new Point(0,0);
        if (!sommets.contains(origine)){
            double angle0 = Math.atan(sommets.get(0).getX()/sommets.get(0).getY());
            double angle1 = Math.atan(sommets.get(1).getX()/sommets.get(0).getY());
            double angle2 = Math.atan(sommets.get(2).getX()/sommets.get(0).getY());
            return (angle0 == -angle1 || angle0 == -angle2 || angle1 == -angle2);}
        return true;
    }

    public List<Point> getSommets() {
        return sommets;
    }

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

//    public TreeSet<Double> getSidelengths(){
//        return sideLengths;}
//
//    public static bool AboutEqual(double x, double y) {
//    double epsilon = Math.Max(Math.Abs(x), Math.Abs(y)) * 1E-15;
//    return Math.Abs(x - y) <= epsilon;
//}
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Triangle triangle = (Triangle) o;
//        return AboutEqual(sideLengths.get(1), triangle.getSidelengths.get(1)) &&
//            AboutEqual(sideLengths.get(0), triangle.getSidelengths.get(0)) &&
//            AboutEqual(sideLengths.get(2), triangle.getSidelengths.get(2));
//    }

}
