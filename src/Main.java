import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {
        Typer typer = new Typer();
        Looker look = new Looker();
        Crafter crafter = new Crafter();
        MouseMover mm = new MouseMover();
        System.out.println("Hello world!");
        Thread.sleep(5000);
        Rectangle hotbarScreenRect = new Rectangle(600, 900, 600, 200);
        Rectangle craftingScreenRect = new Rectangle(850, 250, 100, 200);
        int shortSleepTime = 50;
        int longSleepTime = 100;



        // START
        typer.type("/clear",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        typer.type("/time set 0",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        typer.type("/weather clear 10000",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);

        typer.type(".b mine 4 oak_log",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);

        System.out.println("Log");
        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Log_Checkpoint_4.jpg",hotbarScreenRect,0.12,1)){
            Thread.sleep(shortSleepTime);
        }
        System.out.println("TRIGGERED!");

        crafter.craft("wooden_plank", 4);
        Thread.sleep(longSleepTime*5);
        crafter.craft("crafting_table", 1);
        Thread.sleep(longSleepTime*5);
        crafter.craft("stick", 3);

        typer.type(".b goto grass",shortSleepTime,longSleepTime);
        typer.pressEnter(5000);
        typer.type(".b goal ~ ~-1 ~",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        typer.type(".b path",shortSleepTime,longSleepTime);
        typer.pressEnter(6000);
        typer.type("8",shortSleepTime,longSleepTime);
        mm.moveMouse(960,700,longSleepTime);
        typer.holdSpace(100);
        typer.holdRightClick(10);
        typer.releaseSpace(300);
        typer.releaseRightClick(1000);
        typer.holdRightClick(100);
        typer.releaseRightClick(1000);
        Thread.sleep(500);

        crafter.craft("wooden_pickaxe",1);
        Thread.sleep(longSleepTime);
        typer.type(".b mine 14 stone",shortSleepTime,longSleepTime);
        typer.pressEnter(shortSleepTime);

        System.out.println("Stone");
        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Stone_Checkpoint.jpg",hotbarScreenRect,0.12,1)){
            Thread.sleep(shortSleepTime);
        }
        System.out.println("TRIGGERED!");

        System.out.println("Crafting");
        typer.type(".b goto crafting_table",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
            Thread.sleep(shortSleepTime);
        }
        crafter.craft("stone_pickaxe",1);

        typer.type(".b goto crafting_table",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
            Thread.sleep(shortSleepTime);
        }
        crafter.craft("stone_sword",1);

        typer.type(".b goto crafting_table",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
            Thread.sleep(shortSleepTime);
        }
        crafter.craft("stone_shovel",1);

        typer.type(".b goto crafting_table",shortSleepTime,longSleepTime);
        typer.pressEnter(longSleepTime);
        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
            Thread.sleep(shortSleepTime);
        }
        crafter.craft("furnace",1);


    }
}
