package Model;

public class ItemShelf {

    private int shelfCode;
    private Item item;
    private boolean soldOut;

    public ItemShelf(int shelfCode, Item item, boolean soldOut) {
        this.shelfCode = shelfCode;
        this.item = item;
        this.soldOut = soldOut;
    }

    // Getter for shelfCode
    public int getShelfCode() {
        return shelfCode;
    }

    // Setter for shelfCode
    public void setShelfCode(int shelfCode) {
        this.shelfCode = shelfCode;
    }

    // Getter for item
    public Item getItem() {
        return item;
    }

    // Setter for item
    public void setItem(Item item) {
        this.item = item;
    }

    // Getter for soldOut
    public boolean isSoldOut() {
        return soldOut;
    }

    // Setter for soldOut
    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    // Method to restock the shelf with a new item
    public void restockItem(Item newItem) {
        this.item = newItem;
        this.soldOut = false;
    }

    // Method to mark the shelf as sold out
    public void markAsSoldOut() {
        this.soldOut = true;
    }
}
