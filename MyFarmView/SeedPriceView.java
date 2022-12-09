package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

// Window that shows the list of seeds with their price and description
public class SeedPriceView extends JFrame {
    private JTextPane description;

    public SeedPriceView() {
        // Sets specifications of the window
        this.setSize(new Dimension(500, 650));
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Seed Prices and Description");

        // Sets the specifications of the upper panel of the window
        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(50, 50));

        // Sets the specifications of the left panel of the window
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(50, 50));

        // Sets the specifications of the right panel of the window
        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(50, 50));

        // Sets the specifications of the center panel of the window
        JPanel center = new JPanel();
        center.setSize(new Dimension(350, 475));
        
        // Title text of the descriptions
        JLabel text = new JLabel();
        text.setText("Seed Prices and Descriptions");
        text.setFont(new Font("Cambria", Font.BOLD, 25));
        text.setHorizontalAlignment(JLabel.CENTER);

        // Textpane where the seeds' prices and descriptions will be placed
        this.description = new JTextPane();
        this.description.setPreferredSize(new Dimension(300, 475));
        this.description.setFont(new Font("Cambria", Font.PLAIN, 14));
        this.description.setEditable(false);

        // Scroll pane to scroll up and down the descriptions
        JScrollPane scroll = new JScrollPane(this.description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(300, 475));

        // adding title text to the upper panel; adding scroll pane to the center panel
        upper.add(text);
        center.add(scroll);

        // adding panels to the main window
        this.add(upper, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.add(right, BorderLayout.EAST);

        this.setVisible(true);
    }

    // Gets the textpane of the descriptions
    public JTextPane getDescription() {
        return this.description;
    }
}

