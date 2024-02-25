import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartyPlannerGUI extends JFrame {
    private JTextField guestsInput, dinnerGuestsInput;
    private JComboBox<String> dinnerChoiceCombo;
    private JButton planPartyButton, planDinnerPartyButton;
    private JTextArea resultArea;

    public PartyPlannerGUI() {
        createView();
        setTitle("Party Planner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void createView() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        getContentPane().add(panel);

        // Guests for the party
        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Number of guests for the party:"), c);

        guestsInput = new JTextField(10);
        c.gridx = 1;
        panel.add(guestsInput, c);

        // Plan Party button
        planPartyButton = new JButton("Plan Party");
        c.gridx = 0; c.gridy = 1; c.gridwidth = 2;
        panel.add(planPartyButton, c);
        planPartyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Party party = new Party();
                    party.setGuests(Integer.parseInt(guestsInput.getText()));
                    resultArea.setText("The party has " + party.getGuests() + " guests\n" + party.displayInvitation());
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(PartyPlannerGUI.this,
                            "Please enter a valid number for the number of guests.",
                            "Invalid Input",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Dinner party guests
        c.gridx = 0; c.gridy = 2; c.gridwidth = 1;
        panel.add(new JLabel("Number of guests for the dinner party:"), c);

        dinnerGuestsInput = new JTextField(10);
        c.gridx = 1;
        panel.add(dinnerGuestsInput, c);

        // Dinner choice
        c.gridx = 0; c.gridy = 3;
        panel.add(new JLabel("Dinner choice:"), c);

        String[] choices = {"1 for Chicken", "2 for Veg"};
        dinnerChoiceCombo = new JComboBox<>(choices);
        c.gridx = 1;
        panel.add(dinnerChoiceCombo, c);

        // Plan Dinner Party button
        planDinnerPartyButton = new JButton("Plan Dinner Party");
        c.gridx = 0; c.gridy = 4; c.gridwidth = 2;
        panel.add(planDinnerPartyButton, c);
        planDinnerPartyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DinnerParty dinnerParty = new DinnerParty();
                    dinnerParty.setGuests(Integer.parseInt(dinnerGuestsInput.getText()));
                    dinnerParty.setDinnerChoice(dinnerChoiceCombo.getSelectedIndex() + 1);
                    resultArea.setText("The dinner party has " + dinnerParty.getGuests() + " guests\n" +
                            "Menu option " + dinnerParty.getDinnerChoice() + " will be served\n" +
                            dinnerParty.displayInvitation());
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(PartyPlannerGUI.this,
                            "Please enter a valid number for the number of dinner guests.",
                            "Invalid Input",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Result area
        resultArea = new JTextArea(5, 20);
        c.gridx = 0; c.gridy = 5; c.gridwidth = 2;
        panel.add(new JScrollPane(resultArea), c);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PartyPlannerGUI().setVisible(true);
            }
        });
    }
}
