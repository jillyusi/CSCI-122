import java.util.Scanner;

public class DemoPizza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] toppings = new String[10];
        int toppingCount = 0;
        System.out.println("Enter toppings for your Pizza (Type 'QUIT' to finish):");

        while (true) {
            if (toppingCount >= 10) {
                System.out.println("Warning: Maximum of 10 toppings allowed. You cannot add more toppings.");
                break;
            }
            String topping = input.nextLine();
            if ("QUIT".equalsIgnoreCase(topping)) {
                break;
            }
            toppings[toppingCount++] = topping;
        }

        System.out.println("Is the Pizza to be delivered? (yes/no):");
        String deliveryResponse = input.nextLine();

        if ("yes".equalsIgnoreCase(deliveryResponse)) {
            System.out.println("Enter the delivery address:");
            String address = input.nextLine();
            DeliveryPizza deliveryPizza = new DeliveryPizza(toppings, address, toppingCount);
            System.out.println(deliveryPizza);
        } else {
            Pizza pizza = new Pizza(toppings, toppingCount);
            System.out.println(pizza);
        }

        input.close();
    }
}

