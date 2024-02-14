import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PizzaOrderApp extends JFrame implements ActionListener {
    // Declare GUI components as class members to access them in any method
    private JComboBox<String> sizeComboBox;
    private JCheckBox topping1, topping2, topping3, topping4, topping5, extraCheese;
    private JButton calculateButton;
    private JLabel priceLabel, imageLabel;
    private double basePrice = 0;
    private double toppingsPrice = 0;

    public PizzaOrderApp() {
        setTitle("BigY Store Pizza Order"); // Set the window title
        setSize(500, 500); // Set the initial size of the window
        setLayout(new FlowLayout()); // Use FlowLayout for component arrangement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when the window is closed

        // Pizza Sizes Dropdown
        String[] sizes = {"Small ($5)", "Medium ($10)", "Large ($15)", "Super ($20)"};
        sizeComboBox = new JComboBox<>(sizes); // Create a dropdown for pizza sizes
        add(sizeComboBox); // Add the dropdown to the window

        // Toppings Checkboxes
        topping1 = new JCheckBox("Pepperoni ($0.50)");
        topping2 = new JCheckBox("Mushrooms ($0.50)");
        topping3 = new JCheckBox("Onions ($0.50)");
        topping4 = new JCheckBox("Sausage ($0.50)");
        topping5 = new JCheckBox("Bacon ($0.50)");
        extraCheese = new JCheckBox("Extra Cheese"); // No additional charge for extra cheese

        // Add checkboxes for toppings to the window
        add(topping1);
        add(topping2);
        add(topping3);
        add(topping4);
        add(topping5);
        add(extraCheese);

        // Button to calculate the total price
        calculateButton = new JButton("Calculate Price");
        calculateButton.addActionListener(this); // Register this class as the button's action listener
        add(calculateButton); // Add the button to the window

        // Label to display the total price
        priceLabel = new JLabel("Total Price: $0.0");
        add(priceLabel); // Add the label to the window

        // Adding an image below the calculator
        ImageIcon pizzaIcon = new ImageIcon("pizza_image.jpg"); // Load the pizza image
        imageLabel = new JLabel(pizzaIcon); // Create a label to display the image
        add(imageLabel); // Add the image label to the window

        // Set theme colors and fonts for a better visual appearance
        getContentPane().setBackground(new Color(255, 223, 186)); // Light Orange Background
        Font font = new Font("SansSerif", Font.BOLD, 16); // Create a custom font
        // Apply the custom font to all components in the window
        for (Component component : getContentPane().getComponents()) {
            component.setFont(font);
            if (component instanceof JButton) {
                component.setBackground(new Color(250, 150, 100)); // Button Color
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is called whenever an action occurs (e.g., button click, checkbox selection)
        int toppingCount = 0; // Count the number of selected toppings
        // Increment the count for each selected topping
        if (topping1.isSelected()) toppingCount++;
        if (topping2.isSelected()) toppingCount++;
        if (topping3.isSelected()) toppingCount++;
        if (topping4.isSelected()) toppingCount++;
        if (topping5.isSelected()) toppingCount++;

        // Limit the user to selecting no more than 3 toppings
        if (toppingCount > 3) {
            // Show a warning message if more than 3 toppings are selected
            JOptionPane.showMessageDialog(this, "You can't select more than 3 toppings!", "Too Many Toppings", JOptionPane.WARNING_MESSAGE);
            // Deselect the last selected topping
            ((JCheckBox)e.getSource()).setSelected(false);
            return; // Exit the method to prevent further execution
        }

        // Calculate the total price when the calculate button is clicked
        if (e.getSource() == calculateButton) {
            int selectedIndex = sizeComboBox.getSelectedIndex();
            basePrice = 5 + (selectedIndex * 5); // Calculate base price based on the selected size

            // Calculate toppings price based on the number of toppings
            if (toppingCount == 1 || toppingCount == 2) {
                toppingsPrice = 0.50 * toppingCount;
            } else if (toppingCount == 3) {
                toppingsPrice = 1.25; // Special deal for 3 toppings
            } else {
                toppingsPrice = 0.00; // No toppings selected
            }

            double totalPrice = basePrice + toppingsPrice; // Calculate total price
            priceLabel.setText(String.format("Total Price: $%.2f", totalPrice)); // Display the total price
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PizzaOrderApp app = new PizzaOrderApp(); // Create the application window
            app.setVisible(true); // Make the window visible
        });
    }
}

