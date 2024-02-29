import javax.swing.*;
import java.time.LocalDate;

public class TestWedding {
    public static void main(String[] args) {
        // Prompt for Partner 1's details
        String firstName1 = JOptionPane.showInputDialog("Enter Partner 1's First Name:");
        String lastName1 = JOptionPane.showInputDialog("Enter Partner 1's Last Name:");
        Person partner1 = new Person(firstName1, lastName1);

        // Prompt for Partner 2's details
        String firstName2 = JOptionPane.showInputDialog("Enter Partner 2's First Name:");
        String lastName2 = JOptionPane.showInputDialog("Enter Partner 2's Last Name:");
        Person partner2 = new Person(firstName2, lastName2);

        // Create the couple
        Couple couple = new Couple(partner1, partner2);

        // Prompt for Wedding details
        String date = JOptionPane.showInputDialog("Enter the wedding date (YYYY-MM-DD):");
        LocalDate weddingDate = LocalDate.parse(date);
        String location = JOptionPane.showInputDialog("Enter the Wedding Location:");

        // Create the Wedding
        Wedding wedding = new Wedding(couple, weddingDate, location);

        // Display the Wedding details
        JOptionPane.showMessageDialog(null, "Wedding Details:\n" +
                "Partner 1: " + wedding.getCouple().getPartner1().getFirstName() + " " + wedding.getCouple().getPartner1().getLastName() + "\n" +
                "Partner 2: " + wedding.getCouple().getPartner2().getFirstName() + " " + wedding.getCouple().getPartner2().getLastName() + "\n" +
                "Date: " + wedding.getWeddingDate().toString() + "\n" +
                "Location: " + wedding.getLocation());
    }
}
