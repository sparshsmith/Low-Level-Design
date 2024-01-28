import lowlevelDesign.*;
import lowlevelDesign.state.VendingMachineState;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        try{
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            VendingMachineState vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertMoneyButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertMoney(vendingMachine, Money.HUNDRED);
            vendingState.insertMoney(vendingMachine, Money.HUNDRED);
            vendingState.insertMoney(vendingMachine, Money.FIFTY);


            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");

            vendingState.clickOnSelectItemButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.selectProduct(vendingMachine, 101);

            displayInventory(vendingMachine);


        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(int i = 1; i<= slots.length; i++){
            Item item = new Item();
            switch (i) {
                case 1:
                    item.setItemType(ItemType.COKE);
                    item.setPrice(120);
                    item.setCount(4);
                    break;
                case 2:
                    item.setItemType(ItemType.PEPSI);
                    item.setPrice(200);
                    item.setCount(10);
                    break;
                case 3:
                    item.setItemType(ItemType.MAAZA);
                    item.setPrice(90);
                    item.setCount(20);
                    break;
                case 4:
                    item.setItemType(ItemType.SODA);
                    item.setPrice(50);
                    item.setCount(10);
                    break;
                case 5:
                    item.setItemType(ItemType.JUICE);
                    item.setPrice(250);
                    item.setCount(3);
                    break;
                default:
                    System.out.println("Incorrect item type");
                    break;
            }
            slots[i-1].setItem(item);
            slots[i-1].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getItemCode() +
                    " Item: " + slots[i].getItem().getItemType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " Count: " + slots[i].getItem().getCount() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }

}