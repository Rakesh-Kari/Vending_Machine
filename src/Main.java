import Model.*;
import VendingStates.State;

public class Main {
    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();
        try {
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(machine);
            displayInventory(machine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = machine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(machine);

            vendingState = machine.getVendingMachineState();
            vendingState.insertCoin(machine, Coin.NICKEL);
            vendingState.insertCoin(machine, Coin.DIME);

            displayInsertedCoins(machine);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");

            vendingState.clickProductButton(machine);

            vendingState = machine.getVendingMachineState();
            vendingState.chooseProduct(machine, 103);

            displayInventory(machine);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            displayInventory(machine);
        }
    }

    private static void fillUpInventory(VendingMachine machine) {
        ItemShelf[] slots = machine.getInventory().getInventory();
        for(int i = 0; i < slots.length; i++) {
            ItemType itemType;
            int price;

            if(i >= 0 && i < 3) {
                itemType = ItemType.COKE;
                price = 12;
            } else if(i >= 3 && i < 5){
                itemType = ItemType.PEPSI;
                price = 9;
            } else if(i >= 5 && i < 7){
                itemType = ItemType.JUICE;
                price = 13;
            } else {
                itemType = ItemType.SODA;
                price = 7;
            }

            // Correct item initialization
            Item newItem = new Item(itemType.name(), price, true);
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine machine) {
        ItemShelf[] slots = machine.getInventory().getInventory();

        for(int i = 0; i < slots.length; i++) {
            System.out.println("Code Number: " + slots[i].getShelfCode() +
                    " Item: " + slots[i].getItem().getName() +
                    " Price " + slots[i].getItem().getPrice() +
                    " isAvailable " + !slots[i].isSoldOut());
        }
    }

    private static void displayInsertedCoins(VendingMachine machine) {
        System.out.println("|");
        System.out.println("Displaying inserted coins:");
        System.out.println("|");

        int totalValue = 0;
        int coinCount = 0;

        for (Coin coin : machine.getCoinList()) {
            System.out.println("Coin: " + coin.name() + " Value: " + coin.getValue());
            totalValue += coin.getValue();
            coinCount++;
        }

        System.out.println("Total Coins Inserted: " + coinCount);
        System.out.println("Total Value: " + totalValue);
    }
}
