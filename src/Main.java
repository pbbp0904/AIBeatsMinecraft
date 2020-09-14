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


public class Main {

    public static boolean ready;
    public static volatile Starter s;
    public static final String preset = "AIBM";

    public static void main(String[] args) {
        ready = false;
        s = new Starter();
        s.start();
        System.out.println("Bring minecraft into focus and press Enter to begin.");
        System.out.println("The program will automatically begin in 10 seconds, even without pressing enter.");

        int time = 10;

        while (!ready && time > 0) {
            System.out.println(time);
            time--;
            Waiter.wait(1000);
        }




    }



    public static void finish(){
        Typer.command(".preset load user");
        System.exit(0);
    }

    public static void setReady(boolean rdy){
        ready = rdy;
    }
    public static boolean getReady(){
        return ready;
    }


}