package lowlevelDesign;

public class ItemShelf {
    Item item;
    int itemCode;
    boolean isSoldOut;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
}
