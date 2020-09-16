
public class Crafter {
    
    private static final int longSleep;
    
    
    static {
        longSleep = 200;
    }

    public static void craft(String item, int number) throws InterruptedException {
        checkInterrupted();
        int[] coords;
        switch (item) {
            case "oak_planks":
                checkInterrupted();
                Waiter.waitShort();
                // Move Mouse Away
                MouseMover.moveMouseAway();

                // Find location of logs
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_log.jpg", Looker.getInventoryScreenRect());

                checkInterrupted();
                // Pick up items
                MouseMover.moveMouse(coords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
                checkInterrupted();
                // Place item back in original slot
                MouseMover.moveMouse(coords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), Waiter.getShortSleepTime());
                Typer.holdKey("shift", Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                Typer.releaseKey("shift", Waiter.getShortSleepTime());

                break;


            case "crafting_table":
                checkInterrupted();
                Waiter.waitLong();
                // Move mouse away
                MouseMover.moveMouseAway();
                Waiter.waitLong();
                checkInterrupted();

                // Find location of wood
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());

                checkInterrupted();
                // Pick up items
                MouseMover.moveMouse(coords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), Waiter.getShortSleepTime());
                checkInterrupted();
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
                checkInterrupted();
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot3(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot4(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
                checkInterrupted();

                // Place item back in original slot
                MouseMover.moveMouse(coords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), Waiter.getShortSleepTime());
                Typer.holdKey("shift", Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                Typer.releaseKey("shift", Waiter.getShortSleepTime());

                break;


            case "stick":
                checkInterrupted();
                Waiter.waitShort();
                // Move Mouse Away
                MouseMover.moveMouseAway();

                // Find location of wood
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());
                checkInterrupted();

                // Pick up items
                MouseMover.moveMouse(coords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), Waiter.getShortSleepTime());
                checkInterrupted();
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot4(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
                checkInterrupted();

                // Place item back in original slot
                MouseMover.moveMouse(coords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), Waiter.getShortSleepTime());
                Typer.holdKey("shift", Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                Typer.releaseKey("shift", Waiter.getShortSleepTime());
                checkInterrupted();
                break;




            case "mushroom_stew":
                checkInterrupted();
                Waiter.waitLong();
                // Move Mouse Away
                MouseMover.moveMouseAway();
                Waiter.waitLong();
                checkInterrupted();

                // Find location of bowls
                int[] bowlCoords = Looker.findLocationOnScreen("src\\Item_Images\\bowl.jpg", Looker.getInventoryScreenRect());
                // Find location of brown mushrooms
                int[] brownCoords = Looker.findLocationOnScreen("src\\Item_Images\\brown_mushroom.jpg", Looker.getInventoryScreenRect());
                // Find location of red mushrooms
                int[] redCoords = Looker.findLocationOnScreen("src\\Item_Images\\red_mushroom.jpg", Looker.getInventoryScreenRect());

                checkInterrupted();
                // Find if dandelions are on the screen
                boolean dandelionsFound = Looker.foundImageOnScreen("src\\Item_Images\\dandelion.jpg", Looker.getInventoryScreenRect(),0.05);
                checkInterrupted();

                if(dandelionsFound) {
                    int[] dandelionCoords = Looker.findLocationOnScreen("src\\Item_Images\\dandelion.jpg", Looker.getInventoryScreenRect());
                    // Pick up items
                    MouseMover.moveMouse(dandelionCoords, Waiter.getShortSleepTime());
                    Typer.leftClick(Waiter.getShortSleepTime());
                    Waiter.waitShort();
                    Typer.leftClick(Waiter.getShortSleepTime());
                    // Move mouse to craft
                    MouseMover.moveMouse(Looker.getHandCraftSlot3(), Waiter.getShortSleepTime());
                    // Place all the items
                    Typer.leftClick(Waiter.getShortSleepTime());

                    // Place item back in original slot
                    MouseMover.moveMouse(dandelionCoords, Waiter.getShortSleepTime());
                    Typer.leftClick(Waiter.getShortSleepTime());
                    checkInterrupted();
                }

                // Pick up items
                MouseMover.moveMouse(bowlCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                Waiter.waitShort();
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot4(), Waiter.getShortSleepTime());
                // Place all the items
                Typer.leftClick(Waiter.getShortSleepTime());

                checkInterrupted();
                // Place item back in original slot
                MouseMover.moveMouse(bowlCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());


                checkInterrupted();
                // Pick up items
                MouseMover.moveMouse(brownCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }

                // Place item back in original slot
                MouseMover.moveMouse(brownCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());

                checkInterrupted();
                // Pick up items
                MouseMover.moveMouse(redCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }
                checkInterrupted();
                // Place item back in original slot
                MouseMover.moveMouse(redCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());

                Waiter.waitShort();



                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), Waiter.getShortSleepTime());
                Typer.holdKey("shift", Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                Typer.releaseKey("shift", Waiter.getShortSleepTime());
                checkInterrupted();
                break;


            case "ender_eye":
                checkInterrupted();
                Waiter.waitLong();

                // Move Mouse Away
                MouseMover.moveMouseAway();

                Waiter.waitLong();

                // Find location of blaze rods
                int[] rodCoords = Looker.findLocationOnScreen("src\\Item_Images\\blaze_rod.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                MouseMover.moveMouse(rodCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < Math.ceil(number/2.0); i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }

                // Place item back in original slot
                MouseMover.moveMouse(rodCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());


                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), Waiter.getShortSleepTime());
                Typer.holdKey("shift", Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                Typer.releaseKey("shift", Waiter.getShortSleepTime());



                // Move Mouse Away
                MouseMover.moveMouseAway();

                // Find location of blaze powder
                int[] powderCoords = Looker.findLocationOnScreen("src\\Item_Images\\blaze_powder.jpg", Looker.getInventoryScreenRect());
                // Find location of ender pearls
                int[] pearlCoords = Looker.findLocationOnScreen("src\\Item_Images\\ender_pearl.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                MouseMover.moveMouse(powderCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot1(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }

                // Place item back in original slot
                MouseMover.moveMouse(powderCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());


                // Pick up items
                MouseMover.moveMouse(pearlCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), Waiter.getShortSleepTime());
                // Place the correct number of items
                Typer.leftClick(Waiter.getShortSleepTime());

                // Place item back in original slot
                MouseMover.moveMouse(pearlCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());


                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), Waiter.getShortSleepTime());
                Typer.holdKey("shift", Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                Typer.releaseKey("shift", Waiter.getShortSleepTime());


                // Find location of ender pearls
                int[] pearlCoords_2 = Looker.findLocationOnScreen("src\\Item_Images\\ender_pearl.jpg", Looker.getInventoryScreenRect());

                // Pick up items
                MouseMover.moveMouse(pearlCoords_2, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getHandCraftSlot2(), Waiter.getShortSleepTime());
                // Place the correct number of items
                Typer.leftClick(Waiter.getShortSleepTime());

                // Place item back in original slot
                MouseMover.moveMouse(pearlCoords_2, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());


                // Get resultant item
                MouseMover.moveMouse(Looker.getHandCraftSlotRes(), Waiter.getShortSleepTime());
                Typer.holdKey("shift", Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                Typer.releaseKey("shift", Waiter.getShortSleepTime());

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

    public static void craftItem(int[] materialCoords, int[] craftingPositions, int number) throws InterruptedException {
        checkInterrupted();
        // Put item in crafting table
        putMaterialInTable(materialCoords, craftingPositions, number);

        // Get resultant item
        getResultantItem();
    }




    public static void craftItem(int[] materialCoords1, int[] materialCoords2, int[] craftingPositions1, int[] craftingPositions2, int number) throws InterruptedException {
        checkInterrupted();
        // Put item 1 in crafting table
        putMaterialInTable(materialCoords1, craftingPositions1, number);

        // Put item 2 in crafting table
        putMaterialInTable(materialCoords2, craftingPositions2, number);

        // Get resultant item
        getResultantItem();
    }


    public static void getResultantItem() throws InterruptedException {
        checkInterrupted();
        MouseMover.moveMouse(Looker.getTableCraftSlotRes(), Waiter.getShortSleepTime());
        Typer.holdKey("shift", Waiter.getShortSleepTime());
        Typer.leftClick(Waiter.getShortSleepTime());
        Typer.releaseKey("shift", longSleep);
    }

    public static void putMaterialInTable(int[] materialCoords, int[] craftingPositions, int number) throws InterruptedException {
        checkInterrupted();
         // Pick up material
        MouseMover.moveMouse(materialCoords, Waiter.getShortSleepTime());
        Typer.leftClick(Waiter.getShortSleepTime());

        for (int craftingPosition : craftingPositions) {
            // Move mouse to craft
            moveToCraft(craftingPosition);

            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                Typer.rightClick(Waiter.getShortSleepTime());
            }
        }

        // Place material back in original slot
        MouseMover.moveMouse(materialCoords, Waiter.getShortSleepTime());
        Typer.leftClick(longSleep);
    }



    public static void moveToCraft(int value) throws InterruptedException {
        checkInterrupted();
        switch (value) {
            case 1:
                MouseMover.moveMouse(Looker.getTableCraftSlot1(), Waiter.getShortSleepTime());
                break;
            case 2:
                MouseMover.moveMouse(Looker.getTableCraftSlot2(), Waiter.getShortSleepTime());
                break;
            case 3:
                MouseMover.moveMouse(Looker.getTableCraftSlot3(), Waiter.getShortSleepTime());
                break;
            case 4:
                MouseMover.moveMouse(Looker.getTableCraftSlot4(), Waiter.getShortSleepTime());
                break;
            case 5:
                MouseMover.moveMouse(Looker.getTableCraftSlot5(), Waiter.getShortSleepTime());
                break;
            case 6:
                MouseMover.moveMouse(Looker.getTableCraftSlot6(), Waiter.getShortSleepTime());
                break;
            case 7:
                MouseMover.moveMouse(Looker.getTableCraftSlot7(), Waiter.getShortSleepTime());
                break;
            case 8:
                MouseMover.moveMouse(Looker.getTableCraftSlot8(), Waiter.getShortSleepTime());
                break;
            case 9:
                MouseMover.moveMouse(Looker.getTableCraftSlot9(), Waiter.getShortSleepTime());
                break;
        }
    }

    public static void smelt(String item, int number) throws InterruptedException {
        checkInterrupted();
        switch(item) {
            case "iron_ore":
                // Move mouse away
                MouseMover.moveMouseAway();

                ////IRON
                // Find location of items
                int[] ironOreCoords = Looker.findLocationOnScreen("src\\Item_Images\\iron_ore.jpg", Looker.getInventoryScreenRect());
                int[] coalCoords = Looker.findLocationOnScreen("src\\Item_Images\\coal.jpg", Looker.getInventoryScreenRect());
                // Pick up iron ore
                MouseMover.moveMouse(ironOreCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getFurnaceSmeltSlot(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }

                // Place item back in original slot
                MouseMover.moveMouse(ironOreCoords, Waiter.getShortSleepTime());
                Typer.leftClick(longSleep);

                // Pick up coal
                MouseMover.moveMouse(coalCoords, Waiter.getShortSleepTime());
                Typer.leftClick(Waiter.getShortSleepTime());
                // Move mouse to craft
                MouseMover.moveMouse(Looker.getFurnaceCoalSlot(), Waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < (Math.ceil(number/8.0)); i++) {
                    Typer.rightClick(Waiter.getShortSleepTime());
                }

                // Place item back in original slot
                MouseMover.moveMouse(coalCoords, Waiter.getShortSleepTime());
                Typer.leftClick(longSleep);
                break;

        }

    }


    public static void getSmelt() throws InterruptedException {
        checkInterrupted();
        MouseMover.moveMouse(Looker.getFurnaceResSlot(),Waiter.getShortSleepTime());
        Typer.holdKey("shift", Waiter.getShortSleepTime());
        Typer.leftClick(Waiter.getShortSleepTime());
        Typer.releaseKey("shift", longSleep);
    }

    private static void checkInterrupted() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            Typer.releaseAllKeys();
            throw new InterruptedException();
        }
    }
}
