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
import java.util.logging.Level;
import java.util.logging.Logger;



class ThreadHandler extends Thread {

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()) {
            try {
                AIBM.main();
                System.out.println("Successfully completed AIBM main.");
            } catch (InterruptedException ignore) {

            } catch (IOException e) {
                System.out.println("Exception in AIBM Thread.");
                e.printStackTrace();
            } finally {
                Typer.releaseAllKeys();
                System.out.println("AIBM is closing.");
                Main.setShutdown(true);
                Main.setClosed(true);
            }
        }
    }
}







class Starter extends Thread implements NativeKeyListener {

    private static boolean enter;

    static {
        enter = true;
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_END) {
            System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
            System.out.println("Voluntarily quitting run...");
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
}




public class Main {

    public static boolean ready;
    public static boolean shutdown;
    public static boolean closed;
    public static volatile Starter s;
    public static final ThreadHandler aibm = new ThreadHandler();

    public static void main(String[] args) throws InterruptedException {
        ready = false;
        shutdown = false;
        closed = false;
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

        aibm.setName("AIBM");
        aibm.start();
        Waiter.wait(3000);

        while(!shutdown){
            Waiter.wait(500);
        }

        while(!closed) {
            if (!aibm.isInterrupted()) {
                aibm.interrupt();
            }
        }

        System.out.println("before escape 1");
        Typer.holdKey("escape",10);
        System.out.println("before escape 2");
        Typer.holdKey("escape");
        Typer.releaseKey("escape");
        Typer.pressKey("escape");
        System.out.println("before cancel");
        Typer.command(".b cancel");
        Typer.command(".preset load user");
        System.out.println("Before final escape");
        Typer.pressKey("escape");
        System.exit(0);

    }

    public static void setReady(boolean rdy){ ready = rdy; }
    public static void setShutdown(boolean sd){ shutdown = sd; }
    public static void setClosed(boolean closed) { Main.closed = closed; }
}