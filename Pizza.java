public class Pizza {
    private String[] toppings = new String[10];
    private double price;
    private String description = "";

    public Pizza(String[] toppings, int numberOfToppings) {
        for (int i = 0; i < numberOfToppings; i++) {
            this.toppings[i] = toppings[i];
            description += toppings[i];
            if (i < numberOfToppings - 1) {
                description += ", ";
            }
        }
        // Base price is $14 plus $2 for each topping
        this.price = 14 + 2 * numberOfToppings;
    }

    @Override
    public String toString() {
        return "Pizza with toppings: " + description + " | Price: $" + price;
    }
}
