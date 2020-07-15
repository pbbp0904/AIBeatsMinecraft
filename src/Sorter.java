import java.awt.*;

public class Sorter {
    
    private static int shortSleep;
    private static int longSleep;
    private static int stationarySleep;
    
    static {
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
        Typer.holdShift(shortSleep);
        Typer.holdRightClick(shortSleep);
        Typer.releaseRightClick(shortSleep);
        Typer.releaseShift(shortSleep);
    }
}
