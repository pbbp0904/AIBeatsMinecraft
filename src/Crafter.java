import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Crafter {

    public void craft(String item) throws AWTException, InterruptedException, IOException {
        switch (item) {
            case "wooden_planks":
                Typer typer = new Typer();
                typer.type("e");
                Thread.sleep(100);
                BufferedImage screen = screenShot();
                BufferedImage img = getImage("C:\\Users\\chris\\IdeaProjects\\AIBeatsMinecraft\\src\\Item_Images\\Log1.JPG");
                ImageIO.write(screen, "jpg", new File("lol.jpg"));
                int[] coords = findSubImage(screen, img);
                System.out.println(coords[0]);
                System.out.println(coords[1]);
                MouseMover mm = new MouseMover();
                mm.moveMouse(coords);

                break;
        }
    }

    private BufferedImage screenShot() throws AWTException {
        Robot robot = new Robot();

        Rectangle screenRect = new Rectangle(700,500,550,300);
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
        return screenFullImage;
    }

    private BufferedImage getImage(String filename) {
        try {
            BufferedImage img = ImageIO.read(new File(filename));
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Finds the a region in one image that best matches another, smaller, image.
     */
    private static int[] findSubImage(BufferedImage im1, BufferedImage im2) {
        int w1 = im1.getWidth();
        int h1 = im1.getHeight();
        int w2 = im2.getWidth();
        int h2 = im2.getHeight();
        assert (w2 <= w1 && h2 <= h1);
        // will keep track of best position found
        int bestX = 0;
        int bestY = 0;
        double lowestDiff = Double.POSITIVE_INFINITY;
        // brute-force search through whole image (slow...)
        for (int x = 0; x < w1 - w2; x++) {
            for (int y = 0; y < h1 - h2; y++) {
                double comp = compareImages(im1.getSubimage(x, y, w2, h2), im2);
                if (comp < lowestDiff) {
                    bestX = x;
                    bestY = y;
                    lowestDiff = comp;
                }
            }
        }
        // output similarity measure from 0 to 1, with 0 being identical
        System.out.println(lowestDiff);
        // return best location
        return new int[]{bestX+700, bestY+500};
    }

    /**
     * Determines how different two identically sized regions are.
     */
    private static double compareImages(BufferedImage im1, BufferedImage im2) {
        assert (im1.getHeight() == im2.getHeight() && im1.getWidth() == im2.getWidth());
        double variation = 0.0;
        for (int x = 0; x < im1.getWidth(); x++) {
            for (int y = 0; y < im1.getHeight(); y++) {
                variation += compareARGB(im1.getRGB(x, y), im2.getRGB(x, y)) / Math.sqrt(3);
            }
        }
        return variation / (im1.getWidth() * im1.getHeight());
    }

    /**
     * Calculates the difference between two ARGB colours (BufferedImage.TYPE_INT_ARGB).
     */
    private static double compareARGB(int rgb1, int rgb2) {
        double r1 = ((rgb1 >> 16) & 0xFF) / 255.0;
        double r2 = ((rgb2 >> 16) & 0xFF) / 255.0;
        double g1 = ((rgb1 >> 8) & 0xFF) / 255.0;
        double g2 = ((rgb2 >> 8) & 0xFF) / 255.0;
        double b1 = (rgb1 & 0xFF) / 255.0;
        double b2 = (rgb2 & 0xFF) / 255.0;
        double a1 = ((rgb1 >> 24) & 0xFF) / 255.0;
        double a2 = ((rgb2 >> 24) & 0xFF) / 255.0;
        // if there is transparency, the alpha values will make difference smaller
        return a1 * a2 * Math.sqrt((r1 - r2) * (r1 - r2) + (g1 - g2) * (g1 - g2) + (b1 - b2) * (b1 - b2));
    }
}
