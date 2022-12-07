package MyFarmView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Username extends JFrame{
    private JButton button;
    private JTextField textfield;

    public Username() {
        this.setSize(new Dimension(200, 150));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel();
        label.setText("Enter your name: ");
        label.setFont(new Font("Cambria", Font.PLAIN, 14));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(50, 25));

        this.button = new JButton();
        this.button.setText("Submit");
        this.button.setPreferredSize(new Dimension(50, 25));

        this.textfield = new JTextField();
        this.textfield.setColumns(15);
        this.textfield.setPreferredSize(new Dimension(15, 15));

        this.add(label, BorderLayout.NORTH);
        this.add(textfield, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public String getTextfieldTxt() {
        return this.textfield.getText();
    }

    public JButton getButton() {
        return this.button;
    }

    public void CloseWindow() {
        dispose();
    }
}
