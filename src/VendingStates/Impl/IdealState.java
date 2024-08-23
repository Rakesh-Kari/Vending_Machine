package VendingStates.Impl;

import Model.Coin;
import Model.Item;
import Model.VendingMachine;
import VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class IdealState implements State {

    public IdealState() {
        System.out.println("Machine is in Ideal State");
    }

    public IdealState(VendingMachine machine) {
        System.out.println("Currently vending machine is in Ideal State");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        System.out.println("Please insert the coins");
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Coins cannot be inserted in ideal state");
    }

    @Override
    public void clickProductButton(VendingMachine machine) throws Exception {
        throw new Exception("You need to insert coins before selecting a product.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("You need to insert coins before selecting a product.");
    }

    @Override
    public int getChange(VendingMachine machine, int returnChangeMoney) throws Exception {
        throw new Exception("Cannot get change in the ideal state.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Cannot dispense product in the ideal state.");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        throw new Exception("Cannot refund money in the ideal state.");
    }

    @Override
    public void updateInventory(VendingMachine machine, int productCode, Item item) throws Exception {
        throw new Exception("Cannot update inventory in the ideal state.");
    }
}
