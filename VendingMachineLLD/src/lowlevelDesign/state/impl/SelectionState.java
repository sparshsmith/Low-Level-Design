package lowlevelDesign.state.impl;

import lowlevelDesign.Item;
import lowlevelDesign.Money;
import lowlevelDesign.VendingMachine;
import lowlevelDesign.state.VendingMachineState;

import java.util.List;

public class SelectionState implements VendingMachineState {
    public SelectionState(){
        System.out.println("Currently Vending machine is in Selection State");
    }

    public SelectionState(VendingMachine vendingMachine){
        System.out.println("Currently Vending machine is in Selection State");

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
    public void selectProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        Item item = vendingMachine.getInventory().getItem(itemCode);

        int totalMoneyPaidByUser = 0;
        for(Money money: vendingMachine.getMoneyList()){
            totalMoneyPaidByUser+= money.value;
        }

        if(totalMoneyPaidByUser < item.getPrice()){
            System.out.println("Insufficient fund!!! Refunding money");
            refundFullMoney(vendingMachine);
            throw new Exception("Insufficient Fund!");
        } else {
            if(totalMoneyPaidByUser > item.getPrice()){
                getChange(totalMoneyPaidByUser - item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, itemCode));

        }
    }

    @Override
    public int getChange(int changeMoney) {
        System.out.println("Refunding change : "+changeMoney);
        return changeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int itemCode) {
        System.out.println("Not supported in this state");
        return null;
    }

    @Override
    public List<Money> refundFullMoney(VendingMachine vendingMachine) {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getMoneyList();

    }

    @Override
    public void updateInventory(VendingMachine vendingMachine) {
        System.out.println("Not supported in this state");
    }
}
