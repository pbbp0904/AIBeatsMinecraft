import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        System.out.println("Hello world!");
        Typer typer = new Typer();
        //typer.type("hello");
        Thread.sleep(5000);
        Inventory inventory = new Inventory();
        Crafter crafter = new Crafter();
        crafter.craft("wooden_plank", 4);
        Thread.sleep(50);
        crafter.craft("crafting_table", 1);
        Thread.sleep(50);
        crafter.craft("stick", 4);

    }
}
