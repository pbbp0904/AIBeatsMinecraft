import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.io.FileReader;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;

public class Main {

    public static boolean ready;
    public static volatile Starter s;

    public static void main(String[] args){



//        for(int i = 0; i < 10000; i++) {
//            PointerInfo a = MouseInfo.getPointerInfo();
//            Point b = a.getLocation();
//            int x = (int) b.getX();
//            int y = (int) b.getY();
//            System.out.print(x + ",");
//            System.out.print(y + "\n");
//            Thread.sleep(100);
//        }

//        Main main = new Main();
//        main.Waiter.wait(5000);
//
//        main.startUp();
//        main.jumpToPhase(4);
//        main.Waiter.wait(2000);
//        main.doPhase(4);




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


        //giveDiamondStuff(main.Typer,main.Waiter);
        //main.Waiter.iwait(30000);

        //doHunt(main.Typer, main.Waiter);


        //obsidianGather(main.looker, main.Typer, main.crafter, main.mm, main.Waiter);
        //makeObsidianTest(main.Typer,main.Waiter);
        //main.startUp();

        // Write a block off water fall routine for the obsidian problem?

        //woodGather(main.looker, main.Typer, main.crafter, main.Waiter);
        //stoneGather(main.looker, main.Typer, main.crafter, main.mm, main.Waiter);
        //ironGather(main.looker, main.Typer, main.crafter, main.mm, main.Waiter);
        //diamondGather(main.looker, main.Typer, main.crafter, main.mm, main.Waiter);
        //bedGather(main.looker, main.Typer, main.crafter, main.Waiter);
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


        Typer.holdEscape(3000);
        Typer.releaseEscape(100);
        for(int i = 0; i<8; i++){
            Typer.pressTab(600);
        }
        Typer.pressEnter(1500);
        for(int i = 0; i<1; i++){
            Typer.pressTab(100);
        }
        Typer.pressEnter(100);

        for(int i = 0; i<1; i++){
            Typer.pressTab(100);
        }
        Typer.pressEnter(15000);

        for(int i = 0; i<2; i++){
            Typer.pressTab(100);
        }
        Typer.pressEnter(100);

        for(int i = 0; i<4; i++){
            Typer.pressTab(100);
        }
        Typer.pressEnter(100);

        for(int i = 0; i<3; i++){
            Typer.pressTab(100);
        }
        Typer.pressEnter(100);

        for(int i = 0; i<6; i++){
            Typer.pressTab(100);
        }
        Typer.pressEnter(100);

        for(int i = 0; i<3; i++){
            Typer.pressTab(100);
        }
        Typer.pressEnter(15000);
    }

    public void jumpToPhase(int phase){
        String instructionSetString = "src\\Instruction_Sets\\JumpToPhase_" + Integer.toString(phase) + ".json";
        doInstructionSet(instructionSetString);
    }


    public static void doPhase(int phase){
        String instructionSetString = "src\\Instruction_Sets\\Phase_" + Integer.toString(phase) + ".json";
        doInstructionSet(instructionSetString);
    }

    public void doPhase(int phase, int startingInstruction){
        String instructionSetString = "src\\Instruction_Sets\\Phase_" + Integer.toString(phase) + ".json";
        doInstructionSet(instructionSetString, startingInstruction);
    }

    public static void doInstructionSet(String instructionSetString){
        JSONArray instructionSet = loadInstructionSet(instructionSetString);
        for (Object instruction : instructionSet){
            doInstruction((JSONObject) instruction);
        }
    }



    public void doPhaseTime(int phase, long time){
        String instructionSetString = "src\\Instruction_Sets\\Phase_" + Integer.toString(phase) + ".json";
        doInstructionSetTime(instructionSetString, time);
    }

    public void doInstructionSetTime(String instructionSetString, long time){
        JSONArray instructionSet = loadInstructionSet(instructionSetString);
        for (Object instruction : instructionSet){
            doInstruction((JSONObject) instruction);
            if (System.currentTimeMillis() > time) {
                break;
            }
        }
    }


