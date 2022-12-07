package MyFarmView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class SystemLogsView extends JPanel{
    private JTextPane logs;

    public SystemLogsView() {
        this.logs = new JTextPane();
        this.logs.setFont(new Font("Cambria", Font.PLAIN, 16));
        this.logs.setEditable(false);
        this.logs.setPreferredSize(new Dimension(750, 75));
        this.logs.setAlignmentY(CENTER_ALIGNMENT);
        this.logs.setBorder(new LineBorder(Color.BLACK));
        this.logs.setText("Welcome to Farming Simulator Rip-Off! Enjoy the game!");

        this.setAlignmentY(CENTER_ALIGNMENT);
        this.add(this.logs);
    }

    public JTextPane getLogs() {
        return this.logs;
    }

    public void clearLogs() {
        this.logs.setText("");
    }
}
