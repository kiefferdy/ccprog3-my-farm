package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class FarmStatsView extends JFrame {
    private JTextPane description;

    public FarmStatsView() {
        this.setSize(new Dimension(300, 200));
        this.setLayout(new BorderLayout(5, 5));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Farm Stats");

        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(25, 30));

        JPanel center = new JPanel();
        center.setSize(new Dimension(250, 100));

        JPanel lower = new JPanel();
        lower.setPreferredSize(new Dimension(25, 20));

        JLabel text = new JLabel();
        text.setText("Farm Stats");
        text.setFont(new Font("Cambria", Font.BOLD, 25));
        text.setHorizontalAlignment(JLabel.CENTER);

        this.description = new JTextPane();
        this.description.setPreferredSize(new Dimension(250, 100));
        this.description.setFont(new Font("Cambria", Font.PLAIN, 14));
        this.description.setEditable(false);

        upper.add(text);
        center.add(description);

        this.add(lower, BorderLayout.SOUTH);
        this.add(upper, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public JTextPane getDescription() {
        return this.description;
    }
}
