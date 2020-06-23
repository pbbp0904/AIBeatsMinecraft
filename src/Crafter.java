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
    int shortSleepTime = 40;
    int longSleepTime = 100;
    Rectangle screenRect = new Rectangle(700, 500, 550, 300);
    int[] handCraftSlot1 = new int[]{1015,360};
    int[] handCraftSlot2 = new int[]{1067,360};
    int[] handCraftSlot3 = new int[]{1067,413};
    int[] handCraftSlot4 = new int[]{1015,413};
    int[] handCraftSlotRes = new int[]{1189,390};


    public Crafter() throws AWTException {
    }

    public void craft(String item, int number) throws AWTException, InterruptedException, IOException {
        switch (item) {
            case "wooden_plank":
                // Open inventory
                typer.type("e",shortSleepTime,longSleepTime);
                // Find location of logs
                coords = look.findLocationOnScreen("src\\Item_Images\\Log1.jpg",screenRect,1 );
                // Pick up items
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot1, shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
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
                typer.type("e",shortSleepTime, longSleepTime);
                break;




            case "crafting_table":
                // Open inventory
                typer.type("e",shortSleepTime,longSleepTime);
                // Find location of wood
                coords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg",screenRect,1 );
                // Pick up items
                mm.moveMouse(coords,shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot1,shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot2,shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot3,shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot4,shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick(shortSleepTime);
                }

                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Get resultant item
                mm.moveMouse(handCraftSlotRes,shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(shortSleepTime);
                // Close inventory
                typer.type("e",shortSleepTime,longSleepTime);
                break;





             case "stick":
                // Open inventory
                typer.type("e",shortSleepTime,longSleepTime);
                // Find location of wood
                coords = look.findLocationOnScreen("src\\Item_Images\\Wood1.jpg",screenRect,1 );
                // Pick up items
                mm.moveMouse(coords,shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Move mouse to craft
                mm.moveMouse(handCraftSlot2,shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick(shortSleepTime);
                }
                // Move mouse to craft
                mm.moveMouse(handCraftSlot3,shortSleepTime);
                // Place the correct number of items
                for(int i = 0;i<number;i++){
                    typer.rightClick(shortSleepTime);
                }

                // Place item back in original slot
                mm.moveMouse(coords, shortSleepTime);
                typer.leftClick(shortSleepTime);
                // Get resultant item
                mm.moveMouse(handCraftSlotRes,shortSleepTime);
                typer.holdShift(shortSleepTime);
                typer.leftClick(shortSleepTime);
                typer.releaseShift(shortSleepTime);
                // Close inventory
                typer.type("e",shortSleepTime,longSleepTime);
                break;
        }
    }
}
