import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;

public class Main {

    public static boolean ready;
    public static volatile Starter s;
    public static final String preset = "AIBM";

    public static void main(String[] args) throws IOException {

        //TODO Implementations:
        // - Replenishing food for phases 3 and 4, Medium
        // - Integrating phases 2->3 and 3->4, Medium
        // - Destroy end crystals, Hard - N/A time detection, better ways?
        // - Dealing damage to kill the ender dragon, Hard

        //TODO Improvements:
        // - Edit Portal Schematic for better chance at lighting the portal, Medium
        // - External config file, Easy
        // - Move command/instruction code out of main, Easy
        // - Nether Mushroom Shimmy
        // - More consistent portal assembly, Medium
        // - Start up Baritone/Autoeject config, Medium
        // - Making inventory item search faster, Medium
        // - Move to png image files, Medium
        // - Progress checks, Medium
        // - More efficiently hunting enderman, Medium
        // - Asynch run counter git push, Medium
        // - Interact via the baritone API, Hard
        // - Getting obsidian more consistently, Hard


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




        startUp();

        doPhase(1);
        doPhase(2);
        doPhase(3);

        //jumpToPhase(4);
        //Waiter.wait(2000);
        //doPhase(4);

        //giveDiamondThings();
        //gotoEndPortal();
        //goIntoEndPortal();
        //lightEndPortal();
        //doPhase(1);
        //doPhase(4);




//        startUp();
//        Looker.lookDown();
//        int i = 0;
//        while(i < 1000000000){
//            doCheck("ender_pearls");
//            Waiter.wait(10000);
//            i++;
//        }


//        startUp();
//        gotoEndPortal();


//        while(true){
//            startUp();
//            long start = System.currentTimeMillis();
//            long end = start + 1200*1000;
//            doPhaseTime(1,end);
//            Waiter.wait(10000);
//            reset();
//        }




//        while (true) {
//
//            main.startUp();
//            main.jumpToPhase(2);
//        main.Waiter.wait(500);
//        main.looker.lookDown();
//        main.Typer.type("4");
//        main.Typer.holdRightClick(20);
//        main.Typer.releaseRightClick(20);
//        main.Waiter.wait(2000);
//            main.Waiter.wait(10000);
//            main.Typer.holdS(400);
//            main.Typer.holdD(400);
//            main.Typer.releaseS(200);
//            main.Typer.releaseD(200);
//            long start = System.currentTimeMillis();
//            long end = start + 600*1000;
//            main.doPhaseTime(2,end);
//            main.reset();
//        }



//        main.startUp();
//        main.jumpToPhase(2);
//        main.Waiter.wait(500);
//        main.looker.lookDown();
//        main.Typer.type("4");
//        main.Typer.holdRightClick(20);
//        main.Typer.releaseRightClick(20);
//        main.Waiter.wait(2000);
//        main.Waiter.wait(10000);
//        main.Typer.holdS(400);
//        main.Typer.holdD(250);
//        main.Typer.releaseS(200);
//        main.Typer.releaseD(200);
//        main.Waiter.wait(1000);
//        main.doPhase(2);

        //finish();
    }

