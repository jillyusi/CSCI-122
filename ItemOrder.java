public class ItemOrder {
    private Item item;
    private int quantity;
    private double priceForBulk;
    private int quantityForBulk;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.priceForBulk = -1; // Indicates no bulk price set
        this.quantityForBulk = 0;
    }

    public void setBulkPricing(double price, int quantity) {
        this.priceForBulk = price;
        this.quantityForBulk = quantity;
    }

    public double getPrice() {
        if (priceForBulk >= 0 && quantity >= quantityForBulk) {
            int bulkGroups = quantity / quantityForBulk;
            int remainingItems = quantity % quantityForBulk;
            return (bulkGroups * priceForBulk) + (remainingItems * item.getPrice());
        } else {
            return quantity * item.getPrice();
        }
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

