import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Crafter {

    Typer typer = new Typer();
    MouseMover mm = new MouseMover();
    BufferedImage screen;
    BufferedImage img;
    int[] coords;
    int shortSleepTime = 40;
    int longSleepTime = 100;
    static int searchSpacing = 5;
    int[] handCraftSlot1 = new int[]{1015,360};
    int[] handCraftSlot2 = new int[]{1067,360};
    int[] handCraftSlot3 = new int[]{1067,413};
    int[] handCraftSlot4 = new int[]{1015,413};
    int[] handCraftSlotRes = new int[]{1189,390};


    public Crafter() throws AWTException {
    }

    public void craft(String item, int number) throws AWTException, InterruptedException, IOException {
        switch (item) {
            case "wooden_planks":
                // Open inventory
                typer.type("e");
                Thread.sleep(longSleepTime);
                // Take a screenshot
                screen = screenShot();
                // Grab relevant image
                img = getImage("C:\\Users\\chris\\IdeaProjects\\AIBeatsMinecraft\\src\\Item_Images\\Log1.JPG");
                // Find image in screenshot
                coords = findSubImage(screen, img);
                // Pick up items
                mm.moveMouse(coords);
                Thread.sleep(shortSleepTime);
                typer.leftClick();
                Thread.sleep(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot1);
                Thread.sleep(shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick();
                }
                Thread.sleep(shortSleepTime);
                // Place item back in original slot
                mm.moveMouse(coords);
                Thread.sleep(shortSleepTime);
                typer.leftClick();
                Thread.sleep(shortSleepTime);
                // Get resultant item
                mm.moveMouse(handCraftSlotRes);
                Thread.sleep(shortSleepTime);
                typer.holdShift();
                Thread.sleep(shortSleepTime);
                typer.leftClick();
                typer.releaseShift();
                Thread.sleep(shortSleepTime);
                // Close inventory
                typer.type("e");
                Thread.sleep(longSleepTime);
                break;




            case "crafting_table":
                // Open inventory
                typer.type("e");
                Thread.sleep(longSleepTime);
                // Take a screenshot
                screen = screenShot();
                // Grab relevant image
                img = getImage("C:\\Users\\chris\\IdeaProjects\\AIBeatsMinecraft\\src\\Item_Images\\Wood1.JPG");
                // Find image in screenshot
                coords = findSubImage(screen, img);
                // Pick up items
                mm.moveMouse(coords);
                Thread.sleep(shortSleepTime);
                typer.leftClick();
                Thread.sleep(shortSleepTime);

                // Move mouse to craft
                mm.moveMouse(handCraftSlot1);
                Thread.sleep(shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick();
                }
                Thread.sleep(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot2);
                Thread.sleep(shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick();
                }
                Thread.sleep(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot3);
                Thread.sleep(shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick();
                }
                Thread.sleep(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot4);
                Thread.sleep(shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick();
                }
                Thread.sleep(shortSleepTime);

                // Place item back in original slot
                mm.moveMouse(coords);
                Thread.sleep(shortSleepTime);
                typer.leftClick();
                Thread.sleep(shortSleepTime);
                // Get resultant item
                mm.moveMouse(handCraftSlotRes);
                Thread.sleep(shortSleepTime);
                typer.holdShift();
                Thread.sleep(shortSleepTime);
                typer.leftClick();
                typer.releaseShift();
                Thread.sleep(shortSleepTime);
                // Close inventory
                typer.type("e");
                Thread.sleep(longSleepTime);
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
        for (int x = 0; x < w1 - w2; x=x+searchSpacing) {
            for (int y = 0; y < h1 - h2; y=y+searchSpacing) {
                double comp = compareImages(im1.getSubimage(x, y, w2, h2), im2);
                if (comp < lowestDiff) {
                    bestX = x;
                    bestY = y;
                    lowestDiff = comp;
                }
            }
        }
        // output similarity measure from 0 to 1, with 0 being identical
        //System.out.println(lowestDiff);
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
