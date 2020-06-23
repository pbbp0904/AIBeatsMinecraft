import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, AWTException, IOException {

        System.out.println("Hello world!");
        Typer typer = new Typer();
        //typer.type("hello");
        Thread.sleep(5000);
        Crafter crafter = new Crafter();
        crafter.craft("wooden_planks");
    }
}
