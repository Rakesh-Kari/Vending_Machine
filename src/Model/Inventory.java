package Model;

public class Inventory {

    private ItemShelf[] inventory;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            Item item;
            if (i < 3) {
                item = new Item("COKE", 12, true);
            } else if (i < 5) {
                item = new Item("PEPSI", 9, true);
            } else if (i < 7) {
                item = new Item("JUICE", 13, true);
            } else {
                item = new Item("SODA", 7, true);
            }
            inventory[i] = new ItemShelf(startCode + i, item, false);
        }
    }

    public void addItem(int productCode, Item item) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getShelfCode() == productCode) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.restockItem(item);
                } else {
                    throw new Exception("Item is already present in the inventory");
                }
            }
        }
        throw new Exception("Product code does not match any shelf in the inventory.");
    }

    public Item getItem(int productCode) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getShelfCode() == productCode) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("Item has already been sold out");
                } else {
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid shelf code");
    }

    public void updateSoldItem(int productCode) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getShelfCode() == productCode) {
                itemShelf.markAsSoldOut();
                return;
            }
        }
        throw new Exception("Invalid shelf code");
    }
}