    private static void reset() {
        Typer.type("e");
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            assert image != null;
            String s = String.valueOf(System.currentTimeMillis());
            ImageIO.write(image, "png", new File("src\\Completion_Images\\" + s + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Typer.holdKey("escape", 3000);
        Typer.releaseKey("escape", 100);

        Typer.holdKey("escape", 3000);
        Typer.releaseKey("escape", 100);
        for(int i = 0; i<8; i++){
            Typer.pressKey("tab", 600);
        }
        Typer.pressKey("enter", 1500);
        for(int i = 0; i<1; i++){
            Typer.pressKey("tab", 100);
        }
        Typer.pressKey("enter", 100);

        for(int i = 0; i<1; i++){
            Typer.pressKey("tab", 100);
        }
        Typer.pressKey("enter", 15000);

        for(int i = 0; i<2; i++){
            Typer.pressKey("tab", 100);
        }
        Typer.pressKey("enter", 100);

        for(int i = 0; i<4; i++){
            Typer.pressKey("tab", 100);
        }
        Typer.pressKey("enter", 100);

        for(int i = 0; i<3; i++){
            Typer.pressKey("tab", 100);
        }
        Typer.pressKey("enter", 100);

        for(int i = 0; i<6; i++){
            Typer.pressKey("tab", 100);
        }
        Typer.pressKey("enter", 100);

        for(int i = 0; i<3; i++){
            Typer.pressKey("tab", 100);
        }
        Typer.pressKey("enter", 30000);
    }

    public static void jumpToPhase(int phase){
        String instructionSetString = "src\\Instruction_Sets\\JumpToPhase_" + phase + ".json";
        doInstructionSet(instructionSetString);
    }


    public static void doPhase(int phase){
        String instructionSetString = "src\\Instruction_Sets\\Phase_" + phase + ".json";
        doInstructionSet(instructionSetString);
    }

    public static void doPhase(int phase, int startingInstruction){
        String instructionSetString = "src\\Instruction_Sets\\Phase_" + phase + ".json";
        doInstructionSet(instructionSetString, startingInstruction);
    }

    public static void doInstructionSet(String instructionSetString){
        JSONArray instructionSet = loadInstructionSet(instructionSetString);
        for (int i = 0; i<instructionSet.size(); i++){
            Object instruction = instructionSet.get(i);
            int jumpValue = doInstruction((JSONObject) instruction);
            System.out.print(jumpValue);
            i = i + jumpValue;
        }
    }



    public static void doPhaseTime(int phase, long time){
        String instructionSetString = "src\\Instruction_Sets\\Phase_" + phase + ".json";
        doInstructionSetTime(instructionSetString, time);
    }

    public static void doInstructionSetTime(String instructionSetString, long time){
        JSONArray instructionSet = loadInstructionSet(instructionSetString);
        for (Object instruction : instructionSet){
            doInstruction((JSONObject) instruction);
            if (System.currentTimeMillis() > time) {
                break;
            }
            Rectangle deathScreenRect = new Rectangle(1030, 440, 150, 100);
            if (Looker.foundImageOnScreen("src\\Checkpoint_Images\\Death.jpg", deathScreenRect, 0.1)){
                break;
            }
        }
    }

    public static void doInstructionSet(String instructionSetString, int startingInstruction){
        JSONArray instructionSet = loadInstructionSet(instructionSetString);
        for (int i = startingInstruction; i<instructionSet.size(); i++){
            Object instruction = instructionSet.get(i);
            int jumpValue = doInstruction((JSONObject) instruction);
            //System.out.print(jumpValue);
            i = i + jumpValue;
        }
    }

    private static int doInstruction(JSONObject instruction){
        String type = (String) instruction.get("type");
        String name = (String) instruction.get("name");
        System.out.println("Doing Instruction: " + name);
        int jumpValue = 0;
        switch (type) {
            case "command":
                try {
                    doCommand((String) instruction.get("command_string"), (boolean) instruction.get("wait_until_done"), (long) instruction.get("fuse"));
                }catch(java.lang.NullPointerException exception){
                    doCommand((String) instruction.get("command_string"), (boolean) instruction.get("wait_until_done"), -1);
                }
                break;
            case "craft":
                doCraft((String) instruction.get("item"), ((Number) instruction.get("number")).intValue(), (boolean) instruction.get("open_inventory"), (boolean) instruction.get("close_inventory"));
                break;
            case "smelt":
                doSmelt((String) instruction.get("item"), ((Number) instruction.get("number")).intValue(), (boolean) instruction.get("place_in"), (boolean) instruction.get("wait_until_done"), (boolean) instruction.get("open_inventory"), (boolean) instruction.get("close_inventory"));
                break;
            case "place":
                doPlace((String) instruction.get("item"), (boolean) instruction.get("enter"));
                break;
            case "sort":
                doSort((JSONArray) instruction.get("spec"), (boolean) instruction.get("discard_unspecified"), (boolean) instruction.get("open_inventory"), (boolean) instruction.get("close_inventory"));
                break;
            case "light":
                doLight((String) instruction.get("portal"));
                break;
            case "move":
                doMove((String) instruction.get("move_type"));
                break;
            case "check":
                jumpValue = doCheck((String) instruction.get("check_type"));
                break;
            case "hotbar":
                doHotbar((String) instruction.get("slot"));
                break;
            case "throw":
                doThrow();
                break;
        }
        // Type NUMPAD_1 for splits
        Typer.pressKey("NP1");

        //return
        return jumpValue;
    }

    private static void doCommand(String command_string, boolean wait_until_done, long fuse) {
        Typer.command(command_string);
        if(wait_until_done && fuse == -1){
            Looker.waitUntilDone();
        }
        if(wait_until_done && fuse > 0){
            Looker.waitUntilDoneFuse(fuse);
        }

    }

    private static void doCraft(String item, int number, boolean open_inventory, boolean close_inventory) {
        if(open_inventory){
            Typer.openInventory();
        }

        Crafter.craft(item, number);

        if(close_inventory){
            Typer.closeInventory();
        }
    }

    private static void doSmelt(String item, int number, boolean place_in, boolean wait_until_done, boolean open_inventory, boolean close_inventory) {
        if(open_inventory){
            Typer.openInventory();
        }

        if(place_in) {
            Crafter.smelt(item, number);
        }

        if(wait_until_done){
            Looker.waitUntilSmeltingDone();
            Crafter.getSmelt();
        }

        if(close_inventory){
            Typer.closeInventory();
        }
    }

    private static void doPlace(String item, boolean enter) {

        Looker.waitUntilDone();
        Typer.command(".b goal ~ ~1 ~");
        Typer.command(".b path");
        Looker.waitUntilDone();
        Typer.command(".b goal ~ ~-1 ~");
        Typer.command(".b path");
        Looker.waitUntilDone();
        Typer.openInventory();
        MouseMover.moveMouseAway();
        Waiter.waitLong();
        Sorter.putItemInHotbar(item, 9, false);
        Typer.closeInventory();
        Typer.type("9",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Looker.lookDown();
        Waiter.wait(Waiter.getLongSleepTime()*2);
        Typer.doSneak();
        Typer.doJump();
        Waiter.wait(Waiter.getLongSleepTime()*2);
        Typer.holdRightClick(2000);
        Typer.releaseRightClick(Waiter.getShortSleepTime());
        Typer.stopJump();
        Typer.stopSneak();

        if(!enter){
            Typer.closeInventory();
        }
    }

    private static void doSort(JSONArray spec, boolean discard_unspecified, boolean open_inventory, boolean close_inventory) {
        if(open_inventory){
            Typer.openInventory();
        }

        for (Object action : spec){
            int slot = ((Number) (((JSONObject) action).get("slot"))).intValue();
            if(slot>0) {
                Sorter.putItemInHotbar((String) ((JSONObject) action).get("item"), slot, (Boolean) ((JSONObject) action).get("backOnly"));
            }else{
                Sorter.putOnArmor((String) ((JSONObject) action).get("item"),(Boolean) ((JSONObject) action).get("backOnly"));
            }
        }

        if(close_inventory){
            Typer.closeInventory();
        }
    }

    private static void doLight(String portal) {
        switch (portal) {
            case "nether":
                Typer.type("2");
                Looker.lookUp();
                Typer.holdLeftClick(1000);
                Typer.releaseLeftClick(10);
                Sorter.putItemInHotbar("flint_and_steel", 7, false);
                Typer.type("7");
                Typer.holdRightClick(Waiter.getLongSleepTime());
                Typer.releaseRightClick(Waiter.getLongSleepTime());
                Waiter.wait(10000);
                break;
            case "end":
                Typer.command(".b set avoidance false");
                Typer.command(".b goto stone_brick_stairs");
                Looker.waitUntilStationary();
                Typer.command(".b goto spawner");
                Waiter.wait(2000);
                Typer.startMoveForward();
                Typer.doJump();
                Waiter.wait(500);
                Typer.stopJump();
                Waiter.wait(700);
                Looker.lookDown();
                Typer.type("4");
                Typer.holdRightClick(10);
                Typer.stopMoveForward();
                Waiter.wait(750);
                Typer.releaseRightClick(1);

                for(int rot = 0; rot<360; rot+=20) {
                    Typer.command(".rotate " + Integer.toString(rot) + " 0");
                    Typer.type("5");
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
        }
    }




    public static void doMove(String move_type) {
        switch (move_type){
            case "portal":
                Typer.startMoveBack();
                Typer.startMoveRight();
                Waiter.wait(250);
                Typer.stopMoveBack();
                Waiter.wait(250);
                Typer.stopMoveRight();
                Typer.startMoveForward();
                Typer.startMoveRight();
                Waiter.wait(150);
                Typer.stopMoveForward();
                Waiter.wait(150);
                Typer.stopMoveRight();
                Waiter.wait(2000);
                break;
            default:
                break;
        }
    }

    public static int doCheck(String check_type){
        int jumpValue = 0;
        switch(check_type){
            case "blaze_rods":
                Typer.openInventory();
                Waiter.wait(Waiter.getLongSleepTime());
                MouseMover.moveMouseAway();
                Waiter.wait(Waiter.getLongSleepTime());
                boolean blaze_check = Looker.foundImageOnScreen("src\\Checkpoint_Images\\blaze_rod.jpg", Looker.getInventoryScreenRect(),0.05);
                if (blaze_check){
                    jumpValue = 0;
                }else{
                    jumpValue = -9;
                }
                Typer.closeInventory();
            case "ender_pearls":
                Typer.openInventory();
                Waiter.wait(Waiter.getLongSleepTime());
                MouseMover.moveMouseAway();
                Waiter.wait(Waiter.getLongSleepTime());
                boolean ender_check_4 = Looker.foundImageOnScreen("src\\Checkpoint_Images\\ender_pearls_4.jpg", Looker.getInventoryScreenRect(),0.05);
                boolean ender_check_16 = Looker.foundImageOnScreen("src\\Checkpoint_Images\\ender_pearls_16.jpg", Looker.getInventoryScreenRect(),0.05);
                if (ender_check_4 && ender_check_16){
                    jumpValue = 0;
                }else{
                    jumpValue = -7;
                }
                Typer.closeInventory();
        }

        return jumpValue;
    }


    public static void doHotbar(String slot){
        Typer.type(slot);
    }

    public static void doThrow(){
        Typer.rightClick(250);
        Waiter.wait(100);
    }


    public static void giveDiamondThings() {
        Typer.command("/clear @p",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 diamond_helmet{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 diamond_chestplate{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 diamond_leggings{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 diamond_boots{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());

        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime()*5);
        Typer.holdRightClick(Waiter.getShortSleepTime());
        Typer.type("2",Waiter.getShortSleepTime(),Waiter.getLongSleepTime()*5);
        Typer.type("3",Waiter.getShortSleepTime(),Waiter.getLongSleepTime()*5);
        Typer.type("4",Waiter.getShortSleepTime(),Waiter.getLongSleepTime()*5);
        Typer.releaseRightClick(Waiter.getShortSleepTime());

        Typer.command("/give pbbp0904 diamond_sword{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 diamond_pickaxe{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 diamond_shovel{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 cooked_beef 64",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 ender_eye 24",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give pbbp0904 dirt 1024",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());

    }


    private static void gotoEndPortal(){
        Typer.command("/gamerule doDaylightCycle false");
        Typer.command(".b set exploreForBlocks true");

        Typer.command("5");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 1600");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("5");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 800");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("5");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 400");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("5");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 200");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("5");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 200");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("5");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 200");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("5");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 200");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("5");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 100");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command(".b set exploreForBlocks false");
    }




    public static void goIntoEndPortal(){
        Typer.command(".toggle KillAura");
        Typer.command(".b set avoidance false");
        Typer.command(".b goto stone_brick_stairs");
        Looker.waitUntilStationary();
        Typer.command(".b goto spawner");
        Waiter.wait(2000);
        Typer.startMoveForward();
        Typer.doJump();
        Waiter.wait(500);
        Typer.stopJump();
        Waiter.wait(700);
        Looker.lookDown();
        Typer.type("9");
        Typer.holdRightClick(10);
        Typer.stopMoveForward();
        Waiter.wait(750);
        Typer.releaseRightClick(1);
    }

    public static void lightEndPortal(){
        for(int rot = 0; rot<360; rot+=20){
            Typer.command(".rotate " + Integer.toString(rot) + " 0");
            Typer.type("5");
            Typer.rightClick(Waiter.getShortSleepTime());
        }
    }


    public static JSONArray loadInstructionSet(String instructionSetString){
        JSONParser jsonParser = new JSONParser();
        JSONArray instructionSet = null;
        try (FileReader reader = new FileReader(instructionSetString))
        {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            // Convert to JSON array
            instructionSet = (JSONArray) obj;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return instructionSet;
    }

    public static void startUp() throws IOException {
        System.out.println("Hello world!");
        try {
            Filer.incrementRunCounter();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // START
        System.out.println("Starting Run!");
//        Typer.command("/clear");
//        Typer.command("/time set 0");
//        Typer.command("/weather clear 10000");

        // Type num pad 1 for to start splits

        //        while(!looker.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
        //            Thread.sleep(Waiter.getShortSleepTime());
        //        }

        //load our preset and import schematics
        Filer.loadPreset();
        Waiter.waitShort();
        Filer.schematicsFolder();
        Waiter.waitShort();
        Typer.command(".b set maxFallHeightNoWater 3");
        Typer.command(".b set avoidance false");
        Typer.command(".b set exploreForBlocks false");
        Waiter.waitShort();
        Typer.pressKey("NP1");
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







    public static void makeObsidianTest() {
        Typer.command("/fill ~-1 ~-1 ~-1 ~-5 ~-2 ~-5 minecraft:lava", Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/fill ~-3 ~3 ~-3 ~-3 ~3 ~-3 minecraft:water", Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
    }

    public static void doHunt() {
        Typer.command("/clear @p",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give Cosmologicomical diamond_helmet{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give Cosmologicomical diamond_chestplate{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give Cosmologicomical diamond_leggings{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give Cosmologicomical diamond_boots{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());

        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime()*5);
        Typer.holdRightClick(Waiter.getShortSleepTime());
        Typer.type("2",Waiter.getShortSleepTime(),Waiter.getLongSleepTime()*5);
        Typer.type("3",Waiter.getShortSleepTime(),Waiter.getLongSleepTime()*5);
        Typer.type("4",Waiter.getShortSleepTime(),Waiter.getLongSleepTime()*5);
        Typer.releaseRightClick(Waiter.getShortSleepTime());

        Typer.command("/give Cosmologicomical stone_sword{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give Cosmologicomical diamond_pickaxe{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give Cosmologicomical diamond_shovel{Enchantments:[{id:unbreaking,lvl:100}]}",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give Cosmologicomical cooked_beef 64",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/give Cosmologicomical dirt 1024",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());

        Typer.command("/worldborder center ~ ~",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/worldborder set 640",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/weather clear 1000000",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/time set 0",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/effect give @p minecraft:instant_health 100",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/effect give @p minecraft:saturation 10",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/clear @p[name=!Cosmologicomical]",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("tI'll be coming for you in 20 minutes!!!!",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());

        Waiter.wait(1200000);
        Typer.type("t",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("I'll be coming for you very soon!!!!",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Waiter.wait(210000);
        Typer.type("t",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("Best ye run...",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command(".b follow entity player",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
    }


}
