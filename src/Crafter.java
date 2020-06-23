import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Crafter {

    Typer typer = new Typer();
    MouseMover mm = new MouseMover();
    Looker look = new Looker();
    BufferedImage screen;
    BufferedImage img;
    int[] coords;
    int shortSleepTime = 10;
    int longSleepTime = 50;
    Rectangle screenRect = new Rectangle(700, 500, 550, 300);
    int[] handCraftSlot1 = new int[]{1015, 360};
    int[] handCraftSlot2 = new int[]{1067, 360};
    int[] handCraftSlot3 = new int[]{1067, 413};
    int[] handCraftSlot4 = new int[]{1015, 413};
    int[] handCraftSlotRes = new int[]{1189, 390};
    int[] tableCraftSlot1 = new int[]{810, 355};
    int[] tableCraftSlot2 = new int[]{865, 355};
    int[] tableCraftSlot3 = new int[]{920, 355};
    int[] tableCraftSlot4 = new int[]{810, 410};
    int[] tableCraftSlot5 = new int[]{865, 410};
    int[] tableCraftSlot6 = new int[]{920, 410};
    int[] tableCraftSlot7 = new int[]{810, 465};
    int[] tableCraftSlot8 = new int[]{865, 465};
    int[] tableCraftSlot9 = new int[]{920, 465};
    int[] tableCraftSlotRes = new int[]{1090, 410};


    public Crafter() throws AWTException {
    }

    public void craft(String item, int number) throws AWTException, InterruptedException, IOException {
        switch (item) {
            case "wooden_plank":
                // Open inventory
                typer.type("e", shortSleepTime, longSleepTime);
                // Find location of logs
                coords = look.findLocationOnScreen("src\\Item_Images\\Log1.jpg", screenRect, 1);
                // Pick up items
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot1, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Get resultant item
                mm.moveMouse(handCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(shortSleepTime);
                // Close inventory
                typer.type("e", shortSleepTime, longSleepTime);
                break;


            case "crafting_table":
                // Open inventory
                typer.type("e", shortSleepTime, longSleepTime);
                // Find location of wood
                coords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg", screenRect, 1);
                // Pick up items
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot1, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot2, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot3, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot4, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }

                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Get resultant item
                mm.moveMouse(handCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(shortSleepTime);
                // Close inventory
                typer.type("e", shortSleepTime, longSleepTime);
                break;


            case "stick":
                // Open inventory
                typer.type("e", shortSleepTime, longSleepTime);
                // Find location of wood
                coords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg", screenRect, 1);
                // Pick up items
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot2, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot3, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }

                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Get resultant item
                mm.moveMouse(handCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(shortSleepTime);
                // Close inventory
                typer.type("e", shortSleepTime, longSleepTime);
                break;


            case "wooden_pickaxe":
                // Find location of wood
                coords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg", screenRect, 1);
                // Pick up items
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);

                // Find location of stick
                coords = look.findLocationOnScreen("src\\Item_Images\\Stick.jpg", screenRect, 1);
                // Pick up items
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(longSleepTime);

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(longSleepTime);
                // Close inventory
                typer.type("e", shortSleepTime, longSleepTime);
                break;


            case "stone_pickaxe":
                // Find location of wood
                coords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg", screenRect, 1);
                // Pick up items
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);

                // Find location of stick
                coords = look.findLocationOnScreen("src\\Item_Images\\Stick.jpg", screenRect, 1);
                // Pick up items
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(longSleepTime);

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(longSleepTime);
                // Close inventory
                typer.type("e", shortSleepTime, longSleepTime);
                break;
        }
    }
}
