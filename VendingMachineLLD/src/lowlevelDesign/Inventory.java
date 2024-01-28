package lowlevelDesign;

public class Inventory {
    ItemShelf[] inventory = null;

    public Inventory(int itemCount){
        inventory = new ItemShelf[itemCount];
        initiateInventory();
    }

    public void initiateInventory(){
        int itemCode = 101;
        for(int i=0; i< inventory.length;i++){
            ItemShelf shelf = new ItemShelf();
            shelf.setItemCode(itemCode);
            shelf.setSoldOut(true);
            inventory[i] = shelf;
            itemCode++;
        }
    }

    public void addItem(Item item, int code) throws Exception {
        for(ItemShelf shelf: inventory){
            if(shelf.getItemCode() == code){
                if(shelf.isSoldOut == true){
                    shelf.setItem(item);
                    shelf.setSoldOut(false);
                }
            } else{
                throw new Exception("Item already present");
            }
        }
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void dispenseItem(int code) throws Exception {
        for(ItemShelf shelf: inventory){
            if(shelf.getItemCode() == code){
                if(!shelf.isSoldOut){
                    Item item = shelf.getItem();
                    item.setCount(item.getCount()-1);
                    shelf.setItem(item);
                } else {
                    throw new Exception("Item already sold out");
                }
            }
        }
    }

    public Item getItem(int code) throws Exception {
        for(ItemShelf shelf: inventory){
            if(shelf.getItemCode() == code){
                if(!shelf.isSoldOut){
                    return shelf.getItem();
                }
            } else{
                throw new Exception("Item already sold out");
            }
        }
        throw new Exception("Invalid code!!!");
    }
}
