package lowlevelDesign.state;

import lowlevelDesign.Item;
import lowlevelDesign.Money;
import lowlevelDesign.VendingMachine;

import java.util.List;

public interface VendingMachineState {

    public void clickOnInsertMoneyButton(VendingMachine vendingMachine);
    public void insertMoney(VendingMachine vendingMachine, Money money);
    public void clickOnSelectItemButton(VendingMachine vendingMachine);
    public void selectProduct(VendingMachine vendingMachine, int itemCode) throws Exception;
    public int getChange(int changeMoney) throws Exception;
    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode) throws Exception;
    public List<Money> refundFullMoney(VendingMachine vendingMachine);
    public void updateInventory(VendingMachine vendingMachine);
}
