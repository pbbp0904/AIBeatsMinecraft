import java.awt.*;

public class Inventory {

    private InvSlot[][] backpack;
    private InvSlot[] hotbar;

    public Inventory(Typer typer) {
        int size = getInvSize(typer);
        backpack = new InvSlot[3][9];
        hotbar = new InvSlot[9];

    }

    public int getInvSize(Typer typer) {

        typer.pressKey('e');
        Point p = MouseInfo.getPointerInfo().getLocation();
        int[] coords = {p.x, p.y};

        return 0;
    }


    public String getItemInHotbar(int pos) {
        return hotbar[pos].getItem();
    }

    public String getItemInBackpack(int row, int col) {
        return backpack[row][col].getItem();
    }

    public void setItemInHotbar(int pos, String item) {
        hotbar[pos].setItem(item);
    }

    public void setItemInBackpack(int row, int col, String item) {
        backpack[row][col].setItem(item);
    }

    public void setBackpack(InvSlot[][] newBP) {
        if(newBP.length == 3 && newBP[0].length == 9) {
            backpack = newBP;
        }
    }

    public int[] findInBackpack(String item) {
        int i, j;
        i = j = 0;
        for(InvSlot[] row : backpack){
            for(InvSlot col : row){
                if(col.getItem().equals(item)){
                    return new int[]{i, j};
                }
                else{
                    j++;
                }
            }
            i++;
            j = 0;
        }
        return null;
    }

    public int findInHotbar(String item) {
        int i = 0;
        for(InvSlot col : hotbar){
            if(col.getItem().equals(item)){
                    return i;
            }
            else{
                i++;
            }
        }
        return -1;
    }

    public InvSlot shiftClickLoc(String item) {
        int i = 8;
        while(i >= 0){
            if(hotbar[i].isEmpty()) {
                hotbar[i].setItem(item);
                return hotbar[i];
            }
            else {
                i--;
            }
        }
        i = 8;
        int j = 2;
        while (j >= 0) {
            while (i >= 0) {
                if(backpack[j][i].isEmpty()) {
                    backpack[j][i].setItem(item);
                    return backpack[j][i];
                }
                else {
                    i--;
                }
            }
            j--;
        }

        return null;
    }
}
