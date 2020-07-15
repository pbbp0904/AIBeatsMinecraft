import java.awt.*;

public class Sorter {
    private static Typer typer = new Typer();
    private static MouseMover mm = new MouseMover();
    private static Looker looker = new Looker();
    
    private static int shortSleep;
    private static int longSleep;
    private static int stationarySleep;
    
    static {
        shortSleep = 50;
        longSleep = 60;
        stationarySleep = 1500;
    }


    public static void putItemInHotbar(String item, int slot, boolean lookOnlyInBackpack){
        mm.moveMouseAway();
        Rectangle rect;
        if(lookOnlyInBackpack) {
            rect = looker.getBackpackScreenRect();
        }else {
            rect = looker.getInventoryScreenRect();
        }
        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\" + item + ".jpg",rect),longSleep);
        typer.type(Integer.toString(slot),shortSleep,longSleep);
    }


    public static void putOnArmor(String item, boolean lookOnlyInBackpack) {
        mm.moveMouseAway();
        Rectangle rect;
        if(lookOnlyInBackpack) {
            rect = looker.getBackpackScreenRect();
        }else {
            rect = looker.getInventoryScreenRect();
        }
        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\" + item + ".jpg",rect),longSleep);
        typer.holdShift(shortSleep);
        typer.holdRightClick(shortSleep);
        typer.releaseRightClick(shortSleep);
        typer.releaseShift(shortSleep);
    }

    public static void openInventory(){
        typer.type("e", shortSleep, longSleep);
        Waiter.wait(longSleep);
    }

    public static void closeInventory(){
        typer.type("e", shortSleep, longSleep);
        Waiter.wait(longSleep);
    }


}
