package VendingStates.Impl;

import Model.Coin;
import Model.Item;
import Model.VendingMachine;
import VendingStates.State;

import java.util.List;

public class DispenseState implements State {

    public DispenseState(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Currently vending machine is in Dispense State");
        dispenseProduct(machine, productCode); // Automatically dispense the product upon entering this state
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Cannot insert coins while in Dispense State.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Cannot insert coins while in Dispense State.");
    }

    @Override
    public void clickProductButton(VendingMachine machine) throws Exception {
        throw new Exception("Product selection not allowed in Dispense State.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Product selection not allowed in Dispense State.");
    }

    @Override
    public int getChange(VendingMachine machine,int returnChangeMoney) throws Exception {
        throw new Exception("Cannot return change in Dispense State.");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(productCode);
        machine.getInventory().updateSoldItem(productCode); // Mark the product as sold out
        machine.setVendingMachineState(new IdealState(machine)); // Return to the initial state after dispensing
        return item;
    }

    @Override
    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        throw new Exception("Refund not allowed in Dispense State.");
    }

    @Override
    public void updateInventory(VendingMachine machine, int productCode, Item item) throws Exception {
        throw new Exception("Cannot update inventory in Dispense State.");
    }
}
