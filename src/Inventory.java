

public class Inventory {

    String[][] backpack = new String[3][9];
    String[] hotbar = new String[9];

    public Inventory() {

    }

    public String getItemInHotbar(int pos) {
        return hotbar[pos];
    }

    public String getItemInBackpack(int row, int col) {
        return backpack[row][col];
    }

    public void setItemInHotbar(int pos, String item) {
        hotbar[pos] = item;
    }

    public void setItemInBackpack(int row, int col, String item) {
        backpack[row][col] = item;
    }

    public void setBackpack(String[][] newBP) {
        if(newBP.length == 3 && newBP[0].length == 9) {
            backpack = newBP;
        }
    }
}
