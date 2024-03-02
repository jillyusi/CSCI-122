import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BadSubscriptCaught {

    public static void main(String[] args) {
        // Creating the frame for the application
        JFrame frame = new JFrame("Find a Name");
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating the panel to hold components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Setting the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Enter a number (1-10):");
        userLabel.setBounds(10, 20, 160, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(180, 20, 50, 25);
        panel.add(userText);

        JButton findButton = new JButton("Find Name");
        findButton.setBounds(240, 20, 120, 25);
        panel.add(findButton);

        // Array of names
        String[] firstNames = {"John", "Jane", "Bob", "Alice", "Ryan", "Claire", "Zach", "Emily", "Luke", "Sara"};

        // Adding action listener to the button
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(userText.getText());
                    JOptionPane.showMessageDialog(null, "The name is: " + firstNames[index - 1]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Number out of range. Please enter a number between 1 and 10.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Please enter a valid number.");
                }
            }
        });
    }
}
