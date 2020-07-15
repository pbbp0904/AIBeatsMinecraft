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

        Looker.waitUntilStationary();
        Typer.command(".b goal ~ ~1 ~");
        Typer.command(".b path");
        Looker.waitUntilStationary();
        Typer.command(".b goal ~ ~-1 ~");
        Typer.command(".b path");
        Looker.waitUntilStationary();
        Typer.openInventory();
        MouseMover.moveMouseAway();
        Waiter.waitLong();
        Sorter.putItemInHotbar(item, 9, false);
        Typer.closeInventory();
        Typer.type("9",Waiter.getShortSleepTime(),Waiter.getLongSleepTime());
        Looker.lookDown();
        Waiter.wait(Waiter.getLongSleepTime()*2);
        Typer.holdShift(100);
        Typer.holdSpace(100);
        Typer.holdRightClick(2000);
        Typer.releaseRightClick(Waiter.getShortSleepTime());
        Typer.releaseSpace(Waiter.getShortSleepTime());
        Typer.releaseShift(Waiter.getShortSleepTime());

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
