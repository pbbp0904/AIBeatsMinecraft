import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.sun.jna.platform.*;



public class Looker {

    private static final int searchSpacingX = 1;
    private static final int searchSpacingY = 1;
    private static final int guiScale1InvX = 176;
    private static final int guiScale1InvY = 166;

    private static final int[] handCraftSlot1Offset = new int[]{106,28};
    private static final int[] handCraftSlot2Offset = new int[]{124,28};
    private static final int[] handCraftSlot3Offset = new int[]{106,46};
    private static final int[] handCraftSlot4Offset = new int[]{124,46};
    private static final int[] handCraftSlotResOffset = new int[]{162,37};

    private static final int[] tableCraftSlot1Offset = new int[]{38,28};
    private static final int[] tableCraftSlot2Offset = new int[]{56,28};
    private static final int[] tableCraftSlot3Offset = new int[]{74,28};
    private static final int[] tableCraftSlot4Offset = new int[]{38,46};
    private static final int[] tableCraftSlot5Offset = new int[]{56,46};
    private static final int[] tableCraftSlot6Offset = new int[]{74,46};
    private static final int[] tableCraftSlot7Offset = new int[]{38,64};
    private static final int[] tableCraftSlot8Offset = new int[]{56,64};
    private static final int[] tableCraftSlot9Offset = new int[]{74,64};
    private static final int[] tableCraftSlotResOffset = new int[]{132,46};

    private static final int[] furnaceCoalSlotOffset = new int[]{64,64};
    private static final int[] furnaceSmeltSlotOffset = new int[]{64,28};
    private static final int[] furnaceResSlotOffset = new int[]{124,46};

    private static final int[] inventoryScreenRectOffset = new int[]{8, 84};
    private static final int[] backpackScreenRectOffset = new int[]{8, 84};
    private static final int[] furnaceProgressScreenRectOffset = new int[]{80, 35};

    private static final int[] inventoryScreenRectSize = new int[]{162, 76};
    private static final int[] backpackScreenRectSize = new int[]{162, 54};
    private static final int[] furnaceProgressScreenSize = new int[]{24, 17};

    private static final int centerScreenScaling = 15;

    private static final double doneThreshold = 0.1;
    private static final int aLongTime = 10000000;


    private static final int[] handCraftSlot1;
    private static final int[] handCraftSlot2;
    private static final int[] handCraftSlot3;
    private static final int[] handCraftSlot4;
    private static final int[] handCraftSlotRes;

    private static final int[] tableCraftSlot1;
    private static final int[] tableCraftSlot2;
    private static final int[] tableCraftSlot3;
    private static final int[] tableCraftSlot4;
    private static final int[] tableCraftSlot5;
    private static final int[] tableCraftSlot6;
    private static final int[] tableCraftSlot7;
    private static final int[] tableCraftSlot8;
    private static final int[] tableCraftSlot9;
    private static final int[] tableCraftSlotRes;

    private static final int[] furnaceCoalSlot;
    private static final int[] furnaceSmeltSlot;
    private static final int[] furnaceResSlot;

    private static final Rectangle inventoryScreenRect;
    private static final Rectangle backpackScreenRect;
    private static final Rectangle furnaceProgressScreenRect;

    private static final Rectangle centerScreenRect;
    private static final Rectangle topLeftScreenRect;

    private static int guiScale;
    private static int centerX;
    private static int centerY;

