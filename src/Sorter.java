import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Sorter {
    
    private static final int shortSleep;
    private static final int longSleep;
    private static final int stationarySleep;
    
    static {
        checkInterrupted();

        shortSleep = 100;
        longSleep = 250;
        stationarySleep = 1500;
    }


    public static void putItemInHotbar(String item, int slot, boolean lookOnlyInBackpack){
        MouseMover.moveMouseAway();
        Rectangle rect;
        if(lookOnlyInBackpack) {
            rect = Looker.getBackpackScreenRect();
        }else {
            rect = Looker.getInventoryScreenRect();
        }
        MouseMover.moveMouse(Looker.findLocationOnScreen("src\\Item_Images\\" + item + ".jpg",rect),longSleep);
        Typer.type(Integer.toString(slot),shortSleep,longSleep);
    }


    public static void putOnArmor(String item, boolean lookOnlyInBackpack) {
        MouseMover.moveMouseAway();
        Rectangle rect;
        if(lookOnlyInBackpack) {
            rect = Looker.getBackpackScreenRect();
        }else {
            rect = Looker.getInventoryScreenRect();
        }
        MouseMover.moveMouse(Looker.findLocationOnScreen("src\\Item_Images\\" + item + ".jpg",rect),longSleep);
        Typer.holdKey("shift");
        Typer.holdRightClick(shortSleep);
        Typer.releaseRightClick(shortSleep);
        Typer.releaseKey("shift");
    }

    private static void checkInterrupted() {
        while (Thread.currentThread().isInterrupted()) {

        }
    }
}
