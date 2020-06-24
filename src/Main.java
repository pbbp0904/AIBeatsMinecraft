import java.awt.*;
import java.io.IOException;

public class Main {
    
    private Typer typer;
    private Looker look;
    private Crafter crafter;
    private MouseMover mm;
    private Waiter waiter;
    private Filer filer;
    //private static Inventory inventory;
    
    public Main() throws AWTException {
        try {
            typer = new Typer();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        look = new Looker();
        try {
            crafter = new Crafter();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            mm = new MouseMover();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        waiter = new Waiter();
        //inventory = new Inventory(typer);
        filer = new Filer();
    }
    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        Thread.sleep(5000);
        Main main = new Main();
        main.startUp();
        woodGather(main.look, main.typer, main.crafter, main.waiter);
        stoneGather(main.look, main.typer, main.crafter, main.mm, main.waiter);
        ironGather(main.look, main.typer, main.crafter, main.waiter);
    }

    public void startUp() throws IOException, InterruptedException, AWTException {
        System.out.println("Hello world!");
        this.filer.incrementRunCounter();
        // START
        System.out.println("Starting Run!");
        typer.type("/clear",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        typer.type("/time set 0",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        typer.type("/weather clear 10000",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
    }

    public static void woodGather(Looker look, Typer typer, Crafter crafter, Waiter waiter) throws IOException, InterruptedException, AWTException {
        System.out.println("Mining logs.");
        typer.type(".b mine 8 oak_log",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        look.waitUntilStationary();
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Log_Checkpoint_4.jpg",hotbarScreenRect,0.12,1)){
//            Thread.sleep(waiter.getShortSleepTime());
//        }
        System.out.println("We now have enough logs!");

        System.out.println("Crafting wooden items.");
        crafter.craft("wooden_plank", 4);
        Thread.sleep(waiter.getLongSleepTime());
        crafter.craft("crafting_table", 1);
        Thread.sleep(waiter.getLongSleepTime());
        crafter.craft("stick", 4);

        System.out.println("Placing crafting table.");
        typer.type(".b goto grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        look.lookDown();
        look.waitUntilStationary();
        typer.type(".b goal ~ ~-1 ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        typer.type(".b path",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        look.waitUntilStationary();
        typer.type("8",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        look.lookDown();
        Thread.sleep(waiter.getLongSleepTime()*2);
        typer.holdSpace(100);
        typer.holdRightClick(2000);
        typer.releaseSpace(waiter.getShortSleepTime());
        typer.releaseRightClick(waiter.getShortSleepTime());

        System.out.println("Crafting wooden pickaxe.");
        crafter.craft("wooden_pickaxe",1);
        Thread.sleep(waiter.getLongSleepTime());
    }

    public static void stoneGather(Looker look, Typer typer, Crafter crafter, MouseMover mm, Waiter waiter) throws IOException, InterruptedException, AWTException {
        System.out.println("Mining stone.");
        typer.type(".b mine 16 stone",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Stone_Checkpoint.jpg",hotbarScreenRect,0.12,1)){
//            Thread.sleep(waiter.getShortSleepTime());
//        }
        look.waitUntilStationary();
        System.out.println("We now have enough stone!");

        System.out.println("Going to crafting table.");
        typer.type(".b goto crafting_table",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
//            Thread.sleep(waiter.getShortSleepTime());
//        }
        look.waitUntilStationary();
        System.out.println("In crafting table!");

        System.out.println("Crafting stone tools.");
        crafter.craft("stone_tools",1);

        System.out.println("Mining a little grass...");
        typer.type(".b mine grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        Thread.sleep(6000);
        typer.type(".b cancel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());

        System.out.println("Placing furnace.");
        typer.type(".b goto grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        look.waitUntilStationary();
        typer.type(".b goal ~ ~-1 ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        typer.type(".b path",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        look.waitUntilStationary();
        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        Thread.sleep(waiter.getLongSleepTime());
        mm.moveMouse(look.findLocationOnScreen("src\\Item_Images\\Furnace.jpg",look.getInventoryScreenRect()),waiter.getLongSleepTime());
        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        Thread.sleep(waiter.getLongSleepTime());
        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        Thread.sleep(waiter.getLongSleepTime());
        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        Thread.sleep(waiter.getLongSleepTime());
        look.lookDown();
        Thread.sleep(waiter.getLongSleepTime()*2);
        typer.holdSpace(100);
        typer.holdRightClick(2000);
        typer.releaseSpace(waiter.getShortSleepTime());
        typer.releaseRightClick(waiter.getShortSleepTime());
        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());


    }


    public static void ironGather(Looker look, Typer typer, Crafter crafter, Waiter waiter) throws InterruptedException, AWTException {
        System.out.println("Mining iron ore.");
        typer.type(".b mine 30 iron_ore",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        look.waitUntilStationary();
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Iron_Ore_Checkpoint.jpg",inventoryScreenRect,0.15,1)){
//            Thread.sleep(waiter.getShortSleepTime());
//        }
        System.out.println("We now have enough iron_ore!");

        System.out.println("Mining coal.");
        typer.type(".b mine 8 coal_ore",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        look.waitUntilStationary();
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Iron_Ore_Checkpoint.jpg",inventoryScreenRect,0.15,1)){
//            Thread.sleep(waiter.getShortSleepTime());
//        }
        System.out.println("We now have enough coal!");

        System.out.println("Going to furnace.");
        typer.type(".b goto furnace",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
//            Thread.sleep(waiter.getShortSleepTime());
//        }
        look.waitUntilStationary();
        System.out.println("In furnace!");

        crafter.smelt("iron",30);

        System.out.println("Mining gravel.");
        typer.type(".b mine 20 gravel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
        look.waitUntilStationary();
        System.out.println("We now have enough gravel!");

        System.out.println("Going to furnace.");
        typer.type(".b goto furnace",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.pressEnter(waiter.getLongSleepTime());
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
//            Thread.sleep(waiter.getShortSleepTime());
//        }
        look.waitUntilStationary();
        System.out.println("In furnace!");

        look.waitUntilStationary();
        crafter.getSmelt();


    }

}
