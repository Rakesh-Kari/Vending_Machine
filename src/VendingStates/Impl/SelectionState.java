package VendingStates.Impl;

import Model.Coin;
import Model.Item;
import Model.VendingMachine;
import VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently Vending Machine is in Selection State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Cannot insert coin while in Selection State. Please choose a product.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Cannot insert coin while in Selection State. Please choose a product.");
    }

    @Override
    public void clickProductButton(VendingMachine machine) throws Exception {
        throw new Exception("Product already selected. Please choose a product or dispense it.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        Item item = machine.getInventory().getItem(productCode);

        int paidByUser = 0;
        for (Coin coin : machine.getCoinList()) {
            paidByUser += coin.getValue();
        }

        if (paidByUser < item.getPrice()) {
            System.out.println("Insufficient amount. The product you selected is priced at: " + item.getPrice() + " and you paid " + paidByUser);
            refundMoney(machine);
            throw new Exception("Insufficient amount");
        } else if (paidByUser >= item.getPrice()) {
            if (paidByUser > item.getPrice()) {
                int change = paidByUser - item.getPrice();
                getChange(machine,paidByUser - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, productCode)); // Transition to DispenseState with the productCode
        }
    }

    @Override
    public int getChange( VendingMachine machine,int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in Coin Dispense Tray: " + returnChangeMoney);
        machine.getCoinList().clear();
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Cannot dispense product directly in Selection State. Please proceed to product dispensing.");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        System.out.println("Returning the full amount back in the Coin Dispense Tray.");
        List<Coin> refundedCoins = new ArrayList<>(machine.getCoinList());
        machine.getCoinList().clear();
        machine.setVendingMachineState(new IdealState(machine)); // Reset to IdealState after refund
        return refundedCoins;
    }

    @Override
    public void updateInventory(VendingMachine machine, int productCode, Item item) throws Exception {
        machine.getInventory().addItem(productCode, item);
        System.out.println("Inventory updated: Added item to the shelf with code " + productCode);
    }
}
