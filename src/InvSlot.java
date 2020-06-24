public class InvSlot {

    private String item;

    public InvSlot() {
        this.item = null;
    }

    public InvSlot(String item) {
        this.item = item;
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
