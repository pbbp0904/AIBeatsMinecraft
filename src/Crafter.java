
public class Crafter {

    private static final int shortSleep;
    private static final int longSleep;
    
    
    static {
        shortSleep = 50;
        longSleep = 200;
    }

    public static void craft(String item, int number) {
        int[] coords;
        switch (item) {
            case "oak_planks":
                // Move Mouse Away
                MouseMover.moveMouseAway();

                // Find location of logs
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_log.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                MouseMover.moveMouse(coords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }
                // Place item back in original slot
                MouseMover.moveMouse(coords, shortSleep);
                Typer.leftClick(shortSleep);
                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), shortSleep);
                Typer.holdKey("shift", shortSleep);
                Typer.leftClick(shortSleep);
                Typer.releaseKey("shift", shortSleep);

                break;


            case "crafting_table":
                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of wood
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                MouseMover.moveMouse(coords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot3(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot4(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(coords, shortSleep);
                Typer.leftClick(shortSleep);
                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), shortSleep);
                Typer.holdKey("shift", shortSleep);
                Typer.leftClick(shortSleep);
                Typer.releaseKey("shift", shortSleep);

                break;


            case "stick":
                // Move Mouse Away
                MouseMover.moveMouseAway();

                // Find location of wood
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                MouseMover.moveMouse(coords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot4(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(coords, shortSleep);
                Typer.leftClick(shortSleep);
                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), shortSleep);
                Typer.holdKey("shift", shortSleep);
                Typer.leftClick(shortSleep);
                Typer.releaseKey("shift", shortSleep);

                break;




            case "mushroom_stew":
                // Move Mouse Away
                MouseMover.moveMouseAway();

                // Find location of bowls
                int[] bowlCoords = Looker.findLocationOnScreen("src\\Item_Images\\bowl.jpg", Looker.getInventoryScreenRect());
                // Find location of brown mushrooms
                int[] brownCoords = Looker.findLocationOnScreen("src\\Item_Images\\brown_mushroom.jpg", Looker.getInventoryScreenRect());
                // Find location of red mushrooms
                int[] redCoords = Looker.findLocationOnScreen("src\\Item_Images\\red_mushroom.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                MouseMover.moveMouse(bowlCoords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot4(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(bowlCoords, shortSleep);
                Typer.leftClick(shortSleep);


                // Pick up items
                MouseMover.moveMouse(brownCoords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(brownCoords, shortSleep);
                Typer.leftClick(shortSleep);


                // Pick up items
                MouseMover.moveMouse(redCoords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(redCoords, shortSleep);
                Typer.leftClick(shortSleep);

                Waiter.wait(Waiter.getShortSleepTime());


                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), shortSleep);
                Typer.holdKey("shift", shortSleep);
                Typer.leftClick(shortSleep);
                Typer.releaseKey("shift", shortSleep);

                break;

            case "ender_eye":
                // Move Mouse Away
                //MouseMover.moveMouseAway();

                // Find location of blaze rods
                int[] rodCoords = Looker.findLocationOnScreen("src\\Item_Images\\blaze_rod.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                MouseMover.moveMouse(rodCoords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(rodCoords, shortSleep);
                Typer.leftClick(shortSleep);


                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), shortSleep);
                Typer.holdKey("shift", shortSleep);
                Typer.leftClick(shortSleep);
                Typer.releaseKey("shift", shortSleep);



                // Move Mouse Away
                MouseMover.moveMouseAway();

                // Find location of blaze powder
                int[] powderCoords = Looker.findLocationOnScreen("src\\Item_Images\\blaze_powder.jpg", Looker.getInventoryScreenRect());
                // Find location of ender pearls
                int[] pearlCoords = Looker.findLocationOnScreen("src\\Item_Images\\ender_pearl.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                MouseMover.moveMouse(powderCoords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < 2*number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(powderCoords, shortSleep);
                Typer.leftClick(shortSleep);


                // Pick up items
                MouseMover.moveMouse(pearlCoords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < 2*number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(pearlCoords, shortSleep);
                Typer.leftClick(shortSleep);


                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), shortSleep);
                Typer.holdKey("shift", shortSleep);
                Typer.leftClick(shortSleep);
                Typer.releaseKey("shift", shortSleep);

                break;


            case "bowl":

                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of items
                int[] woodCoordsBowl = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());

                ////Bowl
                craftItem(woodCoordsBowl,new int[]{4,6,8},number);

                break;




