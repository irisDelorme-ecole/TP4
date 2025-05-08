import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class export {
    private static final char fSep = File.separatorChar;

    // Chemin d'accès par défaut vers le répertoire des données
    private static final String pathIn = System.getProperty("user.dir") + fSep + "src" + fSep + "TrianglesExport" + fSep ;
    public export(Cercle c){
        String imagePath = "defaultCircleWithPoints.png";
        try{
            File f = new File(pathIn + imagePath);
            BufferedImage myPicture = new BufferedImage(c.getRayon()*100, c.getRayon()*100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = myPicture.createGraphics();

            g2d.setPaint ( new Color ( 255, 255, 255 ) );
            g2d.fillRect ( 0, 0, myPicture.getWidth(), myPicture.getHeight() );
            //make new graphic
            g2d.dispose();
            g2d = myPicture.createGraphics();//end of make new graphic
            g2d.setColor(Color.BLUE);
            g2d.drawOval(0, 0, myPicture.getWidth(), myPicture.getHeight());
//            //make new graphic
//            g2d.dispose();
//            g2d = myPicture.createGraphics();//end of make new graphic
//            g2d.setColor(Color.BLACK);
//            g2d.drawLine(50, 50, 150, 150);//trying to figure out coordinates
            //make all points
            for(Point p : c.getPointsInt()){
                g2d.dispose();
                g2d = myPicture.createGraphics();
                int xAdjusted = (int)(p.getX()*50) +50*c.getRayon();
                int yAdjusted = (int)(p.getY()*50) +50*c.getRayon();
                g2d.setColor(Color.BLACK);
                g2d.fillOval(xAdjusted, yAdjusted, 4, 4);}
            ImageIO.write(myPicture, "jpg", f);

            triangleIntoImage(myPicture, c);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static BufferedImage copyImage(BufferedImage source){
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    public void triangleIntoImage(BufferedImage image, Cercle c){
        try{
            int compteurTri = 0;
            for (Triangle t : c.getUniqueTriangles()){
                if (compteurTri >= 15){
                    break;
                } else{
                    BufferedImage tempImage = copyImage(image);
                    Graphics2D g2d = tempImage.createGraphics();
                    List<Point> points = t.getSommets();
                    //line 0-1
                    g2d.setColor(Color.RED);
                    g2d.drawLine(((int)(points.get(0).getX())*50 + 50*c.getRayon()),(int)(points.get(0).getY())*50 + 50*c.getRayon(),(int)(points.get(1).getX())*50 + 50*c.getRayon(), (int)((points.get(1).getY())*50 + 50*c.getRayon()) );
//line 0-2
                    g2d.dispose();
                    g2d = tempImage.createGraphics();
                    g2d.setColor(Color.RED);
                    g2d.drawLine(((int)(points.get(0).getX())*50 + 50*c.getRayon()),(int)(points.get(0).getY())*50 + 50*c.getRayon(),(int)(points.get(2).getX())*50 + 50*c.getRayon(), (int)((points.get(2).getY())*50 + 50*c.getRayon()) );
                    //line 2-1
                    g2d.dispose();
                    g2d = tempImage.createGraphics();
                    g2d.setColor(Color.RED);
                    g2d.drawLine(((int)(points.get(2).getX())*50 + 50*c.getRayon()),(int)(points.get(2).getY())*50 + 50*c.getRayon(),(int)(points.get(1).getX())*50 + 50*c.getRayon(), (int)((points.get(1).getY())*50 + 50*c.getRayon()) );

                    ImageIO.write(tempImage , "jpg", new File(pathIn + "triangle" + compteurTri + ".jpg"));
                    compteurTri++;}}
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cercle c = new Cercle(2);
        new export(c);
    }
}