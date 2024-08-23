package VendingStates.Impl;

import Model.Coin;
import Model.Item;
import Model.VendingMachine;
import VendingStates.State;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Vending machine is in hasMoneyState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public void clickProductButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {

    }

    @Override
    public int getChange(VendingMachine machine,int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {

        return null;
    }

    @Override
    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdealState(machine));
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, int productCode, Item item) throws Exception {

    }
}
