import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.sun.jna.platform.*;

public class Looker {

    private static int searchSpacingX = 2;
    private static int searchSpacingY = 2;
    private Rectangle hotbarScreenRect;
    private Rectangle craftingScreenRect;
    private Rectangle inventoryScreenRect;


    private Rectangle backpackScreenRect;
    private Rectangle centerScreenRect;
    private Rectangle furnaceProgressScreenRect;
    private Waiter waiter;
    private MouseMover mm;

    public Looker() throws AWTException {
        hotbarScreenRect = new Rectangle(600, 900, 600, 200);
        craftingScreenRect = new Rectangle(850, 250, 100, 200);
        inventoryScreenRect = new Rectangle(711, 525, 500, 240);
        backpackScreenRect = new Rectangle(711, 525, 500, 170);
        centerScreenRect = new Rectangle(910, 490, 100, 100);
        furnaceProgressScreenRect = new Rectangle(930, 380, 80, 60);
        waiter = new Waiter();
        mm = new MouseMover();
    }

    public Rectangle getHotbarScreenRect() {
        return hotbarScreenRect;
    }

    public void setHotbarScreenRect(Rectangle hotbarScreenRect) {
        this.hotbarScreenRect = hotbarScreenRect;
    }

    public Rectangle getCraftingScreenRect() {
        return craftingScreenRect;
    }

    public void setCraftingScreenRect(Rectangle craftingScreenRect) {
        this.craftingScreenRect = craftingScreenRect;
    }

    public Rectangle getInventoryScreenRect() {
        return inventoryScreenRect;
    }

    public void setInventoryScreenRect(Rectangle inventoryScreenRect) {
        this.inventoryScreenRect = inventoryScreenRect;
    }

    public Rectangle getBackpackScreenRect() {
        return backpackScreenRect;
    }

    public void setBackpackScreenRect(Rectangle backpackScreenRect) {
        this.backpackScreenRect = backpackScreenRect;
    }

    public Rectangle getCenterScreenRect() {
        return centerScreenRect;
    }

    public void setCenterScreenRect(Rectangle centerScreenRect) {
        this.centerScreenRect = centerScreenRect;
    }

    public Rectangle getFurnaceProgressScreenRect() {
        return furnaceProgressScreenRect;
    }

    public void setFurnaceProgressScreenRect(Rectangle furnaceProgressScreenRect) {
        this.furnaceProgressScreenRect = furnaceProgressScreenRect;
    }

    public Rectangle getMinecraftWindow() {
        Rectangle rect = null;
        for (DesktopWindow desktopWindow : WindowUtils.getAllWindows(true)) {
            if (desktopWindow.getTitle().contains("Minecraft*")) {
                rect = desktopWindow.getLocAndSize();
            }
        }
        return rect;
    }




    public void lookDown() throws InterruptedException {
        mm.moveMouse(960,1000,10);
        mm.moveMouse(960,1000,10);
    }

    public void waitUntilStationary() throws AWTException, InterruptedException {
        boolean imagesEqual = false;
        BufferedImage screenImg1;
        BufferedImage screenImg2;
        while(!imagesEqual) {
            screenImg1 = screenShot(centerScreenRect);
            Thread.sleep(waiter.getStationaryWaitTime());
            screenImg2 = screenShot(centerScreenRect);
            imagesEqual = bufferedImagesEqual(screenImg1,screenImg2);
        }
    }


    public void waitUntilSmeltingDown() throws AWTException, InterruptedException {
        boolean imagesEqual = false;
        BufferedImage screenImg1;
        BufferedImage screenImg2;
        while(!imagesEqual) {
            screenImg1 = screenShot(furnaceProgressScreenRect);
            Thread.sleep(waiter.getStationaryWaitTime());
            screenImg2 = screenShot(furnaceProgressScreenRect);
            imagesEqual = bufferedImagesEqual(screenImg1,screenImg2);
        }
    }

    boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y))
                        return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }


    public boolean foundImageOnScreen(String pathname, Rectangle screenRect, double threshold, int scale) throws AWTException {
        BufferedImage screenImg = screenShot(screenRect);
        String filePath = new File(pathname).getAbsolutePath();
        BufferedImage img = getImage(filePath);
        double diff = findSubImageDiff(screenImg, img, screenRect);
        System.out.println(diff);
        return diff < threshold;
    }


    public int[] findLocationOnScreen(String pathname, Rectangle screenRect) throws AWTException {
        BufferedImage screenImg = screenShot(screenRect);
        String filePath = new File(pathname).getAbsolutePath();
        BufferedImage img = getImage(filePath);
        int[] coords = findSubImage(screenImg, img, screenRect);
        return coords;
    }

    public BufferedImage screenShot(Rectangle screenRect) throws AWTException {
        Robot robot = new Robot();

        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
        return screenFullImage;
    }

    public BufferedImage getImage(String filename) {
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
    public static int[] findSubImage(BufferedImage im1, BufferedImage im2, Rectangle screenRect) {
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
        for (int x = 0; x < w1 - w2; x = x + searchSpacingX) {
            for (int y = 0; y < h1 - h2; y = y + searchSpacingY) {
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
        return new int[]{bestX + screenRect.x, bestY + screenRect.y};
    }


    public static boolean findColorMatch(BufferedImage im1, Color color, Point p) {
        int pixel = im1.getRGB(p.x, p.y);
        Color color2 = new Color(pixel, true);
        return color.equals(color2);
    }


    public static double findSubImageDiff(BufferedImage im1, BufferedImage im2, Rectangle screenRect) {
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
        for (int x = 0; x < w1 - w2; x = x + searchSpacingX) {
            for (int y = 0; y < h1 - h2; y = y + searchSpacingY) {
                double comp = compareImages(im1.getSubimage(x, y, w2, h2), im2);
                if (comp < lowestDiff) {
                    bestX = x;
                    bestY = y;
                    lowestDiff = comp;
                }
            }
        }
        // output similarity measure from 0 to 1, with 0 being identical
        return lowestDiff;
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
