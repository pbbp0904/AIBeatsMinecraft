import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;

public class Main {

    public static boolean ready;
    public static volatile Starter s;

    public static void main(String[] args){

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
//        doPhase(2);



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
        for (Object instruction : instructionSet){
            doInstruction((JSONObject) instruction);
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
            case "light":
                doLight();
                break;
            case "move":
                doMove((String) instruction.get("move_type"));
                break;
        }
        // Type NUMPAD_1 for splits
        Typer.pressKey("NP1");
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
        Typer.holdKey("shift", 100);
        Typer.holdKey("space", 100);
        Typer.holdRightClick(2000);
        Typer.releaseRightClick(Waiter.getShortSleepTime());
        Typer.releaseKey("space");
        Typer.releaseKey("shift");

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

    private static void doLight() {
        Typer.type("2");
        Looker.lookUp();
        Typer.holdLeftClick(1000);
        Typer.releaseLeftClick(10);
        Sorter.putItemInHotbar("flint_and_steel", 7, false);
        Typer.type("7");
        Typer.holdRightClick(Waiter.getLongSleepTime());
        Typer.releaseRightClick(Waiter.getLongSleepTime());
        Waiter.wait(15000);
    }



    public static void doMove(String move_type) {
        switch (move_type){
            case "portal":
                Typer.holdKey("s",400);
                Typer.holdKey("d",250);
                Typer.releaseKey("s");
                Typer.releaseKey("d");
                Waiter.wait(5000);
                break;
        }
    }



    private static void gotoEndPortal(){
        Typer.command("/give @p ender_eye 20");
        Typer.command("/give @p diamond_pickaxe");
        Typer.command("/give @p diamond_shovel");
        Typer.command("/give @p dirt 256");
        Typer.command("/give @p cooked_beef 20");
        Typer.command("/gamerule doDaylightCycle false");
        Typer.command(".b set exploreForBlocks true");

        Typer.command("1");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 1600");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("1");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 800");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("1");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 400");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("1");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 200");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("1");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 200");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("1");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 200");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("1");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 200");
        Typer.command(".b path");
        Looker.waitUntilStationary();

        Typer.command("1");
        Typer.command(".b follow entity eye_of_ender");
        Waiter.wait(200);
        Typer.rightClick(150);
        Typer.command(".b thisway 100");
        Typer.command(".b path");
        Looker.waitUntilStationary();


        Typer.command(".b set exploreForBlocks false");
        Typer.command(".b goto stone_brick_stairs");
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
//        Typer.command("/clear");
//        Typer.command("/time set 0");
//        Typer.command("/weather clear 10000");

        // Type $ for to start splits
        Typer.pressKey("NP1");
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
