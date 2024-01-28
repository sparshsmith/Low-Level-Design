package lowlevelDesign.state.impl;

import lowlevelDesign.Item;
import lowlevelDesign.Money;
import lowlevelDesign.VendingMachine;
import lowlevelDesign.state.VendingMachineState;

import java.util.List;

public class HasMoneyState implements VendingMachineState {
    public HasMoneyState(){
        System.out.println("Currently Vending machine is in HasMoney State");
    }

    public HasMoneyState(VendingMachine vendingMachine){
        System.out.println("Currently Vending machine is in HasMoney State");

    }

    @Override
    public void clickOnInsertMoneyButton(VendingMachine vendingMachine) {
        System.out.println("Not supported in this state");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, Money money) {
        System.out.println("Accepted the coin");
        vendingMachine.getMoneyList().add(money);
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new SelectionState());
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
    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode) {
        System.out.println("Not supported in this state");
        return null;
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
