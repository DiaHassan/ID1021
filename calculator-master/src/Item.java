public class Item {
    private ItemType type;
    private int value = 0;

    public Item(ItemType itype, int value){
        this.type = itype;
        this.value = value;
    }
    public ItemType type(){
        return this.type;
    }

    public int value(){
        return this.value;
    }
}
