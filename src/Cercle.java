import java.util.*;

public class Cercle
{
    public Cercle(int rayon){
        this.rayon = rayon;
        setPoints(rayon);
        setAllTriangles(pointsInt);
        setUniqueTriangles(allTriangles);
    }

    private int rayon;

    private List<Point> pointsInt;

    private List<Triangle> allTriangles;

    private Set<Triangle> uniqueTriangles;

    private void setPoints(int rayon){
        pointsInt = new ArrayList<>();
        for (int i = 0; i < rayon; i++) {//x
            for (int j = 0; j < rayon; j++) {//y
                if (Math.pow(i,2)+Math.pow(j,2)<rayon){//check si vrm in cercle
                pointsInt.add(new Point(i,j));
                pointsInt.add(new Point(-i,j));//all sign options, all in cercle cause 360 sim
                pointsInt.add(new Point(i,-j));
                pointsInt.add(new Point(-i,-j));
            }}
        }
    }

    public int getNumUniques(){
        return uniqueTriangles.size();
    }

    private void setUniqueTriangles(List<Triangle> triangles){
            HashSet<Triangle> uniqueTriangles = new HashSet<>();

            for(Triangle triangle : triangles){//check tous les triangles
                if (triangle.getSommets().get(0) != triangle.getSommets().get(1) &&
                        triangle.getSommets().get(2) != triangle.getSommets().get(1) &&
                        triangle.getSommets().get(0) != triangle.getSommets().get(2) &&
                        triangle.containsOrigin()){
                    uniqueTriangles.add(triangle);//should not have rotations because of the set equals().
                }

            }
            this.uniqueTriangles = uniqueTriangles;
    }


        public void setAllTriangles(List<Point> set) {
        allTriangles = new ArrayList<>();
        HashSet<Point> subset = new HashSet<>();

            for (int i = 0; i < set.size(); i++) {
                for (int j = i+1; j < set.size(); j++) {
                    for (int k = j+1; k < set.size(); k++) {
                        subset.add(set.get(i));
                        subset.add(set.get(j));
                        subset.add(set.get(k));
                        if (subset.size() > 2){
                            allTriangles.add(new Triangle(subset));}
                        subset.clear();
                    }
                }
            }

        }//backtracking((?not sure for name) subset generator)

    }


