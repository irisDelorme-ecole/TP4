public class Point {
    private final double x;
    private final double y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    public boolean equals(Point p){
        if (p == null){
            return false;
        }
        if (p == this){
            return true;
        }
        return x == p.getX() && y == p.getY();
    }
}