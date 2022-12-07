package MyFarmView;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class SystemLogsView extends JPanel{
    private JTextPane logs;

    public SystemLogsView() {
        this.logs = new JTextPane();
        this.logs.setFont(new Font("Cambria", Font.PLAIN, 16));
        this.logs.setEditable(false);
        this.logs.setAlignmentY(CENTER_ALIGNMENT);
        this.logs.setText("Welcome to Farming Simulator Rip-Off! Enjoy the game!");

        JScrollPane scrollPane = new JScrollPane(this.logs, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(750, 90));

        this.setAlignmentY(CENTER_ALIGNMENT);
        this.add(scrollPane);
    }

    public JTextPane getLogs() {
        return this.logs;
    }

    public void clearLogs() {
        this.logs.setText("");
    }
}
