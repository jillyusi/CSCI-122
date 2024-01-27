import java.util.Scanner;

public class MoneyConverter {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an amount in dollars
        System.out.print("Enter an amount in dollars!: ");
        double amount = scanner.nextDouble();

        // Convert the amount to cents by truncating the decimal part
        int cents = (int) (amount * 100);

        // Calculate the number of quarters, dimes, and nickels
        int quarters = cents / 25;
        cents %= 25; // Update cents to remaining after quarters

        int dimes = cents / 10;
        cents %= 10; // Update cents to remaining after dimes

        int nickels = cents / 5;


        // Display the results
        System.out.println("You will need:");
        System.out.println(quarters + " quarters");
        System.out.println(dimes + " dimes");
        System.out.println(nickels + " nickels");
        // Close the scanner
        scanner.close();
    }
}

