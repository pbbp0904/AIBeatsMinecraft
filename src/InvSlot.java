public class InvSlot {

    private String item;
    private int amount;

    public InvSlot() {
        this.item = null;
        this.amount = 0;
    }

    public InvSlot(String item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isEmpty(){
        if(item.equals(null)) {
            return true;
        }
        return false;
    }

}