    public void doInstructionSet(String instructionSetString, int startingInstruction){
        JSONArray instructionSet = loadInstructionSet(instructionSetString);
        for (int i = startingInstruction; i<instructionSet.size(); i++){
            Object instruction = instructionSet.get(i);
            doInstruction((JSONObject) instruction);
        }
    }

    private static void doInstruction(JSONObject instruction){
        String type = (String) instruction.get("type");
        String name = (String) instruction.get("name");
        System.out.println("Doing Instruction: " + name);
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
        }
    }

    private static void doCommand(String command_string, boolean wait_until_done, long fuse) {
        Typer.command(command_string);
        if(wait_until_done && fuse == -1){
            Looker.waitUntilStationary();
        }
        if(wait_until_done && fuse > 0){
            Looker.waitUntilStationaryFuse(fuse);
        }

    }

    private static void doCraft(String item, int number, boolean open_inventory, boolean close_inventory) {
        Crafter crafter = new Crafter();
        if(open_inventory){
            crafter.openInventory();
        }

        crafter.craft(item, number);

        if(close_inventory){
            crafter.closeInventory();
        }
    }

    private static void doSmelt(String item, int number, boolean place_in, boolean wait_until_done, boolean open_inventory, boolean close_inventory) {
        Crafter crafter = new Crafter();
        Looker looker = new Looker();
        if(open_inventory){
            crafter.openInventory();
        }

        if(place_in) {
            crafter.smelt(item, number);
        }

        if(wait_until_done){
            looker.waitUntilSmeltingDone();
            crafter.getSmelt();
        }

        if(close_inventory){
            crafter.closeInventory();
        }
    }

    private static void doPlace(String item, boolean enter) {
        Looker looker = new Looker();
        MouseMover mm = new MouseMover();

        looker.waitUntilStationary();


        Typer.command(".b path");
        looker.waitUntilStationary();
        Typer.command(".b goal ~ ~-1 ~");
        Typer.command(".b path");
        looker.waitUntilStationary();
        Sorter.openInventory();
        mm.moveMouseAway();
        Waiter.wait(Waiter.getLongSleepTime());
        Sorter.putItemInHotbar(item, 9, false);
        Sorter.closeInventory();
        Typer.type("9",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        looker.lookDown();
        Waiter.wait(Waiter.getLongSleepTime()*2);
        Typer.holdShift(100);
        Typer.holdSpace(100);
        Typer.holdRightClick(2000);
        Typer.releaseRightClick(Waiter.getShortSleepTime());
        Typer.releaseSpace(Waiter.getShortSleepTime());
        Typer.releaseShift(Waiter.getShortSleepTime());

        if(!enter){
            Sorter.closeInventory();
        }
    }

    private static void doSort(JSONArray spec, boolean discard_unspecified, boolean open_inventory, boolean close_inventory) {
        if(open_inventory){
            Sorter.openInventory();
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
            Sorter.closeInventory();
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

    public static void startUp() {
        System.out.println("Hello world!");
        try {
            Filer.incrementRunCounter();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // START
        System.out.println("Starting Run!");
        Typer.command("/clear");
        Typer.command("/time set 0");
        Typer.command("/weather clear 10000");
        //        while(!looker.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
        //            Thread.sleep(Waiter.getShortSleepTime());
        //        }
    }

    public static void setReady(boolean rdy){
        ready = rdy;
    }
    public static boolean getReady(){
        return ready;
    }

//    public static void woodGather(Looker looker, Typer Typer, Crafter crafter, Waiter Waiter) {
//        System.out.println("Mining logs.");
//        Typer.command(".b mine 8 oak_log",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining logs!");
//
//        System.out.println("Crafting wooden items.");
//        crafter.craft("wooden_plank", 8);
//        Waiter.wait(Waiter.getLongSleepTime());
//        crafter.craft("crafting_table", 1);
//        Waiter.wait(Waiter.getLongSleepTime());
//        crafter.craft("stick", 5);
//        System.out.println("Done crafting wooden items!");
//
//        System.out.println("Placing crafting table.");
//        Typer.command(".b goto grass",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.lookDown();
//        looker.waitUntilStationary();
//        Typer.command(".b goal ~ ~-1 ~",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command(".b path",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        Typer.type("8",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.lookDown();
//        Waiter.wait(Waiter.getLongSleepTime()*2);
//        Typer.holdSpace(100);
//        Typer.holdRightClick(2000);
//        Typer.releaseSpace(Waiter.getShortSleepTime());
//        Typer.releaseRightClick(Waiter.getShortSleepTime());
//        System.out.println("Done placing crafting table!");
//
//        System.out.println("Crafting wooden pickaxe.");
//        crafter.craft("wooden_pickaxe",1);
//        Waiter.wait(Waiter.getLongSleepTime());
//        System.out.println("Done crafting wooden pickaxe!");
//    }
//
//    public static void stoneGather(Looker looker, Typer Typer, Crafter crafter, MouseMover mm, Waiter Waiter) throws IOException, InterruptedException, AWTException {
//        System.out.println("Mining stone.");
//        Typer.command(".b mine 12 stone",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining stone!");
//
//        System.out.println("Going to crafting table.");
//        Typer.command(".b goto crafting_table",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("In crafting table!");
//
//        System.out.println("Crafting stone tools.");
//        crafter.craft("stone_tools",1);
//        System.out.println("Done crafting stone tools!");
//
//        System.out.println("Mining a little grass...");
//        Typer.command(".b mine grass",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(6000);
//        Typer.command(".b cancel",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        System.out.println("Done mining a little grass!");
//
//        System.out.println("Placing furnace.");
//        Typer.command(".b goto grass",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        Typer.command(".b goal ~ ~-1 ~",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command(".b path",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        Typer.command("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Furnace.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        Typer.type("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        looker.lookDown();
//        Waiter.wait(Waiter.getLongSleepTime()*2);
//        Typer.holdSpace(100);
//        Typer.holdRightClick(2000);
//        Typer.releaseSpace(Waiter.getShortSleepTime());
//        Typer.releaseRightClick(Waiter.getShortSleepTime());
//        Typer.type("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        System.out.println("Done placing furnace!");
//
//        System.out.println("Mining a little grass...");
//        Typer.command(".b mine grass",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(3000);
//        Typer.command(".b cancel",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        System.out.println("Done mining a little grass!");
//
//    }
//
//
//    public static void ironGather(Looker looker, Typer Typer, Crafter crafter, MouseMover mm, Waiter Waiter)  {
//        System.out.println("Mining iron ore.");
//        Typer.command(".b mine 12 iron_ore",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining iron ore!");
//
//        System.out.println("Mining coal.");
//        Typer.command(".b mine 3 coal_ore",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining coal!");
//
//        System.out.println("Going to furnace.");
//        Typer.command(".b goto furnace",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("In furnace!");
//
//        System.out.println("Putting iron in furnace.");
//        crafter.smelt("iron",12);
//        System.out.println("Done putting iron in furnace!");
//
//        System.out.println("Mining gravel.");
//        Typer.command(".b mine 35 gravel",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining gravel!");
//
//        System.out.println("Going to furnace.");
//        Typer.command(".b goto furnace",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("In furnace!");
//
//        System.out.println("Waiting for smelting to be done.");
//        looker.waitUntilSmeltingDone();
//        crafter.getSmelt();
//        System.out.println("Smelting is done!");
//
//        System.out.println("Going to crafting table.");
//        Typer.command(".b goto crafting_table",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("In crafting table!");
//
//        System.out.println("Crafting iron tools.");
//        crafter.craft("iron_tools",1);
//        System.out.println("Done crafting iron tools!");
//
//        System.out.println("Sorting inventory");
//        Typer.command("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Iron_Pickaxe.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Iron_Pickaxe.jpg",looker.getBackpackScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("2",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Iron_Shovel.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("3",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Flint_and_Steel.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("4",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Dirt.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("5",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        Typer.type("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        System.out.println("Done sorting inventory");
//
//    }
//
//    public static void diamondGather(Looker looker, Typer Typer, Crafter crafter, MouseMover mm, Waiter Waiter) throws InterruptedException, AWTException, IOException {
//        System.out.println("Mining diamonds!");
//        Typer.command(".b mine 30 diamond_ore",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining diamonds!");
//
//        System.out.println("Making crafting table.");
//        crafter.craft("crafting_table", 1);
//        Waiter.wait(Waiter.getLongSleepTime());
//        System.out.println("Done making crafting table!");
//
//        System.out.println("Placing crafting table.");
//        looker.waitUntilStationary();
//        Typer.command(".b goal ~ ~1 ~",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command(".b path",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        Typer.command(".b goal ~ ~-1 ~",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command(".b path",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        Typer.command("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Crafting_Table.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        Typer.type("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        looker.lookDown();
//        Waiter.wait(Waiter.getLongSleepTime()*2);
//        Typer.holdSpace(100);
//        Typer.holdRightClick(2000);
//        Typer.releaseSpace(Waiter.getShortSleepTime());
//        Typer.releaseRightClick(Waiter.getShortSleepTime());
//        System.out.println("Done placing crafting table!");
//
//        System.out.println("Crafting diamond items.");
//        crafter.craft("diamond_items",1);
//        System.out.println("Done crafting diamond items!");
//
//        System.out.println("Putting on armor and sorting inventory.");
//        Typer.command("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Sword.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("1",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Pickaxe.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("2",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Shovel.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.type("3",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Helmet.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.holdShift(Waiter.getShortSleepTime());
//        Typer.leftClick(Waiter.getShortSleepTime());
//        Typer.releaseShift(Waiter.getShortSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Chestplate.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.holdShift(Waiter.getShortSleepTime());
//        Typer.leftClick(Waiter.getShortSleepTime());
//        Typer.releaseShift(Waiter.getShortSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Leggings.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.holdShift(Waiter.getShortSleepTime());
//        Typer.leftClick(Waiter.getShortSleepTime());
//        Typer.releaseShift(Waiter.getShortSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(200,200, Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Boots.jpg",looker.getInventoryScreenRect()),Waiter.getLongSleepTime());
//        Typer.holdShift(Waiter.getShortSleepTime());
//        Typer.leftClick(Waiter.getShortSleepTime());
//        Typer.releaseShift(Waiter.getShortSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        Typer.type("e",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Waiter.wait(Waiter.getLongSleepTime());
//        System.out.println("Done putting on armor and sorting inventory!");
//
//    }
//
//    public static void bedGather(Looker looker, Typer Typer, Crafter crafter, Waiter Waiter) throws InterruptedException, AWTException, IOException {
//    }
//
//    public static void giveDiamondStuff(Typer Typer, Waiter Waiter) throws InterruptedException, AWTException {
//        Typer.command("/give pbbp0904 diamond_pickaxe",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command("/give pbbp0904 diamond_shovel",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command("/give pbbp0904 diamond_helmet",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command("/give pbbp0904 diamond_chestplate",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command("/give pbbp0904 diamond_leggings",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command("/give pbbp0904 diamond_boots",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        Typer.command("/give pbbp0904 dirt 128",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//    }
//
//    public static void obsidianGather(Looker looker, Typer Typer, Crafter crafter, MouseMover mm, Waiter Waiter) throws InterruptedException, AWTException {
//        Typer.command(".b goto obsidian",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        while(true){
//            Typer.command(".b mine 10 obsidian",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//            Waiter.wait(10000);
//            Typer.command(".b cancel",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//            Typer.holdRightClick(10);
//            Typer.type("3", Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
//            looker.lookDown();
//            Waiter.wait(10000);
//            Typer.releaseRightClick(10);
//        }
//    }

    public static void makeObsidianTest(Typer Typer, Waiter Waiter) throws InterruptedException, AWTException {
        Typer.command("/fill ~-1 ~-1 ~-1 ~-5 ~-2 ~-5 minecraft:lava",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Typer.command("/fill ~-3 ~3 ~-3 ~-3 ~3 ~-3 minecraft:water",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
    }

    public static void doHunt(Typer Typer, Waiter Waiter) throws InterruptedException, AWTException {
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
