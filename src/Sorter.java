import java.awt.*;

public class Sorter {
    
    private static final int shortSleep;
    private static final int longSleep;
    
    static {
        shortSleep = 100;
        longSleep = 250;
    }


    public static void putItemInHotbar(String item, int slot, boolean lookOnlyInBackpack) throws InterruptedException {
        checkInterrupted();
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


    public static void putOnArmor(String item, boolean lookOnlyInBackpack) throws InterruptedException {
        checkInterrupted();
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

    private static void checkInterrupted() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            Typer.releaseAllKeys();
            throw new InterruptedException();
        }
    }
}