    static{
        guiScale = 0;
        try {
            guiScale = Filer.getGUIScale();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        centerX = (int) b.getX();
        centerY = (int) b.getY();

        int topLeftX = centerX-(guiScale1InvX/2)*guiScale;
        int topLeftY = centerY-(guiScale1InvY/2)*guiScale;

        handCraftSlot1 = new int[]{topLeftX+(handCraftSlot1Offset[0]*guiScale), topLeftY+(handCraftSlot1Offset[1]*guiScale)};
        handCraftSlot2 = new int[]{topLeftX+(handCraftSlot2Offset[0]*guiScale), topLeftY+(handCraftSlot2Offset[1]*guiScale)};
        handCraftSlot3 = new int[]{topLeftX+(handCraftSlot3Offset[0]*guiScale), topLeftY+(handCraftSlot3Offset[1]*guiScale)};
        handCraftSlot4 = new int[]{topLeftX+(handCraftSlot4Offset[0]*guiScale), topLeftY+(handCraftSlot4Offset[1]*guiScale)};
        handCraftSlotRes = new int[]{topLeftX+(handCraftSlotResOffset[0]*guiScale), topLeftY+(handCraftSlotResOffset[1]*guiScale)};

        tableCraftSlot1 = new int[]{topLeftX+(tableCraftSlot1Offset[0]*guiScale), topLeftY+(tableCraftSlot1Offset[1]*guiScale)};
        tableCraftSlot2 = new int[]{topLeftX+(tableCraftSlot2Offset[0]*guiScale), topLeftY+(tableCraftSlot2Offset[1]*guiScale)};
        tableCraftSlot3 = new int[]{topLeftX+(tableCraftSlot3Offset[0]*guiScale), topLeftY+(tableCraftSlot3Offset[1]*guiScale)};
        tableCraftSlot4 = new int[]{topLeftX+(tableCraftSlot4Offset[0]*guiScale), topLeftY+(tableCraftSlot4Offset[1]*guiScale)};
        tableCraftSlot5 = new int[]{topLeftX+(tableCraftSlot5Offset[0]*guiScale), topLeftY+(tableCraftSlot5Offset[1]*guiScale)};
        tableCraftSlot6 = new int[]{topLeftX+(tableCraftSlot6Offset[0]*guiScale), topLeftY+(tableCraftSlot6Offset[1]*guiScale)};
        tableCraftSlot7 = new int[]{topLeftX+(tableCraftSlot7Offset[0]*guiScale), topLeftY+(tableCraftSlot7Offset[1]*guiScale)};
        tableCraftSlot8 = new int[]{topLeftX+(tableCraftSlot8Offset[0]*guiScale), topLeftY+(tableCraftSlot8Offset[1]*guiScale)};
        tableCraftSlot9 = new int[]{topLeftX+(tableCraftSlot9Offset[0]*guiScale), topLeftY+(tableCraftSlot9Offset[1]*guiScale)};
        tableCraftSlotRes = new int[]{topLeftX+(tableCraftSlotResOffset[0]*guiScale), topLeftY+(tableCraftSlotResOffset[1]*guiScale)};

        furnaceCoalSlot = new int[]{topLeftX+(furnaceCoalSlotOffset[0]*guiScale), topLeftY+(furnaceCoalSlotOffset[1]*guiScale)};
        furnaceSmeltSlot = new int[]{topLeftX+(furnaceSmeltSlotOffset[0]*guiScale), topLeftY+(furnaceSmeltSlotOffset[1]*guiScale)};
        furnaceResSlot = new int[]{topLeftX+(furnaceResSlotOffset[0]*guiScale), topLeftY+(furnaceResSlotOffset[1]*guiScale)};

        inventoryScreenRect = new Rectangle(topLeftX+(inventoryScreenRectOffset[0]*guiScale), topLeftY+(inventoryScreenRectOffset[1]*guiScale), inventoryScreenRectSize[0]*guiScale, inventoryScreenRectSize[1]*guiScale);
        backpackScreenRect = new Rectangle(topLeftX+(backpackScreenRectOffset[0]*guiScale), topLeftY+(backpackScreenRectOffset[1]*guiScale), backpackScreenRectSize[0]*guiScale, backpackScreenRectSize[1]*guiScale);
        furnaceProgressScreenRect = new Rectangle(topLeftX+(furnaceProgressScreenRectOffset[0]*guiScale), topLeftY+(furnaceProgressScreenRectOffset[1]*guiScale), furnaceProgressScreenSize[0]*guiScale, furnaceProgressScreenSize[1]*guiScale);

        centerScreenRect = new Rectangle(centerX-centerScreenScaling*guiScale, centerY-centerScreenScaling*guiScale, 2*centerScreenScaling*guiScale, 2*centerScreenScaling*guiScale);
        topLeftScreenRect = new Rectangle(getMinecraftWindow().x, getMinecraftWindow().y, getMinecraftWindow().width/4, getMinecraftWindow().height/4);
    }

    public static int[] getHandCraftSlot1() {
        return handCraftSlot1;
    }

    public static int[] getHandCraftSlot2() {
        return handCraftSlot2;
    }

    public static int[] getHandCraftSlot3() {
        return handCraftSlot3;
    }

    public static int[] getHandCraftSlot4() {
        return handCraftSlot4;
    }

    public static int[] getHandCraftSlotRes() {
        return handCraftSlotRes;
    }

    public static int[] getTableCraftSlot1() {
        return tableCraftSlot1;
    }

    public static int[] getTableCraftSlot2() {
        return tableCraftSlot2;
    }

    public static int[] getTableCraftSlot3() {
        return tableCraftSlot3;
    }

    public static int[] getTableCraftSlot4() {
        return tableCraftSlot4;
    }

    public static int[] getTableCraftSlot5() {
        return tableCraftSlot5;
    }

    public static int[] getTableCraftSlot6() {
        return tableCraftSlot6;
    }

    public static int[] getTableCraftSlot7() {
        return tableCraftSlot7;
    }

    public static int[] getTableCraftSlot8() {
        return tableCraftSlot8;
    }

    public static int[] getTableCraftSlot9() {
        return tableCraftSlot9;
    }

    public static int[] getTableCraftSlotRes() {
        return tableCraftSlotRes;
    }

    public static int[] getFurnaceCoalSlot() {
        return furnaceCoalSlot;
    }

    public static int[] getFurnaceSmeltSlot() {
        return furnaceSmeltSlot;
    }

    public static int[] getFurnaceResSlot() {
        return furnaceResSlot;
    }


    public static Rectangle getInventoryScreenRect() {
        return inventoryScreenRect;
    }

    public static Rectangle getBackpackScreenRect() {
        return backpackScreenRect;
    }

    public static Rectangle getCenterScreenRect() {
        return centerScreenRect;
    }

    public static Rectangle getFurnaceProgressScreenRect() {
        return furnaceProgressScreenRect;
    }








    public static Rectangle getMinecraftWindow() {
        Rectangle rect = null;
        for (DesktopWindow desktopWindow : WindowUtils.getAllWindows(true)) {
            if (desktopWindow.getTitle().contains("Minecraft*")) {
                rect = desktopWindow.getLocAndSize();
            }
        }
        return rect;
    }

    public static void lookUp() {
        MouseMover.moveMouse(centerX, (int) (centerY /2.0), Waiter.getShortSleepTime());
        MouseMover.moveMouse(centerX, (int) (centerY /2.0), Waiter.getShortSleepTime());
        MouseMover.moveMouse(centerX, (int) (centerY /2.0), Waiter.getShortSleepTime());
    }

    public static void lookDown() {
        MouseMover.moveMouse(centerX, (int) (centerY * 3.0/2.0), Waiter.getShortSleepTime());
        MouseMover.moveMouse(centerX, (int) (centerY * 3.0/2.0), Waiter.getShortSleepTime());
        MouseMover.moveMouse(centerX, (int) (centerY * 3.0/2.0), Waiter.getShortSleepTime());
    }

    public static void waitUntilDone(){
        waitUntilDoneFuse(aLongTime);
    }

    public static void waitUntilDoneFuse(long fuseTime){
        boolean imageFoundOnScreen = false;
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();

        while(!imageFoundOnScreen && end<start+fuseTime) {
            try {
                Thread.sleep(Waiter.getStationaryWaitTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imageFoundOnScreen = foundImageOnScreen("src\\Checkpoint_Images\\done.jpg",topLeftScreenRect,doneThreshold);
            end = System.currentTimeMillis();
        }
    }



    public static void waitUntilStationary() {
        waitUntilStationaryFuse(aLongTime);
    }

    public static void waitUntilStationaryFuse(long fuseTime) {
        boolean imagesEqual = false;
        BufferedImage screenImg1;
        BufferedImage screenImg2;
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        while(!imagesEqual && end<start+fuseTime) {
            screenImg1 = screenShot(centerScreenRect);
            try {
                Thread.sleep(Waiter.getStationaryWaitTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            screenImg2 = screenShot(centerScreenRect);
            imagesEqual = bufferedImagesEqual(screenImg1,screenImg2);
            end = System.currentTimeMillis();
        }
    }


    public static void waitUntilSmeltingDone(){
        boolean imagesEqual = false;
        BufferedImage screenImg1;
        BufferedImage screenImg2;
        while(!imagesEqual) {
            screenImg1 = screenShot(furnaceProgressScreenRect);
            try {
                Thread.sleep(Waiter.getStationaryWaitTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            screenImg2 = screenShot(furnaceProgressScreenRect);
            assert screenImg1 != null;
            assert screenImg2 != null;
            imagesEqual = bufferedImagesEqual(screenImg1,screenImg2);
        }
    }

    public static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
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


    public static boolean foundImageOnScreen(String pathname, Rectangle screenRect, double threshold) {
        BufferedImage screenImg = screenShot(screenRect);
        String filePath = new File(pathname).getAbsolutePath();
       BufferedImage img = resize(Objects.requireNonNull(getImage(filePath)), ((double) (guiScale))/3.0) ;
        assert screenImg != null;
        double diff = findSubImageDiff(screenImg, img);
        System.out.println(diff);
        return diff < threshold;
    }


    public static int[] findLocationOnScreen(String pathname, Rectangle screenRect) {
        BufferedImage screenImg = screenShot(screenRect);
        String filePath = new File(pathname).getAbsolutePath();
        BufferedImage img = resize(Objects.requireNonNull(getImage(filePath)), ((double) (guiScale))/3.0) ;
        assert screenImg != null;
        return findSubImage(screenImg, img, screenRect);
    }

    public static BufferedImage screenShot(Rectangle screenRect) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        assert robot != null;
        return robot.createScreenCapture(screenRect);
    }

    public static BufferedImage getImage(String filename) {
        try {
            return ImageIO.read(new File(filename));
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


    public static double findSubImageDiff(BufferedImage im1, BufferedImage im2) {
        int w1 = im1.getWidth();
        int h1 = im1.getHeight();
        int w2 = im2.getWidth();
        int h2 = im2.getHeight();
        assert (w2 <= w1 && h2 <= h1);
        // will keep track of best position found
        double lowestDiff = Double.POSITIVE_INFINITY;
        // brute-force search through whole image (slow...)
        for (int x = 0; x < w1 - w2; x = x + searchSpacingX) {
            for (int y = 0; y < h1 - h2; y = y + searchSpacingY) {
                double comp = compareImages(im1.getSubimage(x, y, w2, h2), im2);
                if (comp < lowestDiff) {
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






//    Resizes an image by a percentage of original size (proportional).
//    @param inputImagePath Path of the original image
//    @param outputImagePath Path to save the resized image
//    @param percent a double number specifies percentage of the output image
//    over the input image.

    public static BufferedImage resize(BufferedImage inputImage, double percent) {
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        return resize(inputImage, scaledWidth, scaledHeight);
    }

    public static BufferedImage resize(BufferedImage inputImage, int scaledWidth, int scaledHeight) {

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return outputImage;
    }
}
