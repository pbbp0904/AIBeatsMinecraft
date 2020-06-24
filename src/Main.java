import java.awt.*;
import java.io.IOException;

public class Main {
    
    private Typer typer;
    private Looker looker;
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
        looker = new Looker();
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
        //Exiter exiter = new Exiter();
        main.startUp();

        woodGather(main.looker, main.typer, main.crafter, main.waiter);
        stoneGather(main.looker, main.typer, main.crafter, main.mm, main.waiter);
        ironGather(main.looker, main.typer, main.crafter, main.waiter);
    }









    public void startUp() throws IOException, InterruptedException, AWTException {
        System.out.println("Hello world!");
        this.filer.incrementRunCounter();
        // START
        System.out.println("Starting Run!");
        typer.command("/clear",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/time set 0",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/weather clear 10000",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        //        while(!looker.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
        //            Thread.sleep(waiter.getShortSleepTime());
        //        }
    }

    public static void woodGather(Looker looker, Typer typer, Crafter crafter, Waiter waiter) throws IOException, InterruptedException, AWTException {
        System.out.println("Mining logs.");
        typer.command(".b mine 8 oak_log",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        System.out.println("Done mining logs!");

        System.out.println("Crafting wooden items.");
        crafter.craft("wooden_plank", 4);
        waiter.wait(waiter.getLongSleepTime());
        crafter.craft("crafting_table", 1);
        waiter.wait(waiter.getLongSleepTime());
        crafter.craft("stick", 4);
        System.out.println("Done crafting wooden items!");

        System.out.println("Placing crafting table.");
        typer.command(".b goto grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.lookDown();
        looker.waitUntilStationary();
        typer.command(".b goal ~ ~-1 ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command(".b path",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        typer.type("8",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.lookDown();
        waiter.wait(waiter.getLongSleepTime()*2);
        typer.holdSpace(100);
        typer.holdRightClick(2000);
        typer.releaseSpace(waiter.getShortSleepTime());
        typer.releaseRightClick(waiter.getShortSleepTime());
        System.out.println("Done placing crafting table!");

        System.out.println("Crafting wooden pickaxe.");
        crafter.craft("wooden_pickaxe",1);
        waiter.wait(waiter.getLongSleepTime());
        System.out.println("Done crafting wooden pickaxe!");
    }

    public static void stoneGather(Looker looker, Typer typer, Crafter crafter, MouseMover mm, Waiter waiter) throws IOException, InterruptedException, AWTException {
        System.out.println("Mining stone.");
        typer.command(".b mine 16 stone",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        System.out.println("Done mining stone!");

        System.out.println("Going to crafting table.");
        typer.command(".b goto crafting_table",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        System.out.println("In crafting table!");

        System.out.println("Crafting stone tools.");
        crafter.craft("stone_tools",1);
        System.out.println("Done crafting stone tools!");

        System.out.println("Mining a little grass...");
        typer.command(".b mine grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        waiter.wait(6000);
        typer.command(".b cancel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        System.out.println("Done mining a little grass!");

        System.out.println("Placing furnace.");
        typer.command(".b goto grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        typer.command(".b goal ~ ~-1 ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command(".b path",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        typer.command("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Furnace.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
        looker.lookDown();
        waiter.wait(waiter.getLongSleepTime()*2);
        typer.holdSpace(100);
        typer.holdRightClick(2000);
        typer.releaseSpace(waiter.getShortSleepTime());
        typer.releaseRightClick(waiter.getShortSleepTime());
        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        System.out.println("Done placing furnace!");

    }


    public static void ironGather(Looker looker, Typer typer, Crafter crafter, Waiter waiter) throws InterruptedException, AWTException {
        System.out.println("Mining iron ore.");
        typer.command(".b mine 30 iron_ore",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        System.out.println("Done mining iron ore!");

        System.out.println("Mining coal.");
        typer.command(".b mine 8 coal_ore",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        System.out.println("Done mining coal!");

        System.out.println("Going to furnace.");
        typer.command(".b goto furnace",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        System.out.println("In furnace!");

        System.out.println("Putting iron in furnace.");
        crafter.smelt("iron",30);
        System.out.println("Done putting iron in furnace!");

        System.out.println("Mining gravel.");
        typer.command(".b mine 20 gravel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        System.out.println("Done mining gravel!");

        System.out.println("Going to furnace.");
        typer.command(".b goto furnace",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.waitUntilStationary();
        System.out.println("In furnace!");

        System.out.println("Waiting for smelting to be done.");
        looker.waitUntilSmeltingDown();
        crafter.getSmelt();
        System.out.println("Smelting is done!");

    }
}
