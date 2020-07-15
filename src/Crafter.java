
public class Crafter {
    
    private static int[] coords;



    private static int shortSleep;
    private static int longSleep;
    
    
    static {
        shortSleep = 50;
        longSleep = 200;
    }

    public static void craft(String item, int number) {
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


            case "wooden_pickaxe":

                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of items
                int[] woodCoords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());
                int[] stickWoodCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());


                ////WOODEN PICKAXE
                craftItem(woodCoords,stickWoodCoords,new int[]{1,2,3},new int[]{5,8},1);

                break;


            case "stone_tools":
                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of items
                int[] stoneCoords = Looker.findLocationOnScreen("src\\Item_Images\\cobblestone.jpg", Looker.getInventoryScreenRect());
                int[] stickStoneCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());


                ////STONE PICKAXE
                craftItem(stoneCoords,stickStoneCoords,new int[]{1,2,3},new int[]{5,8},1);

                ////STONE SHOVEL
                craftItem(stoneCoords,stickStoneCoords,new int[]{2},new int[]{5,8},1);

                ////FURNACE
                craftItem(stoneCoords, new int[]{1,2,3,4,6,7,8,9},1 );

                break;

            case "iron_tools":
                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of materials
                int[] ironCoords = Looker.findLocationOnScreen("src\\Item_Images\\iron.jpg", Looker.getInventoryScreenRect());
                int[] stickIronCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());
                int[] flintCoords = Looker.findLocationOnScreen("src\\Item_Images\\flint.jpg", Looker.getInventoryScreenRect());


                ////IRON PICKAXES
                craftItem(ironCoords,stickIronCoords,new int[]{1,2,3},new int[]{5,8},2);

                ////IRON SHOVEL
                craftItem(ironCoords,stickIronCoords,new int[]{2},new int[]{5,8},1);

                ////SHEARS
                craftItem(ironCoords, new int[]{2,6},1 );

                ////FLINT AND STEEL
                craftItem(ironCoords,flintCoords,new int[]{2},new int[]{6},1);

                break;

            case "diamond_items":
                // Move mouse away
                MouseMover.moveMouseAway();

                // Find location of materials
                int[] diamondCoords = Looker.findLocationOnScreen("src\\Item_Images\\diamond.jpg", Looker.getInventoryScreenRect());
                int[] stickDiamondCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());


                ////DIAMOND SWORD
                craftItem(diamondCoords,stickDiamondCoords,new int[]{2,5},new int[]{8},1);

                ////DIAMOND PICKAXE
                craftItem(diamondCoords,stickDiamondCoords,new int[]{1,2,3},new int[]{5,8},1);

                ////DIAMOND SHOVEL
                craftItem(diamondCoords,stickDiamondCoords,new int[]{2},new int[]{5,8},1);

                ////HELMET
                craftItem(diamondCoords, new int[]{1,2,3,4,6},1);

                ////CHESTPLATE
                craftItem(diamondCoords, new int[]{1,3,4,5,6,7,8,9},1);

                ////LEGGINGS
                craftItem(diamondCoords, new int[]{1,2,3,4,6,7,9},1);

                ////BOOTS
                craftItem(diamondCoords, new int[]{4,6,7,9},1 );

                break;
        }
    }

    public static void craftItem(int[] materialCoords, int[] craftingPositions, int number) {
        // Pick up material
        MouseMover.moveMouse(materialCoords, shortSleep);
        Typer.leftClick(shortSleep);

        for (int craftingPosition : craftingPositions) {
            // Move mouse to craft
            switch (craftingPosition) {
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
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                Typer.rightClick(shortSleep);
            }
        }

        // Place material back in original slot
        MouseMover.moveMouse(materialCoords, shortSleep);
        Typer.leftClick(longSleep);

        // Get resultant item
        MouseMover.moveMouse(Looker.getTableCraftSlotRes(), shortSleep);
        Typer.holdKey("shift", shortSleep);
        Typer.leftClick(shortSleep);
        Typer.releaseKey("shift", longSleep);
    }




    public static void craftItem(int[] materialCoords1, int[] materialCoords2, int[] craftingPositions1, int[] craftingPositions2, int number) {
        // Pick up material 1
        MouseMover.moveMouse(materialCoords1, shortSleep);
        Typer.leftClick(shortSleep);

        for (int item : craftingPositions1) {
            // Move mouse to craft
            switch (item) {
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
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                Typer.rightClick(shortSleep);
            }
        }

        // Place material 1 back in original slot
        MouseMover.moveMouse(materialCoords1, shortSleep);
        Typer.leftClick(longSleep);


        // Pick up material 2
        MouseMover.moveMouse(materialCoords2, shortSleep);
        Typer.leftClick(shortSleep);

        for (int value : craftingPositions2) {
            // Move mouse to craft
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
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                Typer.rightClick(shortSleep);
            }
        }

        // Place material 2 back in original slot
        MouseMover.moveMouse(materialCoords2, shortSleep);
        Typer.leftClick(longSleep);

        // Get resultant item
        MouseMover.moveMouse(Looker.getTableCraftSlotRes(), shortSleep);
        Typer.holdKey("shift", shortSleep);
        Typer.leftClick(shortSleep);
        Typer.releaseKey("shift", longSleep);
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
                for (int i = 0; i <= (number/8+1); i++) {
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
