import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// extending JFrame for GUI that implements ActionListener
public class DoubleValueEntry extends JFrame implements ActionListener {
    JTextField inputField = new JTextField(10);
    JTextArea displayArea = new JTextArea(5, 20);
    JButton addButton = new JButton("Add");
    double[] values = new double[20];
    int valueCount = 0;

    // Constructor to set up the UI
    public DoubleValueEntry() {
        setTitle(" Double Entry"); // Window title
        setLayout(new FlowLayout()); // Simple layout for components
        add(inputField); // Add input field to the frame
        add(addButton); // Add button to the frame
        displayArea.setEditable(false); // Prevent editing of the display area
        add(new JScrollPane(displayArea)); // Add display area in a scroll pane
        addButton.addActionListener(this); // Register this class to handle button clicks
        setSize(250, 200); // Set window size
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Exit application when window is closed
        setVisible(true); // Show the window
    }

    // Method to handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the maximum number of values has been reached
        if (valueCount >= 20) {
            JOptionPane.showMessageDialog(this, "Limit reached."); // Show message if limit reached
            return;
        }
        try {
            // Try to parse the input as a double and add it to the array and display area
            double value = Double.parseDouble(inputField.getText());
            values[valueCount++] = value; // Store the value
            displayArea.append(value + "\n"); // Show the value in the display area
            inputField.setText(""); // Clear the input field for next entry
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input."); // Show error if input is not a valid double
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new DoubleValueEntry(); // Create an instance of the application
    }
}


