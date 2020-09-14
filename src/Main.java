//TODO Implementations:
// - [PHASE 3,4] Replenishing food for phases 3 and 4, Easy
// - [PHASE 4] Destroy end crystals, Hard - N/A time detection, better ways?
// - [PHASE 4] Dealing damage to kill the ender dragon, Hard

//TODO Improvements:
// - Pressing:
// - [PHASE 3] More efficiently hunting enderman, Hard
// - [PHASE 3] Better Ender Pearl Detection, Medium
// - [PHASE 2] Open spawner problem, Hard
// - [PHASE 2] Netherbrick fence problem, Hard
// - [PHASE 1] More consistent portal assembly, Edit Portal Schematic for better chance at lighting the portal, Medium
// - [PHASE 0] Start up Baritone/Autoeject config, Medium
// - [PHASE 0] Making inventory item search faster, Medium
// - Not Pressing:
// - [PHASE 0] External config file, Easy
// - [PHASE 0] Asynch run counter git push, Medium
// - [PHASE 0] Interact via the baritone API, Hard
// - [PHASE 1] Getting obsidian more consistently/optimizing getting, try obsidian then pillaring, Hard
// - [PHASE 0] Move to png image files, Medium
// - [PHASE 0] Move command/instruction code out of main, Easy


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;



class ThreadHandler extends Thread {

    @Override
    public void run() {

        Thread t = Thread.currentThread();
        Main.sett1ID(t.getId());

        while (!interrupted()) {
            try {
                AIBM.main();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}






class Starter extends Thread implements NativeKeyListener {

    private static boolean enter;
    private long t1ID;

    static {
        enter = true;
    }

    public void setT1(long in) {
        this.t1ID = in;
        System.out.println(in);
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_BACK_SLASH) {
            System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

            Waiter.waitLong();
            Typer.command(".b cancel");
            Typer.command(".preset load user");
            Typer.pressKey("escape", 10);
            Main.setShutdown(true);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_ENTER && enter) {
            enter = false;
            System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
            Main.setReady(true);
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
    }

    public void createListener() {
        // Disables the logging outputs for this stuff
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);


        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new Starter());
    }

    public void run(){
        createListener();
    }

    public static void finish() {
        Typer.command(".preset load user");
        Typer.pressKey("escape", 10);
        System.exit(0);
    }
}







public class Main {

    public static boolean ready;
    public static boolean shutdown = false;
    public static volatile Starter s;
    public static volatile ThreadHandler t1;
    private static long t1ID;
    public static final String preset = "AIBM";

    public static void main(String[] args) {
        ready = false;
        s = new Starter();
        s.start();
        s.setName("KeyboardListener");
        System.out.println(s);
        System.out.println("Bring minecraft into focus and press Enter to begin.");
        System.out.println("The program will automatically begin in 10 seconds, even without pressing enter.");

        int time = 10;

        while (!ready && time > 0) {
            System.out.println(time);
            time--;
            Waiter.wait(1000);
        }

        t1 = new ThreadHandler();

        t1.setName("AIBM");
        t1.start();

        while(!shutdown){
        }

        System.exit(0);

    }



    public static void setReady(boolean rdy){
        ready = rdy;
    }

    public static void setShutdown(boolean sd){
        shutdown = sd;
    }

    public static void sett1ID(long i) { t1ID = i; }
}