

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

    public int[] findInBackpack(String item) {
        int i, j;
        i = j = 0;
        for(String[] row : backpack){

            for(String col : row){
                if(col.equals(item)){
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
        for(String col : hotbar){
            if(col.equals(item)){
                    return i;
            }
            else{
                i++;
            }
        }
        return -1;
    }
}
