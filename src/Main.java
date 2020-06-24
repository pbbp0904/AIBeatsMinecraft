import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        Typer typer = new Typer();

        Looker look = new Looker();
        Crafter crafter = new Crafter();
        MouseMover mm = new MouseMover();
        //Inventory inventory = new Inventory(typer);
        Filer filer = new Filer();
        System.out.println("Hello world!");
        filer.incrementRunCounter();


        Thread.sleep(5000);

        //Thread.sleep(50000);

        int shortSleepTime = 60;
        int longSleepTime = 100;
        int stationaryWaitTime = 1500;


        woodGather(look, typer, crafter);
        stoneGather(look, typer, crafter, mm);






    }

    public static void woodGather(Looker look, Typer typer, Crafter crafter) throws IOException, InterruptedException, AWTException {
        // START

        System.out.println("Starting Run!");
        typer.type("/clear",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        typer.type("/time set 0",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        typer.type("/weather clear 10000",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);

        System.out.println("Mining logs.");
        typer.type(".b mine 8 oak_log",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        look.waitUntilStationary(centerScreenRect, stationaryWaitTime);
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Log_Checkpoint_4.jpg",hotbarScreenRect,0.12,1)){
//            Thread.sleep(shortSleepTime);
//        }
        System.out.println("We now have enough logs!");

        System.out.println("Crafting wooden items.");
        crafter.craft("wooden_plank", 4);
        Thread.sleep(longSleepTime);
        crafter.craft("crafting_table", 1);
        Thread.sleep(longSleepTime);
        crafter.craft("stick", 4);

        System.out.println("Placing crafting table.");
        typer.type(".b goto grass",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        look.lookDown();
        look.waitUntilStationary(centerScreenRect, stationaryWaitTime);
        typer.type(".b goal ~ ~-1 ~",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        typer.type(".b path",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        look.waitUntilStationary(centerScreenRect, stationaryWaitTime);
        typer.type("8",shortSleepTime,longSleepTime);
        look.lookDown();
        Thread.sleep(longSleepTime*2);
        typer.holdSpace(100);
        typer.holdRightClick(2000);
        typer.releaseSpace(shortSleepTime);
        typer.releaseRightClick(shortSleepTime);

        System.out.println("Crafting wooden pickaxe.");
        crafter.craft("wooden_pickaxe",1);
        Thread.sleep(longSleepTime);
    }

    public static void stoneGather(Looker look, Typer typer, Crafter crafter, MouseMover mm) throws IOException, InterruptedException {
        System.out.println("Mining stone.");
        typer.type(".b mine 16 stone",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Stone_Checkpoint.jpg",hotbarScreenRect,0.12,1)){
//            Thread.sleep(shortSleepTime);
//        }
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
        System.out.println("We now have enough stone!");

        System.out.println("Going to crafting table.");
        typer.type(".b goto crafting_table",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
//            Thread.sleep(shortSleepTime);
//        }
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
        System.out.println("In crafting table!");

        System.out.println("Crafting stone tools.");
        crafter.craft("stone_tools",1);

        System.out.println("Mining a little grass...");
        typer.type(".b mine grass",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        Thread.sleep(6000);
        typer.type(".b cancel",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);

        System.out.println("Placing furnace.");
        typer.type(".b goto grass",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
        typer.type(".b goal ~ ~-1 ~",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        typer.type(".b path",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
        typer.type("e",shortSleepTime,longSleepTime);
        Thread.sleep(longSleepTime);
        mm.moveMouse(look.findLocationOnScreen("src\\Item_Images\\Furnace.jpg",look.getInventoryScreenRect(),1),longSleepTime);
        typer.type("1",shortSleepTime,longSleepTime);
        Thread.sleep(longSleepTime);
        typer.type("e",shortSleepTime,longSleepTime);
        Thread.sleep(longSleepTime);
        typer.type("1",shortSleepTime,longSleepTime);
        Thread.sleep(longSleepTime);
        look.lookDown();
        Thread.sleep(longSleepTime*2);
        typer.holdSpace(100);
        typer.holdRightClick(2000);
        typer.releaseSpace(shortSleepTime);
        typer.releaseRightClick(shortSleepTime);
        typer.type("e",shortSleepTime,longSleepTime);


    }


    public static void ironGather(Looker look, Typer typer, Crafter crafter) throws InterruptedException {
        System.out.println("Mining iron ore.");
        typer.type(".b mine 30 iron_ore",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Iron_Ore_Checkpoint.jpg",inventoryScreenRect,0.15,1)){
//            Thread.sleep(shortSleepTime);
//        }
        System.out.println("We now have enough iron_ore!");

        System.out.println("Mining coal.");
        typer.type(".b mine 8 coal_ore",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Iron_Ore_Checkpoint.jpg",inventoryScreenRect,0.15,1)){
//            Thread.sleep(shortSleepTime);
//        }
        System.out.println("We now have enough coal!");

        System.out.println("Going to furnace.");
        typer.type(".b goto furnace",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
//            Thread.sleep(shortSleepTime);
//        }
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
        System.out.println("In furnace!");

        crafter.smelt("iron",30);

        System.out.println("Mining gravel.");
        typer.type(".b mine 20 gravel",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
        System.out.println("We now have enough gravel!");

        System.out.println("Going to furnace.");
        typer.type(".b goto furnace",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
//        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
//            Thread.sleep(shortSleepTime);
//        }
        look.waitUntilStationary(look.getCenterScreenRect(), stationaryWaitTime);
        System.out.println("In furnace!");

        look.waitUntilStationary(look.getFurnaceProgressScreenRect(), stationaryWaitTime*2);
        crafter.getSmelt();


    }

}
