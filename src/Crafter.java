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
    int shortSleepTime = 30;
    int longSleepTime = 60;
    Rectangle screenRect = new Rectangle(700, 500, 600, 400);
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

    int[] furnaceCoalSlot = new int[]{888,466};
    int[] furnaceSmeltSlot = new int[]{888,356};
    int[] furnaceResSlot = new int[]{1066,411};


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

                // Move mouse away
                mm.moveMouse(200,200, longSleepTime);

                // Find location of wood
                int[] woodCoords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg", screenRect, 1);
                // Find location of stick
                int[] stickWoodenPickaxeCoords = look.findLocationOnScreen("src\\Item_Images\\Stick.jpg", screenRect, 1);

                // Pick up items
                mm.moveMouse(woodCoords, shortSleepTime);
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
                mm.moveMouse(woodCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);

                // Pick up items
                mm.moveMouse(stickWoodenPickaxeCoords, shortSleepTime);
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
                mm.moveMouse(stickWoodenPickaxeCoords, shortSleepTime);
                typer.leftClick(longSleepTime);

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(longSleepTime);
                // Close inventory
                typer.type("e", shortSleepTime, longSleepTime);
                break;


            case "stone_tools":
                // Move mouse away
                mm.moveMouse(200,200, longSleepTime);

                ////STONE PICKAXE
                // Find location of items
                int[] cobbleCoords = look.findLocationOnScreen("src\\Item_Images\\Cobblestone.jpg", screenRect, 1);
                int[] stickCoords = look.findLocationOnScreen("src\\Item_Images\\Stick.jpg", screenRect, 1);
                // Pick up cobble
                mm.moveMouse(cobbleCoords, shortSleepTime);
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
                mm.moveMouse(cobbleCoords, shortSleepTime);
                typer.leftClick(longSleepTime);

                // Pick up sticks
                mm.moveMouse(stickCoords, shortSleepTime);
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
                mm.moveMouse(stickCoords, shortSleepTime);
                typer.leftClick(longSleepTime);

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(longSleepTime);



                ////STONE SWORD
                // Pick up cobble
                mm.moveMouse(cobbleCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(cobbleCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);

                // Pick up stick
                mm.moveMouse(stickCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(stickCoords, shortSleepTime);
                typer.leftClick(longSleepTime);

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(longSleepTime);


                ////STONE SHOVEL
                // Pick up cobble
                mm.moveMouse(cobbleCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(cobbleCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);

                // Pick up sticks
                mm.moveMouse(stickCoords, shortSleepTime);
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
                mm.moveMouse(stickCoords, shortSleepTime);
                typer.leftClick(longSleepTime);

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(longSleepTime);



                ////FURNACE
                // Pick up cobble
                mm.moveMouse(cobbleCoords, shortSleepTime);
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
                mm.moveMouse(tableCraftSlot4, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot6, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                mm.moveMouse(tableCraftSlot7, shortSleepTime);
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
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot9, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }
                // Place item back in original slot
                mm.moveMouse(cobbleCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);

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


    public void smelt(String item, int number) throws InterruptedException, AWTException {
        switch(item) {
            case "iron":
                // Move mouse away
                mm.moveMouse(200,200, longSleepTime);

                ////IRON
                // Find location of items
                int[] ironOreCoords = look.findLocationOnScreen("src\\Item_Images\\Iron_Ore.jpg", screenRect, 1);
                int[] coalCoords = look.findLocationOnScreen("src\\Item_Images\\Coal.jpg", screenRect, 1);
                // Pick up iron ore
                mm.moveMouse(ironOreCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(furnaceSmeltSlot, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(shortSleepTime);
                }

                // Place item back in original slot
                mm.moveMouse(ironOreCoords, shortSleepTime);
                typer.leftClick(longSleepTime);

                // Pick up coal
                mm.moveMouse(coalCoords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(furnaceCoalSlot, shortSleepTime);
                // Place the correct number of items
                for (int i = 0; i <= (number/8+1); i++) {
                    typer.rightClick(shortSleepTime);
                }

                // Place item back in original slot
                mm.moveMouse(coalCoords, shortSleepTime);
                typer.leftClick(longSleepTime);
                // Close inventory
                typer.type("e", shortSleepTime, longSleepTime);
                break;

        }

    }



    public void getSmelt() throws InterruptedException, AWTException {
        mm.moveMouse(furnaceResSlot,shortSleepTime);
        typer.holdShift(shortSleepTime);
        typer.leftClick(shortSleepTime);
        typer.releaseShift(longSleepTime);
        // Close inventory
        typer.type("e", shortSleepTime, longSleepTime);
    }


}
