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
    
    private final Typer typer;
    private final Looker looker;
    private final Crafter crafter;
    private final MouseMover mm;
    private final Waiter waiter;
    private final Filer filer;
    //private final Exiter exiter;
    //private static Inventory inventory;
    
    public Main() {
        typer = new Typer();
        looker = new Looker();
        crafter = new Crafter();
        mm = new MouseMover();
        waiter = new Waiter();
        filer = new Filer();
        //exiter = new Exiter();
    }
    public static void main(String[] args){
        Main main = new Main();
        main.waiter.wait(5000);

        main.startUp();
        main.jumpToPhase(4);
        main.waiter.wait(2000);
        main.doPhase(4);




//        while (true) {
//
//            main.startUp();
//            main.jumpToPhase(2);
//        main.waiter.wait(500);
//        main.looker.lookDown();
//        main.typer.type("4");
//        main.typer.holdRightClick(20);
//        main.typer.releaseRightClick(20);
//        main.waiter.wait(2000);
//            main.waiter.wait(10000);
//            main.typer.holdS(400);
//            main.typer.holdD(400);
//            main.typer.releaseS(200);
//            main.typer.releaseD(200);
//            long start = System.currentTimeMillis();
//            long end = start + 600*1000;
//            main.doPhaseTime(2,end);
//            main.reset();
//        }



//        main.startUp();
//        main.jumpToPhase(2);
//        main.waiter.wait(500);
//        main.looker.lookDown();
//        main.typer.type("4");
//        main.typer.holdRightClick(20);
//        main.typer.releaseRightClick(20);
//        main.waiter.wait(2000);
//        main.waiter.wait(10000);
//        main.typer.holdS(400);
//        main.typer.holdD(250);
//        main.typer.releaseS(200);
//        main.typer.releaseD(200);
//        main.waiter.wait(1000);
//        main.doPhase(2);

        //main.doPhase(1);


        //giveDiamondStuff(main.typer,main.waiter);
        //main.waiter.iwait(30000);

        //doHunt(main.typer, main.waiter);


        //obsidianGather(main.looker, main.typer, main.crafter, main.mm, main.waiter);
        //makeObsidianTest(main.typer,main.waiter);
        //main.startUp();

        // Write a block off water fall routine for the obsidian problem?

        //woodGather(main.looker, main.typer, main.crafter, main.waiter);
        //stoneGather(main.looker, main.typer, main.crafter, main.mm, main.waiter);
        //ironGather(main.looker, main.typer, main.crafter, main.mm, main.waiter);
        //diamondGather(main.looker, main.typer, main.crafter, main.mm, main.waiter);
        //bedGather(main.looker, main.typer, main.crafter, main.waiter);
    }

    private void reset() {
        typer.type("e");
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


        typer.holdEscape(3000);
        typer.releaseEscape(100);
        for(int i = 0; i<8; i++){
            typer.pressTab(600);
        }
        typer.pressEnter(1500);
        for(int i = 0; i<1; i++){
            typer.pressTab(100);
        }
        typer.pressEnter(100);

        for(int i = 0; i<1; i++){
            typer.pressTab(100);
        }
        typer.pressEnter(15000);

        for(int i = 0; i<2; i++){
            typer.pressTab(100);
        }
        typer.pressEnter(100);

        for(int i = 0; i<4; i++){
            typer.pressTab(100);
        }
        typer.pressEnter(100);

        for(int i = 0; i<3; i++){
            typer.pressTab(100);
        }
        typer.pressEnter(100);

        for(int i = 0; i<6; i++){
            typer.pressTab(100);
        }
        typer.pressEnter(100);

        for(int i = 0; i<3; i++){
            typer.pressTab(100);
        }
        typer.pressEnter(15000);
    }

    public void jumpToPhase(int phase){
        String instructionSetString = "src\\Instruction_Sets\\JumpToPhase_" + Integer.toString(phase) + ".json";
        doInstructionSet(instructionSetString);
    }


    public void doPhase(int phase){
        String instructionSetString = "src\\Instruction_Sets\\Phase_" + Integer.toString(phase) + ".json";
        doInstructionSet(instructionSetString);
    }

    public void doPhase(int phase, int startingInstruction){
        String instructionSetString = "src\\Instruction_Sets\\Phase_" + Integer.toString(phase) + ".json";
        doInstructionSet(instructionSetString, startingInstruction);
    }

    public void doInstructionSet(String instructionSetString){
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

    private void doInstruction(JSONObject instruction){
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

    private void doCommand(String command_string, boolean wait_until_done, long fuse) {
        Typer typer = new Typer();
        Looker looker = new Looker();
        typer.command(command_string);
        if(wait_until_done && fuse == -1){
            looker.waitUntilStationary();
        }
        if(wait_until_done && fuse > 0){
            looker.waitUntilStationaryFuse(fuse);
        }

    }

    private void doCraft(String item, int number, boolean open_inventory, boolean close_inventory) {
        Crafter crafter = new Crafter();
        if(open_inventory){
            crafter.openInventory();
        }

        crafter.craft(item, number);

        if(close_inventory){
            crafter.closeInventory();
        }
    }

    private void doSmelt(String item, int number, boolean place_in, boolean wait_until_done, boolean open_inventory, boolean close_inventory) {
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

    private void doPlace(String item, boolean enter) {
        Typer typer = new Typer();
        Looker looker = new Looker();
        MouseMover mm = new MouseMover();
        Waiter waiter = new Waiter();
        Sorter sorter = new Sorter();

        looker.waitUntilStationary();
        typer.command(".b goal ~ ~1 ~");
        typer.command(".b path");
        looker.waitUntilStationary();
        typer.command(".b goal ~ ~-1 ~");
        typer.command(".b path");
        looker.waitUntilStationary();
        sorter.openInventory();
        mm.moveMouseAway();
        waiter.wait(waiter.getLongSleepTime());
        sorter.putItemInHotbar(item, 9, false);
        sorter.closeInventory();
        typer.type("9",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        looker.lookDown();
        waiter.wait(waiter.getLongSleepTime()*2);
        typer.holdShift(100);
        typer.holdSpace(100);
        typer.holdRightClick(2000);
        typer.releaseRightClick(waiter.getShortSleepTime());
        typer.releaseSpace(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getShortSleepTime());

        if(!enter){
            sorter.closeInventory();
        }
    }

    private void doSort(JSONArray spec, boolean discard_unspecified, boolean open_inventory, boolean close_inventory) {
        Sorter sorter = new Sorter();

        if(open_inventory){
            sorter.openInventory();
        }

        for (Object action : spec){
            int slot = ((Number) (((JSONObject) action).get("slot"))).intValue();
            if(slot>0) {
                sorter.putItemInHotbar((String) ((JSONObject) action).get("item"), slot, (Boolean) ((JSONObject) action).get("backOnly"));
            }else{
                sorter.putOnArmor((String) ((JSONObject) action).get("item"),(Boolean) ((JSONObject) action).get("backOnly"));
            }
        }

        if(close_inventory){
            sorter.closeInventory();
        }
    }


    public JSONArray loadInstructionSet(String instructionSetString){
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

    public void startUp() {
        System.out.println("Hello world!");
        try {
            this.filer.incrementRunCounter();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // START
        System.out.println("Starting Run!");
        typer.command("/clear");
        typer.command("/time set 0");
        typer.command("/weather clear 10000");
        //        while(!looker.foundImageOnScreen("src\\Checkpoint_Images\\Crafting_Table.jpg",craftingScreenRect,0.15,1)){
        //            Thread.sleep(waiter.getShortSleepTime());
        //        }
    }

//    public static void woodGather(Looker looker, Typer typer, Crafter crafter, Waiter waiter) {
//        System.out.println("Mining logs.");
//        typer.command(".b mine 8 oak_log",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining logs!");
//
//        System.out.println("Crafting wooden items.");
//        crafter.craft("wooden_plank", 8);
//        waiter.wait(waiter.getLongSleepTime());
//        crafter.craft("crafting_table", 1);
//        waiter.wait(waiter.getLongSleepTime());
//        crafter.craft("stick", 5);
//        System.out.println("Done crafting wooden items!");
//
//        System.out.println("Placing crafting table.");
//        typer.command(".b goto grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.lookDown();
//        looker.waitUntilStationary();
//        typer.command(".b goal ~ ~-1 ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command(".b path",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        typer.type("8",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.lookDown();
//        waiter.wait(waiter.getLongSleepTime()*2);
//        typer.holdSpace(100);
//        typer.holdRightClick(2000);
//        typer.releaseSpace(waiter.getShortSleepTime());
//        typer.releaseRightClick(waiter.getShortSleepTime());
//        System.out.println("Done placing crafting table!");
//
//        System.out.println("Crafting wooden pickaxe.");
//        crafter.craft("wooden_pickaxe",1);
//        waiter.wait(waiter.getLongSleepTime());
//        System.out.println("Done crafting wooden pickaxe!");
//    }
//
//    public static void stoneGather(Looker looker, Typer typer, Crafter crafter, MouseMover mm, Waiter waiter) throws IOException, InterruptedException, AWTException {
//        System.out.println("Mining stone.");
//        typer.command(".b mine 12 stone",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining stone!");
//
//        System.out.println("Going to crafting table.");
//        typer.command(".b goto crafting_table",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("In crafting table!");
//
//        System.out.println("Crafting stone tools.");
//        crafter.craft("stone_tools",1);
//        System.out.println("Done crafting stone tools!");
//
//        System.out.println("Mining a little grass...");
//        typer.command(".b mine grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(6000);
//        typer.command(".b cancel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        System.out.println("Done mining a little grass!");
//
//        System.out.println("Placing furnace.");
//        typer.command(".b goto grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        typer.command(".b goal ~ ~-1 ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command(".b path",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        typer.command("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Furnace.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        looker.lookDown();
//        waiter.wait(waiter.getLongSleepTime()*2);
//        typer.holdSpace(100);
//        typer.holdRightClick(2000);
//        typer.releaseSpace(waiter.getShortSleepTime());
//        typer.releaseRightClick(waiter.getShortSleepTime());
//        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        System.out.println("Done placing furnace!");
//
//        System.out.println("Mining a little grass...");
//        typer.command(".b mine grass",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(3000);
//        typer.command(".b cancel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        System.out.println("Done mining a little grass!");
//
//    }
//
//
//    public static void ironGather(Looker looker, Typer typer, Crafter crafter, MouseMover mm, Waiter waiter)  {
//        System.out.println("Mining iron ore.");
//        typer.command(".b mine 12 iron_ore",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining iron ore!");
//
//        System.out.println("Mining coal.");
//        typer.command(".b mine 3 coal_ore",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining coal!");
//
//        System.out.println("Going to furnace.");
//        typer.command(".b goto furnace",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("In furnace!");
//
//        System.out.println("Putting iron in furnace.");
//        crafter.smelt("iron",12);
//        System.out.println("Done putting iron in furnace!");
//
//        System.out.println("Mining gravel.");
//        typer.command(".b mine 35 gravel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining gravel!");
//
//        System.out.println("Going to furnace.");
//        typer.command(".b goto furnace",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("In furnace!");
//
//        System.out.println("Waiting for smelting to be done.");
//        looker.waitUntilSmeltingDone();
//        crafter.getSmelt();
//        System.out.println("Smelting is done!");
//
//        System.out.println("Going to crafting table.");
//        typer.command(".b goto crafting_table",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("In crafting table!");
//
//        System.out.println("Crafting iron tools.");
//        crafter.craft("iron_tools",1);
//        System.out.println("Done crafting iron tools!");
//
//        System.out.println("Sorting inventory");
//        typer.command("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Iron_Pickaxe.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Iron_Pickaxe.jpg",looker.getBackpackScreenRect()),waiter.getLongSleepTime());
//        typer.type("2",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Iron_Shovel.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("3",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Flint_and_Steel.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("4",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Dirt.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("5",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        System.out.println("Done sorting inventory");
//
//    }
//
//    public static void diamondGather(Looker looker, Typer typer, Crafter crafter, MouseMover mm, Waiter waiter) throws InterruptedException, AWTException, IOException {
//        System.out.println("Mining diamonds!");
//        typer.command(".b mine 30 diamond_ore",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        System.out.println("Done mining diamonds!");
//
//        System.out.println("Making crafting table.");
//        crafter.craft("crafting_table", 1);
//        waiter.wait(waiter.getLongSleepTime());
//        System.out.println("Done making crafting table!");
//
//        System.out.println("Placing crafting table.");
//        looker.waitUntilStationary();
//        typer.command(".b goal ~ ~1 ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command(".b path",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        typer.command(".b goal ~ ~-1 ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command(".b path",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        typer.command("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Crafting_Table.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        looker.lookDown();
//        waiter.wait(waiter.getLongSleepTime()*2);
//        typer.holdSpace(100);
//        typer.holdRightClick(2000);
//        typer.releaseSpace(waiter.getShortSleepTime());
//        typer.releaseRightClick(waiter.getShortSleepTime());
//        System.out.println("Done placing crafting table!");
//
//        System.out.println("Crafting diamond items.");
//        crafter.craft("diamond_items",1);
//        System.out.println("Done crafting diamond items!");
//
//        System.out.println("Putting on armor and sorting inventory.");
//        typer.command("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Sword.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Pickaxe.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("2",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Shovel.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.type("3",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Helmet.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.holdShift(waiter.getShortSleepTime());
//        typer.leftClick(waiter.getShortSleepTime());
//        typer.releaseShift(waiter.getShortSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Chestplate.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.holdShift(waiter.getShortSleepTime());
//        typer.leftClick(waiter.getShortSleepTime());
//        typer.releaseShift(waiter.getShortSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Leggings.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.holdShift(waiter.getShortSleepTime());
//        typer.leftClick(waiter.getShortSleepTime());
//        typer.releaseShift(waiter.getShortSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(200,200, waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        mm.moveMouse(looker.findLocationOnScreen("src\\Item_Images\\Diamond_Boots.jpg",looker.getInventoryScreenRect()),waiter.getLongSleepTime());
//        typer.holdShift(waiter.getShortSleepTime());
//        typer.leftClick(waiter.getShortSleepTime());
//        typer.releaseShift(waiter.getShortSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        typer.type("e",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        waiter.wait(waiter.getLongSleepTime());
//        System.out.println("Done putting on armor and sorting inventory!");
//
//    }
//
//    public static void bedGather(Looker looker, Typer typer, Crafter crafter, Waiter waiter) throws InterruptedException, AWTException, IOException {
//    }
//
//    public static void giveDiamondStuff(Typer typer, Waiter waiter) throws InterruptedException, AWTException {
//        typer.command("/give pbbp0904 diamond_pickaxe",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command("/give pbbp0904 diamond_shovel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command("/give pbbp0904 diamond_helmet",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command("/give pbbp0904 diamond_chestplate",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command("/give pbbp0904 diamond_leggings",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command("/give pbbp0904 diamond_boots",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        typer.command("/give pbbp0904 dirt 128",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//    }
//
//    public static void obsidianGather(Looker looker, Typer typer, Crafter crafter, MouseMover mm, Waiter waiter) throws InterruptedException, AWTException {
//        typer.command(".b goto obsidian",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//        looker.waitUntilStationary();
//        while(true){
//            typer.command(".b mine 10 obsidian",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//            waiter.wait(10000);
//            typer.command(".b cancel",waiter.getShortSleepTime(),waiter.getLongSleepTime());
//            typer.holdRightClick(10);
//            typer.type("3", waiter.getShortSleepTime(),waiter.getLongSleepTime());
//            looker.lookDown();
//            waiter.wait(10000);
//            typer.releaseRightClick(10);
//        }
//    }

    public static void makeObsidianTest(Typer typer, Waiter waiter) throws InterruptedException, AWTException {
        typer.command("/fill ~-1 ~-1 ~-1 ~-5 ~-2 ~-5 minecraft:lava",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/fill ~-3 ~3 ~-3 ~-3 ~3 ~-3 minecraft:water",waiter.getShortSleepTime(),waiter.getLongSleepTime());
    }

    public static void doHunt(Typer typer, Waiter waiter) throws InterruptedException, AWTException {
        typer.command("/clear @p",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/give Cosmologicomical diamond_helmet{Enchantments:[{id:unbreaking,lvl:100}]}",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/give Cosmologicomical diamond_chestplate{Enchantments:[{id:unbreaking,lvl:100}]}",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/give Cosmologicomical diamond_leggings{Enchantments:[{id:unbreaking,lvl:100}]}",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/give Cosmologicomical diamond_boots{Enchantments:[{id:unbreaking,lvl:100}]}",waiter.getShortSleepTime(),waiter.getLongSleepTime());

        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime()*5);
        typer.holdRightClick(waiter.getShortSleepTime());
        typer.type("2",waiter.getShortSleepTime(),waiter.getLongSleepTime()*5);
        typer.type("3",waiter.getShortSleepTime(),waiter.getLongSleepTime()*5);
        typer.type("4",waiter.getShortSleepTime(),waiter.getLongSleepTime()*5);
        typer.releaseRightClick(waiter.getShortSleepTime());

        typer.command("/give Cosmologicomical stone_sword{Enchantments:[{id:unbreaking,lvl:100}]}",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/give Cosmologicomical diamond_pickaxe{Enchantments:[{id:unbreaking,lvl:100}]}",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/give Cosmologicomical diamond_shovel{Enchantments:[{id:unbreaking,lvl:100}]}",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/give Cosmologicomical cooked_beef 64",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/give Cosmologicomical dirt 1024",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.type("1",waiter.getShortSleepTime(),waiter.getLongSleepTime());

        typer.command("/worldborder center ~ ~",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/worldborder set 640",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/weather clear 1000000",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/time set 0",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/effect give @p minecraft:instant_health 100",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/effect give @p minecraft:saturation 10",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("/clear @p[name=!Cosmologicomical]",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("tI'll be coming for you in 20 minutes!!!!",waiter.getShortSleepTime(),waiter.getLongSleepTime());

        waiter.wait(1200000);
        typer.type("t",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("I'll be coming for you very soon!!!!",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        waiter.wait(210000);
        typer.type("t",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command("Best ye run...",waiter.getShortSleepTime(),waiter.getLongSleepTime());
        typer.command(".b follow entity player",waiter.getShortSleepTime(),waiter.getLongSleepTime());
    }
}
