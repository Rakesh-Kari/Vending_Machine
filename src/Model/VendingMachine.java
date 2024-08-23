package Model;

import VendingStates.Impl.IdealState;
import VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine() {
        vendingMachineState = new IdealState();
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
