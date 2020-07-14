import java.awt.*;

public class Sorter {
    Typer typer = new Typer();
    MouseMover mm = new MouseMover();
    Looker looker = new Looker();
    Waiter waiter;


    public Sorter() {
        waiter = new Waiter(50,60,1500);
    }


    public void putItemInHotbar(String item, int slot, boolean lookOnlyInBackpack){
        mm.moveMouseAway();
        Rectangle rect;
        if(lookOnlyInBackpack) {
            rect = looker.getBackpackScreenRect();
        }else {
            rect = looker.getInventoryScreenRect();
        }
        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\" + item + ".jpg",rect),waiter.getLongSleepTime());
        typer.type(Integer.toString(slot),waiter.getShortSleepTime(),waiter.getLongSleepTime());
    }


    public void putOnArmor(String item, boolean lookOnlyInBackpack) {
        mm.moveMouseAway();
        Rectangle rect;
        if(lookOnlyInBackpack) {
            rect = looker.getBackpackScreenRect();
        }else {
            rect = looker.getInventoryScreenRect();
        }
        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\" + item + ".jpg",rect),waiter.getLongSleepTime());
        typer.holdShift(waiter.getShortSleepTime());
        typer.holdRightClick(waiter.getShortSleepTime());
        typer.releaseRightClick(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getShortSleepTime());
    }

    public void openInventory(){
        typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
    }

    public void closeInventory(){
        typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
    }


}
