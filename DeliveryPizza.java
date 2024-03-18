public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String[] toppings, String deliveryAddress, int numberOfToppings) {
        super(toppings, numberOfToppings);
        this.deliveryAddress = deliveryAddress;
        // Determine delivery fee based on the price of the pizza
        this.deliveryFee = super.toString().contains("$18") || super.toString().contains("$2") ? 3 : 5;
    }

    @Override
    public String toString() {
        return super.toString() + " | Delivery Address: " + deliveryAddress + " | Delivery Fee: $" + deliveryFee;
    }
}
