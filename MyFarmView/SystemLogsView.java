package MyFarmView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

// Panel that shows the actions performed and the objectcoins and xp gains
public class SystemLogsView extends JPanel{
    private JTextPane logs;

    public SystemLogsView() {
        // Sets specifications of the textpane where the dialogues will be placed
        this.logs = new JTextPane();
        this.logs.setFont(new Font("Cambria", Font.PLAIN, 16));
        this.logs.setEditable(false);
        this.logs.setPreferredSize(new Dimension(750, 75));
        this.logs.setAlignmentY(CENTER_ALIGNMENT);
        this.logs.setBorder(new LineBorder(Color.BLACK));
        this.logs.setText("Welcome to Farming Simulator Rip-Off! Enjoy the game!");

        // Sets specifications of the main panel
        this.setAlignmentY(CENTER_ALIGNMENT);

        // adding the textpane to the main panel
        this.add(this.logs);
    }

    // Gets the textpane where the dialogues will be placed
    public JTextPane getLogs() {
        return this.logs;
    }

    // Clears the textpane
    public void clearLogs() {
        this.logs.setText("");
    }
}
