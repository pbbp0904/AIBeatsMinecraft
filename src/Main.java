import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        Rectangle screenRect = new Rectangle(600, 900, 600, 200);

        System.out.println("Hello world!");
        Typer typer = new Typer();
        Inventory inventory = new Inventory(typer);
        Thread.sleep(5000);
        typer.type(".b mine 20 oak_log",10,50);
        typer.pressEnter(1000);

        Looker look = new Looker();
        while(!look.foundImageOnScreen("src\\Checkpoint_Images\\Log_Checkpoint.jpg",screenRect,0.1,1)){
            Thread.sleep(10);
        }
        System.out.println("TRIGGERED!");
        Crafter crafter = new Crafter();
        crafter.craft("wooden_plank", 4);
        Thread.sleep(50);
        crafter.craft("crafting_table", 1);
        Thread.sleep(50);
        crafter.craft("stick", 4);
        typer.type("8",10,50);
        typer.rightClick(50);
        typer.rightClick(50);
        crafter.craft("wooden_pickaxe",1);
        Thread.sleep(50);
        typer.type(".b mine 14 stone",10,50);
        typer.pressEnter(10);


    }
}
