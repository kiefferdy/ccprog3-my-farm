package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

// Window where the player can see the farm's current overall statistics
public class FarmStatsView extends JFrame {
    private JTextPane description;

    public FarmStatsView() {
        // Sets the specifications of the window
        this.setSize(new Dimension(300, 200));
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Farm Stats");

        // Sets specifications of the upper panel of the window
        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(25, 30));

        // Sets specifications of the center panel of the window
        JPanel center = new JPanel();
        center.setSize(new Dimension(250, 100));

        // Sets specifications of the lower panel of the window
        JPanel lower = new JPanel();
        lower.setPreferredSize(new Dimension(25, 20));

        // Title portion of the window
        JLabel text = new JLabel();
        text.setText("Farm Stats");
        text.setFont(new Font("Cambria", Font.BOLD, 25));
        text.setHorizontalAlignment(JLabel.CENTER);

        // Textpane where the statistics will be placed
        this.description = new JTextPane();
        this.description.setPreferredSize(new Dimension(250, 100));
        this.description.setFont(new Font("Cambria", Font.PLAIN, 14));
        this.description.setEditable(false);

        // adding "text" to the upper panel; adding "description" to the center panel
        upper.add(text);
        center.add(description);

        // adding all panels to the main window
        this.add(lower, BorderLayout.SOUTH);
        this.add(upper, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);

        this.setVisible(true);
    }

    // Gets the textpane where the statistics will be placed
    public JTextPane getDescription() {
        return this.description;
    }
}
