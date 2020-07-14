import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Crafter {

    Typer typer = new Typer();
    MouseMover mm = new MouseMover();
    Looker looker = new Looker();
    int[] coords;
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


    public Crafter() {
        waiter = new Waiter(50,60,1500);
    }

    public void craft(String item, int number) {
        switch (item) {
            case "oak_planks":
                // Move Mouse Away
                mm.moveMouseAway();

                // Find location of logs
                coords = looker.findLocationOnScreen("src\\Item_Images\\oak_log.jpg", looker.getInventoryScreenRect());


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

                break;


            case "crafting_table":
                // Move mouse away
                mm.moveMouseAway();

                // Find location of wood
                coords = looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", looker.getInventoryScreenRect());


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

                break;


            case "stick":
                // Move Mouse Away
                mm.moveMouseAway();

                // Find location of wood
                coords = looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", looker.getInventoryScreenRect());


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

                break;


            case "wooden_pickaxe":

                // Move mouse away
                mm.moveMouseAway();

                // Find location of items
                int[] woodCoords = looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", looker.getInventoryScreenRect());
                int[] stickWoodCoords = looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", looker.getInventoryScreenRect());


                ////WOODEN PICKAXE
                craftItem(woodCoords,stickWoodCoords,new int[]{1,2,3},new int[]{5,8},1);

                break;


            case "stone_tools":
                // Move mouse away
                mm.moveMouseAway();

                // Find location of items
                int[] stoneCoords = looker.findLocationOnScreen("src\\Item_Images\\cobblestone.jpg", looker.getInventoryScreenRect());
                int[] stickStoneCoords = looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", looker.getInventoryScreenRect());


                ////STONE PICKAXE
                craftItem(stoneCoords,stickStoneCoords,new int[]{1,2,3},new int[]{5,8},1);

                ////STONE SHOVEL
                craftItem(stoneCoords,stickStoneCoords,new int[]{2},new int[]{5,8},1);

                ////FURNACE
                craftItem(stoneCoords, new int[]{1,2,3,4,6,7,8,9},1 );

                break;

            case "iron_tools":
                // Move mouse away
                mm.moveMouseAway();

                // Find location of materials
                int[] ironCoords = looker.findLocationOnScreen("src\\Item_Images\\iron.jpg", looker.getInventoryScreenRect());
                int[] stickIronCoords = looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", looker.getInventoryScreenRect());
                int[] flintCoords = looker.findLocationOnScreen("src\\Item_Images\\flint.jpg", looker.getInventoryScreenRect());


                ////IRON PICKAXES
                craftItem(ironCoords,stickIronCoords,new int[]{1,2,3},new int[]{5,8},2);

                ////IRON SHOVEL
                craftItem(ironCoords,stickIronCoords,new int[]{2},new int[]{5,8},1);

                ////SHEARS
                craftItem(ironCoords, new int[]{2,6},1 );

                ////FLINT AND STEEL
                craftItem(ironCoords,flintCoords,new int[]{2},new int[]{6},1);

                break;

            case "diamond_items":
                // Move mouse away
                mm.moveMouseAway();

                // Find location of materials
                int[] diamondCoords = looker.findLocationOnScreen("src\\Item_Images\\diamond.jpg", looker.getInventoryScreenRect());
                int[] stickDiamondCoords = looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", looker.getInventoryScreenRect());


                ////DIAMOND SWORD
                craftItem(diamondCoords,stickDiamondCoords,new int[]{2,5},new int[]{8},1);

                ////DIAMOND PICKAXE
                craftItem(diamondCoords,stickDiamondCoords,new int[]{1,2,3},new int[]{5,8},1);

                ////DIAMOND SHOVEL
                craftItem(diamondCoords,stickDiamondCoords,new int[]{2},new int[]{5,8},1);

                ////HELMET
                craftItem(diamondCoords, new int[]{1,2,3,4,6},1);

                ////CHESTPLATE
                craftItem(diamondCoords, new int[]{1,3,4,5,6,7,8,9},1);

                ////LEGGINGS
                craftItem(diamondCoords, new int[]{1,2,3,4,6,7,9},1);

                ////BOOTS
                craftItem(diamondCoords, new int[]{4,6,7,9},1 );

                break;
        }
    }

    public void craftItem(int[] materialCoords, int[] craftingPositions, int number) {
        // Pick up material
        mm.moveMouse(materialCoords, waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());

        for(int i = 0; i < craftingPositions.length; i++) {
            // Move mouse to craft
            switch(craftingPositions[i]) {
                case 1:
                    mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                    break;
                case 2:
                    mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                    break;
                case 3:
                    mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                    break;
                case 4:
                    mm.moveMouse(tableCraftSlot4, waiter.getShortSleepTime());
                    break;
                case 5:
                    mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                    break;
                case 6:
                    mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                    break;
                case 7:
                    mm.moveMouse(tableCraftSlot7, waiter.getShortSleepTime());
                    break;
                case 8:
                    mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                    break;
                case 9:
                    mm.moveMouse(tableCraftSlot9, waiter.getShortSleepTime());
                    break;
            }
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                typer.rightClick(waiter.getShortSleepTime());
            }
        }

        // Place material back in original slot
        mm.moveMouse(materialCoords, waiter.getShortSleepTime());
        typer.leftClick(waiter.getLongSleepTime());

        // Get resultant item
        mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
        typer.holdShift(waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getLongSleepTime());
    }




    public void craftItem(int[] materialCoords1, int[] materialCoords2, int[] craftingPositions1, int[] craftingPositions2, int number) {
        // Pick up material 1
        mm.moveMouse(materialCoords1, waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());

        for(int i = 0; i < craftingPositions1.length; i++) {
            // Move mouse to craft
            switch(craftingPositions1[i]) {
                case 1:
                    mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                    break;
                case 2:
                    mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                    break;
                case 3:
                    mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                    break;
                case 4:
                    mm.moveMouse(tableCraftSlot4, waiter.getShortSleepTime());
                    break;
                case 5:
                    mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                    break;
                case 6:
                    mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                    break;
                case 7:
                    mm.moveMouse(tableCraftSlot7, waiter.getShortSleepTime());
                    break;
                case 8:
                    mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                    break;
                case 9:
                    mm.moveMouse(tableCraftSlot9, waiter.getShortSleepTime());
                    break;
            }
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                typer.rightClick(waiter.getShortSleepTime());
            }
        }

        // Place material 1 back in original slot
        mm.moveMouse(materialCoords1, waiter.getShortSleepTime());
        typer.leftClick(waiter.getLongSleepTime());


        // Pick up material 2
        mm.moveMouse(materialCoords2, waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());

        for(int i = 0; i < craftingPositions2.length; i++) {
            // Move mouse to craft
            switch(craftingPositions2[i]) {
                case 1:
                    mm.moveMouse(tableCraftSlot1, waiter.getShortSleepTime());
                    break;
                case 2:
                    mm.moveMouse(tableCraftSlot2, waiter.getShortSleepTime());
                    break;
                case 3:
                    mm.moveMouse(tableCraftSlot3, waiter.getShortSleepTime());
                    break;
                case 4:
                    mm.moveMouse(tableCraftSlot4, waiter.getShortSleepTime());
                    break;
                case 5:
                    mm.moveMouse(tableCraftSlot5, waiter.getShortSleepTime());
                    break;
                case 6:
                    mm.moveMouse(tableCraftSlot6, waiter.getShortSleepTime());
                    break;
                case 7:
                    mm.moveMouse(tableCraftSlot7, waiter.getShortSleepTime());
                    break;
                case 8:
                    mm.moveMouse(tableCraftSlot8, waiter.getShortSleepTime());
                    break;
                case 9:
                    mm.moveMouse(tableCraftSlot9, waiter.getShortSleepTime());
                    break;
            }
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                typer.rightClick(waiter.getShortSleepTime());
            }
        }

        // Place material 2 back in original slot
        mm.moveMouse(materialCoords2, waiter.getShortSleepTime());
        typer.leftClick(waiter.getLongSleepTime());

        // Get resultant item
        mm.moveMouse(tableCraftSlotRes, waiter.getShortSleepTime());
        typer.holdShift(waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getLongSleepTime());
    }


    public void smelt(String item, int number) {
        switch(item) {
            case "iron_ore":
                // Move mouse away
                mm.moveMouseAway();

                ////IRON
                // Find location of items
                int[] ironOreCoords = looker.findLocationOnScreen("src\\Item_Images\\iron_ore.jpg", looker.getInventoryScreenRect());
                int[] coalCoords = looker.findLocationOnScreen("src\\Item_Images\\coal.jpg", looker.getInventoryScreenRect());
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
                break;

        }

    }

    public void openInventory(){
        typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
    }

    public void closeInventory(){
        typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
    }

    public void getSmelt() {
        mm.moveMouse(furnaceResSlot,waiter.getShortSleepTime());
        typer.holdShift(waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getLongSleepTime());
    }


}
