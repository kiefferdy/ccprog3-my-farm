package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class EndgameStatsView extends JFrame {
    private JTextPane description;

    public EndgameStatsView() {
        this.setSize(new Dimension(500, 650));
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Game Over!");

        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(50, 50));

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(50, 50));

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(50, 50));

        JPanel center = new JPanel();
        center.setSize(new Dimension(350, 550));
        
        JLabel text = new JLabel();
        text.setText("Game Over! Final Stats");
        text.setFont(new Font("Cambria", Font.BOLD, 25));
        text.setHorizontalAlignment(JLabel.CENTER);

        upper.add(text);

        this.description = new JTextPane();
        this.description.setPreferredSize(new Dimension(300, 475));
        this.description.setFont(new Font("Cambria", Font.PLAIN, 14));
        this.description.setEditable(false);

        center.add(description);

        this.add(upper, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.add(right, BorderLayout.EAST);

        this.setVisible(true);
    }

    public JTextPane getDescription() {
        return this.description;
    }
}
