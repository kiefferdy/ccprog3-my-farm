package MyFarmView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Window for the user to enter their name to start the game
public class Username extends JFrame{
    private JButton button;
    private JTextField textfield;

    public Username() {
        // Sets specifications of the window
        this.setSize(new Dimension(200, 150));   
        this.setResizable(false);                  
        this.setLocationRelativeTo(null);                  
        this.setLayout(new BorderLayout(5, 5));       
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // "Enter you name" text to be displayed
        JLabel label = new JLabel();
        label.setText("Enter your name: ");
        label.setFont(new Font("Cambria", Font.PLAIN, 14));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(50, 25));

        // Submit button
        this.button = new JButton();
        this.button.setText("Submit");
        this.button.setPreferredSize(new Dimension(50, 25));

        // Field where the user can place their name
        this.textfield = new JTextField();
        this.textfield.setColumns(15);
        this.textfield.setPreferredSize(new Dimension(15, 15));

        // adding all components to the main window, in their respective places
        this.add(label, BorderLayout.NORTH);
        this.add(textfield, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    // Gets the text in the text field of the window
    public String getTextfieldTxt() {
        return this.textfield.getText();
    }

    // Gets the submit button
    public JButton getButton() {
        return this.button;
    }

    // Closes the window
    public void CloseWindow() {
        dispose();
    }
}
