import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingGUI extends JFrame {
    private ShoppingCart cart;
    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField itemQuantityField;
    private JButton addButton;
    private JLabel totalLabel;

    public ShoppingGUI() {
        cart = new ShoppingCart();
        createUI();
    }

    private void createUI() {
        setTitle("Shopping Cart");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Item Name:"));
        itemNameField = new JTextField();
        add(itemNameField);

        add(new JLabel("Item Price:"));
        itemPriceField = new JTextField();
        add(itemPriceField);

        add(new JLabel("Quantity:"));
        itemQuantityField = new JTextField();
        add(itemQuantityField);

        addButton = new JButton("Add to Cart");
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToCart();
            }
        });

        add(new JLabel("Total Price:"));
        totalLabel = new JLabel("0");
        add(totalLabel);

        pack();
        setVisible(true);
    }

    private void addItemToCart() {
        String name = itemNameField.getText();
        double price = Double.parseDouble(itemPriceField.getText());
        int quantity = Integer.parseInt(itemQuantityField.getText());

        Item item = new Item(name, price);
        ItemOrder order = new ItemOrder(item, quantity);
        cart.addItemOrder(order);
        updateTotal();
    }

    private void updateTotal() {
        totalLabel.setText(String.valueOf(cart.getTotalPrice()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingGUI();
            }
        });
    }
}
