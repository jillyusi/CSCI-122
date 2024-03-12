import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> list;

    public ShoppingCart() {
        list = new ArrayList<>();
    }

    public void addItemOrder(ItemOrder order) {
        // Optionally, remove any existing order for the same item before adding
        list.add(order);
    }

    public double getTotalPrice() {
        double total = 0;
        for (ItemOrder order : list) {
            total += order.getPrice();
        }
        return total;
    }

    // Implement methods to remove or search for item orders as needed
}

