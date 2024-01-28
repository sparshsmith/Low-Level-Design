package lowlevelDesign.state.impl;

import lowlevelDesign.Item;
import lowlevelDesign.Money;
import lowlevelDesign.VendingMachine;
import lowlevelDesign.state.VendingMachineState;

import java.util.List;

public class DispenseState implements VendingMachineState {
    public DispenseState(){
        System.out.println("Currently Vending machine is in Dispense State");
    }

    public DispenseState(VendingMachine vendingMachine, int itemCode) throws Exception {
        System.out.println("Currently Vending machine is in Dispense State");
        dispenseProduct(vendingMachine, itemCode);

    }
    @Override
    public void clickOnInsertMoneyButton(VendingMachine vendingMachine) {
        System.out.println("Not supported in this state");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, Money money) {
        System.out.println("Not supported in this state");
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vendingMachine) {
        System.out.println("Not supported in this state");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int itemCode) {
        System.out.println("Not supported in this state");
    }

    @Override
    public int getChange(int changeMoney) throws Exception {
        System.out.println("Not supported in this state");
        throw new Exception("Not supported in this state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        System.out.println("Product has been dispensed..");
        Item item = vendingMachine.getInventory().getItem(itemCode);
        vendingMachine.getInventory().dispenseItem(itemCode);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public List<Money> refundFullMoney(VendingMachine vendingMachine) {
        return null;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine) {
        System.out.println("Not supported in this state");
    }
}
