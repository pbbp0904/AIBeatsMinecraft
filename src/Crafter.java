
public class Crafter {

    Typer typer = new Typer();
    MouseMover mm = new MouseMover();
    int[] coords;


    private final Waiter waiter;


    public Crafter() {
        waiter = new Waiter(200,500,1500);

    }

    public void craft(String item, int number) {
        switch (item) {
            case "oak_planks":
                // Move Mouse Away
                mm.moveMouseAway();

                // Find location of logs
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_log.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(Looker.getHandCraftSlot1(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Place item back in original slot
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Get resultant item
                mm.moveMouse(Looker.getHandCraftSlotRes(), waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getShortSleepTime());

                break;


            case "crafting_table":
                // Move mouse away
                mm.moveMouseAway();

                // Find location of wood
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(Looker.getHandCraftSlot1(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(Looker.getHandCraftSlot2(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(Looker.getHandCraftSlot3(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(Looker.getHandCraftSlot4(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }

                // Place item back in original slot
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Get resultant item
                mm.moveMouse(Looker.getHandCraftSlotRes(), waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getShortSleepTime());

                break;


            case "stick":
                // Move Mouse Away
                mm.moveMouseAway();

                // Find location of wood
                coords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());


                // Pick up items
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(Looker.getHandCraftSlot2(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }
                // Move mouse to craft
                mm.moveMouse(Looker.getHandCraftSlot4(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }

                // Place item back in original slot
                mm.moveMouse(coords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Get resultant item
                mm.moveMouse(Looker.getHandCraftSlotRes(), waiter.getShortSleepTime());
                typer.holdShift(waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                typer.releaseShift(waiter.getShortSleepTime());

                break;


            case "wooden_pickaxe":

                // Move mouse away
                mm.moveMouseAway();

                // Find location of items
                int[] woodCoords = Looker.findLocationOnScreen("src\\Item_Images\\oak_planks.jpg", Looker.getInventoryScreenRect());
                int[] stickWoodCoords = Looker.findLocationOnScreen("src\\Item_Images\\stick.jpg", Looker.getInventoryScreenRect());


                ////WOODEN PICKAXE
                craftItem(woodCoords,stickWoodCoords,new int[]{1,2,3},new int[]{5,8},1);

                break;


            case "stone_tools":
                // Move mouse away
                mm.moveMouseAway();

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
                mm.moveMouseAway();

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
                mm.moveMouseAway();

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

    public void craftItem(int[] materialCoords, int[] craftingPositions, int number) {
        // Pick up material
        mm.moveMouse(materialCoords, waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());

        for (int craftingPosition : craftingPositions) {
            // Move mouse to craft
            switch (craftingPosition) {
                case 1:
                    mm.moveMouse(Looker.getTableCraftSlot1(), waiter.getShortSleepTime());
                    break;
                case 2:
                    mm.moveMouse(Looker.getTableCraftSlot2(), waiter.getShortSleepTime());
                    break;
                case 3:
                    mm.moveMouse(Looker.getTableCraftSlot3(), waiter.getShortSleepTime());
                    break;
                case 4:
                    mm.moveMouse(Looker.getTableCraftSlot4(), waiter.getShortSleepTime());
                    break;
                case 5:
                    mm.moveMouse(Looker.getTableCraftSlot5(), waiter.getShortSleepTime());
                    break;
                case 6:
                    mm.moveMouse(Looker.getTableCraftSlot6(), waiter.getShortSleepTime());
                    break;
                case 7:
                    mm.moveMouse(Looker.getTableCraftSlot7(), waiter.getShortSleepTime());
                    break;
                case 8:
                    mm.moveMouse(Looker.getTableCraftSlot8(), waiter.getShortSleepTime());
                    break;
                case 9:
                    mm.moveMouse(Looker.getTableCraftSlot9(), waiter.getShortSleepTime());
                    break;
            }
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                typer.rightClick(waiter.getShortSleepTime());
            }
        }

        // Place material back in original slot
        mm.moveMouse(materialCoords, waiter.getShortSleepTime());
        typer.leftClick(waiter.getLongSleepTime());

        // Get resultant item
        mm.moveMouse(Looker.getTableCraftSlotRes(), waiter.getShortSleepTime());
        typer.holdShift(waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getLongSleepTime());
    }




    public void craftItem(int[] materialCoords1, int[] materialCoords2, int[] craftingPositions1, int[] craftingPositions2, int number) {
        // Pick up material 1
        mm.moveMouse(materialCoords1, waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());

        for (int item : craftingPositions1) {
            // Move mouse to craft
            switch (item) {
                case 1:
                    mm.moveMouse(Looker.getTableCraftSlot1(), waiter.getShortSleepTime());
                    break;
                case 2:
                    mm.moveMouse(Looker.getTableCraftSlot2(), waiter.getShortSleepTime());
                    break;
                case 3:
                    mm.moveMouse(Looker.getTableCraftSlot3(), waiter.getShortSleepTime());
                    break;
                case 4:
                    mm.moveMouse(Looker.getTableCraftSlot4(), waiter.getShortSleepTime());
                    break;
                case 5:
                    mm.moveMouse(Looker.getTableCraftSlot5(), waiter.getShortSleepTime());
                    break;
                case 6:
                    mm.moveMouse(Looker.getTableCraftSlot6(), waiter.getShortSleepTime());
                    break;
                case 7:
                    mm.moveMouse(Looker.getTableCraftSlot7(), waiter.getShortSleepTime());
                    break;
                case 8:
                    mm.moveMouse(Looker.getTableCraftSlot8(), waiter.getShortSleepTime());
                    break;
                case 9:
                    mm.moveMouse(Looker.getTableCraftSlot9(), waiter.getShortSleepTime());
                    break;
            }
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                typer.rightClick(waiter.getShortSleepTime());
            }
        }

        // Place material 1 back in original slot
        mm.moveMouse(materialCoords1, waiter.getShortSleepTime());
        typer.leftClick(waiter.getLongSleepTime());


        // Pick up material 2
        mm.moveMouse(materialCoords2, waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());

        for (int value : craftingPositions2) {
            // Move mouse to craft
            switch (value) {
                case 1:
                    mm.moveMouse(Looker.getTableCraftSlot1(), waiter.getShortSleepTime());
                    break;
                case 2:
                    mm.moveMouse(Looker.getTableCraftSlot2(), waiter.getShortSleepTime());
                    break;
                case 3:
                    mm.moveMouse(Looker.getTableCraftSlot3(), waiter.getShortSleepTime());
                    break;
                case 4:
                    mm.moveMouse(Looker.getTableCraftSlot4(), waiter.getShortSleepTime());
                    break;
                case 5:
                    mm.moveMouse(Looker.getTableCraftSlot5(), waiter.getShortSleepTime());
                    break;
                case 6:
                    mm.moveMouse(Looker.getTableCraftSlot6(), waiter.getShortSleepTime());
                    break;
                case 7:
                    mm.moveMouse(Looker.getTableCraftSlot7(), waiter.getShortSleepTime());
                    break;
                case 8:
                    mm.moveMouse(Looker.getTableCraftSlot8(), waiter.getShortSleepTime());
                    break;
                case 9:
                    mm.moveMouse(Looker.getTableCraftSlot9(), waiter.getShortSleepTime());
                    break;
            }
            // Place the correct number of items
            for (int j = 0; j < number; j++) {
                typer.rightClick(waiter.getShortSleepTime());
            }
        }

        // Place material 2 back in original slot
        mm.moveMouse(materialCoords2, waiter.getShortSleepTime());
        typer.leftClick(waiter.getLongSleepTime());

        // Get resultant item
        mm.moveMouse(Looker.getTableCraftSlotRes(), waiter.getShortSleepTime());
        typer.holdShift(waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getLongSleepTime());
    }


    public void smelt(String item, int number) {
        switch(item) {
            case "iron_ore":
                // Move mouse away
                mm.moveMouseAway();

                ////IRON
                // Find location of items
                int[] ironOreCoords = Looker.findLocationOnScreen("src\\Item_Images\\iron_ore.jpg", Looker.getInventoryScreenRect());
                int[] coalCoords = Looker.findLocationOnScreen("src\\Item_Images\\coal.jpg", Looker.getInventoryScreenRect());
                // Pick up iron ore
                mm.moveMouse(ironOreCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(Looker.getFurnaceSmeltSlot(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i < number; i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }

                // Place item back in original slot
                mm.moveMouse(ironOreCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());

                // Pick up coal
                mm.moveMouse(coalCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getShortSleepTime());
                // Move mouse to craft
                mm.moveMouse(Looker.getFurnaceCoalSlot(), waiter.getShortSleepTime());
                // Place the correct number of items
                for (int i = 0; i <= (number/8+1); i++) {
                    typer.rightClick(waiter.getShortSleepTime());
                }

                // Place item back in original slot
                mm.moveMouse(coalCoords, waiter.getShortSleepTime());
                typer.leftClick(waiter.getLongSleepTime());
                break;

        }

    }

    public void openInventory(){
        typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
    }

    public void closeInventory(){
        typer.type("e", waiter.getShortSleepTime(), waiter.getLongSleepTime());
        waiter.wait(waiter.getLongSleepTime());
    }

    public void getSmelt() {
        mm.moveMouse(Looker.getFurnaceResSlot(),waiter.getShortSleepTime());
        typer.holdShift(waiter.getShortSleepTime());
        typer.leftClick(waiter.getShortSleepTime());
        typer.releaseShift(waiter.getLongSleepTime());
    }


}
