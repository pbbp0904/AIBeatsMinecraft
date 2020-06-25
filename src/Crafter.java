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

    private Waiter waiter;


    public Crafter() throws AWTException {
        waiter = new Waiter(30,60,1500);
    }

    public void craft(String item, int number) throws AWTException, InterruptedException, IOException {
        switch (item) {
            case "wooden_plank":
                // Open inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                // Find location of logs
                coords = look.findLocationOnScreen("src\\Item_Images\\Log1.jpg", screenRect);
                // Pick up items
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(handCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Get resultant item
                mm.moveMouse(handCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getShortSleepTime());
                // Close inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                break;


            case "crafting_table":
                // Open inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                // Move mouse away
                mm.moveMouse(200,200, waiter.getLongSleepTime());
                waiter.wait(waiter.getLongSleepTime());
                // Find location of wood
                coords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg", screenRect);
                // Pick up items
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(handCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot4, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }

                // Place item back in original slot
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Get resultant item
                mm.moveMouse(handCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getShortSleepTime());
                // Close inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                break;


            case "stick":
                // Open inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                // Find location of wood
                coords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg", screenRect);
                // Pick up items
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(handCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }

                // Place item back in original slot
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Get resultant item
                mm.moveMouse(handCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getShortSleepTime());
                // Close inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                break;


            case "wooden_pickaxe":

                // Move mouse away
                mm.moveMouse(200,200, waiter.getLongSleepTime());

                // Find location of wood
                int[] woodCoords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg", screenRect);
                // Find location of stick
                int[] stickWoodenPickaxeCoords = look.findLocationOnScreen("src\\Item_Images\\Stick.jpg", screenRect);

                // Pick up items
                mm.moveMouse(woodCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(woodCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Pick up items
                mm.moveMouse(stickWoodenPickaxeCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickWoodenPickaxeCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());
                // Close inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                break;


            case "stone_tools":
                // Move mouse away
                mm.moveMouse(200,200, waiter.getLongSleepTime());

                ////STONE PICKAXE
                // Find location of items
                int[] cobbleCoords = look.findLocationOnScreen("src\\Item_Images\\Cobblestone.jpg", screenRect);
                int[] stickCoords = look.findLocationOnScreen("src\\Item_Images\\Stick.jpg", screenRect);
                // Pick up cobble
                mm.moveMouse(cobbleCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(cobbleCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Pick up sticks
                mm.moveMouse(stickCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());



//                ////STONE SWORD
//                // Pick up cobble
//                mm.moveMouse(cobbleCoords, waiter.getShortSleepTime());
//                typer.leftClick(waiter.getShortSleepTime());
//                // Move mouse to craft
//                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
//                // Place the correct number of items
//                for (int i = 0; i < number; i++) {
//                    typer.rightClick(waiter.getShortSleepTime());
//                }
//                // Move mouse to craft
//                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
//                // Place the correct number of items
//                for (int i = 0; i < number; i++) {
//                    typer.rightClick(waiter.getShortSleepTime());
//                }
//                // Place item back in original slot
//                mm.moveMouse(cobbleCoords, waiter.getShortSleepTime());
//                typer.leftClick(waiter.getShortSleepTime());
//
//                // Pick up stick
//                mm.moveMouse(stickCoords, waiter.getShortSleepTime());
//                typer.leftClick(waiter.getShortSleepTime());
//                // Move mouse to craft
//                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
//                // Place the correct number of items
//                for (int i = 0; i < number; i++) {
//                    typer.rightClick(waiter.getShortSleepTime());
//                }
//                // Place item back in original slot
//                mm.moveMouse(stickCoords, waiter.getShortSleepTime());
//                typer.leftClick(waiter.getLongSleepTime());
//
//                // Get resultant item
//                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
//                typer.holdShift(waiter.getShortSleepTime());
//                typer.leftClick(waiter.getShortSleepTime());
//                typer.releaseShift(waiter.getLongSleepTime());


                ////STONE SHOVEL
                // Pick up cobble
                mm.moveMouse(cobbleCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(cobbleCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Pick up sticks
                mm.moveMouse(stickCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());



                ////FURNACE
                // Pick up cobble
                mm.moveMouse(cobbleCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                mm.moveMouse(tableCraftSlot4, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                mm.moveMouse(tableCraftSlot7, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot9, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(cobbleCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());
                // Close inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                break;

            case "iron_tools":
                // Move mouse away
                mm.moveMouse(200,200, waiter.getLongSleepTime());
                // Find location of items
                int[] ironCoords = look.findLocationOnScreen("src\\Item_Images\\Iron.jpg", screenRect);
                int[] stickIronToolsCoords = look.findLocationOnScreen("src\\Item_Images\\Stick.jpg", screenRect);
                int[] flintCoords = look.findLocationOnScreen("src\\Item_Images\\Flint.jpg", screenRect);

                ////IRON PICKAXE
                // Pick up iron
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Pick up sticks
                mm.moveMouse(stickIronToolsCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickIronToolsCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());

                ////IRON PICKAXE 2
                // Pick up iron
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Pick up sticks
                mm.moveMouse(stickIronToolsCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickIronToolsCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());



                ////IRON SHOVEL
                // Pick up iron
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Pick up sticks
                mm.moveMouse(stickIronToolsCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickIronToolsCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());



                ////SHEARS
                // Pick up iron
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());



                ////FLINT AND STEEL
                // Pick up iron
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(ironCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Pick up flint
                mm.moveMouse(flintCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(flintCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());


                // Close inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                break;

            case "diamond_items":
                // Move mouse away
                mm.moveMouse(200,200, waiter.getLongSleepTime());

                // Find location of items
                int[] diamondCoords = look.findLocationOnScreen("src\\Item_Images\\Diamond.jpg", screenRect);
                int[] stickDiamondCoords = look.findLocationOnScreen("src\\Item_Images\\Stick.jpg", screenRect);


                ////DIAMOND SWORD
                // Pick up diamond
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Pick up sticks
                mm.moveMouse(stickDiamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickDiamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());


                ////DIAMOND PICKAXE

                // Pick up diamond
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Pick up sticks
                mm.moveMouse(stickDiamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickDiamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());



                ////DIAMOND SHOVEL
                // Pick up diamond
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Pick up sticks
                mm.moveMouse(stickDiamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(stickDiamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());



                ////HELMET
                // Pick up diamond
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot4, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());



                ////CHESTPLATE
                // Pick up diamond
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot4, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot7, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot9, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());


                ////LEGGINGS
                // Pick up diamond
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Move mouse to craft
                mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot4, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot7, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot9, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());


                ////BOOTS
                // Pick up diamond
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());

                // Move mouse to craft
                mm.moveMouse(tableCraftSlot4, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot7, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(tableCraftSlot9, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(diamondCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Get resultant item
                mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getLongSleepTime());


                // Close inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                break;

        }
    }


    public void smelt(String item, int number) throws InterruptedException, AWTException {
        switch(item) {
            case "iron":
                // Move mouse away
                mm.moveMouse(200,200, waiter.getLongSleepTime());

                ////IRON
                // Find location of items
                int[] ironOreCoords = look.findLocationOnScreen("src\\Item_Images\\Iron_Ore.jpg", screenRect);
                int[] coalCoords = look.findLocationOnScreen("src\\Item_Images\\Coal.jpg", screenRect);
                // Pick up iron ore
                mm.moveMouse(ironOreCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(furnaceSmeltSlot, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }

                // Place item back in original slot
                mm.moveMouse(ironOreCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Pick up coal
                mm.moveMouse(coalCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(furnaceCoalSlot, waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i <= (number/8+1); i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }

                // Place item back in original slot
                mm.moveMouse(coalCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());
                // Close inventory
                typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
                break;

        }

    }



    public void getSmelt() throws InterruptedException, AWTException {
        mm.moveMouse(furnaceResSlot,waiter.getShortSleepTime());
        typer.holdShift(waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getLongSleepTime());
        // Close inventory
        typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
    }


}
