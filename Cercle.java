import java.util.*;

public class Cercle
{
    public Cercle(int rayon){
        this.rayon = rayon;
        setPoints(rayon);
        setAllTriangles(pointsInt);
    }

    private int rayon;

    private List<Point> pointsInt;

    private List<Triangle> allTriangles;

    private List<Triangle> uniqueTriangles;

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


    private void setUniqueTriangles(List<Triangle> triangles){
            ArrayList<Triangle> uniqueTriangles = new ArrayList<>();

            for(Triangle triangle : triangles){//check tous les triangles
                if (!(((triangle.getSommets().get(0).getX() <= 0 && triangle.getSommets().get(1).getX() <= 0 && triangle.getSommets().get(2).getX() <= 0)//si un triangle est entierement dans une moitie du cercle(donc not containing origin.)
                        || (triangle.getSommets().get(0).getX() >= 0)//like one before, need to make actually readable
                        || (triangle.getSommets().get(0).getY() <= 0)
                        || (triangle.getSommets().get(0).getY() >= 0)))

                //si l'origine est sur une arrete du triangle
                       //voir photo pour reste, can't do too much alone.

                )
                {

                }
            }
    }


        public void setAllTriangles(List<Point> set) {

        ArrayList<Point> subset = new ArrayList<>();

            for (int i = 0; i < set.size(); i++) {
                for (int j = i+1; j < set.size(); j++) {
                    for (int k = j+1; k < set.size(); k++) {
                        subset.add(set.get(i));
                        subset.add(set.get(j));
                        subset.add(set.get(k));
                        allTriangles.add(new Triangle(subset));
                        subset.clear();
                    }
                }
            }

        }//backtracking((?not sure for name) subset generator)

    }


