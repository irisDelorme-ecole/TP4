import geometry.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**javadoc par github copilot
 * <p>
 * La classe export est responsable de l'exportation d'images basées sur des cercles,
 * des points et des triangles uniques.
 */
public class export {
    private static final char fSep = File.separatorChar;
    private static int nbImageMax = 0;
    // Chemin d'accès par défaut vers le répertoire des données
    private static final String pathIn = System.getProperty("user.dir") + fSep + "src" + fSep + "TrianglesExport" + fSep;

    /**
     * Constructeur de la classe export.
     *
     * @param c      Le cercle contenant des informations sur les points et les triangles.
     * @param nbImg  Le nombre maximum d'images à créer.
     */
    public export(Cercle c, int nbImg) {
        nbImageMax = nbImg;
        String imagePath = "defaultCircleWithPoints.png";
        try {
            File f = new File(pathIn + imagePath);
            BufferedImage myPicture = new BufferedImage(c.getRayon() * 100, c.getRayon() * 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = myPicture.createGraphics();

            g2d.setPaint(new Color(255, 255, 255));
            g2d.fillRect(0, 0, myPicture.getWidth(), myPicture.getHeight());
            // Création d'un nouveau graphique
            g2d.dispose();
            g2d = myPicture.createGraphics();
            g2d.setColor(Color.BLUE);
            g2d.drawOval(0, 0, myPicture.getWidth(), myPicture.getHeight());

            // Dessin de tous les points du cercle
            for (Point p : c.getPointsInt()) {
                g2d.dispose();
                g2d = myPicture.createGraphics();
                int xAdjusted = (int) (p.getX() * 50) + 50 * c.getRayon();
                int yAdjusted = (int) (p.getY() * 50) + 50 * c.getRayon();
                g2d.setColor(Color.BLACK);
                g2d.fillOval(xAdjusted, yAdjusted, 4, 4);
            }
            ImageIO.write(myPicture, "jpg", f);

            triangleIntoImage(myPicture, c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crée une copie d'une image BufferedImage.
     *
     * @param source L'image source à copier.
     * @return Une nouvelle BufferedImage identique à la source.
     */
    public static BufferedImage copyImage(BufferedImage source) {
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    /**
     * Dessine les triangles uniques du cercle sur des images.
     *
     * @param image L'image de base à utiliser.
     * @param c     Le cercle contenant les triangles uniques.
     */
    public void triangleIntoImage(BufferedImage image, Cercle c) {
        try {
            int compteurTri = 0;
            for (Triangle t : c.getUniqueTriangles()) {
                if (compteurTri >= nbImageMax) {
                    break;
                } else {
                    BufferedImage tempImage = copyImage(image);
                    Graphics2D g2d = tempImage.createGraphics();
                    List<geometry.Point> points = t.getSommets();
                    // Ligne entre les sommets 0 et 1
                    g2d.setColor(Color.RED);
                    g2d.drawLine(((int) (points.get(0).getX()) * 50 + 50 * c.getRayon()),
                            (int) (points.get(0).getY()) * 50 + 50 * c.getRayon(),
                            (int) (points.get(1).getX()) * 50 + 50 * c.getRayon(),
                            (int) ((points.get(1).getY()) * 50 + 50 * c.getRayon()));

                    // Ligne entre les sommets 0 et 2
                    g2d.dispose();
                    g2d = tempImage.createGraphics();
                    g2d.setColor(Color.RED);
                    g2d.drawLine(((int) (points.get(0).getX()) * 50 + 50 * c.getRayon()),
                            (int) (points.get(0).getY()) * 50 + 50 * c.getRayon(),
                            (int) (points.get(2).getX()) * 50 + 50 * c.getRayon(),
                            (int) ((points.get(2).getY()) * 50 + 50 * c.getRayon()));

                    // Ligne entre les sommets 2 et 1
                    g2d.dispose();
                    g2d = tempImage.createGraphics();
                    g2d.setColor(Color.RED);
                    g2d.drawLine(((int) (points.get(2).getX()) * 50 + 50 * c.getRayon()),
                            (int) (points.get(2).getY()) * 50 + 50 * c.getRayon(),
                            (int) (points.get(1).getX()) * 50 + 50 * c.getRayon(),
                            (int) ((points.get(1).getY()) * 50 + 50 * c.getRayon()));

                    ImageIO.write(tempImage, "jpg", new File(pathIn + "triangle" + compteurTri + ".jpg"));
                    compteurTri++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Point d'entrée principal du programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
    }
}