package VendingStates;

import Model.Coin;
import Model.Item;
import Model.VendingMachine;

import java.util.List;

public interface State {

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void clickProductButton(VendingMachine machine) throws Exception;
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception;
    public int getChange(VendingMachine machine,int returnChangeMoney) throws Exception;
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception;
    public List<Coin> refundMoney(VendingMachine machine) throws Exception;
    public void updateInventory(VendingMachine machine, int productCode, Item item) throws Exception;
}