            case "wooden_pickaxe":

                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of items
                int[] woodCoords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());
                int[] stickWoodCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());


                ////WOODEN PICKAXE
                craftItem(woodCoords,stickWoodCoords,new int[]{1,2,3},new int[]{5,8},number);

                break;


            case "stone_tools":
                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of items
                int[] stoneCoords = Looker.findLocationOnScreen("src\\Item_Images\\cobblestone.jpg", Looker.getInventoryScreenRect());
                int[] stickStoneCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());


                ////STONE PICKAXE
                craftItem(stoneCoords,stickStoneCoords,new int[]{1,2,3},new int[]{5,8},number);

                ////STONE SHOVEL
                craftItem(stoneCoords,stickStoneCoords,new int[]{2},new int[]{5,8},number);

                ////FURNACE
                craftItem(stoneCoords, new int[]{1,2,3,4,6,7,8,9},number );

                break;

            case "iron_tools":
                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of materials
                int[] ironCoords = Looker.findLocationOnScreen("src\\Item_Images\\iron.jpg", Looker.getInventoryScreenRect());
                int[] stickIronCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());
                int[] flintCoords = Looker.findLocationOnScreen("src\\Item_Images\\flint.jpg", Looker.getInventoryScreenRect());


                ////IRON PICKAXES
                craftItem(ironCoords,stickIronCoords,new int[]{1,2,3},new int[]{5,8},2*number);

                ////IRON SHOVEL
                craftItem(ironCoords,stickIronCoords,new int[]{2},new int[]{5,8},number);

                ////IRON SWORD
                craftItem(ironCoords,stickIronCoords,new int[]{2,5},new int[]{8},number);

                ////FLINT AND STEEL
                craftItem(ironCoords,flintCoords,new int[]{2},new int[]{6},number);

                break;

            case "diamond_items":
                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of materials
                int[] diamondCoords = Looker.findLocationOnScreen("src\\Item_Images\\diamond.jpg", Looker.getInventoryScreenRect());
                int[] stickDiamondCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());


                ////DIAMOND SWORD
                craftItem(diamondCoords,stickDiamondCoords,new int[]{2,5},new int[]{8},number);

                ////DIAMOND PICKAXE
                craftItem(diamondCoords,stickDiamondCoords,new int[]{1,2,3},new int[]{5,8},number);

                ////DIAMOND SHOVEL
                craftItem(diamondCoords,stickDiamondCoords,new int[]{2},new int[]{5,8},number);

                ////HELMET
                craftItem(diamondCoords, new int[]{1,2,3,4,6},number);

                ////CHESTPLATE
                craftItem(diamondCoords, new int[]{1,3,4,5,6,7,8,9},number);

                ////LEGGINGS
                craftItem(diamondCoords, new int[]{1,2,3,4,6,7,9},number);

                ////BOOTS
                craftItem(diamondCoords, new int[]{4,6,7,9},number);

                break;
        }
    }

    public static void craftItem(int[] materialCoords, int[] craftingPositions, int number) {
        // Put item in crafting table
        putMaterialInTable(materialCoords, craftingPositions, number);

        // Get resultant item
        getResultantItem();
    }




    public static void craftItem(int[] materialCoords1, int[] materialCoords2, int[] craftingPositions1, int[] craftingPositions2, int number) {
        // Put item 1 in crafting table
        putMaterialInTable(materialCoords1, craftingPositions1, number);

        // Put item 2 in crafting table
        putMaterialInTable(materialCoords2, craftingPositions2, number);

        // Get resultant item
        getResultantItem();
    }


    public static void getResultantItem(){
        MouseMover.moveMouse(Looker.getTableCraftSlotRes(), shortSleep);
        Typer.holdKey("shift", shortSleep);
        Typer.leftClick(shortSleep);
        Typer.releaseKey("shift", longSleep);
    }

    public static void putMaterialInTable(int[] materialCoords, int[] craftingPositions, int number){
         // Pick up material
        MouseMover.moveMouse(materialCoords, shortSleep);
        Typer.leftClick(shortSleep);

        for (int craftingPosition : craftingPositions) {
            // Move mouse to craft
            moveToCraft(craftingPosition);

            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                Typer.rightClick(shortSleep);
            }
        }

        // Place material back in original slot
        MouseMover.moveMouse(materialCoords, shortSleep);
        Typer.leftClick(longSleep);
    }



    public static void moveToCraft(int value){
        switch (value) {
            case 1:
                MouseMover.moveMouse(Looker.getTableCraftSlot1(), shortSleep);
                break;
            case 2:
                MouseMover.moveMouse(Looker.getTableCraftSlot2(), shortSleep);
                break;
            case 3:
                MouseMover.moveMouse(Looker.getTableCraftSlot3(), shortSleep);
                break;
            case 4:
                MouseMover.moveMouse(Looker.getTableCraftSlot4(), shortSleep);
                break;
            case 5:
                MouseMover.moveMouse(Looker.getTableCraftSlot5(), shortSleep);
                break;
            case 6:
                MouseMover.moveMouse(Looker.getTableCraftSlot6(), shortSleep);
                break;
            case 7:
                MouseMover.moveMouse(Looker.getTableCraftSlot7(), shortSleep);
                break;
            case 8:
                MouseMover.moveMouse(Looker.getTableCraftSlot8(), shortSleep);
                break;
            case 9:
                MouseMover.moveMouse(Looker.getTableCraftSlot9(), shortSleep);
                break;
        }
    }

    public static void smelt(String item, int number) {
        switch(item) {
            case "iron_ore":
                // Move mouse away
                MouseMover.moveMouseAway();

                ////IRON
                // Find location of items
                int[] ironOreCoords = Looker.findLocationOnScreen("src\\Item_Images\\iron_ore.jpg", Looker.getInventoryScreenRect());
                int[] coalCoords = Looker.findLocationOnScreen("src\\Item_Images\\coal.jpg", Looker.getInventoryScreenRect());
                // Pick up iron ore
                MouseMover.moveMouse(ironOreCoords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getFurnaceSmeltSlot(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(ironOreCoords, shortSleep);
                Typer.leftClick(longSleep);

                // Pick up coal
                MouseMover.moveMouse(coalCoords, shortSleep);
                Typer.leftClick(shortSleep);
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getFurnaceCoalSlot(), shortSleep);
                // Place the correct number of items
                for (int i = 0; i < (Math.ceil(number/8.0)); i++) {
                    Typer.rightClick(shortSleep);
                }

                // Place item back in original slot
                MouseMover.moveMouse(coalCoords, shortSleep);
                Typer.leftClick(longSleep);
                break;

        }

    }


    public static void getSmelt() {
        MouseMover.moveMouse(Looker.getFurnaceResSlot(),shortSleep);
        Typer.holdKey("shift", shortSleep);
        Typer.leftClick(shortSleep);
        Typer.releaseKey("shift", longSleep);
    }


}
