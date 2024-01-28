package lowlevelDesign;

import lowlevelDesign.state.VendingMachineState;
import lowlevelDesign.state.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    VendingMachineState vendingMachineState;
    Inventory inventory;
    List<Money> moneyList;
    public VendingMachine(){
        inventory = new Inventory(5);
        vendingMachineState = new IdleState();
        moneyList = new ArrayList<>();
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Money> getMoneyList() {
        return moneyList;
    }

    public void setMoneyList(List<Money> moneyList) {
        this.moneyList = moneyList;
    }
}
