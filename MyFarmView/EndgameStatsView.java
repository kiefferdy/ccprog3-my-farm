package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

// Window where the farm and the farmer's statistics will be displayed (will only show if the game has ended)
public class EndgameStatsView extends JFrame {
    private JTextPane description;

    public EndgameStatsView() {
        // Sets the specifications of the window
        this.setSize(new Dimension(500, 650));
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Game Over!");

        // Sets specifications of the upper panel of the window
        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(50, 50));

        // Sets specifications of the left panel of the window
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(50, 50));

        // Sets specifications of the right panel of the window
        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(50, 50));

        // Sets specifications of the center panel of the window
        JPanel center = new JPanel();
        center.setSize(new Dimension(350, 550));
        
        // Title of the window
        JLabel text = new JLabel();
        text.setText("Game Over! Final Stats");
        text.setFont(new Font("Cambria", Font.BOLD, 25));
        text.setHorizontalAlignment(JLabel.CENTER);

        // Textpane where the statistics will be displayed
        this.description = new JTextPane();
        this.description.setPreferredSize(new Dimension(300, 475));
        this.description.setFont(new Font("Cambria", Font.PLAIN, 14));
        this.description.setEditable(false);

        // adding "text" to the upper panel and "description" to the center panel
        upper.add(text);
        center.add(description);

        // adding all panels to the window
        this.add(upper, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.add(right, BorderLayout.EAST);

        this.setVisible(true);
    }

    // Gets the textpane where the statistics will be placed
    public JTextPane getDescription() {
        return this.description;
    }
}
